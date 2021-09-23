package Projeeto;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class loginUsuario {
    @Test
    public void testRealizarLoginNoSistema() {
        //abrindo o navegador
        System.setProperty("webdriver.chrome.driver", "C:\\chrome driver\\chromedriver.exe");
        WebDriver navegador = new ChromeDriver();
        //navegando para a pagina
        navegador.get("https://mantis-prova.base2.com.br/login_page.php");
        //identificando o formulário de login
        WebElement FormularioLogin = navegador.findElement(By.name("username"));
        //digitar no campo username que esta dentro do formulario o texto "dreice.cousino"
        FormularioLogin.sendKeys("dreice.cousino");
        WebElement FormularioSenha = navegador.findElement(By.xpath("/html/body/div[3]/form/table/tbody/tr[3]/td[2]/input"));
        FormularioSenha.sendKeys("1234");
        WebElement FormularioBotaoLogin = navegador.findElement(By.xpath("/html/body/div[3]/form/table/tbody/tr[6]/td/input"));
        FormularioBotaoLogin.click();
        WebElement FormularioLogadoComSucesso = navegador.findElement(By.xpath("/html/body/table[1]/tbody/tr/td[1]/span[1]"));
        // FormularioLogadoComSucesso.isEnabled();
        // System.out.println(FormularioLogadoComSucesso.isEnabled());
        Assert.assertTrue("Usuário logado com sucesso", FormularioLogadoComSucesso.isEnabled());
        navegador.close();

    }
    @Test
    public void testRealizarLoginNoSistemaInvalido() {
        //abrindo o navegador
        System.setProperty("webdriver.chrome.driver", "C:\\chrome driver\\chromedriver.exe");
        WebDriver navegador = new ChromeDriver();
        //navegando para a pagina
        navegador.get("https://mantis-prova.base2.com.br/login_page.php");
        //identificando o formulário de login
        WebElement FormularioLoginSenhaInvalida = navegador.findElement(By.name("username"));
        //digitar no campo username que esta dentro do formulario o texto "dreice.cousino"
        FormularioLoginSenhaInvalida.sendKeys("dreice.cousino");
        WebElement FormularioSenhaInvalida = navegador.findElement(By.xpath("/html/body/div[3]/form/table/tbody/tr[3]/td[2]/input"));
        FormularioSenhaInvalida.sendKeys("12347");
        WebElement FormularioBotaoLogin = navegador.findElement(By.xpath("/html/body/div[3]/form/table/tbody/tr[6]/td/input"));
        FormularioBotaoLogin.click();
        WebElement FormularioUsuarioSenhaInvalida = navegador.findElement(By.xpath("//*[text()=\"Your account may be disabled or blocked or the username/password you entered is incorrect.\"]"));
        // FormularioUsuarioSenhaInvalida.isEnabled();
        // System.out.println(FormularioLogadoComSucesso.isEnabled());
        Assert.assertTrue("Senha Inválida", FormularioUsuarioSenhaInvalida.isEnabled());
        navegador.close();
    }
}
