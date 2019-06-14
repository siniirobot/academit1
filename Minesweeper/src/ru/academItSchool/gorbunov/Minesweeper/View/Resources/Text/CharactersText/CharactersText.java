package ru.academItSchool.gorbunov.Minesweeper.View.Resources.Text.CharactersText;

import ru.academItSchool.gorbunov.Minesweeper.View.Interfaces.Characters;
import ru.academItSchool.gorbunov.Minesweeper.View.Resources.Cell;

public class CharactersText implements Characters {
    private Object[] characters;

    public CharactersText() {
        this.characters = new Object[]{
                /*openEmptyCell = new CellInterface('\u0020'),
                one,
                two,
                three,
                four,
                five,
                six,
                seven,
                eight,
                closeCell,
                mine,
                flag,
                questionMark,*/
                ('\u0020'),
                ('\u0031'),
                ('\u0032'),
                ('\u0033'),
               ('\u0034'),
                ('\u0035'),
                ('\u0036'),
                ('\u0037'),
                ('\u0038'),
                ('\u034f'),
                ('\u0489'),
                ('\u06e9'),
                ('\u003f'),
        };

    }

    private Cell openEmptyCell = new Cell('\u0020');
    private Cell one = new Cell('\u0031');
    private Cell two = new Cell('\u0032');
    private Cell three = new Cell('\u0033');
    private Cell four = new Cell('\u0034');
    private Cell five = new Cell('\u0035');
    private Cell six = new Cell('\u0036');
    private Cell seven = new Cell('\u0037');
    private Cell eight = new Cell('\u0038');
    private Cell closeCell = new Cell('\u034f');
    private Cell mine = new Cell('\u0489');
    private Cell flag = new Cell('\u06e9');
    private Cell questionMark = new Cell('\u003f');

    public Object[] getCharacters() {
        return this.characters;
    }
}
