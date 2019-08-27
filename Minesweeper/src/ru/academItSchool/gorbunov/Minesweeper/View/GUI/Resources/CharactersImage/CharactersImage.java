package ru.academItSchool.gorbunov.Minesweeper.View.GUI.Resources.CharactersImage;

import ru.academItSchool.gorbunov.Minesweeper.View.Interfaces.Characters;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.*;

public class CharactersImage implements Characters {
    private Object[] characters;

    public CharactersImage() {
        this.characters = new Object[]{
                new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("openCell.png"))),
                new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("one.png"))),
                new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("two.png"))),
                new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("three.png"))),
                new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("four.png"))),
                new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("five.png"))),
                new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("six.png"))),
                new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("seven.png"))),
                new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("eight.png"))),
                new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("cell.png"))),
                new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("mine.png"))),
                new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("flag.png"))),
                new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("questionMark.png"))),
        };
    }

    public Object[] getCharacters() {
        return this.characters;
    }
}
