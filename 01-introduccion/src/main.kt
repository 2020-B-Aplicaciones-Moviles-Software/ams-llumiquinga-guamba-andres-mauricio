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
        .map { it + 15 }
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



    //ANY All -> Condición --> Bollean
    //or <-> and
    //or = any
    // or (falso - todos son falsos es falso)
    // and= all

    val respuestaAny : Boolean = arregloDinamico
            .any{
                valorActualIteracion ->
                return@any  (valorActualIteracion >5)
            }
    println(respuestaAny) // true

    val respuestaAll : Boolean = arregloDinamico
            .all{
                valorActualIteracion ->
                return@all  valorActualIteracion >5
            }
    println(respuestaAll) // false


    //REDUCE
    //1) Devuelve el acumulado
    //2)En que valor empieza
    //0=0+1
    //1=1+2
    //3=3+3
    //6=6+4
    //10=10+5
    //15

    val respuestaFitler: Int = arregloDinamico
            .reduce{ // valor incial 0
                acumulado, valorActualIteracion ->
                return@reduce  acumulado+valorActualIteracion

            }
    println(respuestaFitler)




    val respuestaReduceFold = arregloDinamico
            .fold(
                    100,
                    {
                        acumulado, valorActualIteracion ->
                        return@fold acumulado-valorActualIteracion
                    }
            )
    println(respuestaReduceFold)


    //arregloMutable.fold (empieza desde el principio)
    //arregloMutable.foldRight (empieza desde el final)
    //arregloMutable.reduce (empieza desde el final)
    //arregloMutable.reduceRight (empeiza desde el final)

    //OPERADORES
    // forEach -> Unit (void)
    // map -> Arreglo
    // filter -> Arreglo
    // all-> Booleano
    // any -> Booleano
    // reduce ->valor
    // fold ->Valor


    val vidaActual: Double = arregloDinamico
            .map{it * 2.3}//arreglo
            .filter { it > 20 }//arreglo
            .fold(100.00, {acc, i -> acc -i})//valor
            .also{ println(it) } //ejeccutar codigo extra
    println("Valor vida actual ${vidaActual}")


    val ejemploUno = Suma(1,2)
    val ejemploDos = Suma(null,2)
    val ejemploTres = Suma (1,null)
    val ejemploCuatro = Suma (null,null)

    println(ejemploUno.sumar())
    println(Suma.historialSumas)
    println(ejemploDos.sumar())
    println(Suma.historialSumas)
    println(ejemploTres.sumar())
    println(Suma.historialSumas)
    println(ejemploCuatro.sumar())
    println(Suma.historialSumas)

}//FIND EL MAIN

abstract class NumerosJav{
    protected val numeroUno:Int
    private val numeroDos:Int
    constructor(//constructor primario
        uno:Int,
        dos: Int
    ){//Bloque  de codigo del constructor primario
        //this.numeroUno
        numeroUno = uno
        //this.numeroDos
        numeroDos= dos
    }
}

abstract class Numeros(  //Constructor Primario
    protected var numeroUno:Int,
    protected var numeroDos:Int
){
    init { //BLOQUE de costructor prmario
        println("Hola")
    }
}

class Suma(
    uno: Int,  //Parametros
    dos: Int   //parametros
):Numeros(uno,dos){
    init {
        //this.numeroDos
        //this.numeroUno
        //X-> this.uno ->NO EXISTE
        //X-> this.dos ->NO EXISTE
    }

    constructor(//Segundo Constructor
            uno: Int?, //parametros
            dos: Int //parametros
    ): this ( //llamada constructor primario
            if(uno==null)0 else uno,
            dos
    ){

    }

    constructor(//Tercer Constructor
            uno: Int, //parametros
            dos: Int? //parametros
    ): this ( //llamada constructor primario
            uno,
            if(dos==null)0 else dos
    ){

    }

    constructor(//Cuarto Constructor
            uno: Int?, //parametros
            dos: Int? //parametros
    ): this ( //llamada constructor primario
            if(uno==null)0 else dos,
            if(dos==null)0 else dos
    ){

    }

    public fun sumar():Int{
        val total:Int = numeroUno+ numeroDos
        Suma.agregarHistorial(total)
        return total
    }

    //SINGLETON
    companion object{//Metodos y Propeidades
        val historialSumas = arrayListOf<Int>()
        fun agregarHistorial(nuevaSuma: Int){
            this.historialSumas.add(nuevaSuma)
        }

    }

}




fun imprimirNombre(nombre:String) {
    println("nombre ${nombre}")  //Tempalte

}

fun calcularSueldo(
    sueldo : Double, //requerido
    tasa:Double=12.00, //Opcionales
    calculoEspecial: Int?=null
        //Variables que peuden ser Null
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

class BaseDeDatos(){
    companion object{
        val datos = arrayListOf<Int>()
    }
}

//BaseDeDatos.datos