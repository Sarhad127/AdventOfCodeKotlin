package `2017Day2`.Efter

import java.io.File

fun checksum2(input: List<List<Int>>): Int {
    return input.fold(0) { acc, rad -> //fold adderar från noll
        val min = rad.minOrNull() ?: 0
        val max = rad.maxOrNull() ?: 0
        acc + (max - min)
    } //funktionen räknar ut summan av differensen mellan det största och minsta värdet
      //för varje rad och stoppas in i acc, vilket är noll till att börja med.
}
fun del2(input: List<List<Int>>): Int {
    return input
        .map { checkDividableSum2(it) } //använder map för att igenom varje rad i listan
        .sumBy { it.first / it.second }
}

fun checkDividableSum2(rad: List<Int>): Pair<Int, Int> {
    for (i in rad.indices) {
        for (j in rad.indices) {
            if (i != j && rad[i] % rad[j] == 0) {
                return Pair(rad[i], rad[j])
            }
        }
    }
    throw IllegalArgumentException("Ingen passande tal hittades")
}

fun main() {
    val spreadsheet = mutableListOf<List<Int>>()
    val minData = File("src/2017Day2/Före/Spreadsheet.txt")
    minData.forEachLine {
        val rad = it.split("\\s+".toRegex()).mapNotNull { it.toIntOrNull() }
        spreadsheet.add(rad)
    }
    println("Del 1: ${checksum2(spreadsheet)}")
    println("Del 2: ${del2(spreadsheet)}")
}

//https://todd.ginsberg.com/post/advent-of-code/2017/day2/
