package net.axis.automaiton;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;
public class StepDefinition extends BaseTestClass {

    @Test(priority = 1, description = "Masuk ke Axis Net")
    public void goToAxisNet() {
        logger = reports.startTest("Testing masuk axis net");
        loginPage.goToAxisNet();
        assertEquals(loginPage.getTextLogin(), "Lihat Nomor Hp Saya");
    }

    @Test(priority = 2, description = "Login ke Axis Net")
    public void login() {
        logger = reports.startTest("Testing login axis net");
        loginPage.loginAxisNet("083114944146", "MANTAP");
        assertEquals(loginPage.getTextHome(), "Hai,");
    }
}
