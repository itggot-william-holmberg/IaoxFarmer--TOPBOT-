package tasks;

import org.tbot.methods.Skills.Skill;

import enums.assignment.Assignment;



public class Task {

	private Assignment task;
	private Skill skill;
	private int levelGoal;

	public Task(Assignment task, Skill skill, int levelGoal) {
		this.task = task;
		this.levelGoal = levelGoal;
		this.skill = skill;
	}

	public Assignment getAssignment() {
		return task;
	}
	
	public Skill getSkill(){
		return skill;
	}

	public int getLevelGoal() {
		return levelGoal;
	}

	public String toString() {
		return levelGoal + " wc at " + task.toString();
	}
}