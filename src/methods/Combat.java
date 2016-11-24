package methods;

import org.tbot.methods.Players;

import data.Areas;
import data.Data;
import enums.assignment.CombatAssignment;

public class Combat {

	public static boolean playerReadyForFight(){
		return getAssignment().getArea().contains(Players.getLocal().getLocation());
	}
	
	public static CombatAssignment getAssignment(){
		return Data.COMBAT_ASSIGNMENT;
	}
}
