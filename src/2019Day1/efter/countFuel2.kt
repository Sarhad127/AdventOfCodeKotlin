package `2019Day1`.efter

import java.io.File

val file = File("src/2019Day1/före/modules")
var result2 = 0 //bränslemängd för del 2


fun Int.fuel(): Int = (this / 3) - 2 //Förlängningsfunktion som utför formeln för att lösa del 1

fun del1(modules: List<Int>): Int = //tar en lista som argument och kallar sedan på Förlängningsfunktionen
    modules.sumBy { it.fuel() } //sumby tillämpar funktionen på alla rader

fun del2(){
    file.forEachLine {
            line -> val mass = line.toInt()
        var currentMass = mass
        while (currentMass > 0) {
            val fuel = (currentMass / 3) - 2
            if (fuel > 0) {
                result2 += fuel
            }
            currentMass = fuel
        }
    }
}

fun main(args: Array<String>) {
    val modules = file.readLines().map { it.toInt() } //läser in varje rad från filen, konverterar den till en Int och skapar en lista av moduler.
    val result1 = del1(modules)
    del2()

    println("Del 1: $result1")
    println("Del 2: $result2")
}

/*
* https://github.com/tginsberg/advent-2019-kotlin/blob/master/src/main/kotlin/com/ginsberg/advent2019/Day01.kt
* https://github.com/TheTurkeyDev/Advent-of-Code-2019/commit/fe9657cb63079b805ebe676cfdcae6bfeddad840
* */