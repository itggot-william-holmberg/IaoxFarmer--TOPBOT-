package state.agility;

import org.tbot.internal.handlers.LogHandler;
import org.tbot.methods.NPCChat;
import org.tbot.methods.Players;
import org.tbot.methods.Random;
import org.tbot.methods.Time;
import org.tbot.methods.Widgets;
import org.tbot.methods.tabs.Equipment;
import org.tbot.methods.tabs.Inventory;
import org.tbot.methods.walking.Walking;
import org.tbot.util.Condition;
import org.tbot.wrappers.Widget;
import org.tbot.wrappers.WidgetChild;
import org.tbot.wrappers.def.ItemDef;

import data.AgilityResources;
import data.Data;
import data.Item;
import data.agility.GnomeData;
import methods.Agility;
import methods.Combat;
import methods.Player;
import state.State;

public class WalkToAgilityCourse extends State {
	
	private WidgetChild w;

	@Override
	public boolean active() {
		return !Agility.playerInObstacleArea();
	}

	@Override
	public void execute() {
		switch (Agility.getAssignment()) {
		case GNOME_COURSE:
			WalkToGnomeCourse();
			break;
		}
		// Data.currentMission = "Lets go to the agility course";
		// Walking.findPath(AgilityResources.gnomeAgilityArea.getCentralTile()).traverse();

	}

	private void WalkToGnomeCourse() {
		if(GnomeData.GNOME_GATE_AREA.contains(Players.getLocal())){
			if(NPCChat.getNPCChatWidget() != null){
				w = Widgets.getWidget(219).getChild(0).getChild(2);
				if(w != null){
					w.click();
					Time.sleep(Random.nextInt(2000,3000));
					Widgets.clickContinue();
					Time.sleep(Random.nextInt(2000,3000));
					Widgets.clickContinue();
					Time.sleepUntil(new Condition(){

						@Override
						public boolean check() {
							return Players.getLocal().getRegionY() > 3383;
						}
						
					}, Random.nextInt(10000,12000));
				}
			} else{
				Agility.climbObs("Open", 190);
			}
		} else if (Player.playerHasItem(Item.COMBAT_BRAC) && !GnomeData.WHOLE_GNOME_INCLUDING_TELEPORT_AREA.contains(Players.getLocal())) {
			travelToGnomeWithTeleport();
		} else{
			Walking.findPath(GnomeData.OBSTACLES[0].getArea().getCentralTile()).traverse();
		}
		
	}
	
	private void travelToGnomeWithTeleport() {
		if (Equipment.contains(Item.COMBAT_BRAC.getItemName())) {
			LogHandler.log("lets teleport");
			Equipment.getItem(Item.COMBAT_BRAC.getItemName()).interact("Ranging guild");
			Time.sleepUntil(new Condition(){

				@Override
				public boolean check() {
					return GnomeData.WHOLE_GNOME_INCLUDING_TELEPORT_AREA.contains(Players.getLocal());
				}
				
			});
		} else if (Inventory.contains(Item.COMBAT_BRAC.getItemName())) {
			LogHandler.log("lets equip teleportmethod");
			Inventory.getItem(Item.COMBAT_BRAC.getItemName()).click();
		} else {
			LogHandler.log("lets get the bracelet");
			Data.ITEM_WITHDRAW_LIST.add(Item.COMBAT_BRAC);
		}

	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

}
