package ru.academItSchool.gorbunov.Minesweeper.View;

import ru.academItSchool.gorbunov.Minesweeper.View.Interfaces.Characters;

public class Cell {
    private Object realContent;
    private boolean isMine;
    private Object visibleContent;
    private int line;
    private int column;

    public Cell(Object realContent, Characters characters, int line, int column) {
        this.realContent = realContent;
        this.isMine = false;
        this.visibleContent = characters.getCharacters()[9];
        this.line = line;
        this.column = column;
    }

    public void setVisibleContent(Object visibleContent) {
        this.visibleContent = visibleContent;
    }

    public void setRealContent(Object realContent) {
        this.realContent = realContent;
    }

    public Object getRealContent() {
        return this.realContent;
    }

    public void setMine() {
        this.isMine = true;
    }

    public boolean isMine() {
        return this.isMine;
    }

    public Object getVisibleContent() {
        return this.visibleContent;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line = line;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }
}
