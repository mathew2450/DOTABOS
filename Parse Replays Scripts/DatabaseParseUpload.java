/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databaseparseupload;

/**
 *
 * @author mathew
 */
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;

public class DatabaseParseUpload {
    public static String[] Items = new String[]{"item_quelling_blade","item_blight_stone","item_boots","item_ring_of_health",
        "item_morbid_mask","item_blink_dagger","item_poor_mans_shield","item_stout_shield","item_hand_of_midas","item_boots_of_travel",
            "item_moon_shard","item_phase_boots","item_power_treads","item_ring_of_basilius","item_iron_talon","item_tranquil_boots",
                "item_ring_of_aquila","item_arcane_boots","item_vladmirs_offering","item_guardian_greaves","item_force_staff",
                    "item_euls_scepter_of_divinity","item_agnamins_scepter","item_crystalys","item_armlet_of_mordiggian",
                        "item_shadow_blade","item_battle_fury","item_silver_edge","item_radiance","item_monkey_king_bar","item_daedalus",
                            "item_divine_raiper","item_abyssal_blade","item_bloodthorn","item_vanguard","item_blade_mail",
                                "item_crimson_guard","item_blank_king_bar","item_lotus_orb","item_shivas_guard","item_bloodstone",
                                    "item_manta_style","item_linkens_sphere","item_hurricane_pike","item_assault_cuirass",
                                        "item_heart_of_tarrasque","item_mask_of_madness","item_helm_of_the_dominator","item_dragon_lance",
                                            "item_sange","item_yasha","item_echo_sabre","item_maelstrom","item_diffusal_blade",
                                                "item_desolator","item_heavens_halberd","item_sange_and_yasha","item_eye_of_skadi",
                                                    "item_mjolnir","item_satanic"};
    public static void main(String[] args) {
    try {
        if(args.length >= 4){
            InputStream is = new FileInputStream(args[0]);
            PrintWriter printOut = new PrintWriter(args[1]);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String strLine;
            ArrayList<Interval> slot0 = new ArrayList<>();
            ArrayList<String> oldItems0 = new ArrayList<>();
            ArrayList<String> newItems0 = new ArrayList<>();
            ArrayList<Interval> slot1 = new ArrayList<>();
            ArrayList<String> oldItems1 = new ArrayList<>();
            ArrayList<String> newItems1 = new ArrayList<>();
            ArrayList<Interval> slot2 = new ArrayList<>();
            ArrayList<String> oldItems2 = new ArrayList<>();
            ArrayList<String> newItems2 = new ArrayList<>();
            ArrayList<Interval> slot3 = new ArrayList<>();
            ArrayList<String> oldItems3 = new ArrayList<>();
            ArrayList<String> newItems3 = new ArrayList<>();
            ArrayList<Interval> slot4 = new ArrayList<>();
            ArrayList<String> oldItems4 = new ArrayList<>();
            ArrayList<String> newItems4 = new ArrayList<>();
            ArrayList<Interval> slot5 = new ArrayList<>();
            ArrayList<String> oldItems5 = new ArrayList<>();
            ArrayList<String> newItems5 = new ArrayList<>();
            ArrayList<Interval> slot6 = new ArrayList<>();
            ArrayList<String> oldItems6 = new ArrayList<>();
            ArrayList<String> newItems6 = new ArrayList<>();
            ArrayList<Interval> slot7 = new ArrayList<>();
            ArrayList<String> oldItems7 = new ArrayList<>();
            ArrayList<String> newItems7 = new ArrayList<>();
            ArrayList<Interval> slot8 = new ArrayList<>();
            ArrayList<String> oldItems8 = new ArrayList<>();
            ArrayList<String> newItems8 = new ArrayList<>();
            ArrayList<Interval> slot9 = new ArrayList<>();
            ArrayList<String> oldItems9 = new ArrayList<>();
            ArrayList<String> newItems9 = new ArrayList<>();
            ArrayList<ArrayList<Interval>> heroes = new ArrayList<>();
            ArrayList<ArrayList<String>> oldItems = new ArrayList<>();
            ArrayList<ArrayList<String>> newItems = new ArrayList<>();
            heroes.add(slot0);
            heroes.add(slot1);
            heroes.add(slot2);
            heroes.add(slot3);
            heroes.add(slot4);
            heroes.add(slot5);
            heroes.add(slot6);
            heroes.add(slot7);
            heroes.add(slot8);
            heroes.add(slot9);
            oldItems.add(oldItems0);
            oldItems.add(oldItems1);
            oldItems.add(oldItems2);
            oldItems.add(oldItems3);
            oldItems.add(oldItems4);
            oldItems.add(oldItems5);
            oldItems.add(oldItems6);
            oldItems.add(oldItems7);
            oldItems.add(oldItems8);
            oldItems.add(oldItems9);
            newItems.add(newItems0);
            newItems.add(newItems1);
            newItems.add(newItems2);
            newItems.add(newItems3);
            newItems.add(newItems4);
            newItems.add(newItems5);
            newItems.add(newItems6);
            newItems.add(newItems7);
            newItems.add(newItems8);
            newItems.add(newItems9);            
            //Read File Line By Line
            double startTime = 0;
            String winner = "N/A";
            while ((strLine = br.readLine()) != null)   {
                if(strLine.contains("\"DOTA_COMBATLOG_GAME_STATE\",\"value\":5"))
                    startTime = Double.parseDouble(strLine.substring(strLine.indexOf("time")+6, strLine.indexOf("type")-2));
                if(strLine.contains("\"DOTA_COMBATLOG_TEAM_BUILDING_KILL\",\"value\":3")){
                    if(strLine.contains("npc_dota_badguys_fort"))
                        winner = "radiant";
                    else
                        winner = "dire";
                }                    
                if(strLine.contains("hero_inventory")){
                    for(int i = 0; i <= 9; i++){
                        if(strLine.contains("\"type\":\"interval\"") && strLine.contains("\"slot\":" + i)){
                                //System.out.print(strLine);
                                heroes.get(i).add(new Interval(strLine));
                                newItems.get(i).clear();
                                String[] temp = strLine.substring(strLine.indexOf("hero_inventory")+16, strLine.indexOf("life_state")-3).split("\"");
                                for(String str : temp){
                                        if(str.contains("item") && !oldItems.get(i).contains(str)){
                                                newItems.get(i).add(str);
                                                oldItems.get(i).add(str);
                                        }
                                }
                                if(!newItems.get(i).isEmpty())
                                        heroes.get(i).get(heroes.get(i).size()-1).setNewItem(newItems.get(i).toString().replaceAll(",", " "));
                        }
                    }                  
                }	  
            }
            String temp = winner;
            for(int i = 0; i < 10; i ++){
                System.out.println(heroes.get(i).get(1).getHero().toLowerCase() + " = " + winner + ", slot#:" + i);
                if(heroes.get(i).get(1).getHero().toLowerCase().contains(args[2])){
                    if(args[3].toLowerCase().contains("radiant") && winner.contains("radiant") && i < 5)
                        temp = "yes";
                    else if(args[3].toLowerCase().contains("radiant") && winner.contains("dire"))
                        temp = "no";
                    else if(args[3].toLowerCase().contains("radiant") && winner.contains("radiant") && i > 4)
                        temp = "no";
                    else if(args[3].toLowerCase().contains("dire") && winner.contains("dire") && i > 4)
                        temp = "yes";
                    else if(args[3].toLowerCase().contains("dire") && winner.contains("radiant"))
                        temp = "no";
                    else if(args[3].toLowerCase().contains("dire") && winner.contains("dire") && i < 5)
                        temp = "no";
                    else
                        temp = "UnKnown";
                    break;
                }   
            }
            printOut.println("\"frame\", \"gold\", \"ratio\", \"new_item\", \"hero\", \"winner\"");
            for(int i = 0; i < 10; i ++){
                for(Interval j : heroes.get(i)){
                    
                    double direNet = (heroes.get(5).get(heroes.get(i).indexOf(j)).getGold()+
                            heroes.get(6).get(heroes.get(i).indexOf(j)).getGold()+
                                heroes.get(7).get(heroes.get(i).indexOf(j)).getGold()+
                                    heroes.get(8).get(heroes.get(i).indexOf(j)).getGold()+
                                        heroes.get(9).get(heroes.get(i).indexOf(j)).getGold());
                    double radianceNet = (heroes.get(0).get(heroes.get(i).indexOf(j)).getGold()+
                                heroes.get(1).get(heroes.get(i).indexOf(j)).getGold()+
                                    heroes.get(2).get(heroes.get(i).indexOf(j)).getGold()+
                                        heroes.get(3).get(heroes.get(i).indexOf(j)).getGold()+
                                            heroes.get(4).get(heroes.get(i).indexOf(j)).getGold());
                    if(direNet > 0 && radianceNet > 0){
                        if(i < 5){                        
                            j.setRatio(j.getGold()/direNet);
                            j.setTime(j.getTime() - startTime);
                            printOut.println(j.getPrintString() + ", " + temp);
                        }
                        else{                        
                            j.setRatio(j.getGold()/radianceNet);
                            j.setTime(j.getTime() - startTime);
                            printOut.println(j.getPrintString() + ", " + temp);
                        }
                    }                    
                }                        
            }
            printOut.close();
        }
        else
                System.out.println("no input file");
    } catch (IOException e) {
        // TODO Auto-generated catch block
    }
    }
}
