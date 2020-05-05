package net.group.insert.output;

public class Group {
	protected int num;
	protected String name;
	protected int groupnum;
	protected String setsnum;
	protected String sport;
	protected int distance;
	protected int split;


public Group() {
}

public Group(String name, String sport) {
	super();

	this.name = name;
	this.sport = sport;
}


public Group(String name, int groupnum,String setsnum, String sport, int distance, int split) {
	super();

	this.name = name;
	this.groupnum = groupnum;
	this.setsnum = setsnum;
	this.sport = sport;
	this.distance = distance;
	this.split = split;
}


public Group(int num, String name, int groupnum, String setsnum, String sport, int distance, int split) {
	super();
	this.num = num;
	this.name = name;
	this.groupnum = groupnum;
	this.setsnum = setsnum;
	this.sport = sport;
	this.distance = distance;
	this.split = split;
}



public int getNum() {
	return num;
}



public void setNum(int num) {
	this.num = num;
}



public String getName() {
	return name;
}



public void setName(String name) {
	this.name = name;
}



public int getGroupnum() {
	return groupnum;
}



public void setGroupnum(int groupnum) {
	this.groupnum = groupnum;
}



public String getSetsnum() {
	return setsnum;
}



public void setSetsnum(String set) {
	this.setsnum = setsnum;
}



public String getSport() {
	return sport;
}



public void setSport(String sport) {
	this.sport = sport;
}



public int getDistance() {
	return distance;
}



public void setDistance(int distance) {
	this.distance = distance;
}



public int getSplit() {
	return split;
}



public void setSplit(int split) {
	this.split = split;
}
}
