package state.combat;

import org.tbot.methods.Bank;
import org.tbot.methods.Players;
import org.tbot.methods.Random;
import org.tbot.methods.tabs.Inventory;

import data.Data;
import methods.BankMethods;
import methods.Combat;
import state.State;

public class FightBank extends State{

	@Override
	public boolean active() {
		if (Combat.getAssignment().getBankArea().contains(Players.getLocal()) && !Combat.playerReadyForCombat()) {
			return true;
		}
		return false;
	}

	@Override
	public void execute() {
		switch(Combat.getAssignment()){
		default:
			//idk?
			break;
		case DRUIDS:
			bankDruids();
			break;
		}
	}	

	private void bankDruids() {
		if(Inventory.isFull() || Inventory.getEmptySlots() < 20){
			BankMethods.depositAll();
		}else if(!Inventory.contains("Falador Teleport")){
			BankMethods.withdraw(Random.nextInt(4) + 1, "Falador Teleport");
		}else if(Data.amountOfFood > 0 && Inventory.getCount(Data.foodName) < 5){
			BankMethods.withdraw(Data.amountOfFood + Random.nextInt(2),Data.foodName );
		}
		
		
	}

	@Override
	public String toString() {
		return "Lets bank";
	}

}