import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
    private double spelldamage, physicaldamage, deathtime, smoketime, xpos, ypos, xp, stuntime;
    private ArrayList<String> currentMods = new ArrayList<>();
    int sens, obs, deaths, kills, assists, lhlane, lhnuetral, lhancient, stacks, pulls, level, roshes, denies, casts;

    public double getStuntime() {
		return stuntime;
	}

	public void setStuntime(double stuntime) {
		this.stuntime = stuntime;
	}

	public int getRoshes() {
		return roshes;
	}

	public void setRoshes(int roshes) {
		this.roshes = roshes;
	}

	public int getDenies() {
		return denies;
	}

	public void setDenies(int denies) {
		this.denies = denies;
	}

	public int getCasts() {
		return casts;
	}

	public void setCasts(int casts) {
		this.casts = casts;
	}

	public double getSpelldamage() {
		return spelldamage;
	}

	public void setSpelldamage(double spelldamage) {
		this.spelldamage = spelldamage;
	}

	public double getPhysicaldamage() {
		return physicaldamage;
	}

	public void setPhysicaldamage(double physicaldamage) {
		this.physicaldamage = physicaldamage;
	}

	public double getDeathtime() {
		return deathtime;
	}

	public void setDeathtime(double deathtime) {
		this.deathtime = deathtime;
	}

	public double getSmoketime() {
		return smoketime;
	}

	public void setSmoketime(double smoketime) {
		this.smoketime = smoketime;
	}

	public double getXpos() {
		return xpos;
	}

	public void setXpos(double xpos) {
		this.xpos = xpos;
	}

	public double getYpos() {
		return ypos;
	}

	public void setYpos(double ypos) {
		this.ypos = ypos;
	}

	public double getXp() {
		return xp;
	}

	public void setXp(double xp) {
		this.xp = xp;
	}

	public ArrayList<String> getCurrentMods() {
		return currentMods;
	}

	public void setCurrentMods(ArrayList<String> currentMods) {
		this.currentMods = currentMods;
	}

	public int getSens() {
		return sens;
	}

	public void setSens(int sens) {
		this.sens = sens;
	}

	public int getObs() {
		return obs;
	}

	public void setObs(int obs) {
		this.obs = obs;
	}

	public int getDeaths() {
		return deaths;
	}

	public void setDeaths(int deaths) {
		this.deaths = deaths;
	}

	public int getKills() {
		return kills;
	}

	public void setKills(int kills) {
		this.kills = kills;
	}

	public int getAssists() {
		return assists;
	}

	public void setAssists(int assists) {
		this.assists = assists;
	}

	public int getLhlane() {
		return lhlane;
	}

	public void setLhlane(int lhlane) {
		this.lhlane = lhlane;
	}

	public int getLhnuetral() {
		return lhnuetral;
	}

	public void setLhnuetral(int lhnuetral) {
		this.lhnuetral = lhnuetral;
	}

	public int getLhancient() {
		return lhancient;
	}

	public void setLhancient(int lhancient) {
		this.lhancient = lhancient;
	}

	public int getStacks() {
		return stacks;
	}

	public void setStacks(int stacks) {
		this.stacks = stacks;
	}

	public int getPulls() {
		return pulls;
	}

	public void setPulls(int pulls) {
		this.pulls = pulls;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public void setGold(double gold) {
		this.gold = gold;
	}
    //{"time":2113.043,"type":"interval","unit":"CDOTA_Unit_Hero_Spectre","slot":8,"gold":7081,"lh":83,"xp":7554,"x":124,"y":154,"stuns":0.0,"hero_id":67,"hero_inventory":
	//[{"id":"item_phase_boots"},{"id":"item_iron_talon"},{"id":"item_broadsword"},{"id":"item_vanguard"},{"id":"item_chainmail"},{"id":"item_tpscroll","num_charges":1}],
	//"life_state":0,"level":12,"kills":2,"deaths":7,"assists":5,"denies":2,"obs_placed":0,"sen_placed":0,"creeps_stacked":0,"camps_stacked":0,"rune_pickups":3,"randomed":false,
	//"pred_vict":false}

	Interval(String str, int type){
		if(type == 0){
            this.gold = Double.parseDouble(str.substring(str.indexOf("gold")+6, str.indexOf("lh")-2));
            this.time = Double.parseDouble(str.substring(str.indexOf("time")+6, str.indexOf("type")-2));
            this.hero = str.substring(str.indexOf("unit")+7, str.indexOf("slot")-3);
            this.deaths = Integer.parseInt(str.substring(str.indexOf("deaths")+8, str.indexOf("assists")-2));
            this.kills = Integer.parseInt(str.substring(str.indexOf("kills")+7, str.indexOf("deaths")-2));
            this.assists = Integer.parseInt(str.substring(str.indexOf("assists")+9, str.indexOf("denies")-2));
            this.xpos = Double.parseDouble(str.substring(str.indexOf("\"x\"")+4, str.indexOf("\"y\"")-1));
            this.ypos = Double.parseDouble(str.substring(str.indexOf("\"y\"")+4, str.indexOf("stuns")-2));
            this.xp = Double.parseDouble(str.substring(str.indexOf("xp")+4, str.indexOf("\"x\"")-1));
            this.stacks = Integer.parseInt(str.substring(str.indexOf("camps_stacked")+6, str.indexOf("rune_pickups")-2));
            this.pulls = Integer.parseInt(str.substring(str.indexOf("creeps_stacked")+16, str.indexOf("camps_stacked")-2));
            this.denies = Integer.parseInt(str.substring(str.indexOf("gold")+6, str.indexOf("lh")-2));
            this.stuntime = Double.parseDouble(str.substring(str.indexOf("denies")+8, str.indexOf("obs_placed")-2));
            this.obs = Integer.parseInt(str.substring(str.indexOf("obs_placed")+12, str.indexOf("sen_placed")-2));
            this.sens = Integer.parseInt(str.substring(str.indexOf("sen_placed")+12, str.indexOf("creeps_stacked")-2));
		}
		else if(type == 1){
			
		}
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