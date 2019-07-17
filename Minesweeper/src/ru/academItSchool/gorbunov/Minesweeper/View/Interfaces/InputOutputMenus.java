package ru.academItSchool.gorbunov.Minesweeper.View.Interfaces;

import ru.academItSchool.gorbunov.Minesweeper.Model.Difficult.Difficult;
import ru.academItSchool.gorbunov.Minesweeper.Model.GameField.GameField;
import ru.academItSchool.gorbunov.Minesweeper.Model.Model;
import ru.academItSchool.gorbunov.Minesweeper.Model.MyTimer;

import java.io.IOException;

public interface InputOutputMenus {
    /**
     * @return вывод главного меню.
     */
    Object getMainMenu();

    /**
     * @return вывод меню выбора сложности.
     */
    Object getSettingMenu();

    /**
     * @return вывод меню выбора сложности для вывода таблицы рекордов.
     */
    Object getHeightScoreMenu();

    /**
     * @return Меню завершения игры.
     */
    Object getEndGameMenu();

    /**
     * @param from с какой цифры вводить
     * @param to по какую цифру вводить
     * @return Создается сообщение для ввода информации.
     */
    Object getMenuMessage(int from, int to);

    /**
     * @param from с какой цифры вводить
     * @param to по какую цифру вводить
     * @param message сообщение для ввода информации.
     * @return цифра введеная пользователем
     */
    int getInput(int from, int to, String message);

    /**
     * Вывод игрового поля
     * @param model игровое поле
     * @param difficult сложность
     * @param myTimer текщее время
     */
    Object getPrintGame(Model model, Difficult difficult, MyTimer myTimer) throws IOException;

    /**
     * Запись в таблицу рекордов и вывод таблицы рекордов.
     * @param myTimer время игры
     * @param difficult сложность игры
     * @return true Если запись была сделана false если хуже последнего места в таблице
     */
    boolean getHighScoreWrite(MyTimer myTimer, Difficult difficult);
}
