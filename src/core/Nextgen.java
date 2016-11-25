package core;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import org.tbot.bot.TBot;
import org.tbot.internal.AbstractScript;
import org.tbot.internal.Manifest;
import org.tbot.internal.event.EventManager;
import org.tbot.internal.event.listeners.PaintListener;
import org.tbot.internal.handlers.RandomHandler;
import org.tbot.internal.handlers.ScriptHandler;
import org.tbot.methods.Game;
import org.tbot.methods.Skills;
import org.tbot.methods.Widgets;
import org.tbot.wrappers.WorldData;

import data.Data;
import gui.NextgenGUI;
import state.State;
import state.agility.AgilityAction;
import state.agility.WalkToGnomeCourse;
import state.combat.Fight;
import state.combat.WalkToFight;
import tasks.Task;

@Manifest(name = "TestScript", version = 2.2122)
public class Nextgen extends AbstractScript implements PaintListener {

	public static List<Task> taskHandler = new ArrayList<Task>();
	public static Task currentTask = null;

	public static List<State> stateHandler = new ArrayList<State>();
	public static List<State> withdrawItemstateHandler = new ArrayList<State>();
	public NextgenGUI gui;

	@Override
	public boolean onStart() {
		gui = new NextgenGUI();
		return super.onStart();
	}

	@Override
	public int loop() {

		if (Data.shouldRun) {

			if (currentTask != null && !taskIsCompleted(currentTask)) {
				
				checkContinue();
				
				if (!shouldHop()) {

					if (Data.ITEM_WITHDRAW_LIST.isEmpty()) {

						boolean foundState = false;

						for (State state : stateHandler) {

							if (state.active()) {
								Data.currentState = state;
								state.execute();
								foundState = true;
							}
						}
						if (!foundState) {
							log("We couldnt find a state.. what should we do?");
							log("if this occurs more than 10 times we should do a 'home tele' or something");
							return 5000;
						}
					} else {
						for (State state : withdrawItemstateHandler) {

							if (state.active()) {
								Data.currentState = state;
								state.execute();
							}
						}
					}
				} else {
					log("We should hop world. This world is either crowded or a 'bad world'");
					hopWorld();
				}

			} else {
				currentTask = newTask();
				return 1000;
			}
		} else {
			log("Waiting for user input");
			return 2500;
		}
		log("Loop");
		return 700;
	}

	public void checkContinue() {
		if (Widgets.canContinue()) {
			Widgets.clickContinue();
		}
		return;
	}

	private boolean taskIsCompleted(Task task) {
		if (task == null) {
			return true;
		}
		if (Skills.getCurrentLevel(task.getSkill()) >= task.getLevelGoal()) {
			return true;
		}
		return false;
	}

	private Task newTask() {
		if (taskIsCompleted(currentTask)) {
			log("Removing current task");
			taskHandler.remove(currentTask);
		}
		if (!taskHandler.isEmpty()) {
			for (Task task : taskHandler) {
				if (!taskIsCompleted(task)) {
					log("We found a suitable task");
					addStates(task);
					Data.currentTask = task;
					return task;
				} else {
					log("We already completed that task, lets remove it.");
					taskHandler.remove(task);
				}
			}
		} else {
			log("Stopping script because no task available");
			stop();
		}
		return null;
	}

	public boolean shouldHop() {
		if (Game.getCurrentWorld() == Data.badWorld) {
			return true;
		}
		return false;
	}

	private void hopWorld() {

		if (Game.isMembersWorld()) {
			Game.hopRandomP2P();
		} else {
			Game.hopRandomF2P();
		}

		sleep(3000, 6000);

		if (!shouldHop()) {
			Data.amountOfWorldHops += 1;
		}
	}

	private void addStates(Task task) {

		stateHandler.clear();
		switch (task.getAssignment()) {
		case ATTACK:
		case STRENGTH:
		case DEFENCE:
		case RANGE:
			stateHandler.add(new WalkToFight());
			stateHandler.add(new Fight());
			// stateHandler.add(new WalkToFight().init(this));
			// stateHandler.add(new FightBank().init(this));
			// stateHandler.add(new WalkToFightBank().init(this));
			break;
		case AGILITY:
			// if agil level < 20
			stateHandler.add(new AgilityAction());
			stateHandler.add(new WalkToGnomeCourse());
			break;
		}

	}

	@Override
	public void onRepaint(Graphics g) {
		g.drawString("Mission: " + Data.currentMission, 50, 50);

	}
	
	public static void stop(){
		TBot.getBot().getScriptHandler().stopScript();
	}

}
