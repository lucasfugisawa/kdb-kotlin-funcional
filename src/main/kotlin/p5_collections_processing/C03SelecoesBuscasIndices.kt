package com.fugisawa.p5_collections_processing

fun main() {
    val students = listOf(
        Student("Alice", 21, 8.5, true),
        Student("Bob", 23, 6.0, false),
        Student("Charlie", 22, 9.0, true),
        Student("Diana", 20, 7.0, true)
    )

    // withIndex -> retorna um IndexedValue (índice + valor)
    println("Iterando com indices:")
    for (indexedStudent in students.withIndex()) {
        println("Index: ${indexedStudent.index} - Estudante: ${indexedStudent.value.name}")
    }
    println("Iterando com indices + desestruturação:")
    for ((index, student) in students.withIndex()) {
        println("Index: $index - Estudante: ${student.name}")
    }

    // take e takeLast -> seleciona os primeiros/últimos elementos
    println("\nPrimeiros 2 estudantes: ${students.take(2).map { it.name }}")
    println("Últimos 2 estudantes: ${students.takeLast(2).map { it.name }}")

    // drop e dropLast -> descarta os primeiros/últimos elementos
    println("\nDescartando os 2 primeiros: ${students.drop(2).map { it.name }}")
    println("Descartando os 2 últimos: ${students.dropLast(2).map { it.name }}")

    // subList -> retorna uma sublista a partir de índices específicos
    println("\nsubList(1, 3): ${students.subList(1, 3).map { it.name }}")

    // random -> retorna um elemento aleatório da lista (atenção em produção)
    val randomStudent = students.random()
    println("\nEstudante aleatório: ${randomStudent.name}")

    // find -> encontra o primeiro elemento que satisfaz a condição ou null
    val studentFind = students.find { it.grade > 8.9 }
    println("\nfind (grade > 8.9): ${studentFind?.name}")

    // firstOrNull -> similar ao find, mas sem precisar de lambda (opcional)
    val studentFirstOrNull = students.firstOrNull { it.name == "Zack" }
    println("firstOrNull (Zack?): $studentFirstOrNull")

    // findLast e lastOrNull -> análogos, mas buscando do fim para o início
    val studentFindLast = students.findLast { it.active }
    println("findLast (ativo): ${studentFindLast?.name}")

    val studentLastOrNull = students.lastOrNull { it.name.startsWith("A") }
    println("lastOrNull (nome começa com A): ${studentLastOrNull?.name}")
}
