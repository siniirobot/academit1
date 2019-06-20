package ru.academItSchool.gorbunov.Minesweeper.View.Resources;

import ru.academItSchool.gorbunov.Minesweeper.Model.Difficult.Easy;
import ru.academItSchool.gorbunov.Minesweeper.Model.Model;
import ru.academItSchool.gorbunov.Minesweeper.View.Resources.Text.CharactersText.CharactersText;
import ru.academItSchool.gorbunov.Minesweeper.View.Resources.Text.TextMenus.TextMenus;

import java.util.Arrays;

public class View {
    private TextMenus textMenus = new TextMenus();

    public void startGame() {
        System.out.println(textMenus.getMainMenu());
        String[] buttons = new String[]{"1", "2"};
        String menuNumber = (String) textMenus.getInput(buttons);
        switch (menuNumber) {
            case "1":
                System.out.println(textMenus);
                buttons = new String[]{"1", "2", "3", "4", "5"};
                switch (menuNumber) {
                    case "1":
                        Easy easy = new Easy(new CharactersText());
                }
        }
    }
}
