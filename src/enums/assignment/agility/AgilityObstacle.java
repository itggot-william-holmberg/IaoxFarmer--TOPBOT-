package enums.assignment.agility;

import java.util.List;

import org.tbot.wrappers.Area;

public class AgilityObstacle {

	private Area obstacleArea;
	private String obstacleAction;
	private int obstacleID;

	public AgilityObstacle(Area obstacleArea, String obstacleAction, int obstacleID){
		this.obstacleArea = obstacleArea;
		this.obstacleAction = obstacleAction;
		this.obstacleID = obstacleID;
	}

	public String getAction() {
		return this.obstacleAction;
	}

	public int getObstacleID() {
		return obstacleID;
	}

	public Area getArea() {
		return this.obstacleArea;
	}
}
