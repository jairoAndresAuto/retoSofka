package co.com.sura.acelerador.stepdefinitions;

import co.com.sura.acelerador.tasks.back.CrearToken;
import co.com.sura.acelerador.tasks.front.RealizarInicio;
import io.cucumber.java.Before;
import io.cucumber.java.es.Dado;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import org.openqa.selenium.WebDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static co.com.sura.acelerador.util.Constantes.ARCHIVO_PROPERTIES;
import static co.com.sura.acelerador.util.Constantes.BASE_URL_API;
import static co.com.sura.acelerador.util.Constantes.BASE_URL_AUTH;
import static co.com.sura.acelerador.util.Constantes.BASE_URL_FRONT;
import static co.com.sura.acelerador.util.Constantes.PASSWORD;
import static co.com.sura.acelerador.util.Constantes.USUARIO;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class Hook {

    private static Properties propiedades = new Properties();

    @Managed(driver = "chrome")
    public static WebDriver driver;

//    @Managed(driver = "Edge")
//    public WebDriver driver;

    @Before
    public static void setTheStage() throws IOException {
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActor("Calidad");
        FileInputStream archivo = new FileInputStream(ARCHIVO_PROPERTIES);
        propiedades.load(archivo);
    }

    @Dado("Procede a realizar el llamado del servicio de booking")
    public void procedeARealizarElLlamadoDelServicioDeBooking() throws IOException {
        String baseUrl = propiedades.getProperty(BASE_URL_API);
        theActorInTheSpotlight().can(CallAnApi.at(baseUrl));
    }

    @Dado("que procede a realizar la creacion del token")
    public void queProcedeARealizarLaCreacionDelToken() throws IOException {
        String baseUrlAuth = propiedades.getProperty(BASE_URL_AUTH);
        theActorInTheSpotlight().remember(USUARIO,propiedades.getProperty(USUARIO));
        theActorInTheSpotlight().remember(PASSWORD,propiedades.getProperty(PASSWORD));
        theActorInTheSpotlight().can(CallAnApi.at(baseUrlAuth))
                .attemptsTo(CrearToken.deAutenticacion());
    }

    @Dado("Procede a abrir la url")
    public void procedeAAbrirLaUrl() {
        String baseUrlFront = propiedades.getProperty(BASE_URL_FRONT);
        theActorInTheSpotlight().can(BrowseTheWeb.with(driver)).
                attemptsTo(Open.url(baseUrlFront));
    }

    @Dado("que el usuario procede a loguearse")
    public void queElUsuarioProcedeALoguearse() {
        String usuario = propiedades.getProperty("usuario.front");
        String password = propiedades.getProperty("password.front");
        theActorInTheSpotlight().attemptsTo(RealizarInicio.sesion(usuario,password));
    }


}
