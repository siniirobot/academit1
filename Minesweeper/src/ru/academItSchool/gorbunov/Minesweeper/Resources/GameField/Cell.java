package ru.academItSchool.gorbunov.Minesweeper.Resources.GameField;

public class Cell {
    private Character character;
    private boolean isVisible;

    public Cell(Character character) {
        this.character = character;
        isVisible = false;
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
}
