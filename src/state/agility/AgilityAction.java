package state.agility;

import org.tbot.internal.handlers.LogHandler;
import org.tbot.methods.Players;
import org.tbot.methods.Random;
import org.tbot.methods.Time;
import org.tbot.util.Condition;

import data.AgilityResources;
import enums.assignment.agility.AgilityObstacle;
import methods.Agility;
import state.State;

public class AgilityAction extends State {

	@Override
	public boolean active() {
		return true;
	}

	@Override
	public void execute() {
		for (AgilityObstacle obstacle : Agility.getAssignment().getObstacles()){
			if (obstacle.getArea().contains(Players.getLocal())) {
				LogHandler.log("We found the perfect obstacle");
				if (Agility.shouldMove()) {
					Agility.climbObs(obstacle.getAction(), obstacle.getObstacleID());
					Time.sleepUntil(new Condition() {
						@Override
						public boolean check() {
							return !Players.getLocal().isMoving();
						}
					}, Random.nextInt(4000, 6000));
				}
				return;
			}else{
				LogHandler.log("No Obstacle found");
			}
		}
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

}
