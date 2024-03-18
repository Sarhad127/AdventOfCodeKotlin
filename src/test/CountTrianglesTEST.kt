package test

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Assertions.*
import src2016Day3Före2016del1.*


class CountTrianglesTEST {
    @Test
    fun `test giltigTriangel`() {
        assertTrue(giltigTriangel(listOf(3, 4, 5)))
        assertFalse(giltigTriangel(listOf(1, 9, 3)))
    }

    @Test
    fun `test horisontellTriangel`() {
        val trianglar = mutableListOf<List<Int>>()
        val testData = listOf(
            listOf(3, 4, 5),
            listOf(1, 9, 3),
            listOf(6, 8, 10)
        )
        testData.forEach { sidor ->
            if (giltigTriangel(sidor)) {
                trianglar.add(sidor)
            }
        }
        assertEquals(2, trianglar.size)
    }


    @Test
    fun `test vertikalTriangel`() {
        var trianglar2 = 0
        val testData = listOf(
            listOf(3, 1, 6),
            listOf(4, 2, 8),
            listOf(5, 3, 10)
        )
        testData.forEach { sidor ->
            if (giltigTriangel(sidor)) {
                trianglar2++
            }
        }
        assertEquals(0, trianglar2)
    }

}
