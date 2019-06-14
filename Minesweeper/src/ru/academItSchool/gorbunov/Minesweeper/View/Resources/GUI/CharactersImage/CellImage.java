package ru.academItSchool.gorbunov.Minesweeper.View.Resources.GUI.CharactersImage;

import ru.academItSchool.gorbunov.Minesweeper.View.Interfaces.CellInterface;

import java.awt.*;

public class CellImage implements CellInterface {
    private Image content;
    private boolean isMine;
    private boolean isVisible;

    private CellImage(Image content) {
        this.content = content;
        this.isMine = false;
        this.isVisible = false;
    }

    public void setVisible(boolean visible) {
        this.isVisible = visible;
    }

    @Override
    public void setContent(Object content) {
        this.content = (Image) content;
    }

    @Override
    public Object getContent() {
        return this.content;
    }

    @Override
    public void setMine() {
        this.isMine = true;
    }

    @Override
    public boolean isMine() {
        return this.isMine;
    }

    @Override
    public boolean isVisible() {
        return isVisible;
    }
}
