package state.combat;

import org.tbot.methods.Players;
import org.tbot.methods.walking.Walking;

import data.Areas;
import data.Data;
import state.State;

public class WalkToFight extends State{

	@Override
	public boolean active() {
		return !Areas.agilityArea.contains(Players.getLocal().getLocation()) ;
	}

	@Override
	public void execute() {
		Data.currentMission = "Lets gogoooogoog";
		Walking.findPath(Areas.SEAGULL_AREA.getCentralTile()).traverse();
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

}
