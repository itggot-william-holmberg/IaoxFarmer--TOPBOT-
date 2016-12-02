package data.agility;

import org.tbot.wrappers.Area;
import org.tbot.wrappers.Tile;

import enums.assignment.agility.AgilityObstacle;

public class GnomeData {
	
	public static Area GNOME_GATE_AREA = new Area(2459,3384,2463,3381);
	public static Area WHOLE_COURSE_AREA = new Area(new Tile[] { new Tile(2472,3441,0), new Tile(2478,3441,0), new Tile(2468,3437,0), new Tile(2468,3434,0), new Tile(2468,3425,0), new Tile(2468,3421,0), new Tile(2468,3417,0), new Tile(2470,3415,0), new Tile(2473,3413,0), new Tile(2475,3413,0), new Tile(2479,3413,0), new Tile(2483,3413,0), new Tile(2486,3413,0), new Tile(2487,3413,0), new Tile(2490,3416,0), new Tile(2491,3418,0), new Tile(2491,3421,0), new Tile(2491,3425,0), new Tile(2491,3429,0), new Tile(2491,3432,0), new Tile(2491,3436,0), new Tile(2489,3439,0), new Tile(2487,3441,0), new Tile(2481,3441,0), new Tile(2474,3441,0), new Tile(2471,3440,0),});

	private static Area AREA_1_BALANCE_LOG_AREA = new Area(2477,3436,2472,3439);
	private static Area AREA_2_CLIMB_NET = new Area(2477,3430,2470,3426);
	private static Area AREA_3_CLIMB_TREE = new Area(new Tile(2471,3425,1),new Tile(2476,3422,1));
	private static Area AREA_4_BALANCE_ROPE = new Area(new Tile(2472,3418,2),new Tile(2478,3422,2));
	private static Area AREA_5_CLIMB_TREE = new Area(new Tile(2482,3418,2),new Tile(2488,3421,2));
	private static Area AREA_6_CLIMB_OBSTACLE = new Area(2489,3419,2482,3426);
	private static Area AREA_7_SQUEEZE_OBS = new Area(2483,3426,2489,3432);
	
	public static final Area WHOLE_GNOME_INCLUDING_TELEPORT_AREA = new Area(new Tile[] {
			new Tile(2669, 3449, 0),
			new Tile(2662, 3383, 0),
			new Tile(2605, 3344, 0),
			new Tile(2430, 3341, 0),
			new Tile(2412, 3458, 0),
			new Tile(2443, 3507, 0),
			new Tile(2617, 3497, 0)
	});
	
	public static AgilityObstacle[] OBSTACLES = {new AgilityObstacle(AREA_1_BALANCE_LOG_AREA, "Walk-across", 23145),
												 new AgilityObstacle(AREA_2_CLIMB_NET, "Climb-over", 23134),
												 new AgilityObstacle(AREA_3_CLIMB_TREE, "Climb", 23559),
												 new AgilityObstacle(AREA_4_BALANCE_ROPE, "Walk-on", 23557),
												 new AgilityObstacle(AREA_5_CLIMB_TREE, "Climb-down", 23560),
												 new AgilityObstacle(AREA_6_CLIMB_OBSTACLE, "Climb-over", 23135),
												 new AgilityObstacle(AREA_7_SQUEEZE_OBS, "Squeeze-through", 23139)};
		
}
