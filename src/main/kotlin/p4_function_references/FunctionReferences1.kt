package com.fugisawa.p4_function_references

// Função top-level
fun dobro(x: Int) = x * 2

// Classe com métodos
class Operacoes {
    fun triplo(x: Int) = x * 3
}

// Funções sobrecarregadas
fun sobrecarregada(x: Int) = x * 2
fun sobrecarregada(x: String) = x.repeat(2)

// Função genérica
fun <T> identidade(x: T): T = x

// Extension function
fun String.exclamar() = "$this!"

fun main() {
    // Referência a função top-level
    val refDobro: (Int) -> Int = ::dobro
    println("Dobro: ${refDobro(4)}") // Saída: Dobro: 8

    // Referência a método de instância (bounded function reference)
    val operacoes = Operacoes()
    val refTriplo: (Int) -> Int = operacoes::triplo
    println("Triplo: ${refTriplo(3)}") // Saída: Triplo: 9

    // Referência a extension function
    val refExclamar: (String) -> String = String::exclamar
    println(refExclamar("Olá")) // Saída: Olá!

    // Referência a função genérica
    val refIdentidade: (Int) -> Int = ::identidade
    println("Identidade: ${refIdentidade(10)}") // Saída: Identidade: 10

    // Referência a função sobrecarregada (especificando tipos)
    val refSobrecarregadaInt: (Int) -> Int = ::sobrecarregada
    println("Sobrecarregada Int: ${refSobrecarregadaInt(5)}") // Saída: Sobrecarregada Int: 10

    val refSobrecarregadaString: (String) -> String = ::sobrecarregada
    println("Sobrecarregada String: ${refSobrecarregadaString("Oi")}") // Saída: Sobrecarregada String: OiOi

    // Referência a propriedade
    val mensagem = "Kotlin é legal"
    val refLength: (String) -> Int = String::length
    println("Comprimento: ${refLength(mensagem)}") // Saída: Comprimento: 14
}


/*
RESUMO:
Referências usando '::': Capturamos referências para funções e propriedades para uso posterior.
Bounded function reference: Referência que já está associada a uma instância específica.
Funções genéricas e sobrecarregadas: Podemos referenciar funções genéricas e resolver sobrecargas especificando tipos.
Propriedades como funções: Referências a propriedades podem ser usadas como funções que retornam seu valor.
*/