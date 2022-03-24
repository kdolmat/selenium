import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class project1 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Inna\\Downloads\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://qa-duotify.us-east-2.elasticbeanstalk.com/register.php");
        String title = driver.getTitle();



        char c=' ';
        String temp="";
        String rand = "";
        for(int i=0;i<6;i++){
            c = (char)(26*(Math.random())+65);
          temp  = String.valueOf(c);
          rand=temp+rand;
        }
        String email = rand+"@gmail.com";


        if(title.contains("Welcome to Duotify!")){
            driver.findElement(By.id("hideLogin")).click();
            driver.findElement(By.name("username")).sendKeys(rand);
            driver.findElement(By.name("firstName")).sendKeys("Kiryl");
            driver.findElement(By.name("lastName")).sendKeys("Dolmat");
            driver.findElement(By.name("email")).sendKeys(email);
            driver.findElement(By.name("email2")).sendKeys(email);
            driver.findElement(By.name("password")).sendKeys("123456789");
            driver.findElement(By.name("password2")).sendKeys("123456789");
            driver.findElement(By.name("registerButton")).click();
        }else{
            System.out.println("failed title");
        }



        String getUrl = driver.getCurrentUrl();
        String expectedUrl = "http://qa-duotify.us-east-2.elasticbeanstalk.com/browse.php?";

        if(getUrl.equals(expectedUrl)){

           driver.findElement(By.id("nameFirstAndLast")).click();
           Thread.sleep(1000);
            // WebElement logout = driver.findElement(By.xpath("//*[.='LOGOUT']"));
            //  driver.findElement(By.xpath("//*[.='LOGOUT']")).click();
                driver.findElement(By.id("rafael")).click();
        }else{
            System.out.println("failed link");
        }
        Thread.sleep(1000);
        String logOutUrl = driver.getCurrentUrl();
        String expectedLogOut = "http://qa-duotify.us-east-2.elasticbeanstalk.com/register.php";


        if(logOutUrl.contains(expectedLogOut)){
        driver.findElement(By.id("loginUsername")).sendKeys(rand);
        driver.findElement(By.id("loginPassword")).sendKeys("123456789");
        driver.findElement(By.name("loginButton")).click();

        }else {
            System.out.println("failed logout");
        }

        Thread.sleep(1000);
        String h1 = driver.findElement(By.tagName("h1")).getText();

if(h1.equals("You Might Also Like")){
    System.out.println("testing is over");
}else{
    System.out.println("not yet");
}





    }
}
