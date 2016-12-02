package methods;

import org.tbot.methods.Players;
import org.tbot.methods.Random;
import org.tbot.methods.Time;
import org.tbot.methods.Widgets;
import org.tbot.methods.tabs.Inventory;
import org.tbot.util.Condition;
import org.tbot.wrappers.Tile;

public class Teleport {
	
	private static Tile tile;
	public static void teleportWithTablet(String teleport) {
		if (Inventory.contains(teleport)) {
			tile = Players.getLocal().getLocation();
			Widgets.close();
			Inventory.getFirst(teleport).click();
			Time.sleep(6000, 800);
		}
	}
}
