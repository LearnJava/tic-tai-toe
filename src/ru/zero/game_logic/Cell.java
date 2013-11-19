package ru.zero.game_logic;

public class Cell {

    private boolean isClean = true;
    private boolean isZero;

    public void computerMove() {
        isClean = false;
        isZero = true;
    }

    public void userMove() {
        isClean = false;
    }

    public boolean getIsZero() {
        return isZero;
    }

    public boolean getIsClean() {
        return isClean;
    }

    public boolean isZeroChecked() {
        return !isClean && isZero;
    }

    public boolean isXChecked() {
        return !isClean && !isZero;
    }
}
