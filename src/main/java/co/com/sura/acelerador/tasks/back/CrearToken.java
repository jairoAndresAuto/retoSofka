package co.com.sura.acelerador.tasks.back;

import co.com.sura.acelerador.interactions.PostConsumirServicioSinPath;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

import static co.com.sura.acelerador.util.Constantes.JSON_AUTENTICACION;
import static co.com.sura.acelerador.util.Constantes.PASSWORD;
import static co.com.sura.acelerador.util.Constantes.TOKEN;
import static co.com.sura.acelerador.util.Constantes.USUARIO;
import static co.com.sura.acelerador.util.Utilidades.codificacionBase64;

public class CrearToken implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        String json= String.format(JSON_AUTENTICACION,
                codificacionBase64(actor.recall(USUARIO).toString()),
                codificacionBase64(actor.recall(PASSWORD).toString()));
       actor.attemptsTo(PostConsumirServicioSinPath.servicio(json));
       actor.remember(TOKEN, SerenityRest.lastResponse().jsonPath().getString(TOKEN));
    }


    public static CrearToken deAutenticacion() {
        return Tasks.instrumented(CrearToken.class);
    }


}
