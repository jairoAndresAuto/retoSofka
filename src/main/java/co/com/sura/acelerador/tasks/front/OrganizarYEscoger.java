package co.com.sura.acelerador.tasks.front;

import co.com.sura.acelerador.interactions.Espera;
import com.github.javafaker.Faker;
import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.SelectFromOptions;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static co.com.sura.acelerador.userinterfaces.ArticulosUI.BTN_ADD_CART;
import static co.com.sura.acelerador.userinterfaces.ArticulosUI.LBL_PRECIO_ARTICULO;
import static co.com.sura.acelerador.userinterfaces.ArticulosUI.SLC_ORDEMANIENTO;
import static co.com.sura.acelerador.util.Constantes.ESPANIOL;
import static co.com.sura.acelerador.util.Utilidades.ordenarAscendentemente;
import static co.com.sura.acelerador.util.Utilidades.ordenarDescendentemente;

@AllArgsConstructor
public class OrganizarYEscoger implements Task {

    String tipoOrdenamiento;

    @Override
    public <T extends Actor> void performAs(T actor) {
        List<Double> preciosSinCaracteres = new ArrayList<>();
        List<String> precios = LBL_PRECIO_ARTICULO.resolveAllFor(actor).texts();
        for (int i = 0; i < precios.size(); i++) {
            preciosSinCaracteres.add(Double.valueOf(precios.get(i).replace("$", "")));
        }
        if (tipoOrdenamiento.equals("Ascendente")) {
            ordenarAscendentemente(preciosSinCaracteres,actor,"Ascendentemente");
        } else {
            ordenarDescendentemente(preciosSinCaracteres,actor,"Descendentemente");
        }
        Faker faker = new Faker(new Locale(ESPANIOL));
        actor.attemptsTo(SelectFromOptions.byVisibleText("Price (low to high)").from(SLC_ORDEMANIENTO));
        int cantidadPosiciones = BTN_ADD_CART.resolveAllFor(actor).size();
        BTN_ADD_CART.resolveAllFor(actor).get(0).click();
        actor.attemptsTo(Espera.unTiempo(500));
        BTN_ADD_CART.resolveAllFor(actor).get(cantidadPosiciones - 1).click();
        actor.attemptsTo(Espera.unTiempo(500));
        BTN_ADD_CART.resolveAllFor(actor).get(faker.random().nextInt(1, cantidadPosiciones - 2)).click();
    }

    public static OrganizarYEscoger articulos(String tipoOrdenamiento) {
        return Tasks.instrumented(OrganizarYEscoger.class, tipoOrdenamiento);
    }
}
