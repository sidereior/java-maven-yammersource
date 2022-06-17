import java.io.*;
import java.security.Timestamp;
import java.time.Duration;
import java.time.Instant;
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
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;


public class SourceAccess {



    public static void main(String[] args) {
        System.out.println("this ahppened?");
        String currTime=Instant.now().toString();
        if(currTime.substring(11,13).equals("10"))
        {
            //TODO: put all runtime code here
        }
        System.out.println("this ahppened?");
        try {
            System.out.println("this ahppened?");
            //yammer@lakeshore.com
            //z3K!+V!>OW@>z>KyI#%%
            String val = getData("1559814952", "null", "yammer@lakeshore.com", "z3K!+V!>OW@>z>KyI#%%");
            System.out.println("this gotData?");
            System.out.println(val);
            System.out.println("probable");
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
        options.addArguments("start-maximized");
        ChromeDriver driver = new ChromeDriver(options);
        //driver.manage.window.maximize();
        System.out.println("setProperty");
        System.out.println("this occurs?");
        driver.get("https://login.microsoftonline.com/common/oauth2/authorize?client_id=00000005-0000-0ff1-ce00-000000000000&domain_hint=lakeshore.com&msafed=0&nonce=3ff7b976fcfdf4036f7f800c00b067f9555977d10dd53d00112f0565f9a8e79c&redirect_uri=https%3A%2F%2Fpersona.yammer.com%2Foffice_sessions%3F&resource=https%3A%2F%2Fwww.yammer.com%2F&response_mode=form_post&response_type=id_token+code&scope=open_id&site_id=501393&state=1f5398bb9ab572287b8c42027101dc60caba89709b2d8787c963835a1a5474dc&sso_reload=true");
        System.out.println("this occured?");
        try {
            Thread.sleep(1000);
        } catch (Exception e)
        {
            throw new RuntimeException("Error occurred in loading webpage, check that you have an internet connection.");
        }
        System.out.println(driver.getCurrentUrl());
        System.out.println("------------page-current-source----------");
        System.out.println(driver.getPageSource());
        System.out.println("------------end-page-current-source------");
        List<WebElement> someElements = driver.findElements(By.cssSelector("input"));
        //this is the problem here with some elements
        System.out.println(someElements.size());
        for (WebElement anElement : someElements) {
            if (anElement.getAttribute("name").equals("loginfmt")) {
                anElement.sendKeys(username);
                System.out.println("clicked the button");
            }
        }
        //WebElement element = driver.findElement(By.id("i0116"));
        System.out.println("finished send login-lookup-container");
        List<WebElement> someElements2 = driver.findElements(By.id("idSIButton9"));
        for (WebElement anElement : someElements2) {
            if (anElement.getAttribute("type").equals("submit")) {
                anElement.click();
                System.out.println("clicked the button");
            }
        }
        System.out.println(driver.getCurrentUrl());
        //WebDriverWait wdw = new WebDriverWait(driver, Duration.ofSeconds((long)30));
       // wdw.until(!driver.getCurrentUrl().equals("https://login.microsoftonline.com/common/oauth2/authorize?client_id=00000005-0000-0ff1-ce00-000000000000&domain_hint=lakeshore.com&msafed=0&nonce=3ff7b976fcfdf4036f7f800c00b067f9555977d10dd53d00112f0565f9a8e79c&redirect_uri=https%3A%2F%2Fpersona.yammer.com%2Foffice_sessions%3F&resource=https%3A%2F%2Fwww.yammer.com%2F&response_mode=form_post&response_type=id_token+code&scope=open_id&site_id=501393&state=1f5398bb9ab572287b8c42027101dc60caba89709b2d8787c963835a1a5474dc"));
        System.out.println(driver.getCurrentUrl());


        //driver.navigate().to(url);


        /*
        System.out.println(driver.getTitle());
        System.out.println("Current Text in username: " + element.getText());
        element.sendKeys("username");
        System.out.println("username " + username + " was sent to host");
        element.submit();
        System.out.println("Current Text in username: " + element.getText());
        System.out.println("sent username: " + username);
        System.out.println(driver.getTitle());
        element = driver.findElement(By.className("login-password"));
        //assume it is logged in, and assume that it has the source code from the website AS A STRING?
        //junkData currently stores that
         */
        URL url = new URL("https://www.yammer.com/api/v1/messages.json");
        URLConnection urlConn = url.openConnection();
        InputStreamReader inStream = new InputStreamReader(urlConn.getInputStream());
        BufferedReader buff = new BufferedReader(inStream);
        ArrayList<String> listResults = new ArrayList<>();
        String line = buff.readLine();
        String result = "didn't work";
        while (line != null) {
            System.out.println(line);
            if (target.equals("null")) {
                if (line.contains("\"sender_id\":" + userID)) {
                    if (!(line.contains("\"replied_to_id\":") && line.contains("\"group_id\":113185030144") && line.contains("\"message_type\":\"update\""))) {
                        result = line;
                        listResults.add(line);
                        System.out.println(line);
                    }
                }
            } else if (!target.equals("null")) {
                if (line.contains("\"sender_id\":" + userID)) {
                    if (!(line.contains("\"replied_to_id\":") && line.contains("\"group_id\":113185030144") && line.contains("\"message_type\":\"update\"") && line.contains(target))) {
                        result = line;
                        listResults.add(line);
                        System.out.println(line);
                    }
                }
            }
        }
        inStream.close();
        buff.close();
        System.out.println("----------------");
        System.out.println(result);
        System.out.println("----------------");
        for (int i = 0; i < listResults.size(); i++){
            System.out.println("-----" + listResults.get(i) + "-------");
        }
        return result;
        // System.out.println("work");

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
            // System.out.println(last);

        } else if (result.contains("</span></b></td>")) {
            value = result.substring(0, result.indexOf("</span></b></td>"));
            last = value;
            for (int i = value.length() - 1; i >= 0; i--) {
                if ((Character.toString(value.charAt(i))).equals(">")) {
                    last = value.substring(i + 1, value.length());
                    break;
                }
            }
            // System.out.println(last);
        } else if (result.contains("</b></td>")) {
            // System.out.println("did this work");
            value = result.substring(0, result.indexOf("</b></td>"));
            last = value;
            for (int i = value.length() - 1; i >= 0; i--) {
                if ((Character.toString(value.charAt(i))).equals(">")) {
                    last = value.substring(i + 1, value.length());
                    break;
                }
            }

        }
        // do it here:
        // System.out.println(last);
        if (last.contains("%") || last.contains("M") || last.contains("B") || last.contains("K")) {
            try {
                // System.out.println("here");
                String dubs = (last.substring(0, last.length() - 1));
                try {
                    dubs = dubs.replaceAll(",", "");
                    Double fin = Double.parseDouble(dubs);
                    // System.out.println(fin);
                    return fin;

                } catch (NumberFormatException b) {
                    throw new RuntimeException("could not be resolved to type double");
                }
            } catch (NumberFormatException e) {
                throw new RuntimeException("could not be resovled to type double");
            }
        } else {
            // System.out.println("did this run");
            try {
                // System.out.println("got here tho");
                // System.out.println(last);
                // so its with the string
                String ret2 = last;
                ret2 = ret2.replaceAll(",", "");
                // System.out.println("res");
                // System.out.println(ret2);

                Double fin = Double.parseDouble(ret2);
                // System.out.println(fin);
                return fin;

            } catch (NumberFormatException b) {
                throw new RuntimeException("could not be resolved to type double");
            }
        }

        // return null;
    }
}
