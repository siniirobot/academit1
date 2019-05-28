package ru.academItSchool.gorbunov.Minesweeper.Resources.Characters;

import java.awt.*;

public class Characters {
    public Cell[] getCell() {
        return new Cell[]{
                new Cell('\u0020', Toolkit.getDefaultToolkit().getImage("icon.png")),
                new Cell('\u0031', Toolkit.getDefaultToolkit().getImage("icon.png")),
                new Cell('\u0032', Toolkit.getDefaultToolkit().getImage("icon.png")),
                new Cell('\u0033', Toolkit.getDefaultToolkit().getImage("icon.png")),
                new Cell('\u0034', Toolkit.getDefaultToolkit().getImage("icon.png")),
                new Cell('\u0035', Toolkit.getDefaultToolkit().getImage("icon.png")),
                new Cell('\u0036', Toolkit.getDefaultToolkit().getImage("icon.png")),
                new Cell('\u0037', Toolkit.getDefaultToolkit().getImage("icon.png")),
                new Cell('\u0038', Toolkit.getDefaultToolkit().getImage("icon.png")),
                new Cell('\u034f', Toolkit.getDefaultToolkit().getImage("icon.png")),
                new Cell('\u0489', Toolkit.getDefaultToolkit().getImage("icon.png")),
                new Cell('\u06e9', Toolkit.getDefaultToolkit().getImage("icon.png")),
                new Cell('\u003f', Toolkit.getDefaultToolkit().getImage("icon.png")),
        };
    }
}
