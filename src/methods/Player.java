package methods;


import data.Data;
import data.Item;

public class Player {

	public static boolean playerHasItem(Item item) {
		return !Data.ITEM_WE_NEED_TO_BUY_LIST.contains(item);
	}
}
