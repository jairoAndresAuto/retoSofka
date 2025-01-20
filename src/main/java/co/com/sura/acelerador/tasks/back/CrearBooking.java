package co.com.sura.acelerador.tasks.back;

import co.com.sura.acelerador.interactions.PostConsumirServicioSinPath;
import co.com.sura.acelerador.util.SumarDias;
import com.github.javafaker.Faker;
import lombok.AllArgsConstructor;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

import java.time.LocalDate;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import static co.com.sura.acelerador.util.Constantes.ADDITIONAL_NEEDS;
import static co.com.sura.acelerador.util.Constantes.CERO;
import static co.com.sura.acelerador.util.Constantes.CHECKIN;
import static co.com.sura.acelerador.util.Constantes.CHECKOUT;
import static co.com.sura.acelerador.util.Constantes.DEPOSIT_PA_ID;
import static co.com.sura.acelerador.util.Constantes.ESPANIOL;
import static co.com.sura.acelerador.util.Constantes.FIRST_NAME;
import static co.com.sura.acelerador.util.Constantes.JSON_CREAR_BOOKING;
import static co.com.sura.acelerador.util.Constantes.LAST_NAME;
import static co.com.sura.acelerador.util.Constantes.RUTA_DATO_BOOKING;
import static co.com.sura.acelerador.util.Constantes.TOTAL_PRICE;
import static co.com.sura.acelerador.util.Utilidades.validarDato;

@AllArgsConstructor
public class CrearBooking implements Task {

    private List<Map<String,String>> datos;

    @Override
    public <T extends Actor> void performAs(T actor) {
        String nombre = validarDato(datos.get(CERO).get(FIRST_NAME));
        String apellido = validarDato(datos.get(CERO).get(LAST_NAME));
        String numero = validarDato(datos.get(CERO).get(TOTAL_PRICE));
        String estado = validarDato(datos.get(CERO).get(DEPOSIT_PA_ID));
        String fechaIni = validarDato(datos.get(CERO).get(CHECKIN));
        String fechaFin = validarDato(datos.get(CERO).get(CHECKOUT));
        String observacion = validarDato(datos.get(CERO).get(ADDITIONAL_NEEDS));
        String json = String.format(JSON_CREAR_BOOKING, nombre, apellido, numero, estado , fechaIni, fechaFin, observacion);
        actor.attemptsTo(PostConsumirServicioSinPath.servicio(json));

    }

    public static CrearBooking conDatos(List<Map<String,String>> datos) {
        return Tasks.instrumented(CrearBooking.class,datos);
    }


}
