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
	private int i;
	@Override
	public boolean active() {
		return Agility.playerInObstacleArea();
	}

	@Override
	public void execute() {
		i = 0;
		for (AgilityObstacle obstacle : Agility.getAssignment().getObstacles()){
			if (obstacle.getArea().contains(Players.getLocal())) {
				LogHandler.log("We found the perfect obstacle");
				if (Agility.shouldMove()) {
					Agility.climbObs(obstacle.getAction(), obstacle.getObstacleID());
					LogHandler.log(i + "    " + Agility.getAssignment().getObstacles().size());
					if(i+1<Agility.getAssignment().getObstacles().size()){
						LogHandler.log("Lets do a nice sleep");
					Time.sleepUntil(new Condition() {
						@Override
						public boolean check() {
							return Agility.getAssignment().getObstacles().get(i+1).getArea().contains(Players.getLocal() );
						}
					}, Random.nextInt(10000,15000));
					}else{
						LogHandler.log("Lets do a bad sleep");
						Time.sleep(8500,11000);
					}
				}
				return;
			}else{
				LogHandler.log("No Obstacle found");
				i++;
			}
		}
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

}
