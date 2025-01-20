package co.com.sura.acelerador.runners.IntegracionBackEnd;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

import static io.cucumber.junit.CucumberOptions.SnippetType.CAMELCASE;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features/IntegracionBackEnd/gestionar_booking.feature"
        , glue = "co.com.sura.acelerador.stepdefinitions"
        , snippets = CAMELCASE)
public class GestionarBookingRunner {
}
