package data;


import java.util.ArrayList;
import java.util.List;

import org.tbot.wrappers.GameObject;

import enums.assignment.CombatAssignment;
import state.State;
import tasks.Task;

public class Data {

	public static List<String> ITEM_WITHDRAW_LIST = new ArrayList<String>();

	public static boolean shouldRun = false;
	
	public static Task currentTask = null;

	public static State currentState;

	public static int badWorld = 0;

	public static int amountOfWorldHops;

	public static String currentMission;

	public static CombatAssignment COMBAT_ASSIGNMENT;

	public static int amountOfFood;

	public static GameObject lastClickedObject = null;

}
