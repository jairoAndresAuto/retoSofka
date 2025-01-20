package co.com.sura.acelerador.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import java.util.List;

import static co.com.sura.acelerador.userinterfaces.ArticulosUI.LBL_NUMERO_ARTICULO;

public class ValidarCantidad implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {
        int cantidad=0;
        List<String> numeros = LBL_NUMERO_ARTICULO.resolveAllFor(actor).texts();
        for (int i = 0; i < numeros.size(); i++) {
            cantidad += Integer.parseInt(numeros.get(i));
        }
        return cantidad==2;
    }

    public static ValidarCantidad deElementos() {
        return new ValidarCantidad();
    }

}
