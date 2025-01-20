package co.com.sura.acelerador.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class AccesoUI {

    private AccesoUI(){

    }

    public static final Target USER_FIELD = Target.the("User Name Login").located(By.id("user-name"));
    public static final Target PASSWORD_FIELD = Target.the("password Login").located(By.id("password"));
}
