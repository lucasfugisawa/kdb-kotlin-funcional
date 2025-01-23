package com.fugisawa.p6_sequencias

fun main() {
    // Vamos criar uma lista e convertê-la em Sequence:
    val numbersList = listOf(1, 2, 3, 4, 5)
    val numbersSequence = numbersList.asSequence()

    println("Processamento com lista (eager):")
    val eagerResult = numbersList
        .map {
            print("map($it) ")
            it * 2
        }
        .filter {
            print("filter($it) ")
            it > 5
        }
        .take(2) // Mesmo se chamarmos take(2), a lista já foi toda mapeada/filtrada
    println("\nResultado final da lista: $eagerResult")

    println("\nProcessamento com sequência (lazy):")
    val lazyResult = numbersSequence
        .map {
            print("map($it) ")
            it * 2
        }
        .filter {
            print("filter($it) ")
            it > 5
        }
        .take(2)
    // Repare que nada foi impresso ainda porque a Sequence não rodou efetivamente.

    println("\nAgora forçando execução da sequência:")
    // Ao consumir com toList(), a sequência começa a processar elemento por elemento.
    val resultList = lazyResult.toList()
    println("\nResultado final da sequência (take 2): $resultList")
}
