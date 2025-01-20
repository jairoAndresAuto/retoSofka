package co.com.sura.acelerador.tasks.back;

import co.com.sura.acelerador.interactions.PutConsumirServicioConPath;
import co.com.sura.acelerador.tasks.ficheros.BorrarDatosFichero;
import co.com.sura.acelerador.tasks.ficheros.LeerFichero;
import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

import static co.com.sura.acelerador.util.Constantes.DATA;
import static co.com.sura.acelerador.util.Constantes.DATO;
import static co.com.sura.acelerador.util.Constantes.RUTA_DATO_BOOKING;

@AllArgsConstructor
public class ActualizarBooking implements Task {

    private String token;

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(LeerFichero.clave(RUTA_DATO_BOOKING,DATO),
                BorrarDatosFichero.clave(RUTA_DATO_BOOKING),
                CrearData.aleatoriamente());
        actor.attemptsTo(PutConsumirServicioConPath.servicio(actor.recall(DATA).toString(),actor.recall(DATO).toString(),token));
    }

    public static ActualizarBooking creado(String token) {
        return Tasks.instrumented(ActualizarBooking.class,token);
    }

}
