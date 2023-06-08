package org.example;

import com.github.javafaker.Faker;

import java.util.Arrays;

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
		this.players[fk.number().numberBetween(0,4)].setLeadership(true);
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
	public void replacePlayer(int oldPlayerNumber, String newPlayerName){
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
	public void replacePlayer(String oldPlayerName, String newPlayerName){
		String removedPlayer;
		for (Jugador player:this.players) {
			if (player.getName() == oldPlayerName) {
				removedPlayer = player.getName() + ", Number:" + player.getNumber();
				this.removePlayer(player);
				this.addPlayer(newPlayerName);
				System.out.println(removedPlayer + ", has been replaced successfully with "+ this.players[4].toString()+".");				break;
			}
		}
	}

	/**
	 * 
	 * @param oldPlayerName
	 * @param newPlayer
	 */
	public void replacePlayer(String oldPlayerName, Jugador newPlayer) {
		String removedPlayer;
		for (Jugador player:this.players) {
			if (player.getName() == oldPlayerName) {
				removedPlayer = player.toString();
				this.removePlayer(player);
				this.players[4] = newPlayer;
				System.out.println(removedPlayer + ", has been replaced successfully with "+ this.players[4].toString()+".");
				break;
			}
		}
	}

	public Jugador getLeader() throws Exception{
		for (Jugador player:this.players) {
			if (player.askIfLeader()) {
				return player;
			}
		}
		throw new Exception("This team has no leader.");
	}

	public int getLeaderNumber() throws Exception{
		for (Jugador player:this.players) {
			if (player.askIfLeader()) {
				return player.getNumber();
			}
		}
		throw new Exception("This team has no leader.");
	}

	public String getLeaderName()  throws Exception{
		for (Jugador player:this.players) {
			if (player.askIfLeader()) {
				return player.getName();
			}
		}
		throw new Exception("This team has no leader.");
	}

	/**
	 * 
	 * @param newLeaderNumber
	 */
	public void changeLeader(int newLeaderNumber) throws Exception {
		String oldLeader;
		for (Jugador player: this.players) {
			if (player.askIfLeader()) {
				player.setLeadership(false);
				for (Jugador leaderCandidate:this.players) {
					oldLeader = player.toString();
					getPlayer(newLeaderNumber).setLeadership(true);
					System.out.println(oldLeader + ", has been replaced successfully with "+ leaderCandidate.toString()+" as leader.");
					break;
				}
			}
		}
	}

	/**
	 * 
	 * @param newLeaderName
	 */
	public void changeLeader(String newLeaderName) throws Exception{
		String oldLeader;
		for (Jugador player: this.players) {
			if (player.askIfLeader()) {
				player.setLeadership(false);
				for (Jugador leaderCandidate:this.players) {
					oldLeader = player.toString();
					getPlayer(newLeaderName).setLeadership(true);
					System.out.println(oldLeader + ", has been replaced successfully with "+ leaderCandidate.toString()+" as leader.");
					break;
				}
			}
		}
	}

	/**
	 * 
	 * @param name
	 */
	public void addPlayer(String name) {
		if (this.players.length <= 4) {
			int length = this.players.length;
			this.players[length] = new Jugador(name);
		}
	}

	/**
	 * 
	 * @param name
	 */
	public void removePlayer(String name) {
		int count = 0;
		Jugador[] updatedPlayers = new Jugador[this.players.length];
		for (Jugador jugador : this.players) {
			if (!jugador.getName().equals(name)) {
				updatedPlayers[count++] = jugador;
			}
		}
		this.players = new Jugador[count];
		System.arraycopy(updatedPlayers, 0, this.players, 0, count);
	}



	/**
	 *
	 * @param jugador
	 */
	public void removePlayer(Jugador jugador) {
		int count = 0;
		Jugador[] updatedPlayers = new Jugador[this.players.length];
		for (Jugador removalCandidate : this.players) {
			if (!removalCandidate.equals(jugador)) {
				updatedPlayers[count++] = removalCandidate;
			}
		}
		this.players = new Jugador[count];
		System.arraycopy(updatedPlayers, 0, this.players, 0, count);
	}


	public int playerCount() {
		return this.players.length;
	}

	public boolean hasEnoughPlayers() {
		return this.players.length == 5;
	}

	public boolean hasLeader() {
		for (Jugador jugador:this.players) {
			if (jugador.askIfLeader()) {
				return true;
			}
		}
		return false;
	}

	public String toString(int num) {
		return "Equipo" + num +
				"{players=" + Arrays.toString(players) +
				", score=" + score +
				'}';
	}
}