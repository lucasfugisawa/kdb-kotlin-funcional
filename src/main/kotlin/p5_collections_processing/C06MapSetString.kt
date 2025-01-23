package com.fugisawa.p5_collections_processing

fun main() {
    // MAP
    // Criação de um map (chave/valor)
    val gradesMap = mapOf(
        "Alice" to 8.5,
        "Bob" to 6.0,
        "Charlie" to 9.0,
    )

    // Iterando em maps
    println("Iterando em Map:")
    gradesMap.forEach { (name, grade) ->
        println("$name -> $grade")
    }

    // Filtrando, transformando, etc. (similar a listas, mas com chaves/valores)
    val approvedMap = gradesMap.filter { (_, grade) -> grade >= 7.0 }
    println("\nAprovados: $approvedMap")

    val namesUpper = gradesMap.map { (name, _) -> name.uppercase() }
    println("Nomes em Uppercase: $namesUpper")

    // SET
    // Set não possui elementos duplicados
    val namesSet = setOf("Alice", "Bob", "Alice", "Diana")
    println("\nSet: $namesSet") // "Alice" aparece só 1 vez

    // Exemplos de operações comuns
    println("contains(\"Bob\")? ${namesSet.contains("Bob")}")
    println("size: ${namesSet.size}")
    println("isEmpty: ${namesSet.isEmpty()}")

    // STRING
    // Podemos tratar string como coleção de caracteres
    val message: String = "Kotlin"
    val chars = message.map { it.uppercaseChar() }
    println("\nString -> Lista de chars maiúsculos: $chars")

    // filter em string
    val onlyVowels = message.filter { it in listOf('a','e','i','o','u','A','E','I','O','U') }
    println("Somente vogais: $onlyVowels")

    // chunked em string
    val chunkedString = "abcdefghij".chunked(3)
    println("Chunked String: $chunkedString")
}
