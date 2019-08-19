package mystore.ui;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class PaginaMiCuenta {
    public static final Target SUBTITULO = Target.the("logueo exitoso").located(By.className("info-account"));
    public static final Target USUARIO = Target.the("input usuario login").located(By.id("email"));
    public static final Target PASSWORD = Target.the("input password login").located(By.id("passwd"));
    public static final Target LOGIN = Target.the("button login").located(By.id("SubmitLogin"));
}
