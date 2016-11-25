package methods;

import org.tbot.internal.handlers.LogHandler;
import org.tbot.methods.GameObjects;
import org.tbot.methods.Players;
import org.tbot.wrappers.GameObject;

import data.Data;
import enums.assignment.agility.AgilityAssignment;

public class Agility {

	public static boolean shouldMove(){
		return !Players.getLocal().isMoving();
	}
	
	public static AgilityAssignment getAssignment(){
		return AgilityAssignment.GNOME_COURSE;
	}
	
	public static void climbObs(String action, int obstacleID){
		GameObject potential_obstacle = GameObjects.getNearest(objects -> objects.hasAction(action) && objects.getID() == obstacleID);
		if(potential_obstacle != null){
			LogHandler.log("We already clicked the object");
			if(Data.lastClickedObject != null && potential_obstacle.getID() == Data.lastClickedObject.getID()){
				LogHandler.log("We already clicked the object");
			}else{
			potential_obstacle.interact(action);
			Data.lastClickedObject = potential_obstacle;
			}
		}
	}
}
