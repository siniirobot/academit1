package ru.academItSchool.gorbunov.Minesweeper.Resources.GameField;

public class Cell {
    private Character character;
    private int[] coordinate;
    private boolean isVisible;

    public Cell(Character character,int[] coordinate) {
        this.character = character;
        this.coordinate = coordinate;
        this.isVisible = false;
    }

    public Character getCharacter() {
        return character;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }

    public boolean isVisible() {
        return isVisible;
    }

    public void setVisible(boolean visible) {
        isVisible = visible;
    }

    @Override
    public String toString() {
        return character.toString();
    }

    public int[] getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(int[] coordinate) {
        this.coordinate = coordinate;
    }
}
