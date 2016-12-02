package methods;

import org.tbot.internal.handlers.LogHandler;
import org.tbot.methods.Bank;
import org.tbot.methods.Time;

import core.Nextgen;
import data.Data;

public class BankMethods {

	public static void withdraw(int amount, String item){
		if(Bank.isOpen()){
			Data.currentMission = "Lets withdraw " + amount + " " + item;
			if(Bank.contains(item)){
			Bank.withdraw(item, amount);
			}else{
				LogHandler.log("we dont have the item");
				Nextgen.stop();
			}
			Time.sleep(2000,4000);
		}else{
			Data.currentMission = "Lets open the bank";
			Bank.openNearestBank();
		}
	}
	public static void depositAll(){
		if(Bank.isOpen()){
			Data.currentMission = "Lets deposit all";
			Bank.depositAll();
			Time.sleep(2000,4000);
		}else{
			Data.currentMission = "Lets open the bank";
			Bank.openNearestBank();
		}
	}
}
