package com.fugisawa.p7_dsl_conflitos

// Sem @DslMarker, podemos ter confusão de "receivers" aninhados, podendo acessar propriedades que não deveriam. 
// Para contornar isso, criamos nossa anotação customizada e a aplicamos nas classes e funções DSL.

// Criar uma meta-anotação e aplicar @DslMarker
@DslMarker
annotation class ProfileDsl

// Classes de Domínio
@ProfileDsl
class UserProfile {
    var name: String = ""
    var age: Int = 0

    // Coleção interna:
    val addresses = mutableListOf<Address>()

    fun showInfo() {
        println("Usuário: $name, $age anos")
        println("Endereços:")
        addresses.forEach {
            println(" - ${it.name}: ${it.street}, ${it.city}")
        }
    }
}
@ProfileDsl
class Address {
    // "name" descreve o tipo de endereço (Residencial, Comercial, etc.)
    var name: String = ""
    var street: String = ""
    var city: String = ""
}

// Builders Internos:
@ProfileDsl
fun userProfile(block: UserProfile.() -> Unit): UserProfile = UserProfile().apply(block)

// Note que agora "address" cria e adiciona um novo Address à lista
@ProfileDsl
fun UserProfile.address(block: Address.() -> Unit) {
    val newAddress = Address().apply(block)
    addresses += newAddress
}

// Exemplo de uso
fun main() {
    val profile = userProfile {
        name = "Alice"
        age = 30

        address {
            name = "Residencial"
            street = "Main Street"
            city = "Springfield"
        }
        address {
            name = "Comercial"
            street = "Downtown Avenue"
            city = "Metropolis"
        }
    }

    profile.showInfo()
    // Usuário: Alice, 30 anos
    // Endereços:
    //  - Residencial: Main Street, Springfield
    //  - Comercial: Downtown Avenue, Metropolis
}

