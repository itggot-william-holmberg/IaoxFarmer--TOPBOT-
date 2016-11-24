package state;

import java.util.List;
import java.util.stream.Collectors;


import org.tbot.internal.AbstractScript;
import org.tbot.methods.Players;
import org.tbot.methods.Random;
import org.tbot.methods.Skills.Skill;
import org.tbot.methods.Widgets;
import org.tbot.methods.tabs.Equipment;
import org.tbot.wrappers.Area;
import org.tbot.wrappers.Player;
import org.tbot.wrappers.Widget;
import org.tbot.wrappers.WidgetChild;

import data.Data;
import enums.assignment.CombatAssignment;



public abstract class State {


	public abstract boolean active();

	public abstract void execute();

	public abstract String toString();

	

}
