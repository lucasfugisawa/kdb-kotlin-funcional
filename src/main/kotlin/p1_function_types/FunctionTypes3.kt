package com.fugisawa.p1_function_types

// Definindo uma classe que implementa um tipo função
class Multiplicador(z: Int? = null) : (Int, Int) -> Int {
    override fun invoke(x: Int, y: Int): Int = x * y * (z ?: 1)

    val description = "Multiplicador"
    val z: Int? = z

    fun print() {
        println("Description: $description")
        println("Z: $z")
    }
}

// Reutilizando a função 'calcular' do exemplo anterior
// fun calcular(a: Int, b: Int, operacao: (Int, Int) -> Int): Int {
//     return operacao(a, b)
// }

fun main() {
    val multiplicador10 = Multiplicador(10)
    println("Multiplicação: ${multiplicador10(4, 5)}") // Saída: Multiplicação: 20
    multiplicador10.print()

    // Também podemos usá-lo onde um tipo função é esperado
    val resultado = calcular(6, 7, multiplicador10)
    println("Resultado: $resultado") // Saída: Resultado: 42
}

/*
RESUMO:
Implementação de interface função: Como tipos função são interfaces, Multiplicador implementa (Int, Int) -> Int.
Uso flexível: A instância de Multiplicador pode ser usada como uma função devido à implementação de invoke.
*/