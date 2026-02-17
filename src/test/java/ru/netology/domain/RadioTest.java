package ru.netology.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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
        radio.setVolume(98);
        radio.moreVolume();radio.moreVolume();
        assertEquals(100, radio.getCurrentVolume());

        // Попытка увеличения громкости выше максимума.
        radio.moreVolume();
        assertEquals(100, radio.getCurrentVolume());

        // Уменьшение громкости из максимума.
        radio.lessVolume();
        assertEquals(99, radio.getCurrentVolume());
    }

    @ParameterizedTest
    @CsvSource(value =
            {"10",
            "25"},
            delimiter = ','
    )
    void radiostationButtonsTest(int countRadiostation) {
        Radio radio = new Radio(countRadiostation);

        // Переключение радиостанции на следующую из начала.
        assertEquals(0, radio.getCurrentRadiostation());
        radio.next();
        assertEquals(1, radio.getCurrentRadiostation());

        // Переклюючение радиостании на предыдущую (Выход за пределы диапазона станций).
        radio.prev();radio.prev();
        assertEquals(radio.getLastStation(), radio.getCurrentRadiostation());

        // Переклюючение радиостании на предыдущую из конца.
        radio.prev();
        assertEquals((radio.getLastStation() - 1), radio.getCurrentRadiostation());

        // Переклюючение радиостании на следующую (Выход за пределы диапазона станций).
        radio.next();radio.next();
        assertEquals(0, radio.getCurrentRadiostation());

    }

    @ParameterizedTest
    @CsvSource(value =
            {"10",
                    "25"},
            delimiter = ','
    )
    void setRadiostation(int countRadiostation) {
        Radio radio = new Radio(countRadiostation);

        // Тестирование установки радиостанции через анализ граничных значений и эквиваленитное разбиение.
        assertEquals(0, radio.getCurrentRadiostation());
        radio.setRadiostation(countRadiostation/2);
        assertEquals(countRadiostation/2, radio.getCurrentRadiostation());
        radio.setRadiostation(-1);
        assertEquals(countRadiostation/2, radio.getCurrentRadiostation());
        radio.setRadiostation(countRadiostation+1);
        assertEquals(countRadiostation/2, radio.getCurrentRadiostation());
        radio.setRadiostation(0);
        assertEquals(0, radio.getCurrentRadiostation());
        radio.setRadiostation(radio.getLastStation());
        assertEquals(radio.getLastStation(), radio.getCurrentRadiostation());
    }
}