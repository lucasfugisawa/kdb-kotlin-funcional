package com.fugisawa.p2_funcoes_anonimas

// Função anônima com tipos explícitos
val somar = fun(a: Int, b: Int): Int {
    return a + b
}

// Função anônima com retorno inferido
val subtrair = fun(a: Int, b: Int) = a - b

// Função anônima com tipos de parâmetros inferidos (necessita de contexto)
val multiplicar: (Int, Int) -> Int = fun(a, b) = a * b

// Função anônima que retorna Unit
val imprimirMensagem = fun(mensagem: String) {
    println("Mensagem: $mensagem")
}

fun main() {
    println("Soma: ${somar(5, 7)}") // Saída: Soma: 12

    println("Subtração: ${subtrair(10, 3)}") // Saída: Subtração: 7

    println("Multiplicação: ${multiplicar(4, 6)}") // Saída: Multiplicação: 24

    imprimirMensagem("Olá, mundo!") // Saída: Mensagem: Olá, mundo!
}

/*
Tipos explícitos vs inferidos: Vimos diferentes formas de definir funções anônimas com tipos explícitos e inferidos.
Retorno Unit: Funções que não retornam valor útil retornam Unit.
*/