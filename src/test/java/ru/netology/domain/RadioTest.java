package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RadioTest {

    @Test
    void changeVolume() {
        Radio radio = new Radio();

        // Попытка уменьшения громкости меньше минимума.
        assertEquals(0, radio.getCurrentVolume());
        radio.lessVolume();
        assertEquals(0, radio.getCurrentVolume());

        // Увеличение громкости из минимума.
        radio.moreVolume();
        assertEquals(1, radio.getCurrentVolume());

        // Увеличение громкости до максимума.
        radio.moreVolume();radio.moreVolume();radio.moreVolume();radio.moreVolume();
        radio.moreVolume();radio.moreVolume();radio.moreVolume();radio.moreVolume();
        radio.moreVolume();
        assertEquals(10, radio.getCurrentVolume());

        // Попытка увеличения громкости выше максимума.
        radio.moreVolume();
        assertEquals(10, radio.getCurrentVolume());

        // Уменьшение громкости из максимума.
        radio.lessVolume();
        assertEquals(9, radio.getCurrentVolume());
    }

    @Test
    void radiostationButtonsTest() {
        Radio radio = new Radio();

        // Переключение радиостанции на следующую из начала.
        assertEquals(0, radio.getCurrentRadiostation());
        radio.next();
        assertEquals(1, radio.getCurrentRadiostation());

        // Переклюючение радиостании на предыдущую (Выход за пределы диапазона станций).
        radio.prev();radio.prev();
        assertEquals(9, radio.getCurrentRadiostation());

        // Переклюючение радиостании на предыдущую из конца.
        radio.prev();
        assertEquals(8, radio.getCurrentRadiostation());

        // Переклюючение радиостании на следующую (Выход за пределы диапазона станций).
        radio.next();radio.next();
        assertEquals(0, radio.getCurrentRadiostation());

    }

    @Test
    void setRadiostation() {
        Radio radio = new Radio();

        // Тестирование установки радиостанции через анализ граничных значений и эквиваленитное разбиение.
        assertEquals(0, radio.getCurrentRadiostation());
        radio.setRadiostation(5);
        assertEquals(5, radio.getCurrentRadiostation());
        radio.setRadiostation(-1);
        assertEquals(5, radio.getCurrentRadiostation());
        radio.setRadiostation(10);
        assertEquals(5, radio.getCurrentRadiostation());
        radio.setRadiostation(0);
        assertEquals(0, radio.getCurrentRadiostation());
        radio.setRadiostation(9);
        assertEquals(9, radio.getCurrentRadiostation());
    }
}