package ru.netology.domain;

public class Conditioner {
    private static final int DEFAULT_TEMP = 16;

    protected final String name;
    protected final int minTemp;
    protected final int maxTemp;
    protected int currentTemp;
    protected boolean isOn;

    // Конструктор.
    public Conditioner(String name, int minTemp, int maxTemp) {
        this.name = name;
        this.minTemp = minTemp;
        this.maxTemp = maxTemp;
        this.currentTemp = DEFAULT_TEMP;
        this.isOn = false;
    }

    // Получить имя.
    public String getName() {
        return name;
    }

    // Получить минимальную температуру.
    public int getMinTemp() {
        return minTemp;
    }

    // Получить максимальную температуру.
    public int getMaxTemp() {
        return maxTemp;
    }

    // Получить актуальную температуру.
    public int getCurrentTemp() {
        return currentTemp;
    }

    // Установить температуру.
    public void setCurrentTemp(int currentTemp) {
        if (currentTemp < minTemp) {
            this.currentTemp = minTemp;
        } else if (currentTemp > maxTemp) {
            this.currentTemp = maxTemp;
        } else {
            this.currentTemp = currentTemp;
        }
    }

    // Статус.
    public boolean isOn() {
        return isOn;
    }

    // Вкл/выкл.
    public void setOn() {
        if (isOn) {
            this.isOn = false;
        } else {
            isOn = true;
        }
    }
}
