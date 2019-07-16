package ru.academItSchool.gorbunov.Minesweeper.View.GUI.Resources.CharactersImage;

import javafx.scene.image.Image;
import ru.academItSchool.gorbunov.Minesweeper.View.Interfaces.Characters;
import ru.academItSchool.gorbunov.Minesweeper.View.Cell;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class CharactersImage implements Characters {
    private Cell openEmptyCell = new Cell(ImageIO.read(new File("Minesweeper/src/ru/academItSchool/gorbunov/Minesweeper" +
            "/View/GUI/Resources/CharactersImage/openCell.png")));
    private Cell one = new Cell(ImageIO.read(new File("Minesweeper/src/ru/academItSchool/gorbunov/Minesweeper" +
            "/View/GUI/Resources/CharactersImage/one.png")));
    private Cell two = new Cell(ImageIO.read(new File("Minesweeper/src/ru/academItSchool/gorbunov/Minesweeper" +
            "/View/GUI/Resources/CharactersImage/two.png")));
    private Cell three = new Cell(ImageIO.read(new File("Minesweeper/src/ru/academItSchool/gorbunov/Minesweeper" +
            "/View/GUI/Resources/CharactersImage/three.png")));
    private Cell four = new Cell(ImageIO.read(new File("Minesweeper/src/ru/academItSchool/gorbunov/Minesweeper" +
            "/View/GUI/Resources/CharactersImage/four.png")));
    private Cell five = new Cell(ImageIO.read(new File("Minesweeper/src/ru/academItSchool/gorbunov/Minesweeper" +
            "/View/GUI/Resources/CharactersImage/five.png")));
    private Cell six = new Cell(ImageIO.read(new File("Minesweeper/src/ru/academItSchool/gorbunov/Minesweeper" +
            "/View/GUI/Resources/CharactersImage/six.png")));
    private Cell seven = new Cell(ImageIO.read(new File("Minesweeper/src/ru/academItSchool/gorbunov/Minesweeper" +
            "/View/GUI/Resources/CharactersImage/seven.png")));
    private Cell eight = new Cell(ImageIO.read(new File("Minesweeper/src/ru/academItSchool/gorbunov/Minesweeper" +
            "/View/GUI/Resources/CharactersImage/eight.png")));
    private Cell closeCell = new Cell(ImageIO.read(new File("Minesweeper/src/ru/academItSchool/gorbunov/Minesweeper" +
            "/View/GUI/Resources/CharactersImage/closeCell.png")));
    private Cell mine = new Cell(ImageIO.read(new File("Minesweeper/src/ru/academItSchool/gorbunov/Minesweeper" +
            "/View/GUI/Resources/CharactersImage/mine.png")));
    private Cell flag = new Cell(ImageIO.read(new File("Minesweeper/src/ru/academItSchool/gorbunov/Minesweeper" +
            "/View/GUI/Resources/CharactersImage/flag.png")));
    private Cell questionMark = new Cell(ImageIO.read(new File("Minesweeper/src/ru/academItSchool/gorbunov/Minesweeper" +
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
