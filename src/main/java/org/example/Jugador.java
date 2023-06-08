package org.example;

import com.github.javafaker.*;

public class Jugador {

	private String name;
	private int number;
	private boolean isLeader;

	public Jugador() {
		Faker fk = new Faker();
		this.name = fk.name().toString();
		this.isLeader = false;
	}

	/**
	 * 
	 * @param name
	 */
	public Jugador(String name) {
		this.name = name;
		this.isLeader = false;
	}

	public String getName() {
		return this.name;
	}

	/**
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	public void setName() {
		Faker fk = new Faker();
		this.name = fk.name().toString();
	}

	public int getNumber() {
		return this.number;
	}

	/**
	 * 
	 * @param number
	 */
	public void setNumber(int number) {
		this.number = number;
	}

	public boolean askIfLeader() {
		return this.isLeader;
	}

	/**
	 * 
	 * @param isLeader
	 */
	public void setLeadership(boolean isLeader) {
		this.isLeader = isLeader;
	}

	@Override
	public String toString() {
		return "Player: " + name+ ", Number: " + number;
	}
}