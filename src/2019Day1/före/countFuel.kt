import java.io.File

//2019 Day 1: The Tyranny of the Rocket Equation

val file = File("src/2019Day1/före/modules")

fun countFuel(mass: Int): Int {
    return mass / 3 - 2
}
fun countFuel2(mass: Int): Int { //del-2 lösning
    var totalFuel = 0
    var remainingMass = mass

    while (true) {
        val fuel = remainingMass / 3 - 2
        if (fuel <= 0) break
        totalFuel += fuel
        remainingMass = fuel
    } //while loop som utför ekvationen tills den blir noll eller negativ

    return totalFuel
}

fun main() {
    val moduleMass = mutableListOf<Int>()

    file.forEachLine {
        moduleMass.add(it.toInt())
    }

    var totalFuel = 0
    var totalFuel2 = 0

    for (mass in moduleMass) {
        totalFuel += countFuel(mass)
    }
    for (mass in moduleMass) {
        totalFuel2 += countFuel2(mass)
    }

    println("Fuel needed: $totalFuel")
    println("All fuel needed $totalFuel2")
}

/*
Del-1
Uppgiften är att hitta det totala bränslebehovet för alla moduler på ett rymdskepp genom att
individuellt beräkna det bränsle som behövs för varje modul och sedan summera alla bränslevärden.

Formeln är att ta en rad, dela den med tre, avrunda neråt och sedan subtrahera med två.
Gör detta på alla tal och sedan addera alla värden ihop och skriv ut svaret
exempelvis: Bränsle = (50062 / 3) - 2 = 16686 - 2 = 16684

Del-2
Formeln går ut på att beräkna bränslebehovet som på del 1 men
att fortsätta tillämpa formeln ända tills talet blir
noll eller negativt
*/