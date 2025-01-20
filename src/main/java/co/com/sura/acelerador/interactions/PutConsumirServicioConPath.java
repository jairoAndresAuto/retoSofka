package co.com.sura.acelerador.interactions;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.rest.interactions.Put;
import static co.com.sura.acelerador.util.Constantes.APPLICATIONJSON;
import static co.com.sura.acelerador.util.Constantes.ETIQUETA_ACCEPT;
import static co.com.sura.acelerador.util.Constantes.ETIQUETA_APPLICATIONJSON;
import static co.com.sura.acelerador.util.Constantes.ETIQUETA_COOKIE;

@AllArgsConstructor
public class PutConsumirServicioConPath implements Interaction {

    private String json;
    private String resource;
    private String token;

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Put.to(resource)
                .with(request -> request
                        .relaxedHTTPSValidation()
                        .header(ETIQUETA_APPLICATIONJSON, APPLICATIONJSON)
                        .header(ETIQUETA_ACCEPT, APPLICATIONJSON)
                        .header(ETIQUETA_COOKIE, "token="+token)
                        .body(json)));
    }

    public static PutConsumirServicioConPath servicio(String json, String resource, String token) {
        return new PutConsumirServicioConPath(json, resource, token);
    }

}
