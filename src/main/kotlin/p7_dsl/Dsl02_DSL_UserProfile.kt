package com.fugisawa.p7_dsl_user_profile

// CLASSE UserProfile SEM DSL
data class UserProfile(
    var name: String = "",
    var age: Int = 0,
    var address: Address? = null,
) {
    fun showInfo() {
        println("Usuário: $name, $age anos")
        address?.let {
            println("Endereço: ${it.street}, ${it.city}")
        }
    }
}

data class Address(
    var street: String = "",
    var city: String = "",
)

fun main4() {
    // Sem DSL: setamos as propriedades manualmente após a criação do objeto:
    val profile = UserProfile()
    profile.name = "Alice"
    profile.age = 30
    profile.address = Address()
    profile.address?.street = "Main Street"
    profile.address?.city = "Springfield"

    profile.showInfo()

    // ou na construção:
    val profile2 = UserProfile(
        name = "Bob",
        age = 25,
        address = Address(
            street = "Second Street",
            city = "London",
        ),
    )
}

// CRIANDO UM BUILDER USANDO LAMBDAS COM RECEIVER
// Podemos criar uma função que recebe uma lambda com receiver do tipo UserProfile.
fun userProfile(config: UserProfile.() -> Unit): UserProfile {
    val profile = UserProfile()
    profile.config()
    return profile
}

// Agora, vamos criar também uma função de extensão para montar Address dentro de UserProfile
fun UserProfile.address(block: Address.() -> Unit) {
    val endereco = Address()
    endereco.block()
    this.address = endereco
}

// Exemplo de uso
fun main5() {
    val profile = userProfile {
        name = "Alice"
        age = 30
        address {
            street = "Main Street"
            city = "Springfield"
        }
    }

    profile.showInfo()
    // Usuário: Alice, 30 anos
    // Endereço: Main Street, Springfield
}

// REFATORANDO COM apply
// Podemos reusar 'apply', que basicamente chama o bloco de configuração com receiver e retorna o objeto.

fun userProfileComApply(config: UserProfile.() -> Unit): UserProfile = UserProfile().apply(config)

fun UserProfile.addressApply(block: Address.() -> Unit) {
    address = Address().apply(block)
}

fun main6() {
    val profile = userProfileComApply {
        name = "Bob"
        age = 40
        addressApply {
            street = "High Street"
            city = "Greenfield"
        }
    }

    profile.showInfo()
}
