package org.example;

import java.util.Arrays;

public class Liga {

	private Equipo[] teams;

	public Liga() {
		this.teams = new Equipo[16];
		for (int i = 0; i < 16; i++) {
			this.teams[i] = new Equipo();
		}
	}

	public Equipo[] getTeams() {
		return this.teams;
	}

	/**
	 * 
	 * @param Teams
	 */
	public void setTeams(Equipo[] Teams) {
		this.teams = Teams;
	}

	/**
	 * 
	 * @param teamIndex
	 */
	public Equipo getTeam(int teamIndex) {
		return this.teams[teamIndex];
	}

	/**
	 * 
	 * @param teamIndex
	 */
	public Jugador[] getTeamPlayers(int teamIndex) {
		return this.teams[teamIndex].getPlayers();
	}

	public Jugador[] getTeamLeaders() throws Exception {
		Jugador[] leaders = new	Jugador[this.teams.length];
		for (int i = 0; i < this.teams.length; i++) {
			try {
				leaders[i] = this.teams[i].getLeader();
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
		return leaders;
	}

	/**
	 * 
	 * @param teamIndex
	 */
	public int getTeamScore(int teamIndex) {
		return this.teams[teamIndex].getScore();
	}

	/**
	 * 
	 * @param oldTeamIndex
	 * @param newTeam
	 */
	public void replaceTeam(int oldTeamIndex, Equipo newTeam) {
		this.teams[oldTeamIndex] = newTeam;
	}

	/**
	 * 
	 * @param oldTeamIndex
	 */
	public void regenerateTeam(int oldTeamIndex) {
		this.teams[oldTeamIndex] = new Equipo();
	}

	public boolean areTeamsReady() {
		boolean haveAllPlayers=true;
		boolean allTeamsHaveLeader=true;
		for (int i = 0; i < this.teams.length; i++) {
			if (!this.teams[i].hasEnoughPlayers()){
				if (haveAllPlayers) {
					haveAllPlayers = false;
				}
				System.out.println("Equipo "+i+" no tiene la cantidad de jugadores necesaria, tiene "+this.teams[i].playerCount()+".");
			}
			if (!this.teams[i].hasLeader()){
				if (allTeamsHaveLeader) {
					allTeamsHaveLeader = false;
				}
				System.out.println("Equipo "+i+" no tiene un lider.");
			}
		}
		return (haveAllPlayers && allTeamsHaveLeader);
	}

	/**
	 * 
	 * @param newTeam
	 */
	public void addTeam(Equipo newTeam) {
		if (this.teams.length < 4) {
			int length = this.teams.length;
			this.teams = Arrays.copyOf(this.teams, length + 1);
			this.teams[length] = newTeam;
		}
	}

	/**
	 *
	 * @param teamIndex
	 */
	public void removeTeam(int teamIndex) {
		if (teamIndex >= 0 && teamIndex < this.teams.length) {
			int length = this.teams.length;
			Equipo[] updatedTeams = new Equipo[length - 1];
			int count = 0;
			for (int i = 0; i < length; i++) {
				if (i != teamIndex) {
					updatedTeams[count++] = this.teams[i];
				}
			}
			this.teams = updatedTeams;
		}
	}


	public int teamCount() {
		return this.teams.length;
	}

}