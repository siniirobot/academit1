package ru.academItSchool.gorbunov.Minesweeper.Model.Exceptions;

public class Boom extends Exception {
    /**
     * Маркер выхода из игры путем взрыва.
     *
     * @param message - сообщение выхода.
     */
    public Boom(String message) {
        super(message);
    }
}
