package state.combat;

import org.tbot.methods.Players;
import org.tbot.methods.walking.Walking;

import data.Areas;
import data.Data;
import methods.Combat;
import state.State;

public class WalkToFight extends State{

	@Override
	public boolean active() {
		return !Combat.playerReadyForFight();
	}

	@Override
	public void execute() {
		Data.currentMission = "Lets gogoooogoog";
		Walking.findPath(Combat.getAssignment().getArea().getCentralTile()).traverse();
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

}
