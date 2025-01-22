package com.fugisawa.p3_lambda_expressions

// Lambda simples com parâmetro nomeado
val saudacao: (String) -> Unit = { nome ->
    println("Olá, $nome!")
}

// Lambda com parâmetro implícito 'it'
val imprimirEmMaiusculas: (String) -> Unit = {
    println(it.uppercase())
}

// Lambda com desestruturação nos parâmetros
val imprimirPessoa = { (nome, sobrenome): Pair<String, Int> ->
    println("Nome: ${nome}, Idade: ${sobrenome}")
}

// Trailing lambda
fun processarNumeros(numeros: List<Int>, operacao: (Int) -> Int) {
    for (numero in numeros) {
        println(operacao(numero))
    }
}

// Closure: lambda modificando variável do escopo externo
fun main() {

    val meuPar = Pair("Lucas", "Fugisawa")

    val (nome, sobrenome) = meuPar

    println(nome)
    println(sobrenome)


    saudacao("Maria") // Saída: Olá, Maria!

    imprimirEmMaiusculas("kotlin") // Saída: KOTLIN

    imprimirPessoa(Pair("João", 30)) // Saída: Nome: João, Idade: 30

    val numerosAProcessar = listOf(1, 2, 3)
    processarNumeros(numerosAProcessar) duplicador@{
        if (it == 0) {
            return@duplicador - 1
        }
        it * 2
    }

    processarNumeros(listOf(1, 2, 3)) { numero ->
        numero * 2
    }
    // Saída:
    // 2
    // 4
    // 6

    var contador = 0
    val incrementarContador = {
        contador++
    }

    incrementarContador()
    incrementarContador()
    println("Contador: $contador") // Saída: Contador: 2
}

/*
RESUMO:
Parâmetro implícito 'it': Útil quando a lambda tem um único parâmetro.
Desestruturação: Permite extrair componentes de um objeto diretamente nos parâmetros.
Trailing lambda: Sintaxe que move a lambda para fora dos parênteses, melhorando a legibilidade.
Closures: Lambdas podem acessar e modificar variáveis definidas no escopo externo.
*/