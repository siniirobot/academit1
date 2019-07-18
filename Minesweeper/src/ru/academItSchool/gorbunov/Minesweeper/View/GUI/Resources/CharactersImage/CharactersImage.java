package ru.academItSchool.gorbunov.Minesweeper.View.GUI.Resources.CharactersImage;

import javafx.scene.image.Image;
import ru.academItSchool.gorbunov.Minesweeper.View.Interfaces.Characters;
import ru.academItSchool.gorbunov.Minesweeper.View.Cell;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.File;
import java.io.IOException;

public class CharactersImage implements Characters {
    private Object[] characters;

    public CharactersImage()  {
        this.characters = new Object[]{
                new ImageIcon("Minesweeper/src/ru/academItSchool/gorbunov/Minesweeper" +
                        "/View/GUI/Resources/CharactersImage/openCell.png"),
                new ImageIcon("Minesweeper/src/ru/academItSchool/gorbunov/Minesweeper" +
                        "/View/GUI/Resources/CharactersImage/one.png"),
                new ImageIcon("Minesweeper/src/ru/academItSchool/gorbunov/Minesweeper" +
                        "/View/GUI/Resources/CharactersImage/two.png"),
                new ImageIcon("Minesweeper/src/ru/academItSchool/gorbunov/Minesweeper" +
                        "/View/GUI/Resources/CharactersImage/three.png"),
                new ImageIcon("Minesweeper/src/ru/academItSchool/gorbunov/Minesweeper" +
                        "/View/GUI/Resources/CharactersImage/four.png"),
                new ImageIcon("Minesweeper/src/ru/academItSchool/gorbunov/Minesweeper" +
                        "/View/GUI/Resources/CharactersImage/five.png"),
                new ImageIcon("Minesweeper/src/ru/academItSchool/gorbunov/Minesweeper" +
                        "/View/GUI/Resources/CharactersImage/six.png"),
                new ImageIcon("Minesweeper/src/ru/academItSchool/gorbunov/Minesweeper" +
                        "/View/GUI/Resources/CharactersImage/seven.png"),
                new ImageIcon("Minesweeper/src/ru/academItSchool/gorbunov/Minesweeper" +
                        "/View/GUI/Resources/CharactersImage/eight.png"),
                new ImageIcon("Minesweeper/src/ru/academItSchool/gorbunov/Minesweeper" +
                        "/View/GUI/Resources/CharactersImage/closeCell.png"),
                new ImageIcon("Minesweeper/src/ru/academItSchool/gorbunov/Minesweeper" +
                        "/View/GUI/Resources/CharactersImage/mine.png"),
                new ImageIcon("Minesweeper/src/ru/academItSchool/gorbunov/Minesweeper" +
                        "/View/GUI/Resources/CharactersImage/flag.png"),
                new ImageIcon("Minesweeper/src/ru/academItSchool/gorbunov/Minesweeper" +
                        "/View/GUI/Resources/CharactersImage/questionMark.png"),
        };
    }


    public Object[] getCharacters() {
        return this.characters;
    }
}
