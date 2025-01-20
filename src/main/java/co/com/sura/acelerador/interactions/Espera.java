package co.com.sura.acelerador.interactions;

import lombok.AllArgsConstructor;
import net.serenitybdd.model.time.InternalSystemClock;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

@AllArgsConstructor
public class Espera implements Task {

    private final int tiempo;

    @Override
    public <T extends Actor> void performAs(T actor) {
        new InternalSystemClock().pauseFor(tiempo);
    }

    public static Espera unTiempo(int tiempo) {
        return Tasks.instrumented(Espera.class, tiempo);
    }
}
