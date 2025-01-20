package co.com.sura.acelerador.stepdefinitions.Sistema;

import co.com.sura.acelerador.questions.ValidarCantidad;
import co.com.sura.acelerador.questions.ValidarMensaje;
import co.com.sura.acelerador.questions.ValidarSubTotal;
import co.com.sura.acelerador.questions.ValidarTotal;
import co.com.sura.acelerador.tasks.front.IngrasarAlCarritoYEliminar;
import co.com.sura.acelerador.tasks.front.OrganizarYEscoger;
import co.com.sura.acelerador.tasks.front.RealizarCheckout;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.E;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;

import java.util.List;
import java.util.Map;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class AgregarProductosStepDefinition {


    @Cuando("Se procede a organizar los elementos, los agrega al carrito")
    public void seProcedeAOrganizarLosElementosLosAgregaAlCarrito(List<Map<String,String>> tipoOrden) {
        theActorInTheSpotlight().attemptsTo(OrganizarYEscoger.articulos(tipoOrden.get(0).get("tipoOrden")));
    }

    @E("ingresa a la lista de agregados, eliminando uno de ellos")
    public void ingresaALaListaDeAgregadosEliminandoUnoDeEllos() {
        theActorInTheSpotlight().attemptsTo(IngrasarAlCarritoYEliminar.articulo());
    }

    @Y("realiza el checkout")
    public void realizaElCheckout() {
        theActorInTheSpotlight().attemptsTo(RealizarCheckout.compra());
    }

    @Entonces("valida que la informacion este congruente")
    public void validaQueLaInformacionEsteCongruente() {
        theActorInTheSpotlight().should(
                seeThat(ValidarCantidad.deElementos()),
                seeThat(ValidarSubTotal.precio()),
                seeThat(ValidarTotal.precio()),
                seeThat(ValidarMensaje.deExito()));
    }

}
