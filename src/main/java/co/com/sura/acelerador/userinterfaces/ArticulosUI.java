package co.com.sura.acelerador.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ArticulosUI {

    private ArticulosUI() {

    }

    public static final Target SLC_ORDEMANIENTO = Target.the("Lista de ordenamiento").located(By.className("product_sort_container"));
    public static final Target BTN_ADD_CART = Target.the("boton agregar carta").locatedBy("//div[@class='pricebar']//button");
    public static final Target BTN_CARRITO = Target.the("boton carrito de compras").locatedBy("//a[@class='shopping_cart_link']");
    public static final Target BTN_REMOVE = Target.the("Boton remover").locatedBy("//button[contains(.,'Remove')]");
    public static final Target BTN_CHECKOUT = Target.the("Boton checkout").located(By.id("checkout"));
    public static final Target TXT_NOMBRE = Target.the("texto nombre").located(By.id("first-name"));
    public static final Target TXT_APELLIDO = Target.the("texto apellido").located(By.id("last-name"));
    public static final Target TXT_CODIGO = Target.the("Texto codigo").located(By.id("postal-code"));
    public static final Target BTN_CONTINUAR = Target.the("Boton continuar").located(By.id("continue"));
    public static final Target LBL_NUMERO_ARTICULO = Target.the("etiqueta numero de articulo").locatedBy("//div[@class='cart_quantity']");
    public static final Target LBL_PRECIO_UNITARIO = Target.the("Etiqueta precio unitario").locatedBy("//div[@class='inventory_item_price']");
    public static final Target LBL_PRECIO_SUBTOTAL = Target.the("Etiqueta precio subtotal").locatedBy("//div[@class='summary_subtotal_label']");
    public static final Target LBL_PRECIO_IMPUESTO = Target.the("Etiqueta precio impuesto").locatedBy("//div[@class='summary_tax_label']");
    public static final Target LBL_PRECIO_TOTAL = Target.the("Etiqueta precio total").locatedBy("//div[@class='summary_total_label']");
    public static final Target BTN_FINISH = Target.the("Boton finalizar").located(By.id("finish"));
    public static final Target LBL_MENSAJE_EXITO = Target.the("Etiqueta mensaje de exito").locatedBy("//h2[contains(.,'Thank')]");
    public static final Target LBL_PRECIO_ARTICULO = Target.the("Etiqueta precio articulo").locatedBy("//div[@class='inventory_item_price']");

}
