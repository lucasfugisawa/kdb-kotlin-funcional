package com.fugisawa.p1_function_types

val nome: String = "Kotlin é legal."

// Exemplos:
// ((Int) -> Int)?
// (Int) -> String
// (String, Int) -> String
// (String, Int?) -> String?

// Definindo um tipo função que recebe dois Ints e retorna um Int
val soma: (Int, Int) -> Int = { a, b -> a + b }

// Definindo um tipo função nulável
var multiplicacao: ((Int, Int) -> Int)? = null

// Dinfinido uma função da forma "tradicional" de declarar
fun somaComum(a: Int, b: Int): Int = a + b

fun main() {

    val resultadoA1 = somaComum(1, 2)
    val resultadoA2 = soma(3, 4)

    // Invocando o tipo função com parênteses
    val resultado1 = soma(2, 3)
    println("Resultado1: $resultado1") // Saída: Resultado1: 5

    // Invocando o tipo função com 'invoke'
    val resultado2 = soma.invoke(4, 5)
    println("Resultado2: $resultado2") // Saída: Resultado2: 9

    // Usando '?.invoke' para chamar uma função nulável
    val resultado3 = multiplicacao?.invoke(2, 3) ?: 0
    println("Resultado3: $resultado3") // Saída: Resultado3: 0
}


/*
RESUMO:
Definição de tipo função: Criamos uma variável soma do tipo (Int, Int) -> Int e a inicializamos com uma lambda que soma dois números.
Invocação: Vimos duas formas de invocar a função: usando parênteses soma(2, 3) e usando invoke explicitamente soma.invoke(4, 5).
Função nulável: Vimos como lidar com funções que podem ser nulas e como invocá-las usando ?.invoke.
*/