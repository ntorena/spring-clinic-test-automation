package com.tatf.systems.adminces.pom.menu;


import com.tatf.core.browser.IBrowser;

public class MenuPO {
    private final IBrowser browser;
    private final String iniciarSesion = "a[href=\"/adminces/login\"].menu-effect-ces";
    private final String registrarse = "a[href=\"/adminces/register\"].menu-effect-ces";
    private final String reiniciarContrasenia = "a[href=\"/adminces/forgot-password\"].menu-effect-ces";

    public MenuPO(IBrowser browser) {
        this.browser = browser;
    }

    private void clickMenu(String menu) {
        browser.findCss(menu).click();
    }

    public void clickEnIniciarSesion() {
        clickMenu(iniciarSesion);
    }

    public void clickEnRegistrarse() {
        clickMenu(registrarse);
    }

    public void clickReiniciarContrasenia() {
        clickMenu(reiniciarContrasenia);
    }
}