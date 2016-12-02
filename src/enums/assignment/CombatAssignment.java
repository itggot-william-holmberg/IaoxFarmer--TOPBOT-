package enums.assignment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.tbot.wrappers.Area;

import data.Areas;
import data.Data;
import data.NpcID;
import data.WebBank;


public enum CombatAssignment {

	SEAGULL(Areas.SEAGULL_AREAS, NpcID.SEAGULL_ID, WebBank.DRAYNOR.getArea()),
	DRUIDS(Areas.DRUID_AREA, NpcID.DRUID_ID, Data.druidLoot, WebBank.FALADOR_WEST.getArea());
	private Area area;
	private Area bankArea;
	private List<Integer> id;

	CombatAssignment(Area area, int[] id, int[] lootID, Area bankArea){
		this.area = area;
		this.id = new ArrayList<Integer>();
		for (Integer i : id) {
			this.id.add(i);
		}
		for (Integer i : lootID) {
			Data.lootID.add(i);
		}
		this.bankArea = bankArea;
	}
	CombatAssignment(Area area, int[] id, Area bankArea){
		this.area = area;
		this.id = new ArrayList<Integer>();
		for (Integer i : id) {
			this.id.add(i);
		}
		this.bankArea = bankArea;
	}
	CombatAssignment(Area[] area, int[] id, Area bankArea){
		Random r = new Random();
		this.area = area[r.nextInt(area.length)];
		this.id = new ArrayList<Integer>();
		for (Integer i : id) {
			this.id.add(i);
		}
		this.bankArea = bankArea;
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
