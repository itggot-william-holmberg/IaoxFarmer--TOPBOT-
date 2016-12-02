package methods;

import org.tbot.internal.handlers.LogHandler;
import org.tbot.methods.Camera;
import org.tbot.methods.GameObjects;
import org.tbot.methods.Players;
import org.tbot.wrappers.GameObject;

import data.Data;
import enums.assignment.agility.AgilityAssignment;
import enums.assignment.agility.AgilityObstacle;

public class Agility {

	public static boolean shouldMove() {
		return !Players.getLocal().isMoving();
	}

	public static AgilityAssignment getAssignment() {
		return AgilityAssignment.GNOME_COURSE;
	}

	public static void climbObs(String action, int obstacleID) {
		GameObject potential_obstacle = GameObjects
				.getNearest(objects -> objects.hasAction(action) && objects.getID() == obstacleID);
		if (potential_obstacle != null) {
			if (potential_obstacle.isOnScreen()) {
				Data.currentMission = "Lets " + action + " " + obstacleID;
				potential_obstacle.interact(action);
			} else {
				Data.currentMission = "Lets turn the screen";
				Camera.turnTo(potential_obstacle);
			}
		}
	}

	public static boolean playerInObstacleArea() {
		for (AgilityObstacle obs : getAssignment().getObstacles()) {
			if (obs.getArea().contains(Players.getLocal())) {
				return true;
			}
		}
		return false;
	}
}
