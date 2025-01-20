package co.com.sura.acelerador.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ArticulosUI {

    private ArticulosUI() {

    }

    public static final Target SLC_ORDEMANIENTO = Target.the("User Name Login").located(By.className("product_sort_container"));
    public static final Target BTN_ADD_CART = Target.the("User Name Login").locatedBy("//div[@class='pricebar']//button");
    public static final Target BTN_CARRITO = Target.the("User Name Login").locatedBy("//a[@class='shopping_cart_link']");
    public static final Target BTN_REMOVE = Target.the("User Name Login").locatedBy("//button[contains(.,'Remove')]");
    public static final Target BTN_CHECKOUT = Target.the("User Name Login").located(By.id("checkout"));
    public static final Target TXT_NOMBRE = Target.the("User Name Login").located(By.id("first-name"));
    public static final Target TXT_APELLIDO = Target.the("User Name Login").located(By.id("last-name"));
    public static final Target TXT_CODIGO = Target.the("User Name Login").located(By.id("postal-code"));
    public static final Target BTN_CONTINUAR = Target.the("User Name Login").located(By.id("continue"));
    public static final Target LBL_NUMERO_ARTICULO = Target.the("User Name Login").locatedBy("//div[@class='cart_quantity']");
    public static final Target LBL_PRECIO_UNITARIO = Target.the("User Name Login").locatedBy("//div[@class='inventory_item_price']");
    public static final Target LBL_PRECIO_SUBTOTAL = Target.the("User Name Login").locatedBy("//div[@class='summary_subtotal_label']");
    public static final Target LBL_PRECIO_IMPUESTO = Target.the("User Name Login").locatedBy("//div[@class='summary_tax_label']");
    public static final Target LBL_PRECIO_TOTAL = Target.the("User Name Login").locatedBy("//div[@class='summary_total_label']");
    public static final Target BTN_FINISH = Target.the("User Name Login").located(By.id("finish"));
    public static final Target LBL_MENSAJE_EXITO = Target.the("User Name Login").locatedBy("//h2[contains(.,'Thank')]");
    public static final Target LBL_PRECIO_ARTICULO = Target.the("User Name Login").locatedBy("//div[@class='inventory_item_price']");

}
