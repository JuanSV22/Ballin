package org.example;

import java.util.Scanner;

public class Menu {

    private Liga league;

    public Menu() {
        this.league = new Liga();
    }

    public void displayMenu() {
        System.out.println("********** MENU **********");
        System.out.println("1. Ver equipos");
        System.out.println("2. Ver jugadores de un equipo");
        System.out.println("3. Ver líderes de los equipos");
        System.out.println("4. Ver puntaje de un equipo");
        System.out.println("5. Reemplazar equipo");
        System.out.println("6. Regenerar equipo");
        System.out.println("7. Agregar equipo");
        System.out.println("8. Eliminar equipo");
        System.out.println("9. Salir");
        System.out.println("****************************");
        System.out.print("Ingrese el número de opción que desea seleccionar: ");
    }

    public void runMenu() {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        while (!exit) {
            displayMenu();
            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    displayTeams();
                    break;
                case 2:
                    displayTeamPlayers();
                    break;
                case 3:
                    displayTeamLeaders();
                    break;
                case 4:
                    displayTeamScore();
                    break;
                case 5:
                    replaceTeam();
                    break;
                case 6:
                    regenerateTeam();
                    break;
                case 7:
                    addTeam();
                    break;
                case 8:
                    removeTeam();
                    break;
                case 9:
                    exit = true;
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
                    break;
            }
            System.out.println();
        }
    }

    void displayTeams() {
        System.out.println("Equipos:");
        for (int i = 0; i < league.teamCount(); i++) {
            System.out.println("Equipo " + (i) + ":");
            Equipo team = league.getTeam(i);
            Jugador[] players = team.getPlayers();
            for (Jugador player : players) {
                System.out.println("Jugador "+i+": " + player.getName() + ", Número: " + player.getNumber());
            }
            System.out.println();
        }
        if (league.areTeamsReady()){System.out.println("Todos los equipos estan listos para jugar!!!");};
    }

    private void displayTeamPlayers() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el índice del equipo que desea ver: ");
        int teamIndex = scanner.nextInt();
        if (teamIndex >= 0 && teamIndex < league.teamCount()) {
            System.out.println("Jugadores del Equipo " + (teamIndex) + ":");
            Jugador[] players = league.getTeamPlayers(teamIndex);
            for (Jugador player : players) {
                System.out.println("Jugador: " + player.getName() + ", Número: " + player.getNumber());
            }
        } else {
            System.out.println("Índice de equipo inválido.");
        }
    }

    private void displayTeamLeaders() {
        try {
            System.out.println("Líderes de los equipos:");
            Jugador[] leaders = league.getTeamLeaders();
            for (int i = 0; i < leaders.length; i++) {
                if (leaders[i] != null) {
                    System.out.println("Equipo " + (i) + ": Jugador " + leaders[i].getName());
                } else {
                    System.out.println("Equipo " + (i) + ": Sin líder");
                }
            }
        } catch (Exception e) {
            System.out.println("Error al obtener los líderes de los equipos: " + e.getMessage());
        }
    }

    private void displayTeamScore() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el índice del equipo que desea ver el puntaje: ");
        int teamIndex = scanner.nextInt();
        if (teamIndex >= 0 && teamIndex < league.teamCount()) {
            int score = league.getTeamScore(teamIndex);
            System.out.println("Puntaje del Equipo " + (teamIndex) + ": " + score);
        } else {
            System.out.println("Índice de equipo inválido.");
        }
    }

    private void replaceTeam() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el índice del equipo que desea reemplazar: ");
        int teamIndex = scanner.nextInt();
        if (teamIndex >= 0 && teamIndex < league.teamCount()) {
            Equipo newTeam = createNewTeam();
            league.replaceTeam(teamIndex, newTeam);
            System.out.println("El Equipo " + (teamIndex) + " ha sido reemplazado exitosamente.");
        } else {
            System.out.println("Índice de equipo inválido.");
        }
    }

    private void regenerateTeam() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el índice del equipo que desea regenerar: ");
        int teamIndex = scanner.nextInt();
        if (teamIndex >= 0 && teamIndex < league.teamCount()) {
            league.regenerateTeam(teamIndex);
            System.out.println("El Equipo " + (teamIndex) + " ha sido regenerado exitosamente.");
        } else {
            System.out.println("Índice de equipo inválido.");
        }
    }

    private void addTeam() {
        Equipo newTeam = createNewTeam();
        league.addTeam(newTeam);
        System.out.println("El nuevo equipo ha sido agregado exitosamente.");
    }

    private void removeTeam() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el índice del equipo que desea eliminar: ");
        int teamIndex = scanner.nextInt();
        if (teamIndex >= 0 && teamIndex < league.teamCount()) {
            league.removeTeam(teamIndex);
            System.out.println("El Equipo " + (teamIndex) + " ha sido eliminado exitosamente.");
        } else {
            System.out.println("Índice de equipo inválido.");
        }
    }

    private Equipo createNewTeam() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese la cantidad de jugadores del equipo: ");
        int playerCount = scanner.nextInt();
        scanner.nextLine(); // Consume new line character
        Equipo newTeam = new Equipo();
        for (int i = 0; i < playerCount; i++) {
            System.out.print("Ingrese el nombre del jugador " + (i) + ": ");
            String playerName = scanner.nextLine();
            newTeam.addPlayer(playerName);
        }
        return newTeam;
    }
}