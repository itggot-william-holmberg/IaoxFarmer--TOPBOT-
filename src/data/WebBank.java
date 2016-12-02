package data;

import org.tbot.methods.Players;
import org.tbot.wrappers.Area;

public enum WebBank {

    DRAYNOR(Areas.DRAYNOR),
    //AL_KHARID(Areas.AL_KHARID),
    //LUMBRIDGE(Areas.LUMBRIDGE_UPPER),
    //FALADOR_EAST(Areas.FALADOR_EAST),
    FALADOR_WEST(Areas.FALADOR_WEST),
    //VARROCK_EAST(Areas.FALADOR_EAST),
    //VARROCK_WEST(Areas.VARROCK_WEST),
    //SEERS(Areas.CAMELOT),
    //CATHERBY(Areas.CATHERBY),
    //EDGEVILLE(Areas.EDGEVILLE),
    //YANILLE(Areas.YANILLE),
    //GNOME_STRONGHOLD(Areas.GNOME_STRONGHOLD),
    //ARDOUNGE_NORTH(Areas.ARDOUGNE_NORTH),
    //ARDOUNE_SOUTH(Areas.ARDOUGNE_SOUTH),
    //CASTLE_WARS(Areas.CASTLE_WARS),
    //DUEL_ARENA(Areas.DUEL_ARENA),
    //PEST_CONTROL(Areas.PEST_CONTROL),
    //CANIFIS(Areas.CANIFIS),
    //TZHAAR(Areas.TZHAAR),
	GRAND_EXCHANGE(Areas.GRAND_EXCHANGE);

    private final Area area;

    WebBank(Area area) {
        this.area = area;
    }

    public static WebBank getNearest() {
        WebBank bank = null;
        int distance = Integer.MAX_VALUE;
        for (WebBank b : WebBank.values()) {
            final int bDistance = b.area.getCentralTile().distance(Players.getLocal());
            if (bDistance < distance) {
                distance = bDistance;
                bank = b;
            }
        }
        return bank;
    }

    public Area getArea() {
        return area;
    }
}