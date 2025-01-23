package com.fugisawa.p5_collections_processing

fun main() {
    // Lista com nomes repetidos para fins de exemplo
    val names = listOf("Alice", "Bob", "Alice", "Diana", "Bob", "Charlie")

    // distinct -> retorna valores únicos
    println("distinct: ${names.distinct()}")

    // distinctBy -> filtra elementos distintos baseados em um critério
    // Exemplo: manter apenas um nome por sua primeira letra
    val distinctByFirstChar = names.distinctBy { it.first() }
    println("distinctBy (primeira letra): $distinctByFirstChar")

    val students = listOf(
        Student("Alice", 21, 8.5, true),
        Student("Bob", 23, 6.0, false),
        Student("Charlie", 22, 9.0, true),
        Student("Diana", 20, 7.0, true)
    )

    // sorted -> ordena no modo natural (para números)
    // sortedBy -> ordena de acordo com um critério
    val sortedByName = students.sortedBy { it.active }
    println("\nOrdenado pelo nome (sortedBy): ${sortedByName.map { it.name }}")

    // sortedWith -> recebe um Comparator (ordenações mais complexas)
    val sortedByGradeDesc = students.sortedWith(compareByDescending { it.grade })
    println("Ordenado pela nota desc (sortedWith): ${sortedByGradeDesc.map { it.name to it.grade }}")

    val transactions = listOf(
        Transaction(1, "Supermercado", "Alimentação", 200.0, true, 2),
        Transaction(2, "Salário", "Receita", 3500.0, false, null),
        Transaction(3, "Cinema", "Lazer", 45.0, true, 3),
        Transaction(4, "Freelance", "Receita", 800.0, false, 1),
        Transaction(5, "Presente", "Lazer", 100.0, true, null),
        Transaction(6, "Gasolina", "Transporte", 60.0, true, 2),
        Transaction(7, "Uber", "Transporte", 25.0, true, 1),
        Transaction(8, "Extra Pagar", "Moradia", 50.0, true, 3)
    )

    // Ordenar por isExpense desc, depois por categoria, depois por prioridade com nulos por último, e então por amount:
    val sortedList = transactions.sortedWith (
        compareByDescending<Transaction> { it.isExpense }
            .thenBy { it.category }
            .then(compareBy(nullsLast()) { it.priority })
            .thenBy { it.amount }
    )
    sortedList.forEach { println(it) }

    // Em coleções mutáveis, há também a função sort
    val mutableAges = mutableListOf(30, 20, 25, 22)
    mutableAges.sort() // altera a lista diretamente
    println("\nMutableList após sort: $mutableAges")

    // shuffled -> cria uma nova lista embaralhada
    val shuffledStudents = students.shuffled()
    println("Lista embaralhada de estudantes: ${shuffledStudents.map { it.name }}")

    // zip -> combina duas listas em pares
    val listA = listOf(1, 2, 3)
    val listB = listOf("A", "B", "C", "Extra")
    val zipped = listA zip listB
    println("\nzip: $zipped")  // tamanho = min(listA, listB)

    // zipWithNext -> combina cada elemento com o próximo
    val numbers = listOf(10, 20, 30, 40)
    val next = numbers.zipWithNext()
    println("zipWithNext: $next")

    // windowed -> cria "janelas" de tamanho fixo, podendo avançar de N em N
    val windowedResult = numbers.windowed(size = 2, step = 1, partialWindows = false)
    println("windowed(2, step=1): $windowedResult")

    // chunked -> divide a lista em pedaços (chunks) do tamanho informado
    val chunkedResult = (1..10).toList().chunked(3)
    println("chunked(3): $chunkedResult")
}
