import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Locale.filter;

public class Main {
    public static void main(String[] args) {

        List<Persona> personas = Arrays.asList(
                new Persona("Juan", 25, "Masculino"),
                new Persona("María", 30, "Femenino"),
                new Persona("Pedro", 40, "Masculino"),
                new Persona("Ana", 20, "Femenino")
        );
        var edad = personas.stream()
                .filter(persona -> persona.getEdad() >25).count();
        System.out.println("Personas que tienen mas de 25 años: " + edad);

        List<String> nombrePersonas = personas.stream()
                .map(Persona::getNombre)
                .toList();
        System.out.println("nombre = " + nombrePersonas);


        int sumaEdades = personas.stream()
                .map(Persona::getEdad)
                .reduce(0, Integer::sum);

        System.out.println("La suma de las edades es: " + sumaEdades);

        /*
        Contar la cantidad de personas de cada género.
        Calcular el promedio de edades de las personas.
        Encontrar la persona de mayor edad.
         */
    }
}