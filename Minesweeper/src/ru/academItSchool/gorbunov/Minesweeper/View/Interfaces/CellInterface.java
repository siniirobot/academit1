package ru.academItSchool.gorbunov.Minesweeper.View.Interfaces;

public interface CellInterface {
    Object getContent();

    void setMine();

    boolean isMine();

    boolean isVisible();

    void setVisible(boolean visible);

    void setContent(Object content);
}
