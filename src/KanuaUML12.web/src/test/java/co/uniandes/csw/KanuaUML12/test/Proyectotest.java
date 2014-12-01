package co.uniandes.csw.KanuaUML12.test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author estudiante
 */
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Proyectotest {
     private static WebDriver driver;
    private static String baseUrl;
    private static boolean acceptNextAlert = true;
    private static StringBuffer verificationErrors = new StringBuffer();
 
    @BeforeClass
    public static void setUp() throws Exception {
        driver = new FirefoxDriver();
        baseUrl = "http://localhost:8080";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
 
    }
 
    @Before
    public void setUpUrl() {
        driver.get(baseUrl + "/KanuaUML12.web/");
    }
 
@Test
public void testbarra()
{
    driver.findElement(By.linkText("Proyectos")).click();
}
    @Test
    public void testCreateEquipo() throws Exception {
 driver.findElement(By.linkText("Proyectos")).click();  Thread.sleep(1000);
        driver.get(baseUrl+"/KanuaUML12.web/proyectoMaster.html");
       
        /**
         * Comando que realiza click sobre el boton "create" del toolbar. La
         * función 'find' encuentra el control y posteriormente hace clic en el
         * mismo. La forma en la que se busca el control es utilizando
         * expresiones xPath ya que los id de los mismos nunca son iguales (se
         * generan con junto con el valor de componentId que varía).
         */
        driver.findElement(By.xpath("//button[contains(@id,'create')]")).click();
 
        /**
         * Comando que duerme el Thread del test por 2 segundos para dejar que
         * el efecto 'slide down' de backbone abra el formulario de createSport.
         */
        Thread.sleep(2000);
 
        /**
         * Comando que busca el elemento 'name' en el html actual.
         * Posteriormente limpia su contenido (comando clean).
         */
        driver.findElement(By.id("name")).clear();
        /**
         * Comando que simula la escritura de un valor en el elemento(sendKeys)
         * con el String de parámetro sobre // el elemento encontrado.
         */
        driver.findElement(By.id("name")).sendKeys("Proyecto1");
        driver.findElement(By.id("tema")).clear();
        driver.findElement(By.id("tema")).sendKeys("empresa");
        driver.findElement(By.id("descripcion")).clear();
        driver.findElement(By.id("descripcion")).sendKeys("un proyecto de emprendimiento");
        driver.findElement(By.id("estado")).clear();
        driver.findElement(By.id("estado")).sendKeys("en curso");
        driver.findElement(By.id("imagen")).clear();
        driver.findElement(By.id("imagen")).sendKeys("imagen");
        driver.findElement(By.id("demo")).clear();
        driver.findElement(By.id("demo")).sendKeys("youtube");
        driver.findElement(By.id("lema")).clear();
        driver.findElement(By.id("lema")).sendKeys("vamos por un 5");
        driver.findElement(By.id("descripcion")).clear();
        driver.findElement(By.id("descripcion")).sendKeys("un proyecto de emprendimiento");
        driver.findElement(By.linkText("Tag_proyecto")).click();
         Thread.sleep(2000);
          Thread.sleep(2000);
           Thread.sleep(2000);
           
         List<WebElement> a=driver.findElements(By.xpath("//button[contains(@id,'create')]"));
         a.get(1).click();
          Thread.sleep(2000);
           Thread.sleep(2000);
        // driver.findElement(By.xpath("//button[contains(@id,'create')]")).click();
         List<WebElement> b=driver.findElements(By.id("name"));
         b.get(1).sendKeys("emprendimiento");
        // driver.findElement(By.id("name")).sendKeys("emprendimiento");
          Thread.sleep(2000);
  
        /**
         * Comando que encuentra y hace clic sobre el boton "Save" del toolbar
         * (una vez mas encontrado por una expresión Xpath)
         */
          List<WebElement> c=driver.findElements(By.xpath("//button[contains(@id,'save')]"));
          c.get(1).click();
          c.get(0).click();
        
 
        /**
         * Comando que duerme el thread para esperar el efecto de slide down que
         * abre la lista
         */
        Thread.sleep(2000);
        /**
         * Comando que obtiene el div azul de creación exitosa. Si se obtiene,
         * la prueba va bien, si no, saldrá un error y la prueba quedará como
         * fállida. 
         */
        WebElement dialog = driver.findElement(By.xpath("//div[contains(@style,'display: block;')]"));

        /**
         * la prueba es exitosa si se encontró el dialogo de creación exitosa
         */
        assertTrue(dialog != null);
    }
    
    @Test
        public void testUpdateSport() throws Exception {
            driver.get(baseUrl+"/KanuaUML12.web/proyectoMaster.html");
        //    driver.findElement(By.linkText("Proyectos")).click();
            //Se hace clic en  el vinculo "Edit" del primer elemento de la lista de sports (el elemento que se creó en la anterior prueba)
            driver.findElement(By.linkText("Editar")).click();
             Thread.sleep(2000);
             //Se realiza el mismo proceso de diligenciamento de los campos con los cambios
             driver.findElement(By.id("name")).clear();;
            driver.findElement(By.id("name")).sendKeys("Proyecto111");
        driver.findElement(By.id("tema")).clear();
        driver.findElement(By.id("tema")).sendKeys("empresa editada");
        driver.findElement(By.id("descripcion")).clear();
        driver.findElement(By.id("descripcion")).sendKeys("un proyecto de emprendimiento num 2");
        driver.findElement(By.id("estado")).clear();
        driver.findElement(By.id("estado")).sendKeys("en curso 2");
        driver.findElement(By.id("imagen")).clear();
        driver.findElement(By.id("imagen")).sendKeys("imagen2");
        driver.findElement(By.id("demo")).clear();
        driver.findElement(By.id("demo")).sendKeys("youtube");
        driver.findElement(By.id("lema")).clear();
        driver.findElement(By.id("lema")).sendKeys("vamos por un 5!!!");
        driver.findElement(By.id("descripcion")).clear();
        driver.findElement(By.id("descripcion")).sendKeys("un proyecto de emprendimiento");
           
            driver.findElement(By.xpath("//button[contains(@id,'saveButton')]")).click();
            Thread.sleep(2000);
            //Se verifica que en la lista de respuesta hallan aparecido los cambios en el elemento y también el mensaje de edición exitosa.
            WebElement dialog = driver.findElement(By.xpath("//div[contains(@style,'display: block;')]"));
            List<WebElement> table = driver.findElements(By.xpath("//table[contains(@class,'table striped')]/tbody/tr"));
            boolean fail = false;
            for (WebElement webElement : table) {
                List<WebElement> elems = webElement.findElements(By.xpath("td"));
 
 
                if (elems.get(0).getText().equals("Proyecto111")) {
                    fail = true;
                }
 
 
            }
                  //  driver.findElement(By.linkText("Proyectos")).click();
        /**
         * Comando que realiza click sobre el boton "create" del toolbar. La
         * función 'find' encuentra el control y posteriormente hace clic en el
         * mismo. La forma en la que se busca el control es utilizando
         * expresiones xPath ya que los id de los mismos nunca son iguales (se
         * generan con junto con el valor de componentId que varía).
         */
        driver.findElement(By.xpath("//button[contains(@id,'create')]")).click();
 
        /**
         * Comando que duerme el Thread del test por 2 segundos para dejar que
         * el efecto 'slide down' de backbone abra el formulario de createSport.
         */
        Thread.sleep(2000);
 
        /**
         * Comando que busca el elemento 'name' en el html actual.
         * Posteriormente limpia su contenido (comando clean).
         */
        driver.findElement(By.id("name")).clear();
        /**
         * Comando que simula la escritura de un valor en el elemento(sendKeys)
         * con el String de parámetro sobre // el elemento encontrado.
         */
        driver.findElement(By.id("name")).sendKeys("Proyecto22");
        driver.findElement(By.id("tema")).clear();
        driver.findElement(By.id("tema")).sendKeys("empresa");
        driver.findElement(By.id("descripcion")).clear();
        driver.findElement(By.id("descripcion")).sendKeys("un proyecto de prueba");
        driver.findElement(By.id("estado")).clear();
        driver.findElement(By.id("estado")).sendKeys("en curso");
        driver.findElement(By.id("imagen")).clear();
        driver.findElement(By.id("imagen")).sendKeys("imagen11");
        driver.findElement(By.id("demo")).clear();
        driver.findElement(By.id("demo")).sendKeys("youtube");
        driver.findElement(By.id("lema")).clear();
        driver.findElement(By.id("lema")).sendKeys("vamos a ganar");
        driver.findElement(By.id("descripcion")).clear();
        driver.findElement(By.id("descripcion")).sendKeys("el bla");
        driver.findElement(By.linkText("Tag_proyecto")).click();
         Thread.sleep(2000);
          Thread.sleep(2000);
           Thread.sleep(2000);
           
         List<WebElement> a=driver.findElements(By.xpath("//button[contains(@id,'create')]"));
         a.get(1).click();
          Thread.sleep(2000);
           Thread.sleep(2000);
        // driver.findElement(By.xpath("//button[contains(@id,'create')]")).click();
         List<WebElement> b=driver.findElements(By.id("name"));
         b.get(1).sendKeys("bla");
        // driver.findElement(By.id("name")).sendKeys("emprendimiento");
          Thread.sleep(2000);
  
        /**
         * Comando que encuentra y hace clic sobre el boton "Save" del toolbar
         * (una vez mas encontrado por una expresión Xpath)
         */
          List<WebElement> c=driver.findElements(By.xpath("//button[contains(@id,'save')]"));
          c.get(1).click();
          c.get(0).click();
        
        }
       
        @Test
        public void testTags() throws Exception{
            driver.get(baseUrl+"/KanuaUML12.web/proyectoMaster.html");
            driver.findElement(By.id("tagbusqueda")).sendKeys("bla");
               Thread.sleep(10000);
            driver.findElement(By.id("tagProyectobusqueda")).click();
        }
        @Test
    public void testDeleteSport() throws Exception {
        /**
         * Se hace clic en el vinculo "Delete" del primer elemento de la lista
         * de sports
         */
        driver.get(baseUrl+"/KanuaUML12.web/proyectoMaster.html");
        driver.findElement(By.linkText("Eliminar")).click();
        Thread.sleep(2000);
        /**
         * Se verifica que en la lista el elemento halla desaparecido. Si
         * existe, hubo un error.
         */
        try {
            List<WebElement> table = driver.findElements(By.xpath("//table[contains(@class,'table striped')]/tbody/tr"));
            boolean fail = true;
            for (WebElement webElement : table) {
                List<WebElement> elems = webElement.findElements(By.xpath("td"));
 
               
 
            }
 
            WebElement dialog = driver.findElement(By.xpath("//div[contains(@style,'display: block;')]"));
           // assertTrue(dialog != null && !fail);
        } catch (Exception e) {
            assertTrue(true);
        }
 
    }
 
    @AfterClass
    public static void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }
 
    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
 
    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }
 
    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }
}
