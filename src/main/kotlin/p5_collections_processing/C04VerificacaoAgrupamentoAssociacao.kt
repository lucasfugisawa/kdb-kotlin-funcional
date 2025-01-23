package com.fugisawa.p5_collections_processing

data class Transaction(
    val id: Int,
    val description: String,
    val category: String,
    val amount: Double,
    val isExpense: Boolean,
    val priority: Int?,
)

fun main() {
    val students = listOf(
        Student("Alice", 2, 8.5, true),
        Student("Bob", 23, 6.0, false),
        Student("Charlie", 22, 9.0, true),
        Student("Diana", 95, 7.0, true)
    )

    // any, all, none -> verificação de predicados na coleção
    println("Tem algum aluno ativo? ${students.any { it.active }}")
    println("Todos são ativos? ${students.all { it.active }}")
    println("Nenhum tem nota abaixo de 5? ${students.none { it.grade < 5 }}")

    // partition -> divide a lista em dois grupos com base em um predicado (atende / não atende)
    val (active, inactive) = students.partition { it.active }
    println("\nAtivos: ${active.map { it.name }}, Inativos: ${inactive.map { it.name }}")

    // groupBy -> agrupa elementos em um Map<Chave, List<Elemento>>
    val groupedByActive = students.groupBy { it.active }
    println("\nAgrupado por ativo: $groupedByActive")

    val groupedByAgeRange = students.groupBy { student ->
        when (student.age) {
            in 0..12 -> "Infantil"
            in 13..17 -> "Juvenil"
            in 18..65 -> "Adulto"
            else -> "Idoso"
        }
    }

    // groupingBy -> permite operações mais complexas
    val groupingByAge = students.groupingBy { it.age }
    val countByAge = groupingByAge.eachCount() // conta quantos por idade
    println("\nQuantos estudantes por idade: $countByAge")

    val transactions = listOf(
        Transaction(1, "Padaria", "Alimentação", 25.50, true, null),
        Transaction(2, "Supermercado", "Alimentação", 220.90, true, null),
        Transaction(3, "Conta de Luz", "Moradia", 120.00, true, null),
        Transaction(4, "Conta de Água", "Moradia", 80.70, true, null),
        Transaction(5, "Salário", "Receita", 3500.00, false, null),
        Transaction(6, "Freelance", "Receita", 800.00, false, null),
        Transaction(7, "Gasolina", "Transporte", 60.00, true, null),
        Transaction(8, "Uber", "Transporte", 25.00, true, null),
        Transaction(9, "Subsídio", "Receita", 350.00, false, null),
    )

    // Média de gastos (expenses) por categoria de despesa:
    val averageExpenseByCategory = transactions
        .filter { it.isExpense }
        .groupingBy { it.category }
        .aggregate { _, accumulator: Pair<Double, Int>?, transaction, _ ->
            // accumulator é Pair(soma, qtd)
            val (soma, qtd) = accumulator ?: (0.0 to 0)
            (soma + transaction.amount) to (qtd + 1)
        }
        .mapValues { (_, pair) -> // converte Pair(soma, qtd) em média
            val (soma, qtd) = pair
            soma / qtd
        }

    println("\nMédia de gastos por categoria (groupingBy + aggregate):")
    averageExpenseByCategory.forEach { (cat, avg) ->
        println("  $cat => %.2f".format(avg))
    }

    // associate -> retorna um Map<K, V> a partir dos elementos
    // O lambda deve retornar um Pair<Chave, Valor>
    val studentMapByName = students.associate { student ->
        student.name to student.grade
    }
    println("\nMapeando nomes para nota: $studentMapByName")

    // associateWith -> Chave = elemento, Valor = resultado do lambda
    val studentAssociatedWithActive = students.associateWith { it.active }
    println("student -> ativo? $studentAssociatedWithActive")

    // associateBy -> Chave = resultado do lambda, Valor = elemento
    val studentAssociatedByName = students.associateBy { it.name }
    println("nome -> estudante: $studentAssociatedByName")
}
