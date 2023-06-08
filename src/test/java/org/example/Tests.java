package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Tests {

    @org.junit.Test
    public void testJugadorGetName() {
        Jugador jugador = new Jugador("John Doe");
        Assertions.assertEquals("John Doe", jugador.getName());
    }

    @Test
    public void testEquipoAddPlayer() {
        Equipo equipo = new Equipo();
        equipo.addPlayer("Player 1");
        equipo.addPlayer("Player 2");
        Assertions.assertEquals(5, equipo.playerCount());
    }

    @Test
    public void testMenuDisplayTeams() {
        Liga liga = new Liga();
        Equipo equipo1 = new Equipo();
        equipo1.addPlayer("Player 1");
        Equipo equipo2 = new Equipo();
        equipo2.addPlayer("Player 2");
        liga.addTeam(equipo1);
        liga.addTeam(equipo2);

        Menu menu = new Menu();
        Assertions.assertDoesNotThrow(menu::displayTeams);
    }
}
