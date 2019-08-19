package mystore;

import mystore.questions.LaPaginaMyAccount;
import mystore.tareas.Decidido;
import mystore.tareas.IngresarCon;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.Managed;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import static java.time.temporal.ChronoUnit.SECONDS;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;

@RunWith(SerenityRunner.class)
public class CuandoUsuarioSeLoguea {
    Actor actor;
    // cuando se usa esta anotacion se le dice a serenity que maneje el ciclo de vida del navegador
    @Managed
    WebDriver navegador;

    @Before
    public void init() {
        actor = Actor.named("andres");
        // el actor puede
        actor.can(BrowseTheWeb.with(navegador));

    }

    @Test
    public void ingresarAMyAccountCorrectamente() {
        /**
         *
         */
        BrowseTheWeb.as(actor).setImplicitTimeout(20, SECONDS);

        actor.has(Decidido.ingresarConUsuarioYContra());
        actor.attemptsTo(IngresarCon.usario("juantor16@gmail.com").contraseña("Argentina1"));
        //  el actor puede recordar algo, mostrar algo, tiene habilidades de hacer algo
        // deberia
        actor.should(
                seeThat("Subtitulo de pagina My Account", LaPaginaMyAccount.subtitulo(),
                        equalTo("Welcome to your account. Here you can manage all of your personal information and orders."
                        ))
        );
    }
}
