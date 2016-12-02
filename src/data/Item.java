package data;


public enum Item {
	harpoon("Harpoon", 311),cammyTeleport("Camelot teleport",8010),dragonAxe("Dragon axe",6739), waterStaff("Staff of water", 1383),
	ringMould("Ring mould", 1592), cosmicRune("Cosmic rune", 564), goldBar("Gold bar", 2357),
	grimyRanarr("Grimy ranarr", 207),grimyIrit("Grimy irit leaf", 209), grimyAvantoe("Grimy avantoe", 211),
	grimyKwuarm("Grimy kwuarm", 213), grimyHarralander("Grimy harralander", 205),grimyDwarfWeed("Grimy dwarf weed", 217), grimyLantadyme("Grimy lantadyme", 2485),
	lawRune("Law rune", 563), natureRune("Nature rune", 561), mithrilBolts("Mithril bolts", 9142),
	wizardHat("Wizard hat", 579),mindRune("Mind rune", 558), fireRune("Fire rune", 554),
	bronzeAxe("Bronze axe",1351),bronzePick("Bronze pickaxe",1265),coins("Coins", 995),
	ironKiteShield("Iron kiteshield", 1191),ironPlateLegs("Iron platelegs", 1067), 
	amuletOfStrength("Amulet of strength", 1725),ironScimmy("Iron scimitar", 1323), 
	ironFullHelm("Iron full helm", 1153), leatherBody("Leather body", 1129),
	bronzeLongSword("Bronze longsword", 1291), mithrilPick("Mithril pickaxe", 1273), addyPick("Adamant pickaxe", 1271),
	runePick("Rune pickaxe", 1275), mithrilAxe("Mithril axe", 1355),adamantAxe("Adamant axe", 1357),
	runeAxe("Rune axe", 1359), feather("Feather", 314), flyFishingRod("Fly fishing rod", 309), smallFishingNet("Small fishing net", 303),
	rawShrimp("Raw shrimps", 317), rawTrout("Raw trout", 335), rawSalmon("Raw salmon", 331), mithrilPlateLegs("Mithril platelegs", 1071),
	mithrilPlateBody("Mithril platebody", 1121), mithrilFullHelm("Mithril full helm", 1159), mithrilKiteShield("Mithril kiteshield", 1197),
	mithrilScimmy("Mithril scimitar", 1329), leatherChaps("Leather chaps", 1095), leatherVambs("Leather vambraces", 1063), coif("Leather cowl", 1167),
	bronzeArrows("Bronze arrow", 882), diamondRing("Diamond ring", 1643), amuletOfPower("Amulet of power", 1731), greenCape("Green cape", 1027),
	leatherBoots("Leather boots", 1061), shortbow("Shortbow", 841), studdedChaps("Studded chaps", 1097), mapleShortbow("Maple shortbow", 853), trout("Trout",333),
	leather("Leather", 1741), needle("Needle", 1733), thread("Thread", 1734), blueWizardRobe("Blue wizard robe", 577), shadeRobe("Shade robe", 548), airStaff("Staff of air", 1381), airRune("Air rune", 556), goldOre("Gold ore", 444), fallyTab("Falador teleport", 8009), runeScimmy("Rune scimitar", 1333),YEW_LOG("Yew logs", 1515),NORMAL_LOG("Logs", 1511),
	COMBAT_BRAC("Combat bracelet(6)", 11972),

	
	//others
	NOTHING("Nothing", 0);
	
	private String itemName;
	private int ID;

	Item(String itemName, int ID){
		this.itemName= itemName;
		this.ID = ID;
	}
	

	
	
	public String getItemName(){
		return itemName;
	}
	
	public int getItemID(){
		return ID;
	}
	
	
	
	public static Item ItemExist(String name){
		for(Item gen : Item.values()){
			if(gen.getItemName() == name){
				return gen;
			}
		}
		return null;
	}
	public static Item ItemExist(int id){
		for(Item gen : Item.values()){
			if(gen.getItemID() == id){
				return gen;
			}
		}
		return null;
	}
}
