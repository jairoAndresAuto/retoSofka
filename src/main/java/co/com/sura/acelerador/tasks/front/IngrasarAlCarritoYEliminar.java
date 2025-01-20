package co.com.sura.acelerador.tasks.front;

import com.github.javafaker.Faker;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

import java.util.Locale;

import static co.com.sura.acelerador.userinterfaces.ArticulosUI.BTN_ADD_CART;
import static co.com.sura.acelerador.userinterfaces.ArticulosUI.BTN_CARRITO;
import static co.com.sura.acelerador.userinterfaces.ArticulosUI.BTN_CHECKOUT;
import static co.com.sura.acelerador.userinterfaces.ArticulosUI.BTN_REMOVE;
import static co.com.sura.acelerador.util.Constantes.CERO;
import static co.com.sura.acelerador.util.Constantes.ESPANIOL;
import static co.com.sura.acelerador.util.Constantes.UNO;

public class IngrasarAlCarritoYEliminar implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        Faker faker = new Faker(new Locale(ESPANIOL));
        int cantidadRemove = BTN_REMOVE.resolveAllFor(actor).size();
        actor.attemptsTo(Click.on(BTN_CARRITO));
        BTN_REMOVE.resolveAllFor(actor).get(faker.random().nextInt(CERO,cantidadRemove-UNO)).click();
    }

    public static IngrasarAlCarritoYEliminar articulo() {
        return Tasks.instrumented(IngrasarAlCarritoYEliminar.class);
    }
}
