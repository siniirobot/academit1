package ru.academItSchool.gorbunov.Minesweeper.Model.Exceptions;

public class BoomException extends Exception {
    /**
     * Маркер выхода из игры путем взрыва.
     *
     * @param message - сообщение выхода.
     */
    public BoomException(String message) {
        super(message);
    }
}
