package ru.academItSchool.gorbunov.Minesweeper.Resources.Characters;

import java.awt.*;

public class Cell {
    private char textIcon;
    private Image imageIcon;
    private boolean isVisible;

    public Cell(char textIcon, Image imageIcon) {
        this.textIcon = textIcon;
        this.imageIcon = imageIcon;
        this.isVisible = false;
    }

    public boolean isVisible() {
        return this.isVisible;
    }

    public void setVisible() {
        this.isVisible = true;
    }

    public char getChar() {
        return this.textIcon;
    }

    public Image getIcon() {
        return this.imageIcon;
    }
}
