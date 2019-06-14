package ru.academItSchool.gorbunov.Minesweeper.View.Resources.GUI.CharactersImage;

import ru.academItSchool.gorbunov.Minesweeper.View.Interfaces.Cell;
import ru.academItSchool.gorbunov.Minesweeper.View.Interfaces.Characters;
import ru.academItSchool.gorbunov.Minesweeper.View.Resources.Text.CharactersText.CellText;

public class CharactersImage implements Characters {
    private CellText openEmptyCell = new CellText('\u0020');
    private CellText one = new CellText('\u0031');
    private CellText two = new CellText('\u0032');
    private CellText three = new CellText('\u0033');
    private CellText four = new CellText('\u0034');
    private CellText five = new CellText('\u0035');
    private CellText six = new CellText('\u0036');
    private CellText seven = new CellText('\u0037');
    private CellText eight = new CellText('\u0038');
    private CellText closeCell = new CellText('\u034f');
    private CellText mine = new CellText('\u0489');
    private CellText flag = new CellText('\u06e9');
    private CellText questionMark = new CellText('\u003f');


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
