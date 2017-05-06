import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Main {
public static String[] Items = new String[]{"item_quelling_blade","item_blight_stone","item_boots","item_ring_of_health","item_morbid_mask","item_blink_dagger","item_poor_mans_shield","item_stout_shield","item_hand_of_midas","item_boots_of_travel","item_moon_shard","item_phase_boots","item_power_treads","item_ring_of_basilius","item_iron_talon","item_tranquil_boots","item_ring_of_aquila","item_arcane_boots","item_vladmirs_offering","item_guardian_greaves","item_force_staff","item_euls_scepter_of_divinity","item_agnamins_scepter","item_crystalys","item_armlet_of_mordiggian","item_shadow_blade","item_battle_fury","item_silver_edge","item_radiance","item_monkey_king_bar","item_daedalus","item_divine_raiper","item_abyssal_blade","item_bloodthorn","item_vanguard","item_blade_mail","item_crimson_guard","item_blank_king_bar","item_lotus_orb","item_shivas_guard","item_bloodstone","item_manta_style","item_linkens_sphere","item_hurricane_pike","item_assault_cuirass","item_heart_of_tarrasque","item_mask_of_madness","item_helm_of_the_dominator","item_dragon_lance","item_sange","item_yasha","item_echo_sabre","item_maelstrom","item_diffusal_blade","item_desolator","item_heavens_halberd","item_sange_and_yasha","item_eye_of_skadi","item_mjolnir","item_satanic"};
	public static void main(String[] args) {
		try {
			if(args.length >= 1){
		InputStream is = new FileInputStream(args[0]);
		PrintWriter slot0Out = new PrintWriter("slot0.csv");
		PrintWriter slot1Out = new PrintWriter("slot1.csv");
		PrintWriter slot2Out = new PrintWriter("slot2.csv");
		PrintWriter slot3Out = new PrintWriter("slot3.csv");
		PrintWriter slot4Out = new PrintWriter("slot4.csv");
		PrintWriter slot5Out = new PrintWriter("slot5.csv");
		PrintWriter slot6Out = new PrintWriter("slot6.csv");
		PrintWriter slot7Out = new PrintWriter("slot7.csv");
		PrintWriter slot8Out = new PrintWriter("slot8.csv");
		PrintWriter slot9Out = new PrintWriter("slot9.csv");
		
		//OutputStream os = new FileOutputStream(args[1]);
		
		
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
		

		//Read File Line By Line
		while ((strLine = br.readLine()) != null)   {
		if(strLine.contains("hero_inventory")){
		  if(strLine.contains("\"type\":\"interval\"") && strLine.contains("\"slot\":0")){
			  System.out.print(strLine);
			  slot0.add(new Interval(strLine));
			  newItems0.clear();
			  String[] temp = strLine.substring(strLine.indexOf("hero_inventory")+16, strLine.indexOf("life_state")-3).split("\"");
			  for(String str : temp){
				  if(str.contains("item") && !oldItems0.contains(str)){
					  newItems0.add(str);
					  oldItems0.add(str);
				  }
			  }
			  if(!newItems0.isEmpty())
				  slot0.get(slot0.size()-1).setNewItem(newItems0.toString().replaceAll(",", " "));
		  }
		  if(strLine.contains("\"type\":\"interval\"") && strLine.contains("\"slot\":1")){
			  slot1.add(new Interval(strLine));
			  newItems1.clear();
			  String[] temp = strLine.substring(strLine.indexOf("hero_inventory")+16, strLine.indexOf("life_state")-3).split("\"");
			  for(String str : temp){
				  if(str.contains("item") && !oldItems1.contains(str)){
					  newItems1.add(str);
					  oldItems1.add(str);
				  }
			  }
			  if(!newItems1.isEmpty())
				  slot1.get(slot1.size()-1).setNewItem(newItems1.toString().replaceAll(",", " "));
		  }
		  if(strLine.contains("\"type\":\"interval\"") && strLine.contains("\"slot\":2")){
			  slot2.add(new Interval(strLine));
			  newItems2.clear();
			  String[] temp = strLine.substring(strLine.indexOf("hero_inventory")+16, strLine.indexOf("life_state")-3).split("\"");
			  for(String str : temp){
				  if(str.contains("item") && !oldItems2.contains(str)){
					  newItems2.add(str);
					  oldItems2.add(str);
				  }
			  }
			  if(!newItems2.isEmpty())
				  slot2.get(slot2.size()-1).setNewItem(newItems2.toString().replaceAll(",", " "));
		  }
		  if(strLine.contains("\"type\":\"interval\"") && strLine.contains("\"slot\":3")){
			  slot3.add(new Interval(strLine));
			  newItems3.clear();
			  String[] temp = strLine.substring(strLine.indexOf("hero_inventory")+16, strLine.indexOf("life_state")-3).split("\"");
			  for(String str : temp){
				  if(str.contains("item") && !oldItems3.contains(str)){
					  newItems3.add(str);
					  oldItems3.add(str);
				  }
			  }
			  if(!newItems3.isEmpty())
				  slot3.get(slot3.size()-1).setNewItem(newItems3.toString().replaceAll(",", " "));
		  }
		  if(strLine.contains("\"type\":\"interval\"") && strLine.contains("\"slot\":4")){
			  slot4.add(new Interval(strLine));
			  newItems4.clear();
			  String[] temp = strLine.substring(strLine.indexOf("hero_inventory")+16, strLine.indexOf("life_state")-3).split("\"");
			  for(String str : temp){
				  if(str.contains("item") && !oldItems4.contains(str)){
					  newItems4.add(str);
					  oldItems4.add(str);
				  }
			  }
			  if(!newItems4.isEmpty())
				  slot4.get(slot4.size()-1).setNewItem(newItems4.toString().replaceAll(",", " "));
		  }
		  if(strLine.contains("\"type\":\"interval\"") && strLine.contains("\"slot\":5")){
			  slot5.add(new Interval(strLine));
			  newItems5.clear();
			  String[] temp = strLine.substring(strLine.indexOf("hero_inventory")+16, strLine.indexOf("life_state")-3).split("\"");
			  for(String str : temp){
				  if(str.contains("item") && !oldItems5.contains(str)){
					  newItems5.add(str);
					  oldItems5.add(str);
				  }
			  }
			  if(!newItems5.isEmpty())
				  slot5.get(slot5.size()-1).setNewItem(newItems5.toString().replaceAll(",", " "));
		  }
		  if(strLine.contains("\"type\":\"interval\"") && strLine.contains("\"slot\":6")){
			  slot6.add(new Interval(strLine));
			  newItems6.clear();
			  String[] temp = strLine.substring(strLine.indexOf("hero_inventory")+16, strLine.indexOf("life_state")-3).split("\"");
			  for(String str : temp){
				  if(str.contains("item") && !oldItems6.contains(str)){
					  newItems6.add(str);
					  oldItems6.add(str);
				  }
			  }
			  if(!newItems6.isEmpty())
				  slot6.get(slot6.size()-1).setNewItem(newItems6.toString().replaceAll(",", " "));
		  }
		  if(strLine.contains("\"type\":\"interval\"") && strLine.contains("\"slot\":7")){
			  slot7.add(new Interval(strLine));
			  newItems7.clear();
			  String[] temp = strLine.substring(strLine.indexOf("hero_inventory")+16, strLine.indexOf("life_state")-3).split("\"");
			  for(String str : temp){
				  if(str.contains("item") && !oldItems7.contains(str)){
					  newItems7.add(str);
					  oldItems7.add(str);
				  }
			  }
			  if(!newItems7.isEmpty())
				  slot7.get(slot7.size()-1).setNewItem(newItems7.toString().replaceAll(",", " "));
		  }
		  if(strLine.contains("\"type\":\"interval\"") && strLine.contains("\"slot\":8")){
			  slot8.add(new Interval(strLine));
			  newItems8.clear();
			  String[] temp = strLine.substring(strLine.indexOf("hero_inventory")+16, strLine.indexOf("life_state")-3).split("\"");
			  for(String str : temp){
				  if(str.contains("item") && !oldItems8.contains(str)){
					  newItems8.add(str);
					  oldItems8.add(str);
				  }
			  }
			  if(!newItems8.isEmpty())
				  slot8.get(slot8.size()-1).setNewItem(newItems8.toString().replaceAll(",", " "));
		  }
		  if(strLine.contains("\"type\":\"interval\"") && strLine.contains("\"slot\":9")){
			  slot9.add(new Interval(strLine));
			  newItems9.clear();
			  String[] temp = strLine.substring(strLine.indexOf("hero_inventory")+16, strLine.indexOf("life_state")-3).split("\"");
			  for(String str : temp){
				  if(str.contains("item") && !oldItems9.contains(str)){
					  newItems9.add(str);
					  oldItems9.add(str);
				  }
			  }
			  if(!newItems9.isEmpty())
				  slot9.get(slot9.size()-1).setNewItem(newItems9.toString().replaceAll(",", " "));
		  }
		}	  
		}
		slot0Out.println("\"frame\",\"gold\",\"new_item\"");
		for(Interval i : slot0){
			slot0Out.println(i.getPrintString());
		}
		slot0Out.close();
		slot1Out.println("\"frame\",\"gold\",\"new_item\"");
		for(Interval i : slot1){
			slot1Out.println(i.getPrintString());
		}
		slot1Out.close();
		slot2Out.println("\"frame\",\"gold\",\"new_item\"");
		for(Interval i : slot2){
			slot2Out.println(i.getPrintString());
		}
		slot2Out.close();
		slot3Out.println("\"frame\",\"gold\",\"new_item\"");
		for(Interval i : slot3){
			slot3Out.println(i.getPrintString());
		}
		slot3Out.close();
		slot4Out.println("\"frame\",\"gold\",\"new_item\"");
		for(Interval i : slot4){
			slot4Out.println(i.getPrintString());
		}
		slot4Out.close();
		slot5Out.println("\"frame\",\"gold\",\"new_item\"");
		for(Interval i : slot5){
			slot5Out.println(i.getPrintString());
		}
		slot5Out.close();
		slot6Out.println("\"frame\",\"gold\",\"new_item\"");
		for(Interval i : slot6){
			slot6Out.println(i.getPrintString());
		}
		slot6Out.close();
		slot7Out.println("\"frame\",\"gold\",\"new_item\"");
		for(Interval i : slot7){
			slot7Out.println(i.getPrintString());
		}
		slot7Out.close();
		slot8Out.println("\"frame\",\"gold\",\"new_item\"");
		for(Interval i : slot8){
			slot8Out.println(i.getPrintString());
		}
		slot8Out.close();
		slot9Out.println("\"frame\",\"gold\",\"new_item\"");
		for(Interval i : slot9){
			slot9Out.println(i.getPrintString());
		}
		slot9Out.close();
			}
			else
				System.out.println("no input file");
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
