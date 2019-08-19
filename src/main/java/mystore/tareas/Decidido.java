package mystore.tareas;

import mystore.acciones.Navegar;
import mystore.constantes.UrlPagina;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;

public class Decidido implements Task {

    public Decidido(){

    }
    public static Performable ingresarConUsuarioYContra() {
        return Instrumented.instanceOf(Decidido.class).withProperties();
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
            actor.attemptsTo(Navegar.hacia(UrlPagina.PAGINA_SIGN_IN));
    }

}
