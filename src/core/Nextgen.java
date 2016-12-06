package core;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.tbot.bot.TBot;
import org.tbot.internal.AbstractScript;
import org.tbot.internal.Manifest;
import org.tbot.internal.event.EventManager;
import org.tbot.internal.event.listeners.PaintListener;
import org.tbot.internal.handlers.RandomHandler;
import org.tbot.internal.handlers.ScriptHandler;
import org.tbot.methods.Game;
import org.tbot.methods.Skills;
import org.tbot.methods.Time;
import org.tbot.methods.Widgets;
import org.tbot.wrappers.WorldData;

import data.Data;
import gui.NextgenGUI;
import state.State;
import state.agility.AgilityAction;
import state.agility.WalkToAgilityCourse;
import state.combat.Fight;
import state.combat.FightBank;
import state.combat.WalkToFight;
import state.combat.WalkToFightBank;
import tasks.Task;

@Manifest(name = "TestScript", version = 2.8)
public class Nextgen extends AbstractScript implements PaintListener {

	public static List<Task> taskHandler = new ArrayList<Task>();
	public static Task currentTask = null;

	public static List<State> stateHandler = new ArrayList<State>();
	public static List<State> withdrawItemstateHandler = new ArrayList<State>();
	public NextgenGUI gui;
	public static long timeRan;
	public static long timeStarted;

	@Override
	public boolean onStart() {
		gui = new NextgenGUI();
		timeStarted = System.currentTimeMillis();
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
			stateHandler.add(new FightBank());
			stateHandler.add(new WalkToFightBank());
			break;
		case AGILITY:
			// if agil level < 20
			stateHandler.add(new AgilityAction());
			stateHandler.add(new WalkToAgilityCourse());
			break;
		}

	}

	@Override
	public void onRepaint(Graphics g) {
		timeRan = System.currentTimeMillis() - timeStarted;
		g.drawString("Mission: " + Data.currentMission, 340, 345);
		g.drawString("Time ran: " + ft(timeRan), 340,365);
		g.drawString("Money made: " + Data.moneyMade  + " (" + perHour(Data.moneyMade) + ")", 340,385);
	}
	
	private String ft(long duration) {

		String res = "";
		long days = TimeUnit.MILLISECONDS.toDays(duration);
		long hours = TimeUnit.MILLISECONDS.toHours(duration)
				- TimeUnit.DAYS.toHours(TimeUnit.MILLISECONDS.toDays(duration));
		long minutes = TimeUnit.MILLISECONDS.toMinutes(duration)
				- TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(duration));
		long seconds = TimeUnit.MILLISECONDS.toSeconds(duration)
				- TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(duration));
		if (days == 0) {
			res = (hours + ":" + minutes + ":" + seconds);
		} else {
			res = (days + ":" + hours + ":" + minutes + ":" + seconds);
		}
		return res;
	}
	
	private int perHour(int i){
		return (int) (i /((timeRan) / 3600000.0D));
	}
	
	public static void stop(){
		TBot.getBot().getScriptHandler().stopScript();
	}

}
