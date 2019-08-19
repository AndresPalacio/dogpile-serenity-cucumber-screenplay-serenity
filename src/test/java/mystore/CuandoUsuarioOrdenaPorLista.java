package mystore;

import mystore.questions.LaPaginaMyAccount;
import mystore.questions.LaPaginaWomen;
import mystore.tareas.Decidido;
import mystore.tareas.IngresarCon;
import mystore.tareas.IrACategoria;
import mystore.tareas.Ordernar;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;

@RunWith(SerenityRunner.class)
public class CuandoUsuarioOrdenaPorLista {
    Actor actor;
    // cuando se usa esta anotacion se le dice a serenity que maneje el ciclo de vida del navegador
    @Managed
    WebDriver navegador;

    @Before
    public void init(){
        actor= Actor.named("andres");
       // el actor puede
        actor.can(BrowseTheWeb.with(navegador));

    }
    @Test
    public void ingresarAMyAccountCorrectamente(){
        /**
         *
         */
        actor.has(Decidido.ingresarConUsuarioYContra());
        actor.attemptsTo(IrACategoria.women());
       actor.attemptsTo(Ordernar.ordenAlfabeticoDesdeA());
       actor.should(seeThat("titulo de el primer resultado por orden alfabetico es blouse",
               LaPaginaWomen.primerTituloDeProducto(),equalTo("Blouse")));
    }
}
