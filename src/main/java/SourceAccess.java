import java.io.*;
import java.nio.file.Path;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;


public class SourceAccess {

    private static String lastly = "did not work";

    public static void main(String[] args) {

        String currTime = Instant.now().toString();
        if (currTime.substring(11, 13).equals("10")) {

        }
        int pass = 0;
        int fail = 0;
        int uniqueFail = 0;
        double prRate = 0.0;
        int x = 250;
        if (currTime.substring(11, 13).equals("10"))
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
        String ending = solveString("<p class=\"paragraph-458\"><span class=\"text-293\">First image of the black hole at the center of our galaxy</span></p><p class=\"paragraph-458\"><span class=\"text-459\">Once again, Lake Shore helps to advance science</span></p><p class=\"paragraph-458\">&nbsp;</p><p class=\"paragraph-458\">Well, it's sort of a picture of a black hole. More like the stuff <span class=\"text-459\">around </span>the black hole.</p><p class=\"paragraph-458\">&nbsp;</p><p class=\"paragraph-458\">The <a class=\"link-460\" href=\"https://eventhorizontelescope.org/\" rel=\"nofollow noopener noreferrer\" target=\"_blank\" title=\"https://eventhorizontelescope.org/\">Event Horizon Telescope</a>, an international collaboration to link radio dishes around the world, <a class=\"link-460\" href=\"https://physicsworld.com/a/first-ever-image-of-the-black-hole-shadow-at-the-heart-of-the-milky-way-revealed-by-the-event-horizon-telescope/\" rel=\"nofollow noopener noreferrer\" target=\"_blank\" title=\"https://physicsworld.com/a/first-ever-image-of-the-black-hole-shadow-at-the-heart-of-the-milky-way-revealed-by-the-event-horizon-telescope/\">imaged the black hole at the center of the Milky Way</a> recently. This project uses Lake Shore Cernox and silicon diode sensors.</p><p class=\"paragraph-458\">&nbsp;</p><p class=\"paragraph-458\">The <a class=\"link-460\" href=\"https://eventhorizontelescope.org/science\" rel=\"nofollow noopener noreferrer\" target=\"_blank\" title=\"https://eventhorizontelescope.org/science\">method</a> in which the image was created and <a class=\"link-460\" href=\"https://www.space.com/black-hole-movies-event-horizon-telescope\" rel=\"nofollow noopener noreferrer\" target=\"_blank\" title=\"https://www.space.com/black-hole-movies-event-horizon-telescope\">what it means to scientists</a> is pretty fascinating. Also, I don't know about you, but black holes have always seemed pretty terrifying to me. Turns out they're <a class=\"link-460\" href=\"https://www.calacademy.org/explore-science/black-holes-are-nothing-to-fear\" rel=\"nofollow noopener noreferrer\" target=\"_blank\" title=\"https://www.calacademy.org/explore-science/black-holes-are-nothing-to-fear\">much more benign</a> than the massive space Hoover narrative that comes to mind.</p><p class=\"paragraph-458\">&nbsp;</p><p class=\"paragraph-458\">Another amazing way Lake Shore products are advancing science!</p><br><img src=\"https://www.yammer.com/api/v1/uploaded_files/1338279452672/preview/?client_application_id=40443904&fallback_to_icon=false&file_type=image&network_id=674410&storage=SHAREPOINT&uid=1524097277952\"><br><br><img src=\"https://www.yammer.com/api/v1/uploaded_files/1297812873216/preview/?client_application_id=40443904&fallback_to_icon=false&file_type=image&network_id=674410&storage=SHAREPOINT&uid=1524097277952\"><br><br><br><br><p class=\"paragraph-458\"><span class=\"text-293\">The most detailed image of the sun ever taken</span></p><p class=\"paragraph-458\">The European Space Agency and NASA's <a class=\"link-460\" href=\"https://www.esa.int/Science_Exploration/Space_Science/Solar_Orbiter\" rel=\"nofollow noopener noreferrer\" target=\"_blank\" title=\"https://www.esa.int/Science_Exploration/Space_Science/Solar_Orbiter\">Solar Orbiter</a> just took the most detailed set of images of our star that have ever been taken. You can <a class=\"link-460\" href=\"https://www.esa.int/Science_Exploration/Space_Science/Solar_Orbiter/Zooming_into_the_Sun_with_Solar_Orbiter\" rel=\"nofollow noopener noreferrer\" target=\"_blank\" title=\"https://www.esa.int/Science_Exploration/Space_Science/Solar_Orbiter/Zooming_into_the_Sun_with_Solar_Orbiter\">zoom in</a> on the composite image to see just how much detail the orbiter was able to capture. The final image was made up of 25 individual images and has a resolution ten times better than what a 4K TV screen can display.</p><p class=\"paragraph-458\">&nbsp;</p><p class=\"paragraph-458\">Lake Shore Cernox and diode sensors are aboard the orbiter. The craft is taking the closest images and also looking at the sun's uncharted polar regions for the first time ever. </p><p class=\"paragraph-458\">&nbsp;</p><p class=\"paragraph-458\">The data and observations will help answer questions that have long been mysteries to solar scientists. Why is the sun's corona so much hotter than its surface? Why does the sun's magnetic activity have an 11-year cycle? Why does the solar wind even exist? </p><p class=\"paragraph-458\">&nbsp;</p><p class=\"paragraph-458\">Just one more way that everyone at Lake Shore is <span class=\"text-293\">ADVANCING SCIENCE</span>! </p><br><img src=\"https://www.yammer.com/api/v1/uploaded_files/1338279452672/preview/?client_application_id=40443904&fallback_to_icon=false&file_type=image&network_id=674410&storage=SHAREPOINT&uid=1524097277952\"><br><br><img src=\"https://www.yammer.com/api/v1/uploaded_files/1297812873216/preview/?client_application_id=40443904&fallback_to_icon=false&file_type=image&network_id=674410&storage=SHAREPOINT&uid=1524097277952\"><br><br><br><br>");
        System.out.println(ending);
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
            //System.out.printlnn("pathList size: " + pathList.size());

            for (WebElement anElement : pathList) {
                allTexts = allTexts + anElement.getAttribute("innerHTML");
                for (int i = 0; i < 50; i++) {
                    if (driver.findElements(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[2]/div/div/div/div/div/div[2]/ul/li[" + i + "]/div/div/div/div/div/div/div[1]/div[4]/ul/li/div/button/div/img")).size() != 0) {
                        //System.out.printlnn("foundElement" + i);
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
            //System.out.printlnn(allTexts);
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
        //bolds + makes first line larger



        System.out.println("result: " + result);
        return "workedFully";
    }
}
