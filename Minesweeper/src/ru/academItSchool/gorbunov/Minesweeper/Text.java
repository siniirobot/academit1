package ru.academItSchool.gorbunov.Minesweeper;

import ru.academItSchool.gorbunov.Minesweeper.Model.Exceptions.Boom;
import ru.academItSchool.gorbunov.Minesweeper.View.Resources.Text.TextMenus.Game;

public class Text {
    public static void main(String[] args) throws Boom {
        Game game = new Game();
        game.startGame();
    }
}
