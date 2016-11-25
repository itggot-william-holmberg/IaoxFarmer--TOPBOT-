package enums.assignment.agility;

import java.util.ArrayList;
import java.util.List;

import org.tbot.wrappers.Area;

import data.Areas;
import data.NpcID;
import data.agility.GnomeData;

public enum AgilityAssignment {
	
	GNOME_COURSE(GnomeData.WHOLE_COURSE_AREA, GnomeData.OBSTACLES );
	
	private Area area;
	private List<AgilityObstacle> agilityObstacles;

	AgilityAssignment(Area area, AgilityObstacle[] agilityObstacles) {
		this.area = area;
		this.agilityObstacles= new ArrayList<AgilityObstacle>();
		for (AgilityObstacle obs : agilityObstacles) {
			this.agilityObstacles.add(obs);
		}
	}
	
	public Area getArea(){
		return this.area;
	}

	public List<AgilityObstacle> getObstacles() {
		return this.agilityObstacles;
	}
}
