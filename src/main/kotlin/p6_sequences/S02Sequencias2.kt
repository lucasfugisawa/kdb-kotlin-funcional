package com.fugisawa.p6_sequencias

fun main() {
    // Podemos criar sequências infinitas
    val infiniteSequence = generateSequence(1) { it + 1 }

    // É preciso tomar cuidado para não iterar infinitamente
    // Exemplo: pegando apenas os 10 primeiros
    val firstTen = infiniteSequence.take(10).toList()
    println("Primeiros 10 da sequência infinita: $firstTen")

    // Cada transformação continua lazy
    val filteredInfinite = infiniteSequence
        .filter { it % 2 == 0 }    // somente pares
        .map { it * 3 }           // multiplica por 3

    // Exibindo apenas 5 elementos, para evitar loop infinito
    val fiveElements = filteredInfinite.take(5).toList()
    println("5 primeiros pares triplicados: $fiveElements")

    // Demonstrando que não criamos novas coleções a cada passo
    // Os dados só fluem pela pipeline lazy.

    // Observação: se chamarmos `filteredInfinite.toList()`, teremos loop infinito
    // Por isso, só devemos consumir com `take(...)` ou condições que terminem.
}
