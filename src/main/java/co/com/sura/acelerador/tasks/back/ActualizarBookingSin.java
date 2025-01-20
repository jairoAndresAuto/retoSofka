package co.com.sura.acelerador.tasks.back;

import co.com.sura.acelerador.interactions.PutConsumirServicioConPath;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

import static co.com.sura.acelerador.util.Constantes.DATA;
import static co.com.sura.acelerador.util.Constantes.TOKEN_INVALIDO;

public class ActualizarBookingSin implements Task {


    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(CrearData.aleatoriamente());
        actor.attemptsTo(PutConsumirServicioConPath.servicio(actor.recall(DATA).toString(),"747" ,TOKEN_INVALIDO));
    }

    public static ActualizarBookingSin Token() {
        return Tasks.instrumented(ActualizarBookingSin.class);
    }

}
