
public class Interval {
	private int gold;
	private float time;
	private String newItem;
	Interval(String str){
		this.gold = Integer.parseInt(str.substring(str.indexOf("gold")+6, str.indexOf("lh")-2));
		this.time = Float.parseFloat(str.substring(str.indexOf("time")+6, str.indexOf("type")-2));
	}
	
	public int getGold(){
		return this.gold;
	}
	
	public float getTime(){
		return this.time;
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
	
	public String getPrintString(){
		if(this.newItem == null)
			this.newItem = "";
		return(this.time + "," + this.gold + ",\"" + this.newItem + "\"");
	}
}
