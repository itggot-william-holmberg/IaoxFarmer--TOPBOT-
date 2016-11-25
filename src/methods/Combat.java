package methods;

import org.tbot.internal.event.EventManager;
import org.tbot.internal.handlers.LogHandler;
import org.tbot.internal.handlers.ScriptHandler;
import org.tbot.methods.Mouse;
import org.tbot.methods.Players;
import org.tbot.methods.Settings;
import org.tbot.methods.Skills.Skill;
import org.tbot.methods.Widgets;
import org.tbot.methods.tabs.Equipment;

import core.Nextgen;
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
	
	private static int attackStyle() {

		return Settings.get(43);

	}
	
	private static boolean rightAttackStyle() {
		if ((Data.currentTask.getSkill() == Skill.STRENGTH || Data.currentTask.getSkill() == Skill.RANGED) && (attackStyle() != 1)) {
			return false;
		} else if (Data.currentTask.getSkill() == Skill.ATTACK && (attackStyle() != 0)) {
			return false;
		} else if (Data.currentTask.getSkill() == Skill.DEFENCE && (attackStyle() != 3)) {
			return false;
		}
		return true;
	}
	
	private static void checkStyle() {
		if (Widgets.getWidget(593).getChild(2).isVisible()) {

			if ((Data.currentTask.getSkill() == Skill.STRENGTH || Data.currentTask.getSkill() == Skill.RANGED) && (attackStyle() != 1)) {
				LogHandler.log("lets click train str1");
				Mouse.click(689, 270, true);// click "train strength"
			} else if (Data.currentTask.getSkill() == Skill.ATTACK && (attackStyle() != 0)) {
				LogHandler.log("lets click train att1");
				Mouse.click(601, 269, true); // click "train attack"
			} else if (Data.currentTask.getSkill() == Skill.DEFENCE && (attackStyle() != 3)) {
				LogHandler.log("lets click train def1");
				Mouse.click(701, 335, true); // click "train def"
			}

		} else {

			Mouse.click(545, 190, true);
			LogHandler.log("200");
			checkStyle();

		}

	}
	
	
	public static boolean playerCanFight() {
		if (!rightAttackStyle()) {
			checkStyle();
			return false;
		}else if(Data.currentTask.getSkill() == Skill.RANGED && Equipment.getItemInSlot(Equipment.SLOTS_AMMO) == null){
			LogHandler.log("we need ammo!!!");
			Nextgen.stop();
			return false;
		}
		return !Players.getLocal().isHealthBarVisible() || Players.getLocal().isMoving();
	}

}
