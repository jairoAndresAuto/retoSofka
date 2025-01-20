package co.com.sura.acelerador.tasks.back;

import co.com.sura.acelerador.util.SumarDias;
import com.github.javafaker.Faker;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

import java.time.LocalDate;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import static co.com.sura.acelerador.util.Constantes.DATA;
import static co.com.sura.acelerador.util.Constantes.ESPANIOL;
import static co.com.sura.acelerador.util.Constantes.JSON_CREAR_BOOKING;

public class CrearData implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        Faker faker = new Faker(new Locale(ESPANIOL));
        String nombre = faker.name().firstName();
        String apellido = faker.name().lastName();
        int numero = faker.random().nextInt(100, 999);
        String fechaIni = "2018-01-01";
        LocalDate fechaFin = SumarDias.aFecha(fechaIni, faker.random().nextInt(10, 20));
        String observacion = faker.color().name();
        String json = String.format(JSON_CREAR_BOOKING, nombre, apellido, numero, true, fechaIni, fechaFin, observacion);
        actor.remember(DATA,json);
    }

    public static CrearData aleatoriamente() {
        return Tasks.instrumented(CrearData.class);
    }

}
