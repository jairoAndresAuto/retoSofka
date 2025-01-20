package co.com.sura.acelerador.tasks.ficheros;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

@AllArgsConstructor
public class LeerFichero implements Task {

    private String path;
    private String dato;

    @SneakyThrows
    @Override
    public <T extends Actor> void performAs(T actor) {
        File doc = new File(path);
        FileReader fileR=new FileReader(doc);
        BufferedReader obj = new BufferedReader(fileR);
        try {
            actor.remember(dato, obj.readLine());
        } finally {
           obj.close();
        }
    }

    public static LeerFichero clave(String path, String dato) {
        return Tasks.instrumented(LeerFichero.class, path, dato);
    }
}
