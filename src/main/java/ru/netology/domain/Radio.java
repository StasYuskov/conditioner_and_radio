package ru.netology.domain;

public class Radio {
    private int currentRadiostation;
    private int currentVolume;
    private final int lastStation;

    public Radio() {
        this.lastStation = 9;
    }

    public Radio(int countRadiostation) {
        this.lastStation = countRadiostation - 1;
    }

    // Получение уровня громкости.
    public int getCurrentVolume() {
        return currentVolume;
    }

    // Увеличить громкость на 1.
    public void moreVolume() {
        if (currentVolume == 100) {
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

    public void setVolume(int volume) {
        if (volume < 0 || volume > 100) {
            return;
        }
        this.currentVolume = volume;
    }

    // Получить выбранную радиостанцию.
    public int getCurrentRadiostation() {
        return currentRadiostation;
    }

    // Переключить на следующую радиостанцию.
    public void next() {
        if (currentRadiostation == lastStation) {
            currentRadiostation = 0;
        } else {
            currentRadiostation += 1;
        }
    }

    // Переключить на предыдущую радиостанцию.
    public void prev() {
        if (currentRadiostation == 0) {
            currentRadiostation = lastStation;
        } else {
            currentRadiostation -= 1;
        }
    }

    // Установить радиостанцию.
    public void setRadiostation(int radiostation) {
        if (radiostation < 0 || radiostation > lastStation) {
            return;
        }
        this.currentRadiostation = radiostation;
    }

    public int getLastStation() {
        return lastStation;
    }
}
