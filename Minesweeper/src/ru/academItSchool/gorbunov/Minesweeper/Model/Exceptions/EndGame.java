package ru.academItSchool.gorbunov.Minesweeper.Model.Exceptions;

public class EndGame extends Exception {
    /**
     * Маркер выхода из игры.
     * @param message - сообщение.
     */
    public EndGame(String message) {
        super(message);
    }
}
