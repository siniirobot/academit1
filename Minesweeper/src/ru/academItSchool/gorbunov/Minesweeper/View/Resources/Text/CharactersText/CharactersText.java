package ru.academItSchool.gorbunov.Minesweeper.View.Resources.Text.CharactersText;

import ru.academItSchool.gorbunov.Minesweeper.View.Interfaces.Characters;

public class CharactersText implements Characters {
    private CellText[] characters;

    public CharactersText() {
        this.characters = new CellText[]{
                openEmptyCell = new CellText('\u0020'),
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
                /*new CellText('\u0020'),
                new CellText('\u0031'),
                new CellText('\u0033'),
                new CellText('\u0033'),
                new CellText('\u0034'),
                new CellText('\u0035'),
                new CellText('\u0036'),
                new CellText('\u0037'),
                new CellText('\u0038'),
                new CellText('\u034f'),
                new CellText('\u0489'),
                new CellText('\u06e9'),
                new CellText('\u003f'),*/
        };

    }

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

    public CellText[] getCharacters() {
        return this.characters;
    }
}
