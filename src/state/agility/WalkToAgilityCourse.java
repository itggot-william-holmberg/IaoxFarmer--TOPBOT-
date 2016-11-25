package state.agility;

import org.tbot.internal.handlers.LogHandler;
import org.tbot.methods.NPCChat;
import org.tbot.methods.Players;
import org.tbot.methods.walking.Walking;

import data.AgilityResources;
import data.Data;
import data.agility.GnomeData;
import methods.Agility;
import methods.Combat;
import state.State;

public class WalkToAgilityCourse extends State {

	@Override
	public boolean active() {
		return true;
	}

	@Override
	public void execute() {
		switch(Agility.getAssignment()){
		case GNOME_COURSE:
			WalkToGnomeCourse();
			break;
		}
		//Data.currentMission = "Lets go to the agility course";
		//Walking.findPath(AgilityResources.gnomeAgilityArea.getCentralTile()).traverse();
		
	}

	private void WalkToGnomeCourse() {
		if(GnomeData.GNOME_GATE_AREA.contains(Players.getLocal())){
			if(NPCChat.getNPCChatWidget() != null){
				LogHandler.log("tjena!");
			}
		} //else if() player should tele		
		else{
			Walking.findPath(GnomeData.OBSTACLES[0].getArea().getCentralTile()).traverse();
		}
		
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

}
