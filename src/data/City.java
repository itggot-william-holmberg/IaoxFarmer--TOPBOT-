package data;

import org.tbot.wrappers.Area;

public enum City {
	
	VARROCK(Areas.VARROCK_AREA), FALADOR(Areas.FALADOR_AREA);
	
	private Area area;
	City(Area cityArea) {
		this.area = cityArea;
	}
	
	public Area getArea(){
		return area;
	}
}
