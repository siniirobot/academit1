package ru.academItSchool.gorbunov.Minesweeper.View.GUI.Resources.CharactersImage;

import javafx.scene.image.Image;
import ru.academItSchool.gorbunov.Minesweeper.View.Interfaces.Characters;
import ru.academItSchool.gorbunov.Minesweeper.View.Cell;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class CharactersImage implements Characters {
    private Cell openEmptyCell = new Cell((("Minesweeper/src/ru/academItSchool/gorbunov/Minesweeper" +
            "/View/GUI/Resources/CharactersImage/openCell.png")));
    private Cell one = new Cell((("Minesweeper/src/ru/academItSchool/gorbunov/Minesweeper" +
            "/View/GUI/Resources/CharactersImage/one.png")));
    private Cell two = new Cell((("Minesweeper/src/ru/academItSchool/gorbunov/Minesweeper" +
            "/View/GUI/Resources/CharactersImage/two.png")));
    private Cell three = new Cell((("Minesweeper/src/ru/academItSchool/gorbunov/Minesweeper" +
            "/View/GUI/Resources/CharactersImage/three.png")));
    private Cell four = new Cell((("Minesweeper/src/ru/academItSchool/gorbunov/Minesweeper" +
            "/View/GUI/Resources/CharactersImage/four.png")));
    private Cell five = new Cell((("Minesweeper/src/ru/academItSchool/gorbunov/Minesweeper" +
            "/View/GUI/Resources/CharactersImage/five.png")));
    private Cell six = new Cell((("Minesweeper/src/ru/academItSchool/gorbunov/Minesweeper" +
            "/View/GUI/Resources/CharactersImage/six.png")));
    private Cell seven = new Cell((("Minesweeper/src/ru/academItSchool/gorbunov/Minesweeper" +
            "/View/GUI/Resources/CharactersImage/seven.png")));
    private Cell eight = new Cell((("Minesweeper/src/ru/academItSchool/gorbunov/Minesweeper" +
            "/View/GUI/Resources/CharactersImage/eight.png")));
    private Cell closeCell = new Cell((("Minesweeper/src/ru/academItSchool/gorbunov/Minesweeper" +
            "/View/GUI/Resources/CharactersImage/closeCell.png")));
    private Cell mine = new Cell((("Minesweeper/src/ru/academItSchool/gorbunov/Minesweeper" +
            "/View/GUI/Resources/CharactersImage/mine.png")));
    private Cell flag = new Cell((("Minesweeper/src/ru/academItSchool/gorbunov/Minesweeper" +
            "/View/GUI/Resources/CharactersImage/flag.png")));
    private Cell questionMark = new Cell((("Minesweeper/src/ru/academItSchool/gorbunov/Minesweeper" +
            "/View/GUI/Resources/CharactersImage/questionMark.png")));

    public CharactersImage() throws IOException {

    }


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
