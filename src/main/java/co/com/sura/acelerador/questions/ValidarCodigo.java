package co.com.sura.acelerador.questions;

import lombok.AllArgsConstructor;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

@AllArgsConstructor
public class ValidarCodigo implements Question<Boolean> {

    private int codigoRespuesta;

    @Override
    public Boolean answeredBy(Actor actor) {
        return codigoRespuesta == SerenityRest.lastResponse().getStatusCode();
    }

    public static ValidarCodigo delServicio(int codigoRespuesta) {
        return new ValidarCodigo(codigoRespuesta);
    }
}
