package ru.academItSchool.gorbunov.Minesweeper.Resources.Difficult;

import ru.academItSchool.gorbunov.Minesweeper.Resources.GameField.GameField;

public class Easy implements Difficult {
    private String name;
    private GameField gameField;

    public Easy() {
        this.name = "easy";
        this.gameField = new GameField(9, 9, 10);
        this.gameField.fillMinesInField();
        this.gameField.fillNumbersInField();
    }

    @Override
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public GameField getGameField() {
        return gameField;
    }

    public void setGameField(GameField gameField) {
        this.gameField = gameField;
    }
}
