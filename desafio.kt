// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

class Usuario(val nome: String, var formacao: Formacao? = null)

data class ConteudoEducacional(var nome: String, val duracao: Int = 60)

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuario>()
    
    fun matricular(usuario: Usuario) {
        usuario.formacao = this
        inscritos.add(usuario)
        //println("${usuario.nome} foi matriculado na formação $nome.")
                
    }
    
    fun listarInscritos() {
        println("Usuários matriculados na formação $nome:")
        inscritos.forEach { println("${it.nome} - ${it.formacao?.nome ?: "Não matriculado"}") }
    }   
}

fun main() {
    // Criar alguns conteúdos educacionais
    val kotlinIntroducao = ConteudoEducacional("Introdução ao Kotlin", 60)
    val kotlinEstruturas = ConteudoEducacional("Estruturas de Controle em Kotlin", 90)
    val kotlinFuncoes    = ConteudoEducacional("Funções em Kotlin", 75)

    // Criar uma formação
    val formacaoKotlin = Formacao("Kotlin Básico",
                                  listOf(
                                      kotlinIntroducao,
                                      kotlinEstruturas,
                                      kotlinFuncoes)
                                 )

    // Criar alguns usuários
    val usuario1 = Usuario("João")
    val usuario2 = Usuario("Maria")
    val usuario3 = Usuario("Bia")

    // Matricular os usuários na formação
    formacaoKotlin.matricular(usuario1)
    formacaoKotlin.matricular(usuario2)
    formacaoKotlin.matricular(usuario3)
    
    //formacaoKotlin.listarInscritos()
    // Verificar os inscritos na formação
    formacaoKotlin.listarInscritos()

}