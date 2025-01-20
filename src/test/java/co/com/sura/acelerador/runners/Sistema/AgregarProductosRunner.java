package co.com.sura.acelerador.runners.Sistema;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

import static io.cucumber.junit.CucumberOptions.SnippetType.CAMELCASE;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features/Sistema/agregar_productos_carro.feature"
        , glue = "co.com.sura.acelerador.stepdefinitions"
        , snippets = CAMELCASE)
public class AgregarProductosRunner {
}
