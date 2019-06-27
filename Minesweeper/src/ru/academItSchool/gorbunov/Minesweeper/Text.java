package ru.academItSchool.gorbunov.Minesweeper;


import ru.academItSchool.gorbunov.Minesweeper.View.Text.Resources.CharactersText.CharactersText;
import ru.academItSchool.gorbunov.Minesweeper.View.Text.Resources.TextInputOutput.TextInputOutputMenus;
import ru.academItSchool.gorbunov.Minesweeper.View.Text.ViewText;

public class Text {
    public static void main(String[] args) {
        ViewText viewText = new ViewText(new TextInputOutputMenus());
        viewText.startGame(new CharactersText());
    }
}
