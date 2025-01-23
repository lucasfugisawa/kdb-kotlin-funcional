package com.fugisawa.p5_collections_processing

fun main() {
    val students = listOf(
        Student("Alice", 21, 8.5, true),
        Student("Bob", 23, 6.0, false),
        Student("Charlie", 22, 9.0, true),
        Student("Diana", 20, 7.0, true)
    )
    val newStudents = listOf(
        Student("Alice1", 21, 8.5, true),
        Student("Bob1", 23, 6.0, false),
        Student("Charlie1", 22, 9.0, true),
        Student("Diana1", 20, 7.0, true)
    )

    // map -> transforma cada elemento e retorna uma nova lista
    val names = students.map { it.name }
    println("Nomes dos estudantes (map): $names")

    // mapNotNull -> mapeia apenas elementos que não gerem null
    val nameWhenActive = students.mapNotNull { student ->
        if (student.active) student.name else null
    }
    println("\nNomes apenas dos ativos (mapNotNull): $nameWhenActive")

    // flatMap -> mapeia cada elemento em múltiplos elementos (lista de listas)
    val listOfWords = listOf("Kotlin é", "muito legal")
    val words = listOfWords.flatMap { it.split(" ") }
    println("\nUsando flatMap: $words")

    val listaDeTurmas = listOf(students, newStudents)
    val allStudents = listaDeTurmas.flatMap { it }

    // fold -> acumula um valor inicial, aplicando a função para cada elemento
    val sumOfGrades = students.fold(0.0) { acc, student ->
        acc + student.grade
    }
    println("\nSoma das notas (fold): $sumOfGrades")

    // sum -> para somar elementos de uma coleção
    val gradesSum = students.map { it.grade }.sum()
    println("Soma das notas (map -> sum): $gradesSum")

    // sum -> podemos também usar diretamente a função de extensão
    val sumByFunction = students.sumOf { it.grade }
    println("Soma das notas (sumOf): $sumByFunction")

    // count -> retorna quantos elementos satisfazem a condição
    val countActive = students.count { it.active }
    println("\nQuantidade de estudantes ativos (count): $countActive")
}
