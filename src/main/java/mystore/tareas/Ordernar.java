package mystore.tareas;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.MoveMouseToBy;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.actions.selectactions.SelectByIndexFromBy;
import org.openqa.selenium.By;

public class Ordernar implements Task {
    private String orden;

    public Ordernar(String orden){
        this.orden = orden;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Scroll.to(By.id("selectProductSort")),
                SelectFromOptions.byVisibleText(this.orden).from(By.id("selectProductSort")),
                Click.on(By.className("cat-name")));
    }
    // cuando quiero cubrir varios criterios en vez de enviar el target lo mandamos por aqui
    // un metodo Perfomable que recibe que manda el parametro con el .
    public static Performable ordenAlfabeticoDesdeA(){
       return Instrumented.instanceOf(Ordernar.class).withProperties("Product Name: A to Z");
    }
}
