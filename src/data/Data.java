package data;


import java.util.ArrayList;
import java.util.List;

import org.tbot.wrappers.GameObject;

import enums.assignment.CombatAssignment;
import state.State;
import tasks.Task;

public class Data {

	public static List<Item> ITEM_WE_NEED_TO_BUY_LIST = new ArrayList<Item>();

	public static List<Item> ITEM_WITHDRAW_LIST = new ArrayList<Item>();

	public static boolean shouldRun = false;
	
	public static Task currentTask = null;

	public static State currentState;

	public static int badWorld = 0;

	public static int amountOfWorldHops;

	public static String currentMission;

	public static CombatAssignment COMBAT_ASSIGNMENT;

	public static int amountOfFood;

	public static GameObject lastClickedObject = null;

	public static String foodName = "Tuna";
	
	public static List<Integer> lootID = new ArrayList<Integer>();

	public static int moneyMade;

	public static int[] druidLoot = {Item.grimyRanarr.getItemID(), Item.grimyAvantoe.getItemID(),
									 Item.grimyDwarfWeed.getItemID(), Item.grimyHarralander.getItemID(),
									 Item.lawRune.getItemID(), Item.mithrilBolts.getItemID(),
									 Item.grimyIrit.getItemID(), Item.grimyKwuarm.getItemID(),
									 Item.grimyLantadyme.getItemID()};

}
