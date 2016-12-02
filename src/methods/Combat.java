package methods;


import org.tbot.internal.event.EventManager;
import org.tbot.internal.handlers.LogHandler;
import org.tbot.internal.handlers.ScriptHandler;
import org.tbot.methods.Camera;
import org.tbot.methods.GroundItems;
import org.tbot.methods.Mouse;
import org.tbot.methods.Players;
import org.tbot.methods.Random;
import org.tbot.methods.Settings;
import org.tbot.methods.Skills.Skill;
import org.tbot.methods.Time;
import org.tbot.methods.Widgets;
import org.tbot.methods.io.PriceLookup;
import org.tbot.methods.tabs.Equipment;
import org.tbot.methods.tabs.Inventory;
import org.tbot.methods.walking.Walking;
import org.tbot.util.Condition;
import org.tbot.wrappers.GroundItem;

import core.Nextgen;
import data.Areas;
import data.City;
import data.Data;
import enums.assignment.CombatAssignment;



public class Combat {
	
	private static int hp;
	private static int invAmount;
	
	public static boolean playerReadyForCombat() {
		switch (getAssignment()) {
		case DRUIDS:
			return !shouldBankDruids();
		default:
			return true;
		}
	}

	
	
	private static boolean shouldBankDruids() {

		if (Inventory.isFull() && !Inventory.contains(Data.foodName)) {
			return true;
		}

		else if (!Inventory.contains("Falador teleport")) {
			return true;
		} else if (!Inventory.contains(Data.foodName)) {
			return true;
		} else if (City.FALADOR.getArea().contains(Players.getLocal()) && Inventory.getCount(Data.foodName) < Data.amountOfFood){
			return true;
		}
	return false;

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

	public static boolean myPlayerNeedsToEat() {
		return Players.getLocal().getHealthPercent() < 45 && Data.amountOfFood > 1;
	}

	public static void eat() {
		if(Inventory.contains(Data.foodName)){
			hp = Players.getLocal().getCurrentHealth();
			Inventory.getItem(Data.foodName).click();
			Time.sleepUntil(new Condition(){
				@Override
				public boolean check() {
					return Players.getLocal().getCurrentHealth() > hp;
				}
			}, Random.nextInt(4000,5000));
		}else{
			LogHandler.log("Something is wrong, we dont have food");
		}
		
	}

	
	public static GroundItem getBestAvailableLoot() {
		return GroundItems.getNearest(item -> Data.lootID.contains(item.getID())
				&& getAssignment().getArea().contains(item));
	}

	public static boolean lootAvailable() {
		return getBestAvailableLoot() != null;
	}

	public static void loot() {
		GroundItem loot = getBestAvailableLoot();
		if (loot != null && getAssignment().getArea().contains(loot)) {
			if (Inventory.isFull() && Inventory.contains(Data.foodName)) {
				eat();
			} else {
					invAmount = Inventory.getCount(loot.getID());
					if(loot.isOnScreen()){
					loot.pickUp();
					Time.sleepUntil(new Condition(){
						@Override
						public boolean check() {
							return Inventory.getCount(loot.getID()) > invAmount;
						}
					}, Random.nextInt(7000,10000));
					if (Inventory.getCount(loot.getID()) > invAmount) {
						LogHandler.log("we looted!!"+ PriceLookup.getPrice(loot.getID()));
						Data.moneyMade += PriceLookup.getPrice(loot.getID());
					}
					}else{
						if(loot != null){
						Walking.findLocalPath(loot).traverse();
						Camera.turnTo(loot);
						}
					}
				}
		} else {
			LogHandler.log("loot is not available");
			return;
		}

	}

}
