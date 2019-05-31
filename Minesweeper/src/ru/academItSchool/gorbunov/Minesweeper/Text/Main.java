package ru.academItSchool.gorbunov.Minesweeper.Text;

import ru.academItSchool.gorbunov.Minesweeper.Resources.Model.Exceptions.Boom;
import ru.academItSchool.gorbunov.Minesweeper.Text.View.Game;

public class Main {
    public static void main(String[] args) throws Boom {
        Game game = new Game();
        game.startGame();
    }
}
