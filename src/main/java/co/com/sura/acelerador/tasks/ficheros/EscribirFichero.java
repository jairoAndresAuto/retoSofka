package co.com.sura.acelerador.tasks.ficheros;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

import java.io.File;
import java.io.FileWriter;

@AllArgsConstructor
public class EscribirFichero implements Task {

    private String path;
    private String dato;

    @SneakyThrows
    @Override
    public <T extends Actor> void performAs(T actor) {
        File archivo = new File(path);
        try (FileWriter escribir = new FileWriter(archivo, true)) {
            escribir.write(dato);
        }
    }

    public static EscribirFichero clave(String path, String dato) {
        return Tasks.instrumented(EscribirFichero.class, path, dato);
    }
}
