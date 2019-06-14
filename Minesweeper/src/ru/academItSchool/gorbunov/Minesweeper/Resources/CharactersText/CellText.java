package ru.academItSchool.gorbunov.Minesweeper.Resources.CharactersText;

import ru.academItSchool.gorbunov.Minesweeper.Resources.Cell;

public class CellText implements Cell {
    private char content;
    private boolean isMine;
    private boolean isVisible;

    public CellText(char content) {
        this.content = content;
        this.isMine = false;
        this.isVisible = false;
    }

    @Override
    public void setVisible() {
        this.isVisible = true;
    }

    @Override
    public void setContent(Object content) {
        this.content = (char) content;
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
        return this.isVisible;
    }
}
