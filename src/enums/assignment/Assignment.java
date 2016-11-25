package enums.assignment;

import java.util.ArrayList;
import java.util.List;

import org.tbot.methods.Skills.Skill;




public enum Assignment {
	
	STRENGTH(Skill.STRENGTH),ATTACK(Skill.ATTACK),DEFENCE(Skill.DEFENCE), RANGE(Skill.RANGED),
	AGILITY(Skill.AGILITY);
	
	private Skill skill;
	
	Assignment(Skill skill) {
		this.skill = skill;
	}
	public Skill getSkill() {
		return skill;
	}	

}
