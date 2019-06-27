package ru.academItSchool.gorbunov.Minesweeper.View.GUI.Resources.CharactersImage;

import ru.academItSchool.gorbunov.Minesweeper.View.Interfaces.Characters;
import ru.academItSchool.gorbunov.Minesweeper.View.Cell;

public class CharactersImage implements Characters {
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


    public Cell[] getCharacters() {
        return new Cell[]{
                openEmptyCell,
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
                questionMark,
        };
    }
}
