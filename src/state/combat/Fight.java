package state.combat;

import org.tbot.internal.handlers.LogHandler;
import org.tbot.methods.Mouse;
import org.tbot.methods.Npcs;
import org.tbot.methods.Players;
import org.tbot.methods.Random;
import org.tbot.methods.Time;
import org.tbot.methods.input.mouse.target.ModelMouseTarget;
import org.tbot.util.Condition;
import org.tbot.wrappers.NPC;

import data.Data;
import methods.Combat;
import state.State;

public class Fight extends State {
	private NPC potential_enemy;
	private NPC current_enemy;
	private ModelMouseTarget mouseTarget;
	@Override
	public boolean active() {
		return Combat.playerReadyForFight();
	}

	@Override
	public void execute() {
		/*if (myPlayerNeedsToEat()) {
			eat();
		} else {
			if (lootAvailable()) {
				loot();
			} else {
				defaultFight();
			}
		}*/
		if (Combat.playerCanFight()) {				//check if our player is 100% ready to take on a fight
			if (Players.getLocal().getInteractingEntity() == null) {
				Data.currentMission = "Lets attack";
				attack();
			} else {
				Data.currentMission = "The health bar is not visible, but we are fighting";
			}
		} else {
			if (Players.getLocal().getInteractingEntity() == null) {
				Data.currentMission = "We are under attack but not attacking our enemy, lets attack the pussy!";
				current_enemy = Npcs.getNearest(npc -> npc.isInteractingWithLocalPlayer());
				attack(current_enemy);
			} else {
				current_enemy = (NPC) Players.getLocal().getInteractingEntity();
				Data.currentMission = "We are in a perfect fight ";
			}
		}
	}

	public void attack() {
		potential_enemy = Npcs.getNearest(npc -> Combat.getAssignment().getNpcID().contains(npc.getID())
				&& !npc.isHealthBarVisible() && npc.getHealthPercent() > 0);
		if (potential_enemy != null) {
			potential_enemy.interact("Attack");
			Time.sleepUntil(new Condition() {
				@Override
				public boolean check() {
					return potential_enemy.isDead() || potential_enemy.getHealthPercent() < 0 || potential_enemy.isInteractingWithLocalPlayer(); 													//break the loop if the enemy is dead or if the enemy is succesfully interacting with our player.
				}
			}, Random.nextInt(2000,4000));
			LogHandler.log("Lets break the loop");
		}
	}
	
	public void attack(NPC npc) {
		if (npc != null) {
			npc.interact("Attack");
			Time.sleepUntil(new Condition() {
				@Override
				public boolean check() {
					return npc.isDead() || potential_enemy.getHealthPercent() < 0 || npc.isInteractingWithLocalPlayer(); 													//break the loop if the enemy is dead or if the enemy is succesfully interacting with our player.
				}
			}, Random.nextInt(2000,4000));
			LogHandler.log("Lets break the loop");
		}
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

}
