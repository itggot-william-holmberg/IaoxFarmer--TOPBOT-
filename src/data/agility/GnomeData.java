package data.agility;

import org.tbot.wrappers.Area;
import org.tbot.wrappers.Tile;

import enums.assignment.agility.AgilityObstacle;

public class GnomeData {
	
	public static Area GNOME_GATE_AREA = new Area(2459,3384,2463,3381);
	
	private static Area AREA_1_BALANCE_LOG_AREA = new Area(2477,3436,2472,3439);
	
	private static Area AREA_2_CLIMB_NET = new Area(2477,3429,2470,3426);

	
	public static AgilityObstacle[] OBSTACLES = {new AgilityObstacle(AREA_1_BALANCE_LOG_AREA, "Walk-across", 23145),
												 new AgilityObstacle(AREA_2_CLIMB_NET, "Climb-over", 23134)};
	
	public static Area WHOLE_COURSE_AREA = new Area(new Tile[] { new Tile(2472,3441,0), new Tile(2478,3441,0), new Tile(2468,3437,0), new Tile(2468,3434,0), new Tile(2468,3425,0), new Tile(2468,3421,0), new Tile(2468,3417,0), new Tile(2470,3415,0), new Tile(2473,3413,0), new Tile(2475,3413,0), new Tile(2479,3413,0), new Tile(2483,3413,0), new Tile(2486,3413,0), new Tile(2487,3413,0), new Tile(2490,3416,0), new Tile(2491,3418,0), new Tile(2491,3421,0), new Tile(2491,3425,0), new Tile(2491,3429,0), new Tile(2491,3432,0), new Tile(2491,3436,0), new Tile(2489,3439,0), new Tile(2487,3441,0), new Tile(2481,3441,0), new Tile(2474,3441,0), new Tile(2471,3440,0),});
	
}
