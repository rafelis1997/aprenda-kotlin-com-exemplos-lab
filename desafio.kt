// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO }

data class Usuario(val nome: String, val idade: Int)

data class ConteudoEducacional(
    val nome: String, 
    var duracao: Int = 60,
) {
   init {
       if (duracao <= 0) {
            this.duracao = 10
       }
   }
}

data class Formacao(val nome: String, val nivel: Nivel, val conteudos: List<ConteudoEducacional>) {

    val inscritos = mutableSetOf<Usuario>()
    
    fun matricular(vararg usuarios: Usuario) {
        for (usuario in usuarios) {
            inscritos.add(usuario)
        }
    }
}

fun main() {
    val react = Formacao(
        "Reactjs", 
        Nivel.INTERMEDIARIO, 
        listOf(
            ConteudoEducacional("HTML", 5),
            ConteudoEducacional("Javascript", 20),
            ConteudoEducacional("React - básico", 20 * 60), // 20 horas
            ConteudoEducacional("React - avançado", 40 * 60), // 40 horas
        )
    )
    
    react.matricular(Usuario("Marcos", 16), Usuario("Roberta", 19), Usuario("José", 48), Usuario("Marcos", 16))
    
    for (inscrito in react.inscritos) {
        println(inscrito)
    }
}
