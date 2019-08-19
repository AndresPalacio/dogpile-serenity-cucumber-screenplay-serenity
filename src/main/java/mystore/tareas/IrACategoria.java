package mystore.tareas;

import mystore.ui.PaginaPrincipal;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;


public class IrACategoria  implements Task {
    private Target categoria;
    private static String categoriaElegida;
    IrACategoria(Target categoria){
        this.categoria = categoria;
    }
    public static Performable women() {
        // esta variable  se usa para cuando se coloca @Step para colcarlo
        categoriaElegida = "categoria Women";
        return Instrumented.
                instanceOf(IrACategoria.class).
                withProperties(PaginaPrincipal.CATEGORIA_WOMEN);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(this.categoria));
    }
}
