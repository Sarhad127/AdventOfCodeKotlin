package `2017Day2`.Före

import java.io.File

//2017 Day 2: Corruption Checksum

val minData = File("src/2017Day2/Före/Spreadsheet.txt")

fun checksum(): Int {
    val spreadsheet = mutableListOf<List<Int>>()
    minData.forEachLine {
        val rad = it.split("\\s+".toRegex()).mapNotNull { it.toIntOrNull() }
        spreadsheet.add(rad)
    }
    //läser in data från filen och lägger till varje rad som en lista av heltal
    //toRegex indikerar att det kan finnas flera mellanslag
    var checksum = 0
    for (rader in spreadsheet) {
        val max = rader.maxOrNull() ?: 0
        val min = rader.minOrNull() ?: 0
        checksum += max - min
    } //läser in högsta talet i raden och minsta talet i raden och subtraherar dessa
    println("Checksum: $checksum")
    return checksum
}


fun checkDividableSum(): Int {
    val spreadsheet = mutableListOf<List<Int>>()
    minData.forEachLine {
        val rad = it.split("\\s+".toRegex()).mapNotNull { it.toIntOrNull() }
        spreadsheet.add(rad)
    }
    var sum = 0 //variabel för den totala summan

    for (rader in spreadsheet) {
        var result: Int? = null //nullable variabel för att lagra division resultatet

        for (tal in rader) {
            val div = rader.find { it != tal && it % tal == 0 }
            //div variabeln hittar ett tal i samma rad som jämnt delar det nuvarande talet
            //vilket är det första talet i listan "tal"
            if (div != null) {
                result = div / tal
                break
            }
        }
        if (result != null) {
            sum += result
        } //lägger till kvoten av den raden till sum
    }
    println("Kvoten av alla utförda rader: $sum")
    return sum
}


fun main() {
    checksum()
    checkDividableSum()
}

/*
Del 1:
läsa in en spreadsheet med många olika tal i flera rader, och uppgiften går ut på att
räkna hösta talet och minsta talet i en rad, och sedan subtrahera dessa för att sedan addera detta tal
med nästa radens värde

Del 2:
i del 2 kontrolleras varje rad för att
hitta de två talen som jämnt delar varandra och sedan dividera
dem för att få resultatet av divisionen.
Därefter ska man addera resultaten för alla rader och skriva ut den totala summan.
*/
