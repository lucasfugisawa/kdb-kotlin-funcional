package com.fugisawa.p7_dsl_conceitos

// É uma forma de escrever código com uma "linguagem" própria para resolver problemas de um domínio específico.
//
// Em Kotlin, DSLs type-safe (com segurança de tipos em tempo de compilação) fazem uso de:
// - Extension Functions (funções de extensão)
// - Function Types with Receiver (tipos de função que agem como extensões)
// - Lambdas com receiver (possibilidade de chamar this implicitamente dentro da lambda)
// - E a anotação @DslMarker para organizar e aumentar a segurança da nossa "mini-linguagem"
//
// Benefícios:
// legibilidade e fluidez: escrever estruturas que parecem gramáticas específicas
// sugestões (autocomplete) mais contextualizadas em tempo de desenvolvimento
// códigos mais curtos, expressivos e menos suscetíveis a erros


// EXTENSION FUNCTIONS (Funções de Extensão)
// - Podemos adicionar novas funções a classes existentes (String, Int, classes próprias, etc.)
// - Não precisamos herdar ou modificar o código original da classe.

fun String.circundaComParenteses(): String {
    // 'this' representa o objeto String que chamou a função
    return "($this)"
}

fun main1() {
    val texto: String = "Kotlin"
    println(texto.circundaComParenteses()) // Saída: (Kotlin)
}

// FUNÇÕES ANÔNIMAS e FUNÇÕES DE EXTENSÃO ANÔNIMAS
// Assim como funções podem ser anônimas (atribuídas a variáveis val), extension functions também podem ser anônimas e atribuídas a variáveis.

// Exemplo de função anônima normal (sem receiver)
var minhaFuncaoAnonima = fun(x: Int, y: Int): Int {
    return x + y
}

// Exemplo de extension function anônima
// fun String.prefixarHello() = "Hello $this"  (função nomeada de extensão)
// Abaixo, a mesma ideia, porém anônima e atribuída a 'val':

val prefixarHello = fun String.(): String {
    return "Hello $this"
}

fun main2() {
    val soma = minhaFuncaoAnonima(2, 3) // 5
    println(soma)

    // Usando a extension function anônima
    println(
        "Mark".prefixarHello()
    )

     println(
         prefixarHello.invoke("Bob")
     )

    println(
        prefixarHello("Alice")
    )
}

// TIPOS FUNÇÃO COM RECEIVER / LAMBDAS COM RECEIVER
// Um "tipo função com receiver" é um tipo que representa uma função de extensão.
// Ex: Int.(String) -> String significa "uma extensão de Int, que recebe um String e retorna um String".

fun main3() {
    // uma variável do tipo "Função de extensão"
    val formatarValorMonetario: Int.(String) -> String = { moeda ->
        // 'this' aqui é um Int (o 'receiver')
        // 'moeda' é o parâmetro String passado
        "$this $moeda"
    }

    // Podemos chamar de três formas equivalentes:
    println(formatarValorMonetario(10, "BRL")) // 10 BRL
    println(formatarValorMonetario.invoke(20, "USD")) // 20 USD
    println(30.formatarValorMonetario("EUR")) // 30 EUR
}
