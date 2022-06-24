import java.io.*;
import java.security.Timestamp;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.lang.StringBuilder;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import javax.net.ssl.HttpsURLConnection;

import org.apache.commons.net.ntp.TimeStamp;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;


public class SourceAccess {



    public static void main(String[] args) {
        String currTime=Instant.now().toString();
        if(currTime.substring(11,13).equals("10"))
        {
            //CHECK THAT IT IS AM
            //TODO: move runtime code here
            //TODO: make to batch file
            //TODO: make loading relative to amount of computing power allocated to chrome
            //TODO: auto minmimize window
        }
        ////System.out.println("this ahppened?");
        try {
            //System.out.println("this ahppened?");
            //yammer@lakeshore.com
            //z3K!+V!>OW@>z>KyI#%%
            int pass =0;
            int fail =0;
            int uniqueFail=0;
            double prRate=0.0;
            int x=1;
            while(x>0)
            {

                String val = getData("1559814952", "null", "yammer@lakeshore.com", "z3K!+V!>OW@>z>KyI#%%");
                if(val.equals("failcase1"))
                {
                    fail++;
                }
                else if(val.equals("passcase1"))
                {
                    pass++;
                }
                else
                {
                    uniqueFail++;
                }
                prRate=100*(pass/x);
                x--;
                System.out.println("");
                System.out.println("----------TESTCASE" + x + "----------");
                System.out.println("result: " + val);
                System.out.println("pass: " + pass);
                System.out.println("fail: " + fail);
                System.out.println("uniqueFail: " + uniqueFail);
                System.out.println("prRate: " + prRate);
                System.out.println("-------------------------");
                System.out.println("");
            }
            //System.out.println("this gotData?");
            //System.out.println(val);
        } catch (Exception e) {
        }
    }

    public static String getData(String userID, String target, String username, String pass) throws IOException {

        //make sure it does not contain "replied_to_id"
        //when you have a target, then line must also contain target
        //target must be formatted properly to a tag, not sure what/how this works yet but when you decide upon a tag need to generate the string for that tag
        // formatting target is awlays cpatial first leet of words
        //String SYM = "[" + target + "]";

        WebDriverManager.chromedriver().setup();
        ChromeOptions options= new ChromeOptions();
        options.addArguments("incognito");
        options.addArguments("start-minimized");
        ChromeDriver driver = new ChromeDriver(options);
        driver.manage().window().setPosition(new Point(-2000,0));
        //driver.manage.window.maximize();
        //System.out.println("setProperty");
        //System.out.println("this occurs?");
        driver.get("https://login.microsoftonline.com/common/oauth2/authorize?client_id=00000005-0000-0ff1-ce00-000000000000&domain_hint=lakeshore.com&msafed=0&nonce=3ff7b976fcfdf4036f7f800c00b067f9555977d10dd53d00112f0565f9a8e79c&redirect_uri=https%3A%2F%2Fpersona.yammer.com%2Foffice_sessions%3F&resource=https%3A%2F%2Fwww.yammer.com%2F&response_mode=form_post&response_type=id_token+code&scope=open_id&site_id=501393&state=1f5398bb9ab572287b8c42027101dc60caba89709b2d8787c963835a1a5474dc&sso_reload=true");
        //System.out.println("this occured?");
        try {
            Thread.sleep(2500);
        } catch (Exception e)
        {
            return "failcase1";
            //throw new RuntimeException("Error occurred in loading webpage, check that you have an internet connection.");
        }
        //System.out.println(driver.getCurrentUrl());
        //System.out.println("------------page-current-source----------");
        //System.out.println(driver.getPageSource());
        //System.out.println("------------end-page-current-source------");
        List<WebElement> someElements = driver.findElements(By.cssSelector("input"));
        //this is the problem here with some elements
        //System.out.println(someElements.size());
        for (WebElement anElement : someElements) {
            if (anElement.getAttribute("name").equals("loginfmt")) {
                anElement.sendKeys(username);
                //System.out.println("clicked the button");
            }
        }
        //WebElement element = driver.findElement(By.id("i0116"));
        //System.out.println("finished send login-lookup-container");
        List<WebElement> someElements2 = driver.findElements(By.id("idSIButton9"));
        for (WebElement anElement : someElements2) {
            if (anElement.getAttribute("type").equals("submit")) {
                anElement.click();
                //System.out.println("clicked the button");
            }
        }

        //this is the problem here with some elements
        ////System.out.println(someElements.size());

        try {
            //TODO: make relative to computer that is running it
            Thread.sleep(2500);
        } catch (Exception e)
        {
            return "failcase1";
            //throw new RuntimeException("Error occurred in loading webpage, check that you have an internet connection.");
        }

        //System.out.println("input pasasssword!!");
        List<WebElement> Pass = driver.findElements(By.id("i0118"));
        //System.out.println(Pass.size());
        for (WebElement anElement : Pass) {
            if (anElement.getAttribute("name").equals("passwd")) {
                ////System.out.println("-------occurs");
                anElement.sendKeys(pass);
            }
        }

        List<WebElement> passSubmit = driver.findElements(By.id("idSIButton9"));
        //System.out.println(passSubmit.size());
        for (WebElement anElement : passSubmit) {
            anElement.click();
        }
        //System.out.println("finished sign in");
        try{
            Thread.sleep(2500);
        }
        catch (Exception e)
        {
            return "failcase1";
            //throw new RuntimeException("Browser failed to click stay signed in on code. Error: " + e.toString());
        }

        List<WebElement> noSignIn = driver.findElements(By.id("idBtn_Back"));
        for (WebElement anElement : noSignIn)
        {
            if(anElement.getAttribute("class").equals("win-button button-secondary button ext-button secondary ext-secondary"))
            {
                anElement.click();
                //System.out.println("clicked no stay sign in key");
            }
        }
        //System.out.println("clicked no sign in option");
        //System.out.println(driver.getCurrentUrl());
        //System.out.println("faield to exit");
        try
        {
            Thread.sleep(3500);
        }
        catch (Exception e)
        {
            return "failcase1";
            //throw new RuntimeException("Code failed to redirect to yammer homepage. Error:"  + e.toString());
        }
        if(!driver.getCurrentUrl().equals("https://web.yammer.com/main/org/lakeshore.com/feed")) {
            if (driver.getCurrentUrl().equals("https://www.yammer.com/login")) {
                //TODO: once this happens once, it happens for all future instances of the same thread. makes me think its something related to the thread itself not the code
                List<WebElement> clickUsername = driver.findElements(By.id("login"));
                for (WebElement anElement : clickUsername) {
                    if (anElement.getAttribute("type").equals("email")) {
                        anElement.click();
                        anElement.sendKeys(username);
                        anElement.sendKeys(Keys.ENTER);
                    }
                }
                //List<WebElement> buttonUsername = driver.findElements(By.cssSelector("button"));
                //for (WebElement anElement : noSignIn)
                //{
                //    if(anElement.getAttribute("class").equals("win-button button-secondary button ext-button secondary ext-secondary"))
                //    {
                //        anElement.click();
                        //System.out.println("clicked no stay sign in key");
                //    }
                //}
            }
        }
        try
        {
            Thread.sleep(1000);
        }
        catch (Exception e)
        {
            return "failcase1";
            //throw new RuntimeException("Code failed to redirect to yammer homepage. Error:"  + e.toString());
        }
        while(!driver.getCurrentUrl().equals("https://web.yammer.com/main/org/lakeshore.com/feed"))
        {
            try
            {
                Thread.sleep(1000);
            }
            catch (Exception e)
            {
                return "failcase1";
                //throw new RuntimeException("failed to redirect to yammer homepage. error: " + e);
            }
        }
        try
        {
            Thread.sleep(2500);
        }
        catch (Exception e)
        {
            return "failcase1";
        }
        driver.get("https://web.yammer.com/main/org/lakeshore.com/groups/eyJfdHlwZSI6Ikdyb3VwIiwiaWQiOiIxMTMxODUwMzAxNDQifQ/all");
        try
        {
            Thread.sleep(3500);
        }
        catch (Exception e)
        {
            return "failcase1";
        }


        List<WebElement> seeMore = driver.findElements(By.tagName("button"));
       // System.out.println("clicks the see more  + size  " + seeMore.size());
        for (WebElement anElement : seeMore) {
            if(anElement.getAttribute("class").equals("link-98") && anElement.getText().equals("see more"))
            {
                anElement.click();
                //System.out.println("clicks see more onc");
            }
        }

       // System.out.println(driver.getCurrentUrl());
        //these lines have unhandled exceptions\
        ArrayList<WebElement> pathList = new ArrayList<WebElement>();
        ////*[@id="root"]/div/div[2]/div/div[2]/div/div/div[1]/div/div/div[2]/ul/li[1]/div/div/div/div/div/div/div[1]/div[3]/div/div/div/span[1]
        List<WebElement> textBoxes = driver.findElements(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[2]/div/div/div/div/div/div[2]/ul/li[1]/div/div/div/div/div/div/div[1]/div[3]/div/div/div/span[1]"));
        //System.out.println("--------what we are looking for length: " + textBoxes.size());
        //System.out.println("here index zero: " + textBoxes.get(0).getAttribute("innerHTML"));
        //System.out.println("here: " + textBoxes.get(1).getAttribute("innerHTML"));
       // System.out.println("index zero text: " + textBoxes.get(0).getText());
        //System.out.println("index one text: " + textBoxes.get(1).getText());
        for(int i=1; i<50; i++)
        {
            //System.out.println("iteration number" + i );
            ////*[@id="root"]/div/div[2]/div/div[2]/div/div/div[1]/div/div/div[2]/ul/li[1]/div/div/div/div/div/div/div[1]/div[3]/div/div/div/span[1]
            ////*[@id="root"]/div/div[2]/div/div[2]/div/div/div[1]/div/div/div[2]/ul/li[2]/div/div/div/div/div/div/div[1]/div[3]/div/div/div/span[1]
            if(driver.findElements(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[2]/div/div/div/div/div/div[2]/ul/li[" +  i + "]/div/div/div/div/div/div/div[1]/div[3]/div/div/div/span[1]")).size()!=0)
            {
                //System.out.println("this ever ran");
                pathList.add(driver.findElement(By.xpath(new String("//*[@id=\"root\"]/div/div[2]/div/div[2]/div/div/div/div/div/div[2]/ul/li[" + i + "]/div/div/div/div/div/div/div[1]/div[3]/div/div/div/span[1]"))));
            }

        }
        //System.out.println("existsFor");

        String allTexts ="";
        for (WebElement anElement : pathList) {
            allTexts = allTexts + anElement.getAttribute("innerHTML");
            for(int i=0; i<50; i++) {
                if (driver.findElements(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[2]/div/div/div/div/div/div[2]/ul/li[" + i + "]/div/div/div/div/div/div/div[1]/div[4]/ul/li/div/button/div/img")).size() != 0) {
                    String finder = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[2]/div/div/div/div/div/div[2]/ul/li[" + i + "]/div/div/div/div/div/div/div[1]/div[4]/ul/li/div/button/div/img")).getAttribute("src");
                    String htmlFinder = "<img src=\"" + finder + "\">";
                    allTexts = allTexts + "<br>";
                    allTexts = allTexts + htmlFinder;
                    allTexts = allTexts + "<br>";
                }
            }
            allTexts = allTexts + new String("<br>");
            allTexts = allTexts + new String("<br>");
            allTexts = allTexts + new String("<br>");

        }
        Date date = new Date();
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        int year  = localDate.getYear();
        int month = localDate.getMonthValue();
        int day   = localDate.getDayOfMonth();
        System.out.println(allTexts);
        BufferedWriter writer = new BufferedWriter(new FileWriter("output"  + month + day + year));
        writer.write(allTexts);
        writer.close();
        driver.close();
        return "passcase1";
    }

    public static Double solveString(String result) {
        String value = "didn't work";
        String last = "no work";
        if (result.contains("</small></b></td>")) {
            value = result.substring(0, result.indexOf("</small></b></td>"));
            last = value;
            for (int i = value.length() - 1; i >= 0; i--) {
                if ((Character.toString(value.charAt(i))).equals(">")) {
                    last = value.substring(i + 1, value.length());
                    break;
                }
            }
        } else if (result.contains("</span></b></td>")) {
            value = result.substring(0, result.indexOf("</span></b></td>"));
            last = value;
            for (int i = value.length() - 1; i >= 0; i--) {
                if ((Character.toString(value.charAt(i))).equals(">")) {
                    last = value.substring(i + 1, value.length());
                    break;
                }
            }
        } else if (result.contains("</b></td>")) {
            value = result.substring(0, result.indexOf("</b></td>"));
            last = value;
            for (int i = value.length() - 1; i >= 0; i--) {
                if ((Character.toString(value.charAt(i))).equals(">")) {
                    last = value.substring(i + 1, value.length());
                    break;
                }
            }
        }
        if (last.contains("%") || last.contains("M") || last.contains("B") || last.contains("K")) {
            try {
                String dubs = (last.substring(0, last.length() - 1));
                try {
                    dubs = dubs.replaceAll(",", "");
                    Double fin = Double.parseDouble(dubs);
                    return fin;

                } catch (NumberFormatException b) {
                    throw new RuntimeException("could not be resolved to type double");
                }
            } catch (NumberFormatException e) {
                throw new RuntimeException("could not be resovled to type double");
            }
        } else {
            try {
                String ret2 = last;
                ret2 = ret2.replaceAll(",", "");

                Double fin = Double.parseDouble(ret2);
                return fin;

            } catch (NumberFormatException b) {
                throw new RuntimeException("could not be resolved to type double");
            }
        }
    }
}
