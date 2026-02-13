package ru.netology.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class ConditionerTest {

    @ParameterizedTest
    @CsvSource(
            value = {
            "'RX-100', 16, 32"
    }, delimiter = ',')
    public void shouldCreate(String name, int minTemp, int maxTemp) {
        Conditioner conditioner = new Conditioner(name, minTemp, maxTemp);

        assertEquals(name, conditioner.getName());
        assertEquals(minTemp, conditioner.getMinTemp());
        assertEquals(maxTemp, conditioner.getMaxTemp());
        assertEquals(16, conditioner.getCurrentTemp());
        assertFalse(conditioner.isOn());
    }

    @ParameterizedTest
    @CsvSource(
            value = {
                    "'RX-200', 16, 32"
            }, delimiter = ',')
    public void onOff(String name, int minTemp, int maxTemp) {
        Conditioner conditioner = new Conditioner(name, minTemp, maxTemp);
        assertFalse(conditioner.isOn());

        conditioner.setOn();
        assertTrue(conditioner.isOn);

        conditioner.setOn();
        assertFalse(conditioner.isOn);
    }

    @ParameterizedTest
    @CsvSource(
            value = {
                    "'RX-300', 16, 32, 24, 24",
                    "'RX-301', 16, 32, 16, 16",
                    "'RX-302', 16, 32, 15, 16",
                    "'RX-303', 16, 32, 32, 32",
                    "'RX-304', 16, 32, 33, 32"
            }, delimiter = ',')
    public void changeTemp(String name, int minTemp, int maxTemp, int currentTemp, int expectedTemp) {
        Conditioner conditioner = new Conditioner(name, minTemp, maxTemp);

        assertEquals(16, conditioner.getCurrentTemp());

        conditioner.setCurrentTemp(currentTemp);
        assertEquals(expectedTemp, conditioner.getCurrentTemp());
    }

}
