package org.example;

import com.github.javafaker.Faker;

public class Equipo {

	private Jugador[] players;
	private int score;

	public Equipo() {
		Faker fk = new Faker();
		this.score = 0;
		this.players = new Jugador[5];
		for (int i = 0; i < 5; i++) {
			this.players[i] = new Jugador();
			this.players[i].setNumber(fk.number().numberBetween(0,99));
		}
	}

	/**
	 * 
	 * @param players
	 */
	public Equipo(Jugador[] players) {
		Faker fk = new Faker();
		this.score = 0;
		this.players = players;
		while (this.players.length > 5) {
			removePlayer(this.players[5]);
		}
		for (Jugador player:this.players) {
			player.setNumber(fk.number().numberBetween(0,99));
		}
	}

	/**
	 * 
	 * @param players
	 * @param score
	 */
	public Equipo(Jugador[] players, int score) {
		Faker fk = new Faker();
		this.players = players;
		while (this.players.length > 5) {
			removePlayer(this.players[5]);
		}
		for (Jugador player:this.players) {
			player.setNumber(fk.number().numberBetween(0,99));
		}
		this.score = score;
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
	public Jugador getPlayer(int playerNumber) throws Exception {
		for (Jugador player:this.players) {
			if (player.getNumber()==playerNumber){
				return player;
		}}
		throw new Exception("This player doesn't exist.");
	}

	/**
	 * 
	 * @param playerName
	 */
	public Jugador getPlayer(String playerName) throws Exception{
		for (Jugador player:this.players) {
			if (player.getName() == playerName) {
				return player;
			}
		}
		throw new Exception("This player doesn't exist.");
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
	public void replacePlayer(int oldPlayerNumber, String newPlayerName) throws Exception{
		String removedPlayer;
		for (Jugador player:this.players) {
			if (player.getNumber() == oldPlayerNumber) {
				removedPlayer = player.getName() + ", Number:" + player.getNumber();
				this.removePlayer(player);
				this.addPlayer(newPlayerName);
				System.out.println("Player: " + removedPlayer+ ", has been replaced successfully with player: " + this.players[4].getName() + ", Number: " + this.players[4].getNumber() + ".");
				break;
			}
		}
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

	/**
	 *
	 * @param jugador
	 */
	public void removePlayer(Jugador jugador) {
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