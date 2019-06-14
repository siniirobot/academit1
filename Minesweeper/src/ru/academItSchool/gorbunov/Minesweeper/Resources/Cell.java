package ru.academItSchool.gorbunov.Minesweeper.Resources;

public interface Cell {
    Object getContent();


    void setMine();

    boolean isMine();

    boolean isVisible();

    void setVisible();

    void setContent(Object content);
}
