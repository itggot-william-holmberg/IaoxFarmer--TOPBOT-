package data;

import org.tbot.wrappers.Area;
import org.tbot.wrappers.Tile;

public class AgilityResources {

	public int noStateFoundTimes;






	public static int totalLoot;




	

	public static String STATE;

	public static long sleepTime = 1250;

	public static String lastAction;
	
	
	public static Area AREA_1_BALANCE_LOG_AREA = new Area(2477,3436,2472,3439);
	
	public static final Area balanceLogArea = new Area(new Tile(2477,3434,0), new Tile(2471,3439,0));
	public static final Area climbNetArea = new Area(new Tile(2471,3430,0), new Tile(2477,3425,0));
	public static final Area balanceRopeArea = new Area( new Tile(2477,3421,2), new Tile(2471,3418,2));
	public static final Area climbRanchArea = new Area(new Tile(2471,3424,1), new Tile(2476,3422,1));
	public static final Area climbDownRanchArea = new Area( new Tile(2483,3418,2), new Tile(2488,3421,2));
	public static final Area climbNet2Area = new Area( new Tile(2482,3425,0), new Tile(2488,3418,0));
	public static final Area pipeArea = new Area( new Tile(2488,3427,0), new Tile(2483,3431,0));
	public static final Area outOfPipeArea = new Area( new Tile(2483,3436,0), new Tile(2488,3439,0));
	public static final Area gnomeGateArea = new Area(new Tile[] {
			new Tile(2457, 3378, 0),
			new Tile(2456, 3384, 0),
			new Tile(2465, 3384, 0),
			new Tile(2466, 3376, 0)
	});
	
	public static final Area outsideGnomeAgil = new Area(new Tile[] {
			new Tile(2464, 3384, 0),
			new Tile(2458, 3384, 0),
			new Tile(2465, 3388, 0),
			new Tile(2468, 3392, 0),
			new Tile(2493, 3408, 0),
			new Tile(2493, 3449, 0),
			new Tile(2406, 3441, 0)
	});
	
	public static final Tile pathToLog =  new Tile(2474,3438,0);
	
	public static final Tile[] pathToTreeGnome = new Tile[] {
			new Tile(2808, 3434, 0),
			new Tile(2796, 3433, 0),
			new Tile(2793, 3434, 0),
			new Tile(2791, 3436, 0),
			new Tile(2789, 3440, 0),
			new Tile(2787, 3443, 0),
			new Tile(2784, 3447, 0),
			new Tile(2782, 3449, 0),
			new Tile(2778, 3450, 0),
			new Tile(2775, 3451, 0),
			new Tile(2774, 3452, 0),
			new Tile(2772, 3455, 0),
			new Tile(2769, 3458, 0),
			new Tile(2768, 3460, 0),
			new Tile(2766, 3462, 0),
			new Tile(2763, 3465, 0),
			new Tile(2760, 3468, 0),
			new Tile(2755, 3473, 0),
			new Tile(2752, 3477, 0),
			new Tile(2746, 3482, 0),
			new Tile(2740, 3483, 0),
			new Tile(2733, 3485, 0),
			new Tile(2727, 3486, 0),
			new Tile(2722, 3486, 0),
			new Tile(2715, 3486, 0),
			new Tile(2708, 3486, 0),
			new Tile(2700, 3486, 0),
			new Tile(2689, 3485, 0),
			new Tile(2683, 3483, 0),
			new Tile(2679, 3480, 0),
			new Tile(2677, 3475, 0),
			new Tile(2675, 3469, 0),
			new Tile(2674, 3466, 0),
			new Tile(2673, 3462, 0),
			new Tile(2673, 3462, 0),
			new Tile(2673, 3461, 0),
			new Tile(2673, 3459, 0),
			new Tile(2670, 3457, 0),
			new Tile(2669, 3456, 0),
			new Tile(2667, 3455, 0),
			new Tile(2666, 3455, 0),
			new Tile(2664, 3451, 0),
			new Tile(2662, 3448, 0),
			new Tile(2659, 3446, 0),
			new Tile(2657, 3444, 0),
			new Tile(2654, 3441, 0),
			new Tile(2653, 3440, 0),
			new Tile(2652, 3438, 0),
			new Tile(2651, 3436, 0),
			new Tile(2648, 3429, 0),
			new Tile(2647, 3428, 0),
			new Tile(2647, 3426, 0),
			new Tile(2645, 3422, 0),
			new Tile(2644, 3415, 0),
			new Tile(2644, 3414, 0),
			new Tile(2644, 3412, 0),
			new Tile(2644, 3410, 0),
			new Tile(2645, 3409, 0),
			new Tile(2644, 3405, 0),
			new Tile(2643, 3403, 0),
			new Tile(2642, 3402, 0),
			new Tile(2641, 3401, 0),
			new Tile(2638, 3399, 0),
			new Tile(2636, 3398, 0),
			new Tile(2632, 3397, 0),
			new Tile(2631, 3396, 0),
			new Tile(2630, 3395, 0),
			new Tile(2627, 3394, 0),
			new Tile(2621, 3392, 0),
			new Tile(2619, 3392, 0),
			new Tile(2613, 3391, 0),
			new Tile(2609, 3391, 0),
			new Tile(2607, 3391, 0),
			new Tile(2601, 3390, 0),
			new Tile(2598, 3390, 0),
			new Tile(2597, 3390, 0),
			new Tile(2592, 3390, 0),
			new Tile(2587, 3390, 0),
			new Tile(2585, 3390, 0),
			new Tile(2580, 3390, 0),
			new Tile(2574, 3390, 0),
			new Tile(2566, 3392, 0),
			new Tile(2563, 3392, 0),
			new Tile(2560, 3393, 0),
			new Tile(2555, 3395, 0),
			new Tile(2554, 3396, 0),
			new Tile(2548, 3398, 0),
			new Tile(2547, 3398, 0),
			new Tile(2542, 3400, 0),
			new Tile(2539, 3400, 0),
			new Tile(2536, 3400, 0),
			new Tile(2534, 3401, 0),
			new Tile(2531, 3402, 0),
			new Tile(2529, 3402, 0),
			new Tile(2524, 3401, 0),
			new Tile(2523, 3400, 0),
			new Tile(2519, 3397, 0),
			new Tile(2517, 3395, 0),
			new Tile(2513, 3392, 0),
			new Tile(2509, 3389, 0),
			new Tile(2504, 3387, 0),
			new Tile(2504, 3387, 0),
			new Tile(2502, 3387, 0),
			new Tile(2499, 3388, 0),
			new Tile(2497, 3388, 0),
			new Tile(2493, 3389, 0),
			new Tile(2490, 3388, 0),
			new Tile(2485, 3388, 0),
			new Tile(2482, 3388, 0),
			new Tile(2476, 3388, 0),
			new Tile(2470, 3388, 0),
			new Tile(2469, 3385, 0),
			new Tile(2464, 3383, 0),
			new Tile(2461, 3380, 0)
	};
	
	public static final Area gnomeAgilityArea = new Area(new Tile[] { new Tile(2472,3441,0), new Tile(2478,3441,0), new Tile(2468,3437,0), new Tile(2468,3434,0), new Tile(2468,3425,0), new Tile(2468,3421,0), new Tile(2468,3417,0), new Tile(2470,3415,0), new Tile(2473,3413,0), new Tile(2475,3413,0), new Tile(2479,3413,0), new Tile(2483,3413,0), new Tile(2486,3413,0), new Tile(2487,3413,0), new Tile(2490,3416,0), new Tile(2491,3418,0), new Tile(2491,3421,0), new Tile(2491,3425,0), new Tile(2491,3429,0), new Tile(2491,3432,0), new Tile(2491,3436,0), new Tile(2489,3439,0), new Tile(2487,3441,0), new Tile(2481,3441,0), new Tile(2474,3441,0), new Tile(2471,3440,0),});
	
	
	public static final Tile[] pathToAgility = new Tile[] {
			new Tile(2460, 3387, 0),
			new Tile(2461, 3388, 0),
			new Tile(2460, 3390, 0),
			new Tile(2460, 3390, 0),
			new Tile(2460, 3392, 0),
			new Tile(2460, 3393, 0),
			new Tile(2460, 3395, 0),
			new Tile(2461, 3397, 0),
			new Tile(2461, 3398, 0),
			new Tile(2461, 3400, 0),
			new Tile(2461, 3402, 0),
			new Tile(2461, 3403, 0),
			new Tile(2461, 3406, 0),
			new Tile(2461, 3410, 0),
			new Tile(2461, 3413, 0),
			new Tile(2459, 3418, 0),
			new Tile(2459, 3420, 0),
			new Tile(2460, 3424, 0),
			new Tile(2461, 3426, 0),
			new Tile(2461, 3429, 0),
			new Tile(2461, 3432, 0),
			new Tile(2461, 3434, 0),
			new Tile(2463, 3436, 0),
			new Tile(2466, 3438, 0),
			new Tile(2470, 3436, 0),
			new Tile(2474, 3438, 0)
	};
	
	public static final Area WHOLE_GNOME_INCLUDING_TELEPORT_AREA = new Area(new Tile[] {
			new Tile(2669, 3449, 0),
			new Tile(2662, 3383, 0),
			new Tile(2605, 3344, 0),
			new Tile(2430, 3341, 0),
			new Tile(2412, 3458, 0),
			new Tile(2443, 3507, 0),
			new Tile(2617, 3497, 0)
	});






	public static final Area GNOME_GATE_AREA = new Area(2464,3383,2459,3380);
}
