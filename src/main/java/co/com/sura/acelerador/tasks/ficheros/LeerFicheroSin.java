package co.com.sura.acelerador.tasks.ficheros;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@AllArgsConstructor
public class LeerFicheroSin implements Task {

    private String rutaArchivo;
    private String texto;
    private String tipoOrdenamiento;

    @SneakyThrows
    @Override
    public <T extends Actor> void performAs(T actor) {
        File archivo = new File(rutaArchivo);
        try {
            if (!archivo.exists()) {
                archivo.createNewFile();
            }

            try (FileWriter escritor = new FileWriter(archivo, true)) {
                escritor.write("Datos ordenados " + tipoOrdenamiento);
                escritor.write(texto + "\n");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static LeerFicheroSin sobreEscribirDatos(String rutaArchivo, String texto, String tipoOrdenamiento) {
        return Tasks.instrumented(LeerFicheroSin.class, rutaArchivo, texto, tipoOrdenamiento);
    }
}
