package co.com.sura.acelerador.tasks.back;

import co.com.sura.acelerador.interactions.GetConsumoConPath;
import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

@AllArgsConstructor
public class ObtenerBooking implements Task {

    private String idBooking;

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(GetConsumoConPath.servicio(idBooking));
    }

    public static ObtenerBooking con(String idBooking) {
        return Tasks.instrumented(ObtenerBooking.class,idBooking);
    }
}
