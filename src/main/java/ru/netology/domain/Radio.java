package ru.netology.domain;

public class Radio {
    private int currentRadiostation;
    private int currentVolume;

    // Получение уровня громкости.
    public int getCurrentVolume() {
        return currentVolume;
    }

    // Увеличить громкость на 1.
    public void moreVolume() {
        if (currentVolume == 10) {
            return;
        }
        currentVolume += 1;
    }

    // Уменьшить громкость на 1.
    public void lessVolume() {
        if (currentVolume == 0) {
            return;
        }
        currentVolume -= 1;
    }

    // Получить выбранную радиостанцию.
    public int getCurrentRadiostation() {
        return currentRadiostation;
    }

    // Переключить на следующую радиостанцию.
    public void next() {
        if (currentRadiostation == 9) {
            currentRadiostation = 0;
        } else {
            currentRadiostation += 1;
        }
    }

    // Переключить на предыдущую радиостанцию.
    public void prev() {
        if (currentRadiostation == 0) {
            currentRadiostation = 9;
        } else {
            currentRadiostation -= 1;
        }
    }

    // Установить радиостанцию.
    public void setRadiostation(int radiostation) {
        if (radiostation < 0 || radiostation > 9) {
            return;
        }
        this.currentRadiostation = radiostation;
    }
}
