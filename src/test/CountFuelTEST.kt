package test

import countFuel
import countFuel2
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class CountFuelTEST {

    @Test
    fun countFuel() {
        assertEquals(2, countFuel(12))
        assertEquals(2, countFuel(14))
        assertEquals(654, countFuel(1969))
        assertEquals(33583, countFuel(100756))
    }

    @Test
    fun countFuel2() {
        assertEquals(2, countFuel2(12))
        assertEquals(2, countFuel2(14))
        assertEquals(966, countFuel2(1969))
        assertEquals(50346, countFuel2(100756))
    }
}