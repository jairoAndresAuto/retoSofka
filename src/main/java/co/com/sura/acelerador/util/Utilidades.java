package co.com.sura.acelerador.util;

import co.com.sura.acelerador.tasks.ficheros.LeerFicheroSin;
import net.serenitybdd.screenplay.Actor;

import java.util.ArrayList;
import java.util.Base64;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Utilidades {

    private Utilidades() {

    }

    public static String codificacionBase64(String clave) {
        byte[] decodedBytes = Base64.getDecoder().decode(clave);
        return new String(decodedBytes);
    }

    public static List<Double> ordenarDescendentemente(List<Double> lista, Actor actor) {
        actor.attemptsTo(LeerFicheroSin.sobreEscribirDatos("src/test/resources/datos/datos.txt",
                lista.stream().sorted(Collections.reverseOrder()).collect(Collectors.toList()).toString()));
        return lista.stream().sorted(Collections.reverseOrder()).collect(Collectors.toList());
    }

    public static List<Double> ordenarAscendentemente(List<Double> lista, Actor actor) {
        actor.attemptsTo(LeerFicheroSin.sobreEscribirDatos("src/test/resources/datos/datos.txt",
                lista.stream().sorted().collect(Collectors.toList()).toString()));
        return lista.stream().sorted().collect(Collectors.toList());
    }

}
