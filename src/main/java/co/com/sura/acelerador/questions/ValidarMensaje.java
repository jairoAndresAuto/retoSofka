package co.com.sura.acelerador.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.actions.Click;

import static co.com.sura.acelerador.userinterfaces.ArticulosUI.BTN_FINISH;
import static co.com.sura.acelerador.userinterfaces.ArticulosUI.LBL_MENSAJE_EXITO;
import static co.com.sura.acelerador.util.Constantes.MENSAJE_EXITO;

public class ValidarMensaje implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {
        actor.attemptsTo(Click.on(BTN_FINISH));
        return MENSAJE_EXITO.equals(LBL_MENSAJE_EXITO.resolveFor(actor).getText());
    }

    public static ValidarMensaje deExito() {
        return new ValidarMensaje();
    }
}
