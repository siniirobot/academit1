package ru.academItSchool.gorbunov.Minesweeper.View.GUI.Resources.CharactersImage;

import ru.academItSchool.gorbunov.Minesweeper.View.Interfaces.Characters;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.File;
import java.io.IOException;

public class CharactersImage implements Characters {
    private Object[] characters;

    public CharactersImage() {
        try {
            this.characters = new Object[]{
                    ImageIO.read(new File("Minesweeper/src/ru/academItSchool/gorbunov/Minesweeper" +
                            "/View/GUI/Resources/CharactersImage/openCell.png")),
                    ImageIO.read(new File("Minesweeper/src/ru/academItSchool/gorbunov/Minesweeper" +
                            "/View/GUI/Resources/CharactersImage/one.png")),
                    ImageIO.read(new File("Minesweeper/src/ru/academItSchool/gorbunov/Minesweeper" +
                            "/View/GUI/Resources/CharactersImage/two.png")),
                    ImageIO.read(new File("Minesweeper/src/ru/academItSchool/gorbunov/Minesweeper" +
                            "/View/GUI/Resources/CharactersImage/three.png")),
                    ImageIO.read(new File("Minesweeper/src/ru/academItSchool/gorbunov/Minesweeper" +
                            "/View/GUI/Resources/CharactersImage/four.png")),
                    ImageIO.read(new File("Minesweeper/src/ru/academItSchool/gorbunov/Minesweeper" +
                            "/View/GUI/Resources/CharactersImage/five.png")),
                    ImageIO.read(new File("Minesweeper/src/ru/academItSchool/gorbunov/Minesweeper" +
                            "/View/GUI/Resources/CharactersImage/six.png")),
                    ImageIO.read(new File("Minesweeper/src/ru/academItSchool/gorbunov/Minesweeper" +
                            "/View/GUI/Resources/CharactersImage/seven.png")),
                    ImageIO.read(new File("Minesweeper/src/ru/academItSchool/gorbunov/Minesweeper" +
                            "/View/GUI/Resources/CharactersImage/eight.png")),
                    ImageIO.read(new File("Minesweeper/src/ru/academItSchool/gorbunov/Minesweeper" +
                            "/View/GUI/Resources/CharactersImage/closeCell.png")),
                    ImageIO.read(new File("Minesweeper/src/ru/academItSchool/gorbunov/Minesweeper" +
                            "/View/GUI/Resources/CharactersImage/mine.png")),
                    ImageIO.read(new File("Minesweeper/src/ru/academItSchool/gorbunov/Minesweeper" +
                            "/View/GUI/Resources/CharactersImage/flag.png")),
                    ImageIO.read(new File("Minesweeper/src/ru/academItSchool/gorbunov/Minesweeper" +
                            "/View/GUI/Resources/CharactersImage/questionMark.png")),
            };
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Object[] getCharacters() {
        return this.characters;
    }
}
