package co.com.sura.acelerador.tasks.back;

import co.com.sura.acelerador.interactions.PostConsumirServicioSinPath;
import co.com.sura.acelerador.tasks.ficheros.EscribirFichero;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;


import static co.com.sura.acelerador.util.Constantes.BOOKING_ID;
import static co.com.sura.acelerador.util.Constantes.DATA;
import static co.com.sura.acelerador.util.Constantes.RUTA_DATO_BOOKING;

public class CrearBookingConDatos implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(CrearData.aleatoriamente());
        actor.attemptsTo(PostConsumirServicioSinPath.servicio(actor.recall(DATA).toString()));
        actor.attemptsTo(EscribirFichero.clave(RUTA_DATO_BOOKING, SerenityRest.lastResponse().jsonPath().getString(BOOKING_ID)));
    }

    public static CrearBookingConDatos aleatorios() {
        return Tasks.instrumented(CrearBookingConDatos.class);
    }


}
