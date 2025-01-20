package co.com.sura.acelerador.tasks.ficheros;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

import java.io.File;
import java.io.FileWriter;

@AllArgsConstructor
public class BorrarDatosFichero implements Task {

    String path;

    @SneakyThrows
    @Override
    public <T extends Actor> void performAs(T actor) {
        File file = new File(path);
        try (FileWriter fw = new FileWriter(file);){
            fw.flush();
        }
    }

    public static BorrarDatosFichero clave(String path) {
        return Tasks.instrumented(BorrarDatosFichero.class, path);
    }
}
