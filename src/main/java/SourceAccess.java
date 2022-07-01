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
import org.apache.http.auth.UsernamePasswordCredentials;
import org.eclipse.jgit.api.*;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.internal.storage.file.FileRepository;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.transport.CredentialsProvider;
import org.eclipse.jgit.transport.RefSpec;
import org.eclipse.jgit.transport.URIish;
import org.eclipse.jgit.transport.UsernamePasswordCredentialsProvider;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SourceAccess {

    private static String lastly = "did not work";
    private static int numPosts = 0;
    private static String content = "no content";

    public static void main(String[] args) {

        //lastly = "<p class=\"paragraph-427\"><span class=\"text-351\">First image of the black hole at the center of our galaxy</span></p><p class=\"paragraph-427\"><span class=\"text-428\">Once again, Lake Shore helps to advance science</span></p><p class=\"paragraph-427\">&nbsp;</p><p class=\"paragraph-427\">Well, it's sort of a picture of a black hole. More like the stuff <span class=\"text-428\">around </span>the black hole.</p><p class=\"paragraph-427\">&nbsp;</p><p class=\"paragraph-427\">The <a class=\"link-429\" href=\"https://eventhorizontelescope.org/\" rel=\"nofollow noopener noreferrer\" target=\"_blank\" title=\"https://eventhorizontelescope.org/\">Event Horizon Telescope</a>, an international collaboration to link radio dishes around the world, <a class=\"link-429\" href=\"https://physicsworld.com/a/first-ever-image-of-the-black-hole-shadow-at-the-heart-of-the-milky-way-revealed-by-the-event-horizon-telescope/\" rel=\"nofollow noopener noreferrer\" target=\"_blank\" title=\"https://physicsworld.com/a/first-ever-image-of-the-black-hole-shadow-at-the-heart-of-the-milky-way-revealed-by-the-event-horizon-telescope/\">imaged the black hole at the center of the Milky Way</a> recently. This project uses Lake Shore Cernox and silicon diode sensors.</p><p class=\"paragraph-427\">&nbsp;</p><p class=\"paragraph-427\">The <a class=\"link-429\" href=\"https://eventhorizontelescope.org/science\" rel=\"nofollow noopener noreferrer\" target=\"_blank\" title=\"https://eventhorizontelescope.org/science\">method</a> in which the image was created and <a class=\"link-429\" href=\"https://www.space.com/black-hole-movies-event-horizon-telescope\" rel=\"nofollow noopener noreferrer\" target=\"_blank\" title=\"https://www.space.com/black-hole-movies-event-horizon-telescope\">what it means to scientists</a> is pretty fascinating. Also, I don't know about you, but black holes have always seemed pretty terrifying to me. Turns out they're <a class=\"link-429\" href=\"https://www.calacademy.org/explore-science/black-holes-are-nothing-to-fear\" rel=\"nofollow noopener noreferrer\" target=\"_blank\" title=\"https://www.calacademy.org/explore-science/black-holes-are-nothing-to-fear\">much more benign</a> than the massive space Hoover narrative that comes to mind.</p><p class=\"paragraph-427\">&nbsp;</p><p class=\"paragraph-427\">Another amazing way Lake Shore products are advancing science!</p><br><img src=\"https://www.yammer.com/api/v1/uploaded_files/1338279452672/preview/?client_application_id=40443904&fallback_to_icon=false&file_type=image&network_id=674410&storage=SHAREPOINT&uid=1524097277952\"><br><br><br><br><p class=\"paragraph-427\"><span class=\"text-351\">The most detailed image of the sun ever taken</span></p><p class=\"paragraph-427\">The European Space Agency and NASA's <a class=\"link-429\" href=\"https://www.esa.int/Science_Exploration/Space_Science/Solar_Orbiter\" rel=\"nofollow noopener noreferrer\" target=\"_blank\" title=\"https://www.esa.int/Science_Exploration/Space_Science/Solar_Orbiter\">Solar Orbiter</a> just took the most detailed set of images of our star that have ever been taken. You can <a class=\"link-429\" href=\"https://www.esa.int/Science_Exploration/Space_Science/Solar_Orbiter/Zooming_into_the_Sun_with_Solar_Orbiter\" rel=\"nofollow noopener noreferrer\" target=\"_blank\" title=\"https://www.esa.int/Science_Exploration/Space_Science/Solar_Orbiter/Zooming_into_the_Sun_with_Solar_Orbiter\">zoom in</a> on the composite image to see just how much detail the orbiter was able to capture. The final image was made up of 25 individual images and has a resolution ten times better than what a 4K TV screen can display.</p><p class=\"paragraph-427\">&nbsp;</p><p class=\"paragraph-427\">Lake Shore Cernox and diode sensors are aboard the orbiter. The craft is taking the closest images and also looking at the sun's uncharted polar regions for the first time ever. </p><p class=\"paragraph-427\">&nbsp;</p><p class=\"paragraph-427\">The data and observations will help answer questions that have long been mysteries to solar scientists. Why is the sun's corona so much hotter than its surface? Why does the sun's magnetic activity have an 11-year cycle? Why does the solar wind even exist? </p><p class=\"paragraph-427\">&nbsp;</p><p class=\"paragraph-427\">Just one more way that everyone at Lake Shore is <span class=\"text-351\">ADVANCING SCIENCE</span>! </p><br><img src=\"https://www.yammer.com/api/v1/uploaded_files/1297812873216/preview/?client_application_id=40443904&fallback_to_icon=false&file_type=image&network_id=674410&storage=SHAREPOINT&uid=1524097277952\"><br><br><br><br>";
        String currTime = Instant.now().toString();
        int pass = 0;
        int fail = 0;
        int uniqueFail = 0;
        double prRate = 0.0;
        double avgRuntime = 0.0000;
        double timeAtStart  = System.currentTimeMillis()/1000;
        double timeAtEnd = 0.0;
        int x = 1250;
        try {
            long firstTime = System.currentTimeMillis();
            long lastTime = System.currentTimeMillis();
            while (pass != 1 && x > 0) {
                String val = getData("1559814952", "null", "", "");
                if (val.equals("failcase1")) {
                    lastTime = System.currentTimeMillis();
                    fail++;
                } else if (val.equals("passcase1")) {
                    lastTime = System.currentTimeMillis();
                    timeAtEnd  = System.currentTimeMillis()/1000;

                    avgRuntime = (avgRuntime + (timeAtEnd - timeAtStart))/(1250-x);
                    pass++;

                } else {
                    lastTime = System.currentTimeMillis();
                    uniqueFail++;
                }
                prRate = 100 * (pass / x);
                //System.out.println("");
                //System.out.println("----------TESTCASE" + x + "----------");
                //System.out.println("result: " + val);
                //System.out.println("pass: " + pass);
                //System.out.println("fail: " + fail);
                //System.out.println("uniqueFail: " + uniqueFail);
                //System.out.println("prRate: " + prRate);
                //System.out.println("Time taken to run: " + (timeAtEnd - timeAtStart));
                //System.out.println("-------------------------");
                //System.out.println("");
                x--;
            }
        } catch (Exception e) {
            fail++;
        }
        double secondRuntime = System.currentTimeMillis()/1000;
        double secondLastRuntime = 0.0;
        File htmlTemplateFile = new File("C:\\Users\\alex.nanda\\IdeaProjects\\java-maven-yammersource\\src\\main\\java\\new.html");
        try {
            String htmlString = FileUtils.readFileToString(htmlTemplateFile, "UTF-8");
            ////System.out.println(lastly);
            String para1 = lastly.substring(0, lastly.indexOf("<br><br><br><br><p class="));
            para1=solveString(para1);
            para1=para1 + "<br><br><br><br>";
            String para1p1=para1;
            para1p1=para1.substring(para1.indexOf("<img src="));
            //System.out.println(para1p1);
            for(int i=0; i<para1p1.length(); i++)
            {
                if(para1p1.charAt(i)=='>')
                {
                    para1p1=para1p1.substring(0,i-1) + " style=\"float:right\"" + para1p1.substring(i);
                    break;
                }
            }
            para1 = para1.substring(0, para1.indexOf("<img src=")) + para1p1;
            htmlString = htmlString.replace("$p1", para1);
            //System.out.println(para1);
            //System.out.println(para1p1);
            ////System.out.println("para1 " + para1);
            int index = lastly.indexOf("<br><br><br><br><p class=");
            ArrayList<String> ptwotopten = new ArrayList<String>();
            int numiter=0;
            while (index >= 0) {
                //System.out.println("index " + index);
                if(lastly.indexOf("<br><br><br><br><p class=", index + 1)>0)
                {
                    //at least one more left

                    ptwotopten.add(lastly.substring(index, lastly.indexOf("<br><br><br><br><p class=", index + 1)));
                    index = lastly.indexOf("<br><br><br><br><p class=", index + 1);
                    //System.out.println(ptwotopten.get(numiter));
                }
                else
                {
                    //at last post
                    ptwotopten.add(lastly.substring(index));
                    index = -1;
                    //System.out.println(ptwotopten.get(numiter));
                }
                numiter++;
                //index = lastly.indexOf("<br><br><br><br><p class=", index + 1);
                //System.out.println(("lastly at index " + index + " is " + lastly.substring(index, lastly.indexOf("<br><br><br><br><p class=", index + 1))));
                //ptwotopten.add(lastly.substring(index, lastly.indexOf("<br><br><br><br><p class=", index + 1)));
            }
            int numIterTwo =0;
            for(String b: ptwotopten)
            {
                b=solveString(b);
                String parapb = b.substring(b.indexOf("<img src="));
                for(int i=0; i<parapb.length(); i++)
                {
                    if(parapb.charAt(i)=='>')
                    {
                        parapb=parapb.substring(0,i-1) + " style=\"float:right\"" + parapb.substring(i);
                        break;
                    }
                }
                b = b.substring(0, b.indexOf("<img src=")) + parapb;
                //System.out.println(b);
                //System.out.println(numIterTwo+2);
                int whydoesthisevenhappen = numIterTwo+2;
                String toReplace = "$p" + whydoesthisevenhappen;
                //System.out.println(toReplace);
                htmlString = htmlString.replace(toReplace, b);
                numIterTwo++;
            }
            //System.out.println(htmlString.contains("$p1"));
            //System.out.println(htmlString.contains("$p2"));
            ////System.out.println("para2 " + para2);
            File newHtmlFile = new File("C:\\Users\\alex.nanda\\IdeaProjects\\java-maven-yammersource\\output\\index.html");
            FileUtils.writeStringToFile(newHtmlFile, htmlString, "UTF-8");
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }
            boolean success = false;
            while(!success) {
                try {
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("incognito");
                    options.addArguments("start-maximized");
                    ChromeDriver driver = new ChromeDriver(options);
                    //driver.manage().window().setPosition(new Point(-20000, 0));
                    driver.get("https://github.com/login?return_to=https%3A%2F%2Fgithub.com%2Fyammerlakeshore%2Fyammerlakeshore.github.io");
                    List<WebElement> someElements = driver.findElements(By.id("login_field"));
                    for (WebElement anElement : someElements) {
                        if (anElement.getAttribute("name").equals("login")) {
                            anElement.sendKeys("");
                        }
                    }
                    List<WebElement> somePasswords = driver.findElements(By.id("password"));
                    for (WebElement anElement : somePasswords) {
                        if (anElement.getAttribute("name").equals("password")) {
                            anElement.sendKeys("");
                            anElement.sendKeys(Keys.ENTER);
                        }
                    }
                    try
                    {
                        Thread.sleep(2500);
                    }
                    catch (Exception e)
                    {
                    }
                    List<WebElement> someFiles = driver.findElements(By.xpath("//*[@id=\"repo-content-pjax-container\"]/div/div/div[3]/div[1]/div[3]/div[3]/div[1]/div[2]/div[2]/span/a"));
                    for (WebElement anElement : someFiles) {
                        if (anElement.getAttribute("title").equals("index.html")) {
                            anElement.click();
                        }
                    }
                    try
                    {
                        Thread.sleep(1000);
                    }
                    catch (Exception e)
                    {
                    }
                    List<WebElement> someEdits = driver.findElements(By.xpath("//*[@id=\"repo-content-turbo-frame\"]/div/div/div[4]/div[1]/div[2]/div[2]/div[1]/form/button"));
                    for (WebElement anElement : someEdits) {
                        if (anElement.getAttribute("title").equals("Edit this file")) {
                            anElement.click();
                        }
                    }
                    try
                    {
                        Thread.sleep(1000);
                    }
                    catch (Exception e)
                    {
                    }
                    List<WebElement> someClicks = driver.findElements(By.xpath("//*[@id=\"code-editor\"]/div[1]/pre/span/span"));
                    for (WebElement anElement : someClicks) {
                        if (anElement.getAttribute("class").equals("cm-meta")) {
                            anElement.click();
                        }
                    }
                    WebElement currentElement = driver.switchTo().activeElement();
                    currentElement.sendKeys(Keys.CONTROL + "a");
                    currentElement.sendKeys(Keys.DELETE);
                    StringBuilder contentBuilder = new StringBuilder();
                    try {
                        BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream("C:\\Users\\alex.nanda\\IdeaProjects\\java-maven-yammersource\\output\\index.html"), "UTF-8"));
                        String str;
                        while ((str = in.readLine()) != null) {
                            contentBuilder.append(str);
                            currentElement.sendKeys(str);
                            currentElement.sendKeys(Keys.ENTER);
                        }
                        in.close();
                    } catch (IOException e) {
                    }
                    content = contentBuilder.toString();
                    try
                    {
                        Thread.sleep(1000);
                    }
                    catch (Exception e)
                    {
                    }
                    Date date = new Date();
                    LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                    int year = localDate.getYear();
                    int month = localDate.getMonthValue();
                    int day = localDate.getDayOfMonth();
                    List<WebElement> someCommits = driver.findElements(By.xpath("//*[@id=\"commit-summary-input\"]"));
                    for (WebElement anElement : someCommits) {
                        if (anElement.getAttribute("type").equals("text")) {
                            anElement.click();
                            anElement.sendKeys("Update " + month + "/" + day + "/" + year);
                        }
                    }
                    try
                    {
                        Thread.sleep(1000);
                    }
                    catch (Exception e)
                    {
                    }
                    List<WebElement> someSaves = driver.findElements(By.xpath("//*[@id=\"submit-file\"]"));
                    for (WebElement anElement : someSaves) {
                        if (anElement.getAttribute("type").equals("submit")) {
                            anElement.click();
                        }
                    }
                    try
                    {
                        Thread.sleep(1000);
                    }
                    catch (Exception e)
                    {
                    }
                    driver.quit();

                    secondLastRuntime = System.currentTimeMillis()/1000;
                    double totalRuntime = avgRuntime + secondRuntime-secondLastRuntime;
                    //System.out.println("TOTAL AVERAGE RUNTIME: " + totalRuntime);
                    success = true;
                }
                catch (Exception e)
                {

                    throw new RuntimeException(e);

                }
            }
    }

    public static String getData(String userID, String target, String username, String pass) throws IOException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("incognito");
        options.addArguments("start-maximized");
        ChromeDriver driver = new ChromeDriver(options);
        //driver.manage().window().setPosition(new Point(-20000, 0));
        try {
            long timeStart = System.currentTimeMillis();
            long timeEnd = System.currentTimeMillis();
            Date date = new Date();
            LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            int year = localDate.getYear();
            int month = localDate.getMonthValue();
            int day = localDate.getDayOfMonth();
            driver.get("https://login.microsoftonline.com/common/oauth2/authorize?client_id=00000005-0000-0ff1-ce00-000000000000&domain_hint=lakeshore.com&msafed=0&nonce=3ff7b976fcfdf4036f7f800c00b067f9555977d10dd53d00112f0565f9a8e79c&redirect_uri=https%3A%2F%2Fpersona.yammer.com%2Foffice_sessions%3F&resource=https%3A%2F%2Fwww.yammer.com%2F&response_mode=form_post&response_type=id_token+code&scope=open_id&site_id=501393&state=1f5398bb9ab572287b8c42027101dc60caba89709b2d8787c963835a1a5474dc&sso_reload=true");
            try {
                Thread.sleep(2500);
            } catch (Exception e) {
                return "failcase1";
                //throw new RuntimeException("Error occurred in loading webpage, check that you have an internet connection.");
            }
            //////System.out.printlnn(driver.getCurrentUrl());
            //////System.out.printlnn("------------page-current-source----------");
            //////System.out.printlnn(driver.getPageSource());
            //////System.out.printlnn("------------end-page-current-source------");
            List<WebElement> someElements = driver.findElements(By.cssSelector("input"));
            //this is the problem here with some elements
            //////System.out.printlnn(someElements.size());
            for (WebElement anElement : someElements) {
                if (anElement.getAttribute("name").equals("loginfmt")) {
                    anElement.sendKeys(username);
                    //////System.out.printlnn("clicked the button");
                }
            }
            //////System.out.printlnn("finished send login-lookup-container");
            List<WebElement> someElements2 = driver.findElements(By.id("idSIButton9"));
            for (WebElement anElement : someElements2) {
                if (anElement.getAttribute("type").equals("submit")) {
                    anElement.click();
                    //////System.out.printlnn("clicked the button");
                }
            }
            ////////System.out.printlnn(someElements.size());
            try {
                Thread.sleep(2500);
            } catch (Exception e) {
                return "failcase1";
                //throw new RuntimeException("Error occurred in loading webpage, check that you have an internet connection.");
            }
            //////System.out.printlnn("input pasasssword!!");
            List<WebElement> Pass = driver.findElements(By.id("i0118"));
            //////System.out.printlnn(Pass.size());
            for (WebElement anElement : Pass) {
                if (anElement.getAttribute("name").equals("passwd")) {
                    ////////System.out.printlnn("-------occurs");
                    anElement.sendKeys(pass);
                }
            }
            List<WebElement> passSubmit = driver.findElements(By.id("idSIButton9"));
            //////System.out.printlnn(passSubmit.size());
            for (WebElement anElement : passSubmit) {
                anElement.click();
            }
            //////System.out.printlnn("finished sign in");
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
                    //////System.out.printlnn("clicked no stay sign in key");
                }
            }
            //////System.out.printlnn("clicked no sign in option");
            //////System.out.printlnn(driver.getCurrentUrl());
            //////System.out.printlnn("faield to exit");
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
            ////System.out.printlnn("clicks the see more  + size  " + seeMore.size());
            for (WebElement anElement : seeMore) {
                if (anElement.getAttribute("class").equals("link-98") && anElement.getText().equals("see more")) {
                    anElement.click();
                    //////System.out.printlnn("clicks see more onc");
                }
            }
            // ////System.out.printlnn(driver.getCurrentUrl());
            ArrayList<WebElement> pathList = new ArrayList<WebElement>();
            List<WebElement> textBoxes = driver.findElements(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[2]/div/div/div/div/div/div[2]/ul/li[1]/div/div/div/div/div/div/div[1]/div[3]/div/div/div/span[1]"));
            //////System.out.printlnn("--------what we are looking for length: " + textBoxes.size());
            //////System.out.printlnn("here index zero: " + textBoxes.get(0).getAttribute("innerHTML"));
            //////System.out.printlnn("here: " + textBoxes.get(1).getAttribute("innerHTML"));
            // ////System.out.printlnn("index zero text: " + textBoxes.get(0).getText());
            //////System.out.printlnn("index one text: " + textBoxes.get(1).getText());
            for (int i = 1; i < 50; i++) {
                //////System.out.printlnn("iteration number" + i );
                if (driver.findElements(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[2]/div/div/div/div/div/div[2]/ul/li[" + i + "]/div/div/div/div/div/div/div[1]/div[3]/div/div/div/span[1]")).size() != 0) {
                    pathList.add(driver.findElement(By.xpath(new String("//*[@id=\"root\"]/div/div[2]/div/div[2]/div/div/div/div/div/div[2]/ul/li[" + i + "]/div/div/div/div/div/div/div[1]/div[3]/div/div/div/span[1]"))));
                }
            }
            String allTexts = "";
            int j=1;
            ////System.out.printlnn("pathList size: " + pathList.size());
            for (WebElement anElement : pathList) {
                allTexts = allTexts + anElement.getAttribute("innerHTML");
                for (int i = 0; i < 50; i++) {
                    if (i==j && driver.findElements(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[2]/div/div/div/div/div/div[2]/ul/li[" + i + "]/div/div/div/div/div/div/div[1]/div[4]/ul/li/div/button/div/img")).size() != 0) {
                        //System.out.println("foundElement" + i);
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
            ////System.out.printlnn("parses text");
            ////System.out.printlnn("allTexts: " + allTexts);
            BufferedWriter writer = new BufferedWriter(new FileWriter("output" + month + day + year));
            writer.write(allTexts);
            ////System.out.printlnn("writes text");
            writer.close();
            driver.quit();
            //System.out.println(allTexts);
            File exists = new File("C:\\Users\\alex.nanda\\IdeaProjects\\java-maven-yammersource\\output\\output" + month + day + year + ".txt");
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
        if(result.substring(0, 16).equals("<br><br><br><br>")) {
            ////System.out.println("found");
            result = result.substring(16);
        }
        return result;
    }
}
