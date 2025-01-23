package com.fugisawa.p5_collections_processing

data class Student(
    val name: String,
    val age: Int,
    val grade: Double,
    val active: Boolean,
)

fun main() {
    val students = listOf(
        Student("Alice", 21, 8.5, true),
        Student("Bob", 23, 6.0, false),
        Student("Charlie", 22, 9.0, true),
        Student("Diana", 20, 7.0, true)
    )

    // forEach -> itera por cada elemento da coleção
    println("Iterando com forEach:")
    students.forEach { student ->
        println("Estudante: ${student.name}, Idade: ${student.age}")
    }


    // onEach -> similar ao forEach, mas retorna a coleção original
    // útil quando queremos encadear outras chamadas
    println("\nIterando com onEach (retorna a própria lista):")
    val sameStudents = students.onEach { student ->
        println("Estudante: ${student.name}, Ativo: ${student.active}")
    }
    println("Mesmo objeto que chamamos onEach? ${students === sameStudents}")

    // filter -> filtra a coleção de acordo com um predicado / condição booleana
    println("\nFiltrando estudantes ativos:")
    val activeStudents = students.filter { it.active }
    activeStudents.forEach { println(it.name) }

    // Mesma coisa:
    students
        .filter { it.active }
        .forEach { println(it.name) }

    println("\nFiltrando estudantes inativos:")
    val inactiveStudents = students.filterNot { it.active }
    inactiveStudents.forEach { println(it.name) }
}
