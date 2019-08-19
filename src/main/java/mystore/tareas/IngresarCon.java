package mystore.tareas;

import mystore.ui.PaginaMiCuenta;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import org.openqa.selenium.Keys;

public class IngresarCon implements Task {
    private String usuario;
    private String contraseña;

    public static IngresarConBuilder usario(String usuario) {
            return new IngresarConBuilder(usuario);
    }


    @Override
    public <T extends Actor> void performAs(T actor) {
        // THENHIT LUEGO PRESIONA TAB
        actor.attemptsTo(Enter.theValue(usuario).into(PaginaMiCuenta.USUARIO).thenHit(Keys.TAB),
                Enter.theValue(contraseña).into(PaginaMiCuenta.PASSWORD).thenHit(Keys.TAB),
                Click.on(PaginaMiCuenta.LOGIN));
    }
    public IngresarCon(String usuario,String contraseña){
        this.usuario = usuario;
        this.contraseña = contraseña;
    }
    public static class IngresarConBuilder{
        private String usuario;

        public IngresarConBuilder(String usuario){
            this.usuario = usuario;
        }
        public Performable contraseña(String contraseña){
            // recibe por parametro el metodo contraseña
            //  va llamar el constructor y le enviara ambos valores
            // entonces el padre llama al contructor del padre de manera normal
            // luego el hijo llama al su metodo perfomable
            // y devuelve una instancia de instrumente que ejecuta el metodo performAs
            return Instrumented.instanceOf(IngresarCon.class).withProperties(usuario,contraseña);
        }
    }
}
