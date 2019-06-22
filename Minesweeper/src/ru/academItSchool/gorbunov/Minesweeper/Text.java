package ru.academItSchool.gorbunov.Minesweeper;


import ru.academItSchool.gorbunov.Minesweeper.View.Resources.Text.CharactersText.CharactersText;
import ru.academItSchool.gorbunov.Minesweeper.View.Resources.Text.TextMenus.TextInputOutputMenus;
import ru.academItSchool.gorbunov.Minesweeper.View.View;

public class Text {
    public static void main(String[] args) {
        View view = new View(new TextInputOutputMenus());
        view.startGame(new CharactersText());
    }
}
