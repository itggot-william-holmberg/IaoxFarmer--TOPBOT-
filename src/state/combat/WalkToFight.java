
package state.combat;

import org.tbot.internal.handlers.LogHandler;
import org.tbot.methods.Players;
import org.tbot.methods.walking.Path;
import org.tbot.methods.walking.Walking;
import org.tbot.wrappers.Tile;

import data.Areas;
import data.Data;
import methods.Combat;
import state.State;

public class WalkToFight extends State{

	Path pathToFight;
	Tile fightPosition;
	@Override
	public boolean active() {
		return Combat.playerReadyForCombat() && !Combat.getAssignment().getArea().contains(Players.getLocal());
	}

	@Override
	public void execute() {
		fightPosition = Combat.getAssignment().getArea().getCentralTile();
		LogHandler.log(fightPosition.distance());
		if(fightPosition.distance() < 25){
			if(Walking.walkTileMM(new Tile(2932,9846,0))){
				LogHandler.log("We are moving, using local path");
			}else{
				LogHandler.log("we are not moving, something is wrong with local path");
			}
		}else{
			if(Walking.findPath(fightPosition).traverse()){
				LogHandler.log("We are moving, using web path");
			}else{
				LogHandler.log("we are not moving, something is wrong with web path");
			}
		}
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

}
