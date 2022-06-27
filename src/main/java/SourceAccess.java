import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;


public class SourceAccess {

    private static String lastly = "did not work";
    private static int numPosts = 0;

    public static void main(String[] args) {

        String currTime = Instant.now().toString();
        if (currTime.substring(11, 13).equals("10")) {

        }
        int pass = 0;
        int fail = 0;
        int uniqueFail = 0;
        double prRate = 0.0;
        int x = 250;
        //if (currTime.substring(11, 13).equals("10"))
        try {
            long firstTime = System.currentTimeMillis();
            long lastTime = System.currentTimeMillis();
            while (pass != 1 && x > 0) {

                String val = getData("1559814952", "null", "yammer@lakeshore.com", "z3K!+V!>OW@>z>KyI#%%");
                if (val.equals("failcase1")) {
                    lastTime = System.currentTimeMillis();
                    fail++;
                } else if (val.equals("passcase1")) {
                    lastTime = System.currentTimeMillis();
                    pass++;

                } else {
                    lastTime = System.currentTimeMillis();
                    uniqueFail++;
                }
                prRate = 100 * (pass / x);
                x--;
                //System.out.printlnn("");
                //System.out.printlnn("----------TESTCASE" + x + "----------");
                //System.out.printlnn("result: " + val);
                //System.out.printlnn("pass: " + pass);
                //System.out.printlnn("fail: " + fail);
                //System.out.printlnn("uniqueFail: " + uniqueFail);
                //System.out.printlnn("prRate: " + prRate);
                //System.out.printlnn("-------------------------");
                //System.out.printlnn("");
            }
        } catch (Exception e) {
            fail++;
        }
        //add html stuff here
        lastly = solveString(lastly);
        File htmlTemplateFile = new File("index.html");
        try {
            String htmlString = FileUtils.readFileToString(htmlTemplateFile, (Charset) null);
            String title = "New Page";
            String body = "This is Body";
            htmlString = htmlString.replace("$title", title);
            htmlString = htmlString.replace("$body", body);
            File newHtmlFile = new File("new.html");
            FileUtils.writeStringToFile(newHtmlFile, htmlString, (Charset) null);
            //worst case we log on automatically with selenium

        }
        catch (Exception e)
        {

        }

    }

    public static String getData(String userID, String target, String username, String pass) throws IOException {

        //make sure it does not contain "replied_to_id"
        //when you have a target, then line must also contain target
        //target must be formatted properly to a tag, not sure what/how this works yet but when you decide upon a tag need to generate the string for that tag
        // formatting target is awlays cpatial first leet of words
        //String SYM = "[" + target + "]";
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("incognito");
        options.addArguments("start-minimized");

        ChromeDriver driver = new ChromeDriver(options);
        driver.manage().window().setPosition(new Point(-20000, 0));
        try {
            long timeStart = System.currentTimeMillis();
            long timeEnd = System.currentTimeMillis();
            Date date = new Date();
            LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            int year = localDate.getYear();
            int month = localDate.getMonthValue();
            int day = localDate.getDayOfMonth();


            //
            //driver.manage.window.maximize();
            ////System.out.printlnn("setProperty");
            ////System.out.printlnn("this occurs?");
            driver.get("https://login.microsoftonline.com/common/oauth2/authorize?client_id=00000005-0000-0ff1-ce00-000000000000&domain_hint=lakeshore.com&msafed=0&nonce=3ff7b976fcfdf4036f7f800c00b067f9555977d10dd53d00112f0565f9a8e79c&redirect_uri=https%3A%2F%2Fpersona.yammer.com%2Foffice_sessions%3F&resource=https%3A%2F%2Fwww.yammer.com%2F&response_mode=form_post&response_type=id_token+code&scope=open_id&site_id=501393&state=1f5398bb9ab572287b8c42027101dc60caba89709b2d8787c963835a1a5474dc&sso_reload=true");
            ////System.out.printlnn("this occured?");
            try {
                Thread.sleep(2500);
            } catch (Exception e) {
                return "failcase1";
                //throw new RuntimeException("Error occurred in loading webpage, check that you have an internet connection.");
            }
            ////System.out.printlnn(driver.getCurrentUrl());
            ////System.out.printlnn("------------page-current-source----------");
            ////System.out.printlnn(driver.getPageSource());
            ////System.out.printlnn("------------end-page-current-source------");
            List<WebElement> someElements = driver.findElements(By.cssSelector("input"));
            //this is the problem here with some elements
            ////System.out.printlnn(someElements.size());
            for (WebElement anElement : someElements) {
                if (anElement.getAttribute("name").equals("loginfmt")) {
                    anElement.sendKeys(username);
                    ////System.out.printlnn("clicked the button");
                }
            }
            //WebElement element = driver.findElement(By.id("i0116"));
            ////System.out.printlnn("finished send login-lookup-container");
            List<WebElement> someElements2 = driver.findElements(By.id("idSIButton9"));
            for (WebElement anElement : someElements2) {
                if (anElement.getAttribute("type").equals("submit")) {
                    anElement.click();
                    ////System.out.printlnn("clicked the button");
                }
            }

            //this is the problem here with some elements
            //////System.out.printlnn(someElements.size());

            try {
                //TODO: make relative to computer that is running it
                Thread.sleep(2500);
            } catch (Exception e) {
                return "failcase1";
                //throw new RuntimeException("Error occurred in loading webpage, check that you have an internet connection.");
            }

            ////System.out.printlnn("input pasasssword!!");
            List<WebElement> Pass = driver.findElements(By.id("i0118"));
            ////System.out.printlnn(Pass.size());
            for (WebElement anElement : Pass) {
                if (anElement.getAttribute("name").equals("passwd")) {
                    //////System.out.printlnn("-------occurs");
                    anElement.sendKeys(pass);
                }
            }

            List<WebElement> passSubmit = driver.findElements(By.id("idSIButton9"));
            ////System.out.printlnn(passSubmit.size());
            for (WebElement anElement : passSubmit) {
                anElement.click();
            }
            ////System.out.printlnn("finished sign in");
            try {
                Thread.sleep(2500);
            } catch (Exception e) {
                return "failcase1";
                //throw new RuntimeException("Browser failed to click stay signed in on code. Error: " + e.toString());
            }

            List<WebElement> noSignIn = driver.findElements(By.id("idBtn_Back"));
            for (WebElement anElement : noSignIn) {
                if (anElement.getAttribute("class").equals("win-button button-secondary button ext-button secondary ext-secondary")) {
                    anElement.click();
                    ////System.out.printlnn("clicked no stay sign in key");
                }
            }
            ////System.out.printlnn("clicked no sign in option");
            ////System.out.printlnn(driver.getCurrentUrl());
            ////System.out.printlnn("faield to exit");
            try {
                Thread.sleep(3500);
            } catch (Exception e) {
                return "failcase1";
                //throw new RuntimeException("Code failed to redirect to yammer homepage. Error:"  + e.toString());
            }
            if (!driver.getCurrentUrl().equals("https://web.yammer.com/main/org/lakeshore.com/feed")) {
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
                    ////System.out.printlnn("clicked no stay sign in key");
                    //    }
                    //}
                }
            }
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                return "failcase1";
                //throw new RuntimeException("Code failed to redirect to yammer homepage. Error:"  + e.toString());
            }
            while (!driver.getCurrentUrl().equals("https://web.yammer.com/main/org/lakeshore.com/feed")) {
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    return "failcase1";
                    //throw new RuntimeException("failed to redirect to yammer homepage. error: " + e);
                }
            }
            try {
                Thread.sleep(2500);
            } catch (Exception e) {
                return "failcase1";
            }
            driver.get("https://web.yammer.com/main/org/lakeshore.com/groups/eyJfdHlwZSI6Ikdyb3VwIiwiaWQiOiIxMTMxODUwMzAxNDQifQ/all");
            try {
                Thread.sleep(3500);
            } catch (Exception e) {
                return "failcase1";
            }


            List<WebElement> seeMore = driver.findElements(By.tagName("button"));
            if (seeMore.size() == 0) {
                return "failcase1";
            }
            //System.out.printlnn("clicks the see more  + size  " + seeMore.size());
            for (WebElement anElement : seeMore) {
                if (anElement.getAttribute("class").equals("link-98") && anElement.getText().equals("see more")) {
                    anElement.click();
                    ////System.out.printlnn("clicks see more onc");
                }
            }


            // //System.out.printlnn(driver.getCurrentUrl());
            //these lines have unhandled exceptions\
            ArrayList<WebElement> pathList = new ArrayList<WebElement>();
            ////*[@id="root"]/div/div[2]/div/div[2]/div/div/div[1]/div/div/div[2]/ul/li[1]/div/div/div/div/div/div/div[1]/div[3]/div/div/div/span[1]
            List<WebElement> textBoxes = driver.findElements(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[2]/div/div/div/div/div/div[2]/ul/li[1]/div/div/div/div/div/div/div[1]/div[3]/div/div/div/span[1]"));
            ////System.out.printlnn("--------what we are looking for length: " + textBoxes.size());
            ////System.out.printlnn("here index zero: " + textBoxes.get(0).getAttribute("innerHTML"));
            ////System.out.printlnn("here: " + textBoxes.get(1).getAttribute("innerHTML"));
            // //System.out.printlnn("index zero text: " + textBoxes.get(0).getText());
            ////System.out.printlnn("index one text: " + textBoxes.get(1).getText());
            for (int i = 1; i < 50; i++) {
                ////System.out.printlnn("iteration number" + i );
                ////*[@id="root"]/div/div[2]/div/div[2]/div/div/div[1]/div/div/div[2]/ul/li[1]/div/div/div/div/div/div/div[1]/div[3]/div/div/div/span[1]
                ////*[@id="root"]/div/div[2]/div/div[2]/div/div/div[1]/div/div/div[2]/ul/li[2]/div/div/div/div/div/div/div[1]/div[3]/div/div/div/span[1]
                if (driver.findElements(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[2]/div/div/div/div/div/div[2]/ul/li[" + i + "]/div/div/div/div/div/div/div[1]/div[3]/div/div/div/span[1]")).size() != 0) {
                    ////System.out.printlnn("this ever ran");
                    pathList.add(driver.findElement(By.xpath(new String("//*[@id=\"root\"]/div/div[2]/div/div[2]/div/div/div/div/div/div[2]/ul/li[" + i + "]/div/div/div/div/div/div/div[1]/div[3]/div/div/div/span[1]"))));
                }
            }

            //System.out.printlnn("existsFor");

            String allTexts = "";
            int j=1;
            //System.out.printlnn("pathList size: " + pathList.size());
            for (WebElement anElement : pathList) {
                allTexts = allTexts + anElement.getAttribute("innerHTML");
                for (int i = 0; i < 50; i++) {
                    if (i==j && driver.findElements(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[2]/div/div/div/div/div/div[2]/ul/li[" + i + "]/div/div/div/div/div/div/div[1]/div[4]/ul/li/div/button/div/img")).size() != 0) {
                        System.out.println("foundElement" + i);
                        String finder = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[2]/div/div/div/div/div/div[2]/ul/li[" + i + "]/div/div/div/div/div/div/div[1]/div[4]/ul/li/div/button/div/img")).getAttribute("src");
                        String htmlFinder = "<img src=\"" + finder + "\">";
                        allTexts = allTexts + "<br>";
                        allTexts = allTexts + htmlFinder;
                        allTexts = allTexts + "<br>";
                        numPosts++;
                    }
                }
                j++;
                allTexts = allTexts + new String("<br>");
                allTexts = allTexts + new String("<br>");
                allTexts = allTexts + new String("<br>");

            }
            //System.out.printlnn("parses text");
            //System.out.printlnn("allTexts: " + allTexts);
            BufferedWriter writer = new BufferedWriter(new FileWriter("output" + month + day + year));
            writer.write(allTexts);
            //System.out.printlnn("writes text");
            writer.close();
            driver.quit();
            //File exists = new File("output" + month + day + year + ".txt");
            //BufferedReader br = new BufferedReader(new FileReader(exists));
            //System.out.printlnn("reads text");
            //String line = br.readLine();
            //if (exists.exists() &&  line.contains("<br>")) {
            //  exists.delete();
            ////System.out.printlnn("runmtime for method = " + ((timeEnd - timeStart)/1000));
            //return "passcase1";
            //}
            ////System.out.printlnn("getshere");
            System.out.println(allTexts);
            File exists = new File("output" + month + day + year + ".txt");

            //gives error connection reset
            lastly = allTexts;
            return "passcase1";
        } catch (Exception e) {
            long timeStart = System.currentTimeMillis();
            long timeEnd = System.currentTimeMillis();
            Date date = new Date();
            LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            int year = localDate.getYear();
            int month = localDate.getMonthValue();
            int day = localDate.getDayOfMonth();
            File exists = new File("output" + month + day + year + ".txt");
            if (exists.exists()) {
                exists.delete();
            }
            driver.quit();

            return "failcase1";
        }
    }

    public static String solveString(String result) {
        String value = result;
        String last = result;
        ArrayList<String> paragraphInserts = new ArrayList<String>();
        ArrayList<String> imageNameInserts = new ArrayList<String>();
        if (result.contains("<br>")) {
            value = result.substring(0, result.indexOf("<span class="));
            last = result.substring(result.indexOf("<span class="), result.indexOf("</span>"));
            result = result.substring(0, result.indexOf("<span class=")+23)
                    + "<B><big><big><big>"
                    + result.substring(result.indexOf("<span class=")+23);
            result = result.substring(0, result.indexOf("</span>")+7)
                    + "</B></big></big></big>"
                    + result.substring(result.indexOf("</span>")+7);
        }
        return result;
        //HOW TO DYNAMCIALLY DO HTML
        //THEN PUSH
        //THEN PACKAGE
    }
}
