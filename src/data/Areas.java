package data;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.tbot.wrappers.Area;
import org.tbot.wrappers.Tile;



public class Areas {

	public static Area SEAGULL_AREA = new Area(new Tile[] { new Tile(3044, 3191, 0),
			new Tile(3024, 3192, 0), new Tile(3017, 3201, 0), new Tile(3014, 3206, 0),
			new Tile(3016, 3210, 0), new Tile(3033, 3212, 0), new Tile(3055, 3207, 0) });
	public static Area SEAGULL_AREA2 = new Area(3025, 3228, 3035, 3243);
	public static Area[] SEAGULL_AREAS = { SEAGULL_AREA, SEAGULL_AREA2 };
	public static Area CASTLE_WARS_BANK = new Area(new Tile[] { new Tile(2449, 3081, 0),
			new Tile(2430, 3081, 0), new Tile(2431, 3103, 0), new Tile(2451, 3104, 0) });

	public static Area WHOLE_CRAFTING_GUILD = new Area(new Tile[] { new Tile(2906, 3304, 0),
			new Tile(2954, 3300, 0), new Tile(2957, 3261, 0), new Tile(2901, 3263, 0) });
	public static final Area CRAFTING_GUILD = new Area(2928, 3293, 2943, 3276);
	public static final Area CRAFTING_GUILD_GOLD_ORE = new Area(2943, 3276, 2937, 3284);

	public static final Tile[] CRAFTING_GUILD_GOLD_ORE_SPOTS = { new Tile(2939, 3276, 0),
			new Tile(2941, 3276, 0), new Tile(2942, 3276, 0), new Tile(2943, 3279, 0),
			new Tile(2943, 3280, 0), new Tile(2938, 3278, 0), new Tile(2938, 3280, 0) };

	public static final Area GRAND_EXCHANGE = new Area(3160, 3484, 3169, 3492);

	public static Area FALADOR_AREA = new Area(new Tile[] {
			new Tile(3056, 3332, 0),
			new Tile(3018, 3328, 0),
			new Tile(3007, 3325, 0),
			new Tile(2991, 3320, 0),
			new Tile(2959, 3312, 0),
			new Tile(2946, 3315, 0),
			new Tile(2941, 3322, 0),
			new Tile(2937, 3324, 0),
			new Tile(2936, 3386, 0),
			new Tile(2946, 3394, 0),
			new Tile(3059, 3389, 0),
			new Tile(3065, 3386, 0),
			new Tile(3064, 3369, 0),
			new Tile(3057, 3360, 0)
	});
	public static Area VARROCK_AREA = new Area(
			new Tile[] { new Tile(3287, 3377, 0), new Tile(3153, 3378, 0), new Tile(3109, 3467, 0),
					new Tile(3110, 3488, 0), new Tile(3120, 3496, 0), new Tile(3129, 3498, 0),
					new Tile(3134, 3513, 0), new Tile(3140, 3521, 0), new Tile(3185, 3522, 0),
					new Tile(3251, 3522, 0), new Tile(3251, 3508, 0), new Tile(3251, 3500, 0),
					new Tile(3254, 3494, 0), new Tile(3259, 3493, 0), new Tile(3261, 3488, 0),
					new Tile(3261, 3478, 0), new Tile(3261, 3472, 0), new Tile(3264, 3465, 0),
					new Tile(3268, 3462, 0), new Tile(3269, 3456, 0), new Tile(3269, 3446, 0),
					new Tile(3269, 3437, 0), new Tile(3269, 3433, 0), new Tile(3271, 3434, 0) });

	public static Area VARROCK_EAST_MINE = new Area(new Tile[] { new Tile(3294, 3358, 0),
			new Tile(3292, 3357, 0), new Tile(3289, 3359, 0), new Tile(3285, 3360, 0),
			new Tile(3279, 3359, 0), new Tile(3279, 3362, 0), new Tile(3281, 3364, 0),
			new Tile(3282, 3366, 0), new Tile(3280, 3373, 0), new Tile(3284, 3375, 0),
			new Tile(3291, 3374, 0), new Tile(3290, 3369, 0), new Tile(3291, 3365, 0) });
	public static Area RIMMINGTON_MINE = new Area(
			new Tile[] { new Tile(2965, 3245, 0), new Tile(2970, 3249, 0), new Tile(2978, 3250, 0),
					new Tile(2984, 3250, 0), new Tile(2989, 3245, 0), new Tile(2988, 3235, 0),
					new Tile(2985, 3229, 0), new Tile(2978, 3228, 0), new Tile(2971, 3230, 0),
					new Tile(2967, 3235, 0), new Tile(2963, 3240, 0) });

	public static Area PORT_SARIM_DEPOSIT_AREA = new Area(new Tile[] { new Tile(3052, 3232, 0),
			new Tile(3040, 3232, 0), new Tile(3042, 3237, 0), new Tile(3054, 3238, 0) });
	public static Tile VARROCK_EAST_MINE_BEST_IRON_SPOT = new Tile(3286, 3368, 0);
	public static Tile RIMMINGTON_MINE_BEST_IRON_SPOT = new Tile(2982, 3233, 0);
	public static Tile RIMMINGTON_MINE_BEST_COPPER_SPOT = new Tile(2975, 3247, 0);
	public static Tile[] RIMMINGTON_IRON_ORE_SPOTS = { new Tile(2982, 3234, 0), new Tile(2981, 3233, 0) };
	public static Tile[] RIMMINGTON_COPPER_ORE_SPOTS = { new Tile(2976, 3247, 0) };

	public static Tile[] VARROCK_EAST_MINE_IRON_ORE_SPOTS = { new Tile(3286, 3369, 0),
			new Tile(3285, 3368, 0) };
	public static Area SEERS_YEWS_AREA = new Area(
			new Tile[] { new Tile(2765, 3425, 0), new Tile(2757, 3425, 0), new Tile(2753, 3428, 0),
					new Tile(2751, 3430, 0), new Tile(2751, 3435, 0), new Tile(2754, 3436, 0),
					new Tile(2760, 3436, 0), new Tile(2767, 3437, 0) });

	public static Area NORMAL_TREE_LUMBRIDGE = new Area(new Tile[] { new Tile(3197, 3219, 0),
			new Tile(3153, 3223, 0), new Tile(3154, 3238, 0), new Tile(3205, 3249, 0) });
	public static Area WILLOW_TREE_LUMBRIDGE_AREA = new Area(3182, 3268, 3175, 3277);

	public static Area WILLOW_TREE_DRAYNOR_AREA = new Area(new Tile[] { new Tile(3082, 3240, 0),
			new Tile(3095, 3239, 0), new Tile(3095, 3227, 0), new Tile(3085, 3226, 0) });

	public static Area MAPLE_TREE_CAMMY = new Area(
			new Tile[] { new Tile(2716, 3499, 0), new Tile(2715, 3506, 0), new Tile(2720, 3508, 0),
					new Tile(2733, 3504, 0), new Tile(2734, 3498, 0) });

	public static Area YEW_TREE_SEERS = new Area(new Tile[] { new Tile(2752, 3425, 0),
			new Tile(2751, 3436, 0), new Tile(2769, 3439, 0), new Tile(2771, 3424, 0) });
	public static Area TREE_AREA_LUMBRIDGE = new Area(
			new Tile[] { new Tile(3201, 3196, 0), new Tile(3200, 3234, 0), new Tile(3213, 3241, 0),
					new Tile(3216, 3253, 0), new Tile(3197, 3257, 0), new Tile(3191, 3258, 0),
					new Tile(3190, 3263, 0), new Tile(3182, 3270, 0), new Tile(3164, 3261, 0),
					new Tile(3136, 3263, 0), new Tile(3132, 3214, 0) });

	public static Area OAK_TREE_LUMBRIDGE_AREA = new Area(new Tile[] { new Tile(3209, 3237, 0),
			new Tile(3207, 3238, 0), new Tile(3203, 3236, 0), new Tile(3201, 3234, 0),
			new Tile(3196, 3240, 0), new Tile(3193, 3249, 0), new Tile(3200, 3252, 0),
			new Tile(3205, 3253, 0), new Tile(3206, 3249, 0), new Tile(3209, 3242, 0) });



public final static Area fallyTeleArea = new Area(2957, 3373, 2971, 3387);
public final static Area DRUID_AREA = new Area(2926, 9842, 2950, 9870);
public final static Area wholeDungeonArea = new Area (2881,9793,2950,9858);
public static final Area agilityArea = new Area(2936, 3352, 2942, 3358);
public static final Area agilityArea2 = new Area(2935, 3357, 2932, 3352);
public static final Area downLadderArea = new Area(2881, 9801, 2887, 9794);
}
