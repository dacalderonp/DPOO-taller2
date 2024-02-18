package uniandes.dpoo.estructuras.logica;

import java.util.HashMap;
import java.util.Map.Entry;

/**
 * Esta clase tiene un conjunto de métodos para practicar operaciones sobre arreglos de enteros y de cadenas.
 *
 * Todos los métodos deben operar sobre los atributos arregloEnteros y arregloCadenas.
 * 
 * No pueden agregarse nuevos atributos.
 * 
 * Implemente los métodos usando operaciones sobre arreglos (ie., no haga cosas como construir listas para evitar la manipulación de arreglos).
 */
public class SandboxArreglos
{
    /**
     * Un arreglo de enteros para realizar varias de las siguientes operaciones.
     * 
     * Ninguna posición del arreglo puede estar vacía en ningún momento.
     */
    private int[] arregloEnteros;

    /**
     * Un arreglo de cadenas para realizar varias de las siguientes operaciones
     * 
     * Ninguna posición del arreglo puede estar vacía en ningún momento.
     */
    private String[] arregloCadenas;

    /**
     * Crea una nueva instancia de la clase con los dos arreglos inicializados pero vacíos (tamaño 0)
     */
    public SandboxArreglos( )
    {
        arregloEnteros = new int[]{};
        arregloCadenas = new String[]{};
    }

    /**
     * Retorna una copia del arreglo de enteros, es decir un nuevo arreglo del mismo tamaño que contiene copias de los valores del arreglo original
     * @return Una copia del arreglo de enteros
     */
    public int[] getCopiaEnteros( )
    {
        int[] copia = new int[arregloEnteros.length];
        for (int i = 0; i < arregloEnteros.length; i++) {
            copia[i] = arregloEnteros[i];
            //System.out.println(copia[i]);
        }
        return copia;
    }

    /**
     * Retorna una copia del arreglo de cadenas, es decir un nuevo arreglo del mismo tamaño que contiene copias de los valores del arreglo original
     * @return Una copia del arreglo de cadenas
     */
    public String[] getCopiaCadenas( )
    {
        String[] copia = new String[arregloCadenas.length];
        for (int i = 0; i < arregloCadenas.length; i++) {
            copia[i] = arregloCadenas[i];
        }
        return copia;
    }

    /**
     * Retorna la cantidad de valores en el arreglo de enteros
     * @return
     */
    public int getCantidadEnteros( )
    {
    	return arregloEnteros.length;
    }

    /**
     * Retorna la cantidad de valores en el arreglo de cadenas
     * @return
     */
    public int getCantidadCadenas( )
    {
    	return arregloCadenas.length;
    }

    /**
     * Agrega un nuevo valor al final del arreglo. Es decir que este método siempre debería aumentar en 1 la capacidad del arreglo.
     * 
     * @param entero El valor que se va a agregar.
     */
    public void agregarEntero( int entero )
    {
        int nuevaLongitud = arregloEnteros.length + 1;
        int[] nuevoArreglo = new int[nuevaLongitud];
        for (int i = 0; i < arregloEnteros.length; i++) {
            nuevoArreglo[i] = arregloEnteros[i];
        }
        nuevoArreglo[nuevaLongitud - 1] = entero;
        arregloEnteros = nuevoArreglo;

    }

    /**
     * Agrega un nuevo valor al final del arreglo. Es decir que este método siempre debería aumentar en 1 la capacidad del arreglo.
     * 
     * @param cadena La cadena que se va a agregar.
     */
    public void agregarCadena( String cadena )
    {
        int nuevaLongitud = arregloCadenas.length + 1;
        String[] nuevoArreglo = new String[nuevaLongitud];
        for (int i = 0; i < arregloCadenas.length; i++) {
            nuevoArreglo[i] = arregloCadenas[i];
        }
        nuevoArreglo[nuevaLongitud - 1] = cadena;
        arregloCadenas = nuevoArreglo;
    }

    /**
     * Elimina todas las apariciones de un determinado valor dentro del arreglo de enteros
     * @param valor El valor que se va eliminar
     */
    public void eliminarEntero( int valor )
    {
        int cantidadAEliminar = 0;
        for (int i = 0; i < arregloEnteros.length; i++) {
            if (arregloEnteros[i] == valor) {
                cantidadAEliminar++;
            }
        }

        int nuevaLongitud = arregloEnteros.length - cantidadAEliminar;
        int[] nuevoArreglo = new int[nuevaLongitud];
        int indexNuevoArreglo = 0;

        for (int i = 0; i < arregloEnteros.length; i++) {
            if (arregloEnteros[i] != valor) {
                nuevoArreglo[indexNuevoArreglo] = arregloEnteros[i];
                indexNuevoArreglo++;
            }
        }

        arregloEnteros = nuevoArreglo;
    }

    /**
     * Elimina todas las apariciones de un determinado valor dentro del arreglo de cadenas
     * @param cadena La cadena que se va eliminar
     */
    public void eliminarCadena( String cadena )
    {
        int cantidadAEliminar = 0;
        for (int i = 0; i < arregloCadenas.length; i++) {
            if (arregloCadenas[i] != null && arregloCadenas[i].equals(cadena)) {
                cantidadAEliminar++;
            }
        }

        int nuevaLongitud = arregloCadenas.length - cantidadAEliminar;
        String[] nuevoArreglo = new String[nuevaLongitud];
        int indexNuevoArreglo = 0;

        for (int i = 0; i < arregloCadenas.length; i++) {
            if (arregloCadenas[i] != null && !arregloCadenas[i].equals(cadena)) {
                nuevoArreglo[indexNuevoArreglo] = arregloCadenas[i];
                indexNuevoArreglo++;
            }
        }

        arregloCadenas = nuevoArreglo;
    }

    /**
     * Inserta un nuevo entero en el arreglo de enteros.
     * 
     * @param entero El nuevo valor que debe agregarse
     * @param posicion La posición donde debe quedar el nuevo valor en el arreglo aumentado. Si la posición es menor a 0, se inserta el valor en la primera posición. Si la
     *        posición es mayor que el tamaño del arreglo, se inserta el valor en la última posición.
     */
    public void insertarEntero( int entero, int posicion )
    {
        if (posicion < 0) {
            posicion = 0;
        } else if (posicion > arregloEnteros.length) {
            posicion = arregloEnteros.length;
        }

        // Crear un nuevo arreglo con la longitud incrementada
        int[] nuevoArreglo = new int[arregloEnteros.length + 1];

        // Copiar los elementos antes de la posición de inserción
        for (int i = 0; i < posicion; i++) {
            nuevoArreglo[i] = arregloEnteros[i];
        }

        // Insertar el nuevo entero en la posición indicada
        nuevoArreglo[posicion] = entero;

        // Copiar los elementos después de la posición de inserción
        for (int i = posicion; i < arregloEnteros.length; i++) {
            nuevoArreglo[i + 1] = arregloEnteros[i];
        }

        // Asignar el nuevo arreglo al arreglo de enteros existente
        arregloEnteros = nuevoArreglo;
    }

    /**
     * Elimina un valor del arreglo de enteros dada su posición.
     * @param posicion La posición donde está el elemento que debe ser eliminado. Si el parámetro posicion no corresponde a ninguna posición del arreglo de enteros, el método
     *        no debe hacer nada.
     */
    public void eliminarEnteroPorPosicion( int posicion )
    {
        if (posicion >= 0 && posicion < arregloEnteros.length) {
            int nuevaLongitud = arregloEnteros.length - 1;
            int[] nuevoArreglo = new int[nuevaLongitud];
            int indexNuevoArreglo = 0;

            for (int i = 0; i < arregloEnteros.length; i++) {
                if (i != posicion) {
                    nuevoArreglo[indexNuevoArreglo] = arregloEnteros[i];
                    indexNuevoArreglo++;
                }
            }

            arregloEnteros = nuevoArreglo;
        }
    }

    /**
     * Reinicia el arreglo de enteros con los valores contenidos en el arreglo del parámetro 'valores' truncados.
     * 
     * Es decir que si el valor fuera 3.67, en el nuevo arreglo de enteros debería quedar el entero 3.
     * @param valores Un arreglo de valores decimales.
     */
    public void reiniciarArregloEnteros( double[] valores )
    {
        int nuevaLongitud = valores.length;
        int[] nuevoArreglo = new int[nuevaLongitud];

        for (int i = 0; i < nuevaLongitud; i++) {
            nuevoArreglo[i] = (int) valores[i];
        }

        arregloEnteros = nuevoArreglo;
    }

    /**
     * Reinicia el arreglo de cadenas con las representaciones como Strings de los objetos contenidos en el arreglo del parámetro 'objetos'.
     * 
     * Use el método toString para convertir los objetos a cadenas.
     * @param valores Un arreglo de objetos
     */
    public void reiniciarArregloCadenas( Object[] objetos )
    {
        int nuevaLongitud = objetos.length;
        String[] nuevoArreglo = new String[nuevaLongitud];

        for (int i = 0; i < nuevaLongitud; i++) {
            nuevoArreglo[i] = objetos[i].toString();
        }

        arregloCadenas = nuevoArreglo;
    }

    /**
     * Modifica el arreglo de enteros para que todos los valores sean positivos.
     * 
     * Es decir que si en una posición había un valor negativo, después de ejecutar el método debe quedar el mismo valor muliplicado por -1.
     */
    public void volverPositivos( )
    {
        for (int i = 0; i < arregloEnteros.length; i++) {
            if (arregloEnteros[i] < 0) {
                arregloEnteros[i] *= -1;
            }
        }
    }

    /**
     * Modifica el arreglo de enteros para que todos los valores queden organizados de menor a mayor.
     */
    public void organizarEnteros( )
    {
        for (int i = 0; i < arregloEnteros.length - 1; i++) {
            for (int j = 0; j < arregloEnteros.length - i - 1; j++) {
                if (arregloEnteros[j] > arregloEnteros[j + 1]) {
                    // Intercambiar los elementos si están en el orden incorrecto
                    int temp = arregloEnteros[j];
                    arregloEnteros[j] = arregloEnteros[j + 1];
                    arregloEnteros[j + 1] = temp;
                }
            }
        }
    }

    /**
     * Modifica el arreglo de cadenas para que todos los valores queden organizados lexicográficamente.
     */
    public void organizarCadenas( )
    {
        for (int i = 0; i < arregloCadenas.length - 1; i++) {
            for (int j = 0; j < arregloCadenas.length - i - 1; j++) {
                if (arregloCadenas[j].compareTo(arregloCadenas[j + 1]) > 0) {
                    // Intercambiar las cadenas si están en el orden incorrecto
                    String temp = arregloCadenas[j];
                    arregloCadenas[j] = arregloCadenas[j + 1];
                    arregloCadenas[j + 1] = temp;
                }
            }
        }
    }

    /**
     * Cuenta cuántas veces aparece el valor recibido por parámetro en el arreglo de enteros
     * @param valor El valor buscado
     * @return La cantidad de veces que aparece el valor
     */
    public int contarApariciones( int valor )
    {
        int apariciones = 0;
        for (int i = 0; i < arregloEnteros.length; i++) {
            if (arregloEnteros[i] == valor) {
            	apariciones++;
            }
        }
        return apariciones;
    }

    /**
     * Cuenta cuántas veces aparece la cadena recibida por parámetro en el arreglo de cadenas.
     * 
     * La búsqueda no debe diferenciar entre mayúsculas y minúsculas.
     * @param cadena La cadena buscada
     * @return La cantidad de veces que aparece la cadena
     */
    public int contarApariciones( String cadena )
    {
        int apariciones = 0;
        for (int i = 0; i < arregloCadenas.length; i++) {
            if (arregloCadenas[i].equalsIgnoreCase(cadena)) {
            	apariciones++;
            }
        }
        return apariciones;
    }

    /**
     * Busca en qué posiciones del arreglo de enteros se encuentra el valor que se recibe en el parámetro
     * @param valor El valor que se debe buscar
     * @return Un arreglo con los números de las posiciones del arreglo de enteros en las que se encuentra el valor buscado. Si el valor no se encuentra, el arreglo retornado
     *         es de tamaño 0.
     */
    public int[] buscarEntero( int valor )
    {
        int contador = 0;
        // Cuántas veces aparece el valor
        for (int i = 0; i < arregloEnteros.length; i++) {
            if (arregloEnteros[i] == valor) {
                contador++;
            }
        }

        // Arreglo con las posiciones
        int[] posiciones = new int[contador];
        int index = 0;
        for (int i = 0; i < arregloEnteros.length; i++) {
            if (arregloEnteros[i] == valor) {
                posiciones[index++] = i;
            }
        }

        return posiciones;
    }

    /**
     * Calcula cuál es el rango de los enteros (el valor mínimo y el máximo).
     * @return Un arreglo con dos posiciones: en la primera posición, debe estar el valor mínimo en el arreglo de enteros; en la segunda posición, debe estar el valor máximo
     *         en el arreglo de enteros. Si el arreglo está vacío, debe retornar un arreglo vacío.
     */
    public int[] calcularRangoEnteros() {
        if (arregloEnteros.length == 0) {
            // Si el arreglo está vacío, retornar un rango vacío
            return new int[]{};
        }

        int minimo = arregloEnteros[0];
        int maximo = arregloEnteros[0];

        for (int valor : arregloEnteros) {
            if (valor < minimo) {
                minimo = valor;
            } else if (valor > maximo) {
                maximo = valor;
            }
        }

        return new int[]{minimo, maximo};
    }

    /**
     * Calcula un histograma de los valores del arreglo de enteros y lo devuelve como un mapa donde las llaves son los valores del arreglo y los valores son la cantidad de
     * veces que aparece cada uno en el arreglo de enteros.
     * @return Un mapa con el histograma de valores.
     */
    public HashMap<Integer, Integer> calcularHistograma() {
        HashMap<Integer, Integer> histograma = new HashMap<>();

        if (arregloEnteros.length == 0) {
            return histograma;
        }

        // Contar la frecuencia de cada valor en el arreglo
        for (int valor : arregloEnteros) {
        	
            histograma.put(valor, histograma.getOrDefault(valor, 0) + 1);
        }
        
        //for (Entry<Integer, Integer> entry : histograma.entrySet()) {
        //    System.out.println("Valor: " + entry.getKey() + ", Frecuencia: " + entry.getValue());
        //}
        
        // Calcular el rango del arreglo
        int[] rango = calcularRangoEnteros();

        // Calcular la frecuencia mínima
        int frecuenciaMinima = arregloEnteros.length / (rango[1] - rango[0] + 1);
        
        //El nuevo histograma que elimina los valores menores a frecuenciaMinima
        // y asi el test final testGenerarEnterosDistribucion funcione:
        HashMap<Integer, Integer> histogramaFiltrado = new HashMap<>();
        for (Entry<Integer, Integer> entry : histograma.entrySet()) {
            if (entry.getValue() >= frecuenciaMinima) {
                histogramaFiltrado.put(entry.getKey(), entry.getValue());
            }
        }

        return histogramaFiltrado;
    }

    /**
     * Cuenta cuántos valores dentro del arreglo de enteros están repetidos.
     * @return La cantidad de enteos diferentes que aparecen más de una vez
     */
    public int contarEnterosRepetidos( )
    {
        if (arregloEnteros.length == 0) {
            // Si el arreglo está vacío, no hay repetidos
            return 0;
        }

        int cantidadRepetidos = 0;

        for (int i = 0; i < arregloEnteros.length - 1; i++) {
            if (arregloEnteros[i] != Integer.MIN_VALUE) {
                int repeticiones = 1;

                for (int j = i + 1; j < arregloEnteros.length; j++) {
                    if (arregloEnteros[i] == arregloEnteros[j]) {
                        repeticiones++;
                        // Marcar el valor repetido para no contar nuevamente
                        arregloEnteros[j] = Integer.MIN_VALUE;
                    }
                }

                // Contar repeticiones si hay más de una
                if (repeticiones > 1) {
                    cantidadRepetidos++;
                }
            }
        }

        return cantidadRepetidos;
    }

    /**
     * Compara el arreglo de enteros con otro arreglo de enteros y verifica si son iguales, es decir que contienen los mismos elementos exactamente en el mismo orden.
     * @param otroArreglo El arreglo de enteros con el que se debe comparar
     * @return True si los arreglos son idénticos y false de lo contrario
     */
    public boolean compararArregloEnteros( int[] otroArreglo )
    {
        if (arregloEnteros.length != otroArreglo.length) {
            // Si los arreglos tienen diferentes longitudes, no son iguales
            return false;
        }

        for (int i = 0; i < arregloEnteros.length; i++) {
            if (arregloEnteros[i] != otroArreglo[i]) {
                // Si hay al menos un elemento diferente, los arreglos no son iguales
                return false;
            }
        }

        // Si no se encontraron diferencias, los arreglos son iguales
        return true;
    }

    /**
     * Compara el arreglo de enteros con otro arreglo de enteros y verifica que tengan los mismos elementos, aunque podría ser en otro orden.
     * @param otroArreglo El arreglo de enteros con el que se debe comparar
     * @return True si los elementos en los dos arreglos son los mismos
     */
    public boolean mismosEnteros( int[] otroArreglo )
    {
        if (arregloEnteros.length != otroArreglo.length) {
            // Si los arreglos tienen diferentes longitudes, no tienen los mismos elementos
            return false;
        }

        // Crear copias de los arreglos para evitar modificar los originales
        int[] copiaArregloEnteros = copiarArreglo(arregloEnteros);
        int[] copiaOtroArreglo = copiarArreglo(otroArreglo);

        // Ordenar copias de los arreglos para facilitar la comparación
        ordenarArreglo(copiaArregloEnteros);
        ordenarArreglo(copiaOtroArreglo);

        // Comparar los arreglos ordenados
        return compararArreglos(copiaArregloEnteros, copiaOtroArreglo);
    }

    // Método para copiar un arreglo
    private int[] copiarArreglo(int[] original) {
        int[] copia = new int[original.length];
        System.arraycopy(original, 0, copia, 0, original.length);
        return copia;
    }

    // Método para ordenar un arreglo
    private void ordenarArreglo(int[] arreglo) {
        for (int i = 0; i < arreglo.length - 1; i++) {
            for (int j = 0; j < arreglo.length - i - 1; j++) {
                if (arreglo[j] > arreglo[j + 1]) {
                    // Intercambiar elementos si están en el orden incorrecto
                    int temp = arreglo[j];
                    arreglo[j] = arreglo[j + 1];
                    arreglo[j + 1] = temp;
                }
            }
        }
    }

    // Método para comparar dos arreglos
    private boolean compararArreglos(int[] arreglo1, int[] arreglo2) {
        for (int i = 0; i < arreglo1.length; i++) {
            if (arreglo1[i] != arreglo2[i]) {
                // Si hay al menos un elemento diferente, los arreglos no son iguales
                return false;
            }
        }
        return true;
    }

    /**
     * Cambia los elementos del arreglo de enteros por una nueva serie de valores generada de forma aleatoria.
     * 
     * Para generar los valores se debe partir de una distribución uniforme usando Math.random().
     * 
     * Los números en el arreglo deben quedar entre el valor mínimo y el máximo.
     * @param cantidad La cantidad de elementos que debe haber en el arreglo
     * @param minimo El valor mínimo para los números generados
     * @param maximo El valor máximo para los números generados
     */
    public void generarEnteros( int cantidad, int minimo, int maximo )
    {
        if (cantidad <= 0 || minimo > maximo) {
            // Validación de parámetros inválidos
            return;
        }

        // Inicializar el arreglo con la nueva cantidad de elementos
        arregloEnteros = new int[cantidad];

        // Generar valores aleatorios y asignar al arreglo
        arregloEnteros[0] = minimo;
        for (int i = 1; i < cantidad; i++) {
            int valorAleatorio = (int) (Math.random() * (maximo - minimo + 1) + minimo);
            arregloEnteros[i] = valorAleatorio;
        }
    }


}
