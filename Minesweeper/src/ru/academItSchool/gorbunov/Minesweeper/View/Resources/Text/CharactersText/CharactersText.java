package ru.academItSchool.gorbunov.Minesweeper.View.Resources.Text.CharactersText;

import ru.academItSchool.gorbunov.Minesweeper.View.Interfaces.Characters;
import ru.academItSchool.gorbunov.Minesweeper.View.Resources.Cell;

public class CharactersText implements Characters {
    private Object[] characters;

    public CharactersText() {
        this.characters = new Object[]{
                ('\u0020'),
                ('\u0031'),
                ('\u0032'),
                ('\u0033'),
                ('\u0034'),
                ('\u0035'),
                ('\u0036'),
                ('\u0037'),
                ('\u0038'),
                ('\u039C'),
                ('\u0298'),
                ('\u06e9'),
                ('\u003f'),
        };

    }

    public Object[] getCharacters() {
        return this.characters;
    }
}
