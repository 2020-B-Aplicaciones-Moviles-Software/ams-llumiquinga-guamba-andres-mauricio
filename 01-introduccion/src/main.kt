import java.util.*
import kotlin.collections.ArrayList

fun main(){ //incio dle MAIN
    println("Hola mundo")

    //JAVa Int edad =12;
    var edadProfesor = 31

    var sueldoPro = 12.42

    //MUTABLES
    var edadCachoro: Int = 0
    edadCachoro = 1
    edadCachoro = 2
    edadCachoro = 3
    //INMUTABLES no cambian -- Siempre inmutables
    val numeCedula = 2334444


        //TIPOS DE VARIABLES
    val nombProfesor: String = "andy"
    val sueldo: Double = 2.2
    val estadoCivil: Char = 'S'
    val fechaNaciemiento : Date = Date()

    //condicionales
    if(true){
        //Verdadera
    }else{
        //Falsas
    }

    //no existe switch pero existe when
    when(sueldo){
        12.2->{//Iinicio del bloque
            println("Sueldo normal")
        }//Fin del bloque
        -12.2-> println("sueldo engativo")
        else -> println("Sueldo no reconocido")
    }
    val sueldoMayorEstablecido: Int = if (sueldo>12.2) 500 else 0

    imprimirNombre(nombre = "Adrian")

    calcularSueldo(100.00)

    calcularSueldo(100.00, 14.00)

    calcularSueldo(100.00,12.00,3)

    //ARREGLO STATICO
    val arregloEstatico: Array<Int> = arrayOf(1,2,3)

    //ARREGLO DINAMICO
    val arregloDinamico: ArrayList<Int> = arrayListOf(1,2,3,4,5)
    println(arregloDinamico)
    arregloDinamico.add(11)
    arregloDinamico.add(12)
    println(arregloDinamico)



    //OPERADORES sirevn para los arreglos dinamicos y estaticos
    arregloDinamico.forEach{}
    arregloEstatico.forEach {  }

    //FOREACH
    //Iterar un arreglo
    val respuestaForEach: Unit = arregloDinamico
        .forEach { valorActualIteracion ->
            println("Valor ${valorActualIteracion}")

    }
    println(respuestaForEach)
    arregloDinamico
        .forEachIndexed{indice, valorActualIteracion ->
            println("Valor ${valorActualIteracion} Indice: ${indice}")
            }


    //MAp-> mutal el arreglo y regresa otro arreglo

    val respuestaMap: List<Int> = arregloDinamico
        .map {
            valorActualIteracion ->
            //Calculo1
            //Calculo 2
            return@map valorActualIteracion*10
        }
    println(respuestaMap)



    val respuestaMap2: List<Int> = arregloDinamico
        // .map{i->i+15}
        .map { it-> +15 }
    println(respuestaMap2)



    //FILTER ->Filtrar el arreglo
    // Operador de Filtros

    val respuestaFilter: List<Int> = arregloDinamico
        .filter {
                valorActualIteracion ->
            val mayoresACinco: Boolean = valorActualIteracion > 5
            return@filter mayoresACinco
        }
    println(respuestaFilter)

}//FIND EL MAIN


fun imprimirNombre(nombre:String) {
    println("nombre ${nombre}")  //Tempalte

}

fun calcularSueldo(
    sueldo:Double, //requerido
    tasa: Double=12.00, //Opcionales
    calculoEspecial: Int?=null //Variables que peuden ser Null
): Double{
    //String ->String?
    //Int -> int?
    //Date ->Date?
    if(calculoEspecial == null){
        return sueldo * (100/tasa)
    }else{
        return sueldo * (100/tasa)*calculoEspecial
    }

}