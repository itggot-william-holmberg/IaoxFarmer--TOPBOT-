package state.agility;

import org.tbot.internal.handlers.LogHandler;
import org.tbot.methods.Players;
import org.tbot.methods.walking.Walking;

import data.AgilityResources;
import data.Data;
import methods.Combat;
import state.State;

public class WalkToGnomeCourse extends State {

	@Override
	public boolean active() {
		return !AgilityResources.gnomeAgilityArea.contains(Players.getLocal());
	}

	@Override
	public void execute() {
		Data.currentMission = "Lets go to the agility course";
		Walking.findPath(AgilityResources.gnomeAgilityArea.getCentralTile()).traverse();
		
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

}
