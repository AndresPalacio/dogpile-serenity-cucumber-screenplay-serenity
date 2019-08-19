package mystore.acciones;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actions.Open;

public class Navegar implements Interaction {

    private final String opcion;
    public Navegar(String opcion){
        this.opcion = opcion;
    }

    public static Performable hacia(String opcionURL) {
        return Instrumented.instanceOf(Navegar.class).withProperties(opcionURL);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Open.url(opcion));
    }
}
