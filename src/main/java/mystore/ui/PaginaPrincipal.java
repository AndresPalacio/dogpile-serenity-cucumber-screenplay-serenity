package mystore.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class PaginaPrincipal {
    public static final Target CATEGORIA_WOMEN = Target.the("menu").located(By.xpath("//a[@class='sf-with-ul' and contains(.,'Women')]"));
}
