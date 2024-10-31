package com.fugisawa.p1_function_types

fun fazerAlgoComNome(nome: String, limite: Int): String {
    return "teste"
}

// Usando tipos função como parâmetros de função
fun calcular(a: Int, b: Int, operacao: (Int, Int) -> Int): Int {
    return operacao(a, b)
}

// Função de subtração
val subtrair = { x: Int, y: Int -> x - y }

// Usando tipos função como propriedades
class Calculadora {
    var operacao: (Int, Int) -> Int = { _, _ -> 0 }
}

// Usando named parameters em tipos função
val dividir: (dividendo: Int, divisor: Int) -> Int = { dividendo, divisor ->
    dividendo / divisor
}

// Comparação sem named parameters
val dividirSemNomes: (Int, Int) -> Int = { a, b -> a / b }

// Reutilizando a função 'soma' do exemplo anterior
// val soma: (Int, Int) -> Int = { a, b -> a + b }

fun main() {
    val resultado = calcular(10, 5, subtrair)
    println("Resultado: $resultado") // Saída: Resultado: 5

    val resultado2 = calcular(10, 5, dividir)

    val calc = Calculadora()
    calc.operacao = soma
    println("Operação Soma: ${calc.operacao(3, 7)}") // Saída: Operação Soma: 10

    println("Divisão: ${dividir(10, 2)}") // Saída: Divisão: 5

    println("Divisão: ${dividirSemNomes(10, 2)}") // Saída: Divisão: 5
}

/*
RESUMO:
Parâmetros de função: A função calcular recebe uma operação como parâmetro, mostrando como passar funções como argumentos.
Propriedades de classe: Em Calculadora, operacao é uma propriedade que pode ser atribuída a diferentes funções.
Named parameters: Usar nomes nos parâmetros melhora a legibilidade e evita erros ao passar argumentos.
*/