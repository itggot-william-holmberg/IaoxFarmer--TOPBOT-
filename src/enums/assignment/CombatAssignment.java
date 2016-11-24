package enums.assignment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.tbot.wrappers.Area;

import data.Areas;
import data.NpcID;


public enum CombatAssignment {

	SEAGULL(Areas.SEAGULL_AREAS, NpcID.SEAGULL_ID),
	DRUIDS(Areas.DRUID_AREA, NpcID.DRUID_ID);
	private Area area;
	private Area bankArea;
	private List<Integer> id;
	CombatAssignment(Area area, int[] id){
		this.area = area;
		this.id = new ArrayList<Integer>();
		for (Integer i : id) {
			this.id.add(i);
		}
	}
	CombatAssignment(Area[] area, int[] id){
		Random r = new Random();
		this.area = area[r.nextInt(area.length)];
		this.id = new ArrayList<Integer>();
		for (Integer i : id) {
			this.id.add(i);
		}
	}
	
	public Area getArea(){
		return area;
	}
	
	public Area getBankArea(){
		return bankArea;
	}
	
	public List<Integer> getNpcID(){
		return id;
	}
	
	public String toString(){
		return this.name();
		
	}
}
