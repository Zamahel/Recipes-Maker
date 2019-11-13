fun main(args: Array<String>) {

      exit@ while (true) {

        val mensajeInicial = """
        :: Bienvenido a Recipe Maker::
        
        Seleccione la opcion deseada
        1. Hacer una receta
        2. Ver mis recetas
        3. Salir
    """.trimIndent()

        println(mensajeInicial)


        try {
            val response = readLine()?.toInt()?:0
            if (response==4){
                println("Por favor elija una opcion")
                continue@exit
            }

            if (response==1){
                println("${viewRecipe(titulo0 = "Bienvenido")}")
                val nombre_receta:String?= readLine()?.toString()?:"Mi Receta"
                println("${viewRecipe(titulo1 = "Hola, Estas viendo tus Ingredientes ")}")
                for ((index,ingredient) in "${makeRecipe()}".withIndex()){
                    println("${index+1}.-${ingredient}")
                }
                println("\n 0.-Guardar receta\n -1.-Salir ")
                var receta_nueva:String = nombre_receta + ": "
                val desarrolloReseta: String = """
                    Aqui escribe el desarrollo de tu receta
                """.trimIndent()
                println(desarrolloReseta.trimIndent())

            }

            if (response==2) {
                println("${viewRecipe(titulo1 = "Hola, Estas viendo tus Ingredientes en Vertical" )}")
                println("Estos son los ingredientes disponibles:\n ${makeRecipe()} ")
                continue@exit
            }

            if (response==3){
                break@exit
            }



        } catch (e: NumberFormatException) {
            println("Ingresa un valor del 1 al tres")
        }
    }
}

fun makeRecipe(ingrediente1: String ="1.Aguacate", ingrediente2: String ="2.Leche",ingrediente3: String ="3.Huevos",
               ingrediente4: String ="4.Frutas", ingrediente5: String ="5.Chorizo"): String {

    return "${ingrediente1} \n ${ingrediente2} \n ${ingrediente3} \n ${ingrediente4} \n ${ingrediente5} "
}

fun viewRecipe(titulo0: String="Bienveidos" , titulo1: String="Hola, Estas viendo tus Ingredientes",
titulo2: String="Ve tu receta", titulo3: String="Salr"): String{
    return "${titulo0} ${titulo1} ${titulo2} ${titulo3} "
}