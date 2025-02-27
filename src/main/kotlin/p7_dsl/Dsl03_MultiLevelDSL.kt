package com.fugisawa.p7_dsl_multilevel

// MULTI-LEVEL DSL
// Como podemos ter mais "camadas" ou objetos dentro de UserProfile?
// Por exemplo, a pessoa pode ter múltiplos endereços ou contatos. Podemos evoluir para ver como criamos uma estrutura hierárquica (multi-nível).

// Exemplo: Vamos supor que o usuário pode ter diversos endereços classificados por name (por exemplo, "Residencial", "Comercial").

// Classes de Domínio
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

class Address {
    // "name" descreve o tipo de endereço (Residencial, Comercial, etc.)
    var name: String = ""
    var street: String = ""
    var city: String = ""
}

// Builders Internos:
fun userProfile(block: UserProfile.() -> Unit): UserProfile = UserProfile().apply(block)

// Note que agora "address" cria e adiciona um novo Address à lista
fun UserProfile.address(block: Address.() -> Unit) {
    val newAddress = Address().apply(block)
    addresses += newAddress
}

val unparsedAddresses = listOf(
    "Residencial,Main Street,Springfield",
    "Comercial,Downtown Avenue,Metropolis",
)

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

        unparsedAddresses.forEach {
            val (name, street, city) = it.split(",")
            address {
                this.name = name
                this.street = street
                this.city = city
            }
        }
    }

    profile.showInfo()
    // Usuário: Alice, 30 anos
    // Endereços:
    //  - Residencial: Main Street, Springfield
    //  - Comercial: Downtown Avenue, Metropolis
}
