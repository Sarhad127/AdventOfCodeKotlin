package src2016Day3Före2016del1

//2016 Day 3: Squares With Three Sides

import java.io.File

val trianglar = mutableListOf<List<Int>>() //min triangel lista
var file = File("src/2016Day3/Före/sides") //filens plats
var trianglar2 = 0; //variabel för del 2

fun main() {
    horisontellTriangel() //del1
    vertikalTriangel() //del2
}

fun giltigTriangel(sidor: List<Int>): Boolean {
    val (a, b, c) = sidor.sorted()
    return a + b > c
}
/* Denna funktion tar in en lista som argument och kontrollerar att de tre talen som finns
   i en rad sorteras och returnerar true om de två första talen är större än den tredje
 */

fun horisontellTriangel(){
    file.forEachLine {
            linje -> val sidor =
                linje.trim().split(" ").mapNotNull { it.toIntOrNull() }

        if (sidor.size == 3 && giltigTriangel(sidor)) {
            trianglar.add(sidor)
        }
    }
    println("Giltiga trianglar: ${trianglar.size}")
}
/* Denna funktion läser varje rad för sig i filen och
   kontrollerar att det finns tre olika tal av typen int och kollar sedan om det är en giltig
   triangel
*/



fun vertikalTriangel() {
    val Kolumn = Array(3) { mutableListOf<Int>() } // array som räknar 3 tal i kolumn

    file.forEachLine { line ->
        val sidor = line.trim().split(" ").mapNotNull { it.toIntOrNull() }

        if (sidor.size == 3) {
            for (i in 0 until 3) {
                Kolumn[i].add(sidor[i])
            }
        } //ansvarig för att få ut kolumn av tre tal
    }
    for (kolumner in Kolumn) {
        for (i in 0 until kolumner.size step 3) { // step ökar i med 3 varje iteration
            val sidor = kolumner.subList(i, i + 3)
            if (giltigTriangel(sidor)) {
                trianglar2++
            } //om giltig läggs den till i variabeln trianglar2
        }
    }
    println("Giltiga trianglar genom att läsa vertikalt: $trianglar2")
}

/*

Del-1:
I del 1 undersöker vi varje rad i vår fil, och sorerar de tre sidorna som finns i
varje rad, och sedan kontrollerar summan av de två första och om sidorna av dessa
är större än den tredje sidan är detta en giltig triangel och då ska denna rad läggas
till i våt lista över giltiga trianglar

Del-2:
I del ett räknade vi trianglarna från filen horisontiellt, men här så räknar vi
vertikalt dvs uppifrån och ned i varje kolumn och sedan kontrollerar
vi om det är en giltig triangel.
Printar till sist ut alla giltiga trianglar för både vertikalt och horisontell
*/
