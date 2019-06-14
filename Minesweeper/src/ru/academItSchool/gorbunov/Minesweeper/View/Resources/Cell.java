package ru.academItSchool.gorbunov.Minesweeper.View.Resources;

public class Cell  {
    private Object content;
    private boolean isMine;
    private boolean isVisible;

    public Cell(Object content) {
        this.content = content;
        this.isMine = false;
        this.isVisible = false;
    }

    public void setVisible(boolean visible) {
        this.isVisible = visible;
    }

    public void setContent(Object content) {
        this.content = (char) content;
    }

    public Object getContent() {
        return this.content;
    }

    public void setMine() {
        this.isMine = true;
    }

    public boolean isMine() {
        return this.isMine;
    }

    public boolean isVisible() {
        return this.isVisible;
    }
}
