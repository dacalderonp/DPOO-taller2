package uniandes.dpoo.estructuras.logica;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Esta clase tiene un conjunto de métodos para practicar operaciones sobre mapas.
 *
 * Todos los métodos deben operar sobre el atributo mapaCadenas que se declara como un Map.
 * 
 * En este mapa, las llaves serán cadenas y los valores serán también cadenas. La relación entre los dos será que cada llave será igual a la cadena del valor, pero invertida.
 * 
 * El objetivo de usar el tipo Map es que sólo puedan usarse métodos de esa interfaz y no métodos adicionales provistos por la implementación concreta (HashMap).
 * 
 * No pueden agregarse nuevos atributos.
 */
public class SandboxMapas
{
    /**
     * Un mapa de cadenas para realizar varias de las siguientes operaciones.
     * 
     * Las llaves del mapa son cadenas, así como los valores.
     * 
     * Las llaves corresponden a invertir la cadena que aparece asociada a cada llave.
     */
    private Map<String, String> mapaCadenas;

    /**
     * Crea una nueva instancia de la clase con las dos listas inicializadas pero vacías
     */
    public SandboxMapas( )
    {
        mapaCadenas = new HashMap<String, String>( );
    }

    /**
     * Retorna una lista con las cadenas del mapa (los valores) ordenadas lexicográficamente
     * @return Una lista ordenada con las cadenas que conforman los valores del mapa
     */
    public List<String> getValoresComoLista( )
    {
       List<String> valoresOrdenados = new ArrayList<>(mapaCadenas.values());

        // Implementa tu propio algoritmo de ordenamiento lexicográfico
        for (int i = 0; i < valoresOrdenados.size() - 1; i++) {
            for (int j = i + 1; j < valoresOrdenados.size(); j++) {
                if (valoresOrdenados.get(i).compareTo(valoresOrdenados.get(j)) > 0) {
                    // Intercambia los elementos si están en el orden incorrecto
                    String temp = valoresOrdenados.get(i);
                    valoresOrdenados.set(i, valoresOrdenados.get(j));
                    valoresOrdenados.set(j, temp);
                }
            }
        }

        return valoresOrdenados;
    }

    /**
     * Retorna una lista con las llaves del mapa ordenadas lexicográficamente de mayor a menor
     * @return Una lista ordenada con las cadenas que conforman las llaves del mapa
     */
    public List<String> getLlavesComoListaInvertida( )
    {
        List<String> llavesOrdenadas = new LinkedList<>();

        // Copia las llaves del mapa a la lista
        for (String llave : mapaCadenas.keySet()) {
            llavesOrdenadas.add(llave);
        }

        // Implementa tu propio algoritmo de ordenamiento lexicográfico de mayor a menor
        for (int i = 0; i < llavesOrdenadas.size() - 1; i++) {
            for (int j = i + 1; j < llavesOrdenadas.size(); j++) {
                if (llavesOrdenadas.get(i).compareTo(llavesOrdenadas.get(j)) < 0) {
                    // Intercambia los elementos si están en el orden incorrecto
                    String temp = llavesOrdenadas.get(i);
                    llavesOrdenadas.set(i, llavesOrdenadas.get(j));
                    llavesOrdenadas.set(j, temp);
                }
            }
        }

        return llavesOrdenadas;
    }

    /**
     * Retorna la cadena que sea lexicográficamente menor dentro de las llaves del mapa .
     * 
     * Si el mapa está vacío, debe retornar null.
     * @return
     */
    public String getPrimera( )
    {
        if (mapaCadenas.isEmpty()) {
            return null;
        }

        String menor = null;

        // Itera sobre las llaves del mapa
        for (String llave : mapaCadenas.keySet()) {
            if (menor == null || llave.compareTo(menor) < 0) {
                menor = llave;
            }
        }

        return menor;
    }

    /**
     * Retorna la cadena que sea lexicográficamente mayor dentro de los valores del mapa
     * 
     * Si el conjunto está vacío, debe retornar null.
     * @return
     */
    public String getUltima( )
    {
        if (mapaCadenas.isEmpty()) {
            return null;
        }

        String mayor = null;

        // Itera sobre los valores del mapa
        for (String valor : mapaCadenas.values()) {
            if (mayor == null || valor.compareTo(mayor) > 0) {
                mayor = valor;
            }
        }

        return mayor;
    }

    /**
     * Retorna una colección con las llaves del mapa, convertidas a mayúsculas.
     * 
     * El orden de las llaves retornadas no importa.
     * @return Una lista de cadenas donde todas las cadenas están en mayúsculas
     */
    public Collection<String> getLlaves( )
    {
        List<String> llavesMayusculas = new ArrayList<>();

        // Itera sobre las llaves del mapa
        for (String llave : mapaCadenas.keySet()) {
            llavesMayusculas.add(llave.toUpperCase());
        }

        return llavesMayusculas;
    }

    /**
     * Retorna la cantidad de *valores* diferentes en el mapa
     * @return
     */
    public int getCantidadCadenasDiferentes( )
    {
        List<String> valores = new ArrayList<>(mapaCadenas.values());
        int cantidadDiferentes = 0;

        for (int i = 0; i < valores.size(); i++) {
            boolean esDiferente = true;

            for (int j = i + 1; j < valores.size(); j++) {
                if (valores.get(i).equals(valores.get(j))) {
                    esDiferente = false;
                    break;
                }
            }

            if (esDiferente) {
                cantidadDiferentes++;
            }
        }

        return cantidadDiferentes;
    }

    /**
     * Agrega un nuevo valor al mapa de cadenas: el valor será el recibido por parámetro, y la llave será la cadena invertida
     * 
     * Este método podría o no aumentar el tamaño del mapa, dependiendo de si ya existía la cadena en el mapa
     * 
     * @param cadena La cadena que se va a agregar al mapa
     */
    public void agregarCadena( String cadena )
    {
        String llaveInvertida = new StringBuilder(cadena).reverse().toString();

        // Verifica si la llave ya existe en el mapa
        if (!mapaCadenas.containsKey(llaveInvertida)) {
            // Si la llave no existe, la agrega al mapa
            mapaCadenas.put(llaveInvertida, cadena);
        }
    }

    /**
     * Elimina una cadena del mapa, dada la llave
     * @param cadena La llave para identificar el valor que se debe eliminar
     */
    public void eliminarCadenaConLLave( String llave )
    {
        if (mapaCadenas.containsKey(llave)) {
            // Si la llave existe, elimina el valor asociado
            mapaCadenas.remove(llave);
        }
    }

    /**
     * Elimina una cadena del mapa, dado el valor
     * @param cadena El valor que se debe eliminar
     */
    public void eliminarCadenaConValor( String valor )
    {
    	 mapaCadenas.entrySet().removeIf(entry -> valor.equals(entry.getValue()));
    }

    /**
     * Reinicia el mapa de cadenas con las representaciones como Strings de los objetos contenidos en la lista del parámetro 'objetos'.
     * 
     * Use el método toString para convertir los objetos a cadenas.
     * @param valores Una lista de objetos
     */
    public void reiniciarMapaCadenas( List<Object> objetos )
    {
        mapaCadenas.clear(); // Elimina todos los elementos existentes en el mapa

        for (Object obj : objetos) {
            String cadena = obj.toString();
            String llaveInvertida = new StringBuilder(cadena).reverse().toString();

            // Agrega la cadena al mapa con la llave invertida
            mapaCadenas.put(llaveInvertida, cadena);
        }
    }

    /**
     * Modifica el mapa de cadenas reemplazando las llaves para que ahora todas estén en mayúsculas pero sigan conservando las mismas cadenas asociadas.
     */
    public void volverMayusculas( )
    {
        Map<String, String> nuevoMapa = new HashMap<>();

        for (Map.Entry<String, String> entry : mapaCadenas.entrySet()) {
            String nuevaLlave = entry.getKey().toUpperCase();
            String valor = entry.getValue();
            nuevoMapa.put(nuevaLlave, valor);
        }

        mapaCadenas = nuevoMapa;
    }

    /**
     * Verifica si todos los elementos en el arreglo de cadenas del parámetro hacen parte del mapa de cadenas (de los valores)
     * @param otroArreglo El arreglo de enteros con el que se debe comparar
     * @return True si todos los elementos del arreglo están dentro de los valores del mapa
     */
    public boolean compararValores( String[] otroArreglo )
    {
        for (String cadena : otroArreglo) {
            boolean encontrado = false;

            for (Map.Entry<String, String> entry : mapaCadenas.entrySet()) {
                if (cadena.equals(entry.getValue())) {
                    encontrado = true;
                    break;
                }
            }

            if (!encontrado) {
                return false;
            }
        }

        return true;
    }

}
