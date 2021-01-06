import java.io.*
import kotlin.collections.ArrayList

fun main(args: Array<String>){
    var entrenador = Entrenador()
    var mascota = Mascota()
    println("CRUD con Archivos")
    while (true){
        opciones()
        println("Escoja una opcion: ")
        var opcion = readLine()!!.toInt()
        if(opcion == 1){
            entrenador.crear_entrenador()
            println("La mascosta ya existe?: (1) Si o (2)No")
            var existe = readLine()!!.toInt()
            if (existe==2){
                mascota.crear_mascota()

            }else{
                println("Guardado")
            }


        }else if (opcion == 2){
            entrenador.leer_entrenador()



        }else if (opcion == 3){
            entrenador.editar_entrenador()

        }else if (opcion == 4){
            entrenador.eliminar_entrenador()

        }else if (opcion == 5){
            mascota.crear_mascota()

        }else if (opcion == 6){
            mascota.leer_mascota()

        }else if (opcion == 7){
            mascota.editar_mascota()


        }else if (opcion == 8){
            mascota.eliminar_mascota()

        }else if (opcion == 9){
            break

        }else{
            println("Opcion no valida, pulse una tecla ")
            var c = readLine()!!.toString()

        }

    }



}
fun opciones(){
    println("OPCIONES")
    println("******************************************")
    println("ENTRENADOR")
    println("1: Insertar\n2: Leer\n3: Actualizar\n4: Eliminar")
    println("******************************************")
    println("MASCOTA")
    println("5: Insertar\n6: Leer\n7: Actualizar\n8: Eliminar")
    println("**************************************************")
    println("9: Salir")

}

class Entrenador{
    var id_entrenador: Int =0
    var nombre: String =""
    var costo: Double =0.0
    var titulado: Boolean = false
    var idEstudiante: Int = 0

    fun crear_entrenador(){
        val path = "./src/Entrenador.txt"
        println("ID")
        var id_entrenador = readLine()!!.toInt().toString()
        println("Nombre")
        var nombre = readLine()!!.toString()
        println("Costo por mascota")
        var costo = readLine()!!.toDouble().toString()
        println("Titulado(true/false)")
        var titulado = readLine()!!.toBoolean().toString()
        println("Id del tipo de mascota")
        var idEstudiante = readLine()!!.toInt().toString()
        try{
            val file_writer = FileWriter(path, true)
            file_writer.write("$id_entrenador:$nombre:$costo:$titulado:$idEstudiante")
            println("Entrenador guardado")
            file_writer.close()


        }catch (ex: Exception){
            println("Error al crear"+ex)
        }
    }


    fun leer_entrenador(){
        val path = "./src/Entrenador.txt"
        println("Estructura: ")
        println("id:Nombre:Costo:Titulado:Id tipo de mascota")
        var array_entrenadores = ArrayList<String>()
        File(path).useLines { lines -> lines.forEach { array_entrenadores.add(it) } }
        array_entrenadores.forEach { println(">"+it) }
    }
    fun editar_entrenador(){
        val path = "./src/Entrenador.txt"
        println("Ingrese el indice del entrenador: ")
        var indice=readLine()!!.toString()
        println("Asi se ve: "+indice)
        var array_entrenador = ArrayList<String>()
        File(path).forEachLine { line -> array_entrenador.add(line)}
        var indiceEditar = array_entrenador.indexOfFirst{ line->line.split(":")[0]== indice }

        println(indiceEditar)
        if (indiceEditar > -1){
            println("Nuevo ID")
            var id_entrenador = readLine()!!.toInt().toString()
            println("Nuevo Nombre")
            var nombre = readLine()!!.toString()
            println("Nuevo costo")
            var costo = readLine()!!.toDouble().toString()
            println("Nueva Titulado(true/false)")
            var titulado = readLine()!!.toBoolean().toString()
            println("Nueva Ciudad")
            var idEstudiante = readLine()!!.toInt().toString()
            array_entrenador[indiceEditar] = "$id_entrenador:$nombre:$costo:$titulado:$idEstudiante"


        }else{
            println("No se encontro el Indice")

        }
        try {
            val file_writer = FileWriter(path,true)
            File(path).writeText("")
            array_entrenador.forEach { file_writer.write(it+"\n") }
            println("Entrenador Editado.")
            file_writer.close()

        }catch (ex: Exception){
            println("No se pudo Editar el Pais.")

        }

    }
    fun eliminar_entrenador(){
        val path = "./src/Entrenador.txt"
        println("Ingrese el indice del entrenador: ")
        var indice=readLine()!!.toString()
        //println("Asi se ve: "+indice)
        var array_entrenador = ArrayList<String>()
        File(path).forEachLine { line -> array_entrenador.add(line)}
        var indice_borrar = array_entrenador.indexOfFirst{ line->line.split(":")[0]== indice}
        var aux:Int = indice_borrar
        var indice_borrarEstudiante = array_entrenador[aux].split(":")
        var indEstudianteborrar:Int=indice_borrarEstudiante[4].toInt()
        eliminarmascotaligada(indEstudianteborrar)
        if(indice_borrar>-1){
            array_entrenador.removeAt(indice_borrar)



        }else{
            println("No se encontro el Entrenador")
        }
        try {
            val file_writer = FileWriter(path, true)
            File(path).writeText("")
            array_entrenador.forEach { file_writer.write(it+"\n") }
            println("Se elimino el entrenador con el "+ indice)
            file_writer.close()
        }catch (ex: Exception){
            println("No se pudo eliminar")
        }
    }


    fun eliminarmascotaligada(indiceEliminar:Int){
        val path = "./src/Mascota.txt"
        var indice=indiceEliminar.toString()
        var array_mascota = ArrayList<String>()
        File(path).forEachLine { line -> array_mascota.add(line)}
        var indice_borrar = array_mascota.indexOfFirst{ line->line.split(":")[0]== indice }
        if(indice_borrar>-1){
            array_mascota.removeAt(indice_borrar)

        }else{
            println("No se encontro la amscota")
        }
        try {
            val file_writer = FileWriter(path, true)
            File(path).writeText("")
            array_mascota.forEach { file_writer.write(it+"\n") }
            println("Se elimino: "+ indice)
            file_writer.close()
        }catch (ex: Exception){
            println("No se pudo eliminar")
        }
    }

}
class Mascota{
    var id_mascota: Int =0
    var nombre_mascota: String =""
    var horasDeCurso: Double =0.0
    var vacunado: Boolean = false
    var apodo: String = ""

    fun crear_mascota(){
        val path = "./src/Mascota.txt"
        println("ID: ")
        var id_mascota = readLine()!!.toInt().toString()
        println("Nombre: ")
        var nombre_mascota = readLine()!!.toString()
        println("Horas a tomar: ")
        var horasDeCurso = readLine()!!.toDouble().toString()
        println("Vacunado(true/false): ")
        var vacunado = readLine()!!.toBoolean().toString()
        println("Apodo de la mascota: ")
        var apodo = readLine()!!.toString()
        try{
            val file_mascota = FileWriter(path, true)
            file_mascota.write("$id_mascota:$nombre_mascota:$horasDeCurso:$vacunado:$apodo")
            println("Mascota guardada")
            file_mascota.close()


        }catch (ex: Exception){
            println("Error al crear"+ex)
        }

    }


    fun leer_mascota(){
        val path = "./src/Mascota.txt"
        //var salida = ""
        println("Formato: ")
        println("ID:Nombre:Horas:Vacunado:Apodo")
        var array_mascota = ArrayList<String>()
        File(path).useLines { lines -> lines.forEach { array_mascota.add(it) } }
        array_mascota.forEach { println(">"+it) }

    }
    fun editar_mascota(){
        val path = "./src/Mascota.txt"
        println("Ingrese el indice de la mascota: ")
        var indice=readLine()!!.toString()
        //println("Asi se ve: "+indice)
        var array_mascota = ArrayList<String>()
        File(path).forEachLine { line -> array_mascota.add(line)}
        var indiceEditar = array_mascota.indexOfFirst{ line->line.split(":")[0]== indice }

        if (indiceEditar > -1){
            println("Nuevo ID: ")
            var id_mascota = readLine()!!.toInt().toString()
            println("Nuevo Nombre: ")
            var nombre_mascota = readLine()!!.toString()
            println("Horas del curso: ")
            var horasDeCurso = readLine()!!.toDouble().toString()
            println("Nuevo Vacunado(true/false): ")
            var vacunado = readLine()!!.toBoolean().toString()
            println("Nuevo Apoddo de mascota: ")
            var apodo = readLine()!!.toString()
            array_mascota[indiceEditar] = "$id_mascota:$nombre_mascota:$horasDeCurso:$vacunado:$apodo"


        }else{
            println("No se encontro el indice")

        }
        try {
            val file_mascota = FileWriter(path,true)
            File(path).writeText("")
            array_mascota.forEach { file_mascota.write(it+"\n") }
            println("Mascota Editado.")
            file_mascota.close()

        }catch (ex: Exception){
            println("No se pudo Editar el Pais.")

        }

    }
    fun eliminar_mascota(){
        val path = "./src/Mascota.txt"
        println("Ingrese el indice de la mascota: ")
        var indice=readLine()!!.toString()
        //println("Asi se ve: "+indice)
        var array_mascota = ArrayList<String>()
        File(path).forEachLine { line -> array_mascota.add(line)}
        var indice_borrar = array_mascota.indexOfFirst{ line->line.split(":")[0]== indice }
        if(indice_borrar>-1){
            array_mascota.removeAt(indice_borrar)

        }else{
            println("No se encontro la mascota")
        }
        try {
            val file_writer = FileWriter(path, true)
            File(path).writeText("")
            array_mascota.forEach { file_writer.write(it+"\n") }
            println("Se elimino: "+ indice)
            file_writer.close()
        }catch (ex: Exception){
            println("No se pudo eliminar")
        }
    }




}