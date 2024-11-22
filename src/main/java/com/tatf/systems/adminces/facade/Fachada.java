package com.tatf.systems.adminces.facade;

import com.tatf.core.browser.IBrowser;
import com.tatf.core.driver.manager_singlenton.DriverManagerSinglenton;
import com.tatf.core.verification.IVerify;
import com.tatf.systems.adminces.pom.login.IngresoSitioPO;
import com.tatf.systems.adminces.pom.menu.MenuPO;
import org.openqa.selenium.WebDriver;

public class Fachada {
    private final String tituloIncorrecto = "Título incorrecto.";
    private final int waitSeconds = 10;
    private final WebDriver driver = DriverManagerSinglenton.getInstance().getDriver();
    private final IVerify verify = IVerify.create();
    private final IBrowser browser;
    private final IngresoSitioPO ingresoSitio;
    private final MenuPO menu;

    public Fachada() {
        browser = IBrowser.create(this.waitSeconds, driver);
        ingresoSitio = new IngresoSitioPO(this.browser);
        menu = new MenuPO(this.browser);
    }

    public Fachada entrarSitio(String url, String contrasenia) {
        browser.navigateTo(url);
        ingresoSitio.ingresarContrasenia(contrasenia);
        ingresoSitio.clickBotonIngresar();
        return this;
    }

    public Fachada validarTituloHome(String tituloEsperado) {
        String tituloActual = browser.findCss("nav>p").getText();
        verify.verify(tituloEsperado, tituloActual, tituloIncorrecto);
        return this;
    }

    public Fachada entrarEnIniciarSesion(String tituloEsperado) {
        menu.clickEnIniciarSesion();

        String tituloActual = this.browser.findTag("h5").getText();

        verify.verify(tituloEsperado, tituloActual, tituloIncorrecto);
        return this;
    }

    public Fachada entrarEnRegistrarse(String tituloEsperado) {
        menu.clickEnRegistrarse();

        String tituloActual = this.browser.findTag("h5").getText();

        verify.verify(tituloEsperado, tituloActual, tituloIncorrecto);
        return this;
    }

    public Fachada entrarEnReiniciarContrasenia(String tituloEsperado) {
        menu.clickReiniciarContrasenia();

        String tituloActual = this.browser.findTag("h5").getText();

        verify.verify(tituloEsperado, tituloActual, tituloIncorrecto);
        return this;
    }

    public Fachada cerrarNavegador() {
        browser.quit();
        return this;
    }
}
