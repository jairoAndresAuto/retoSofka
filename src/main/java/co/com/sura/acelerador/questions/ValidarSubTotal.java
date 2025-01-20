package co.com.sura.acelerador.questions;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import java.util.List;

import static co.com.sura.acelerador.userinterfaces.ArticulosUI.LBL_PRECIO_SUBTOTAL;
import static co.com.sura.acelerador.userinterfaces.ArticulosUI.LBL_PRECIO_UNITARIO;

public class ValidarSubTotal implements Question<Boolean> {
    @Override
    public Boolean answeredBy(Actor actor) {
        double precioSubTotal =0;
        List<String> precio = LBL_PRECIO_UNITARIO.resolveAllFor(actor).texts();
        for (int i = 0; i < precio.size() ; i++) {
            precioSubTotal += Double.valueOf(precio.get(i).replace("$",""));
        }
        actor.remember("subtotal",precioSubTotal);
        Serenity.recordReportData().withTitle("subtotal").andContents(LBL_PRECIO_SUBTOTAL.resolveFor(actor).getText().replace("Item total: $",""));
        Serenity.recordReportData().withTitle("subtotal").andContents(String.valueOf(precioSubTotal));
        return Double.valueOf(LBL_PRECIO_SUBTOTAL.resolveFor(actor).getText().replace("Item total: $",""))==precioSubTotal;
    }

    public static ValidarSubTotal precio() {
        return new ValidarSubTotal();
    }
}
