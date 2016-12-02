package state.combat;

import org.tbot.methods.Players;
import org.tbot.methods.tabs.Inventory;
import org.tbot.methods.walking.Walking;

import data.City;
import methods.Combat;
import methods.Teleport;
import state.State;

public class WalkToFightBank extends State{
	
	@Override
	public boolean active() {
		if (!Combat.getAssignment().getBankArea().contains(Players.getLocal()) && !Combat.playerReadyForCombat()) {
			return true;
		}
		return false;
	}

	@Override
	public void execute() {
		switch(Combat.getAssignment()){
		case DRUIDS:
			walkToDruidBank();
			break;
		default:
			Walking.findPath(Combat.getAssignment().getBankArea().getCentralTile()).traverse();
			break;
		}
	}

	private void walkToDruidBank() {
		if(City.FALADOR.getArea().contains(Players.getLocal()) || !Inventory.contains("Falador teleport")){
			Walking.findPath(Combat.getAssignment().getBankArea().getCentralTile()).traverse();
		}else if(Inventory.contains("Falador teleport")){
			Teleport.teleportWithTablet("Falador teleport");
		}
		
	}

	@Override
	public String toString() {
		return "Lets walk to bank area";
	}
}
