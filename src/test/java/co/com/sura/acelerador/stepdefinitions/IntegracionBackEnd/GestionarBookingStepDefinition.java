package co.com.sura.acelerador.stepdefinitions.IntegracionBackEnd;

import co.com.sura.acelerador.questions.ValidarCodigo;
import co.com.sura.acelerador.tasks.back.ActualizarBooking;
import co.com.sura.acelerador.tasks.back.ActualizarBookingSin;
import co.com.sura.acelerador.tasks.back.CrearBooking;
import co.com.sura.acelerador.tasks.back.CrearBookingConDatos;
import co.com.sura.acelerador.tasks.ficheros.LeerFichero;
import co.com.sura.acelerador.tasks.back.ObtenerBooking;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import java.util.List;
import java.util.Map;

import static co.com.sura.acelerador.util.Constantes.DATO;
import static co.com.sura.acelerador.util.Constantes.RUTA_DATO_BOOKING;
import static co.com.sura.acelerador.util.Constantes.TOKEN;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class GestionarBookingStepDefinition {

    @Cuando("Se procede a crear el booking")
    public void seProcedeACrearElBooking() {
        theActorInTheSpotlight().attemptsTo(CrearBookingConDatos.aleatorios());
    }

    @Entonces("Podemos observar el codigo {int}")
    public void podemosObservarElCodigo(Integer codigoEsperado) {
        theActorInTheSpotlight().should(
                seeThat(ValidarCodigo.delServicio(codigoEsperado)));
    }

    @Cuando("Se procede a crear el booking con los siguientes datos")
    public void seProcedeACrearElBookingConLosSiguientesDatos(List<Map<String,String>> datos) {
        theActorInTheSpotlight().attemptsTo(CrearBooking.conDatos(datos));
    }

    @Entonces("Podemos observar el codigo {string}")
    public void podemosObservarElCodigo(String codigoEsperado) {
        theActorInTheSpotlight().should(
                seeThat(ValidarCodigo.delServicio(Integer.parseInt(codigoEsperado))));
    }

    @Cuando("Se procede a obtener el booking")
    public void seProcedeAObtenerElBooking() {
        theActorInTheSpotlight().attemptsTo(LeerFichero.clave(RUTA_DATO_BOOKING,DATO));
        theActorInTheSpotlight().attemptsTo(ObtenerBooking.con(theActorInTheSpotlight().recall(DATO).toString()));
    }

    @Cuando("Se procede a obtener el booking con {int}")
    public void seProcedeAObtenerElBookingCon(int dato) {
        theActorInTheSpotlight().attemptsTo(ObtenerBooking.con(String.valueOf(dato)));
    }

    @Cuando("Se procede a actualizar el booking")
    public void seProcedeAActualizarElBooking() {
        String token= theActorInTheSpotlight().recall(TOKEN).toString();
        theActorInTheSpotlight().attemptsTo(ActualizarBooking.creado(token));
    }

    @Cuando("Se procede a actualizar el booking con token invalido")
    public void seProcedeAActualizarElBookingConTokenInvalido() {
        theActorInTheSpotlight().attemptsTo(ActualizarBookingSin.Token());
    }
}
