package org.example;

public class Equipo {

	private Jugador[] players;
	private int score;

	public Equipo() {
		// TODO - implement Equipo.Equipo
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param players
	 */
	public Equipo(Jugador[] players) {
		// TODO - implement Equipo.Equipo
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param players
	 * @param score
	 */
	public Equipo(Jugador[] players, int score) {
		// TODO - implement Equipo.Equipo
		throw new UnsupportedOperationException();
	}

	public Jugador[] getPlayers() {
		return this.players;
	}

	/**
	 * 
	 * @param players
	 */
	public void setPlayers(Jugador[] players) {
		this.players = players;
	}

	/**
	 * 
	 * @param playerNumber
	 */
	public Jugador getPlayer(int playerNumber) {
		// TODO - implement Equipo.getPlayer
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param playerName
	 */
	public Jugador getPlayer(String playerName) {
		// TODO - implement Equipo.getPlayer
		throw new UnsupportedOperationException();
	}

	public int getScore() {
		return this.score;
	}

	/**
	 * 
	 * @param score
	 */
	public void setScore(int score) {
		this.score = score;
	}

	/**
	 * 
	 * @param oldPlayerNumber
	 * @param newPlayerName
	 */
	public void replacePlayer(int oldPlayerNumber, String newPlayerName) {
		// TODO - implement Equipo.replacePlayer
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param oldPlayerName
	 * @param newPlayerName
	 */
	public void replacePlayer(String oldPlayerName, String newPlayerName) {
		// TODO - implement Equipo.replacePlayer
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param oldPlayerName
	 * @param newPlayer
	 */
	public void replacePlayer(String oldPlayerName, Jugador newPlayer) {
		// TODO - implement Equipo.replacePlayer
		throw new UnsupportedOperationException();
	}

	public Jugador getLeader() {
		// TODO - implement Equipo.getLeader
		throw new UnsupportedOperationException();
	}

	public int getLeaderNumber() {
		// TODO - implement Equipo.getLeaderNumber
		throw new UnsupportedOperationException();
	}

	public String getLeaderName() {
		// TODO - implement Equipo.getLeaderName
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param newLeaderNumber
	 */
	public void changeLeader(int newLeaderNumber) {
		// TODO - implement Equipo.changeLeader
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param newLeaderName
	 */
	public void changeLeader(String newLeaderName) {
		// TODO - implement Equipo.changeLeader
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param name
	 */
	public void addPlayer(String name) {
		// TODO - implement Equipo.addPlayer
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param name
	 */
	public void removePlayer(String name) {
		// TODO - implement Equipo.removePlayer
		throw new UnsupportedOperationException();
	}

	public int playerCount() {
		// TODO - implement Equipo.playerCount
		throw new UnsupportedOperationException();
	}

	public boolean hasEnoughPlayers() {
		// TODO - implement Equipo.hasEnoughPlayers
		throw new UnsupportedOperationException();
	}

	public boolean hasLeader() {
		// TODO - implement Equipo.hasLeader
		throw new UnsupportedOperationException();
	}

}