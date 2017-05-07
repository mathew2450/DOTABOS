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

public class Interval {
    private double gold;
    private double time;
    private String newItem;
    private String hero;
    private double ratio; 

    Interval(String str){
            this.gold = Double.parseDouble(str.substring(str.indexOf("gold")+6, str.indexOf("lh")-2));
            this.time = Double.parseDouble(str.substring(str.indexOf("time")+6, str.indexOf("type")-2));
            this.hero = str.substring(str.indexOf("unit")+7, str.indexOf("slot")-3);
    }
    
    public double getGold(){
            return this.gold;
    }

    public double getTime(){
            return this.time;
    }
    
    public void setTime(double t){
        this.time = t;
    }

    public double getRatio() {
        return ratio;
    }

    public void setRatio(double ratio) {
        this.ratio = ratio;
    }

    public String getNewItem(){
            if(this.newItem == null)
                    return("");
            else
                    return(this.newItem);
    }

    public void setNewItem(String item){
            this.newItem = item;
    }
    
    public String getHero() {
        return hero;
    }

    public void setHero(String hero) {
        this.hero = hero;
    }

    public String getPrintString(){
            if(this.newItem == null)
                    this.newItem = "";
            return(this.time + "," + this.gold + "," + this.ratio + ",\"" + this.newItem + "\"," + this.hero + "");
    }
}