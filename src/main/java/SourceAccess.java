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
        //First part of the program, gets the post info from Yammer and adds it to a file.
        getYammerFeed();

        //Second part of the program, parses HTML text file, uses new.html as template, writes to index.html with changes.
        parseHtml();

        //Third part of the program, logs into GitHub, writes changes from index.html into index.html of the project.
        publishChanges();
    }

    public static void publishChanges()
    {
        //double secondRuntime = System.currentTimeMillis()/1000;
        //double secondLastRuntime = 0.0;
        //This is just used for the testing service, collects data on runtime.
        boolean success = false;
        while(!success) {
            //Until this part of the program succeeds, it keeps on trying.
            try {
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("incognito");
                options.addArguments("start-minimized");
                ChromeDriver driver = new ChromeDriver(options);
                driver.manage().window().setPosition(new Point(-20000, 0));
                driver.get("https://github.com/login?return_to=https%3A%2F%2Fgithub.com%2Fyammerlakeshore%2Fyammerlakeshore.github.io");
                //Opens login page for github pages project at github.com/yammerlakeshore/yammerlakeshore.github.io.
                List<WebElement> someElements = driver.findElements(By.id("login_field"));
                //Locates login field.
                for (WebElement anElement : someElements) {
                    if (anElement.getAttribute("name").equals("login")) {
                        anElement.sendKeys("");
                        //Types username in login field.
                    }
                }
                List<WebElement> somePasswords = driver.findElements(By.id("password"));
                //Locates password field.
                for (WebElement anElement : somePasswords) {
                    if (anElement.getAttribute("name").equals("password")) {
                        anElement.sendKeys("");
                        anElement.sendKeys(Keys.ENTER);
                        //Types password in password field and waits for github to redirect.
                    }
                }
                //Waits for github to redirect.
                try
                {
                    Thread.sleep(2500);
                }
                catch (Exception e)
                {
                }
                //Locates the index.html file in the project.
                List<WebElement> someFiles = driver.findElements(By.xpath("//*[@id=\"repo-content-pjax-container\"]/div/div/div[3]/div[1]/div[3]/div[3]/div[1]/div[2]/div[2]/span/a"));
                for (WebElement anElement : someFiles) {
                    if (anElement.getAttribute("title").equals("index.html")) {
                        anElement.click();
                        //Clicks into the index.html file in the project so that you can edit it in the text editor.
                    }
                }
                //Waits for github to redirect.
                try
                {
                    Thread.sleep(1000);
                }
                catch (Exception e)
                {
                }
                //Locates the text editor within the index.html file on github.
                List<WebElement> someEdits = driver.findElements(By.xpath("//*[@id=\"repo-content-turbo-frame\"]/div/div/div[4]/div[1]/div[2]/div[2]/div[1]/form/button"));
                for (WebElement anElement : someEdits) {
                    if (anElement.getAttribute("title").equals("Edit this file")) {
                        anElement.click();
                        //Clicks on the edit file button within the index.html file in github.
                    }
                }
                //Waits for github to redirect.
                try
                {
                    Thread.sleep(1000);
                }
                catch (Exception e)
                {
                }
                //Finds the first line within the github text editor.
                List<WebElement> someClicks = driver.findElements(By.xpath("//*[@id=\"code-editor\"]/div[1]/pre/span/span"));
                for (WebElement anElement : someClicks) {
                    if (anElement.getAttribute("class").equals("cm-meta")) {
                        anElement.click();
                        //Clicks on the first line within the text editor so that it can now edit the index.html file.
                    }
                }
                WebElement currentElement = driver.switchTo().activeElement();
                //Switches the current element to the text editor.
                currentElement.sendKeys(Keys.CONTROL + "a");
                currentElement.sendKeys(Keys.DELETE);
                //Deletes the current text in the text editor.`
                StringBuilder contentBuilder = new StringBuilder();
                try {
                    //Writes in the new content from the index.html file.
                    BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream("C:\\Users\\alex.nanda\\IdeaProjects\\java-maven-yammersource\\output\\index.html"), "UTF-8"));
                    String str;
                    while ((str = in.readLine()) != null) {
                        //Iteratively reads from the index.html file and writes each line to the github text editor.
                        contentBuilder.append(str);
                        currentElement.sendKeys(str);
                        currentElement.sendKeys(Keys.ENTER);
                    }
                    in.close();
                } catch (IOException e) {
                }
                content = contentBuilder.toString();
                //Waits for this process to finish.
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
                //Locates the commit changes box.
                List<WebElement> someCommits = driver.findElements(By.xpath("//*[@id=\"commit-summary-input\"]"));
                for (WebElement anElement : someCommits) {
                    if (anElement.getAttribute("type").equals("text")) {
                        //Once clicked on the commit changes box it types the commit message as an update.
                        //ex: Update 6/28/2022
                        anElement.click();
                        anElement.sendKeys("Update " + month + "/" + day + "/" + year);
                    }
                }
                //Waits for github to register.
                try
                {
                    Thread.sleep(1000);
                }
                catch (Exception e)
                {
                }
                List<WebElement> someSaves = driver.findElements(By.xpath("//*[@id=\"submit-file\"]"));
                //Locates the save button.
                for (WebElement anElement : someSaves) {
                    if (anElement.getAttribute("type").equals("submit")) {
                        //Submits changes.
                        anElement.click();
                    }
                }
                //Waits for this process to finish.
                try
                {
                    Thread.sleep(1000);
                }
                catch (Exception e)
                {
                }
                //Closes Chrome driver, etc.
                driver.quit();
                //secondLastRuntime = System.currentTimeMillis()/1000;
                //double totalRuntime = avgRuntime + secondRuntime-secondLastRuntime;
                //System.out.println("TOTAL AVERAGE RUNTIME: " + totalRuntime);
                success = true;
            }
            catch (Exception e)
            {
                throw new RuntimeException(e);
            }
        }
    }


    public static void parseHtml()
    {
        //Makes the template for the HTML file.
        //This template is called new.html, and it contains dynamic elements where you can add in the html source code for the posts.
        File htmlTemplateFile = new File("C:\\Users\\alex.nanda\\IdeaProjects\\java-maven-yammersource\\src\\main\\java\\new.html");
        try {
            String htmlString = FileUtils.readFileToString(htmlTemplateFile, "UTF-8");
            //Takes the HTML template file and makes it into a string.
            String para1 = lastly.substring(0, lastly.indexOf("<br><br><br><br><p class="));
            //The first ppst is the string from the first post to the start of the second post.
            para1=solveString(para1);
            //Solves the string for the first post.
            para1=para1 + "<br><br><br><br>";
            String para1p1=para1;
            para1p1=para1.substring(para1.indexOf("<img src="));
            //Finds where the image source is located in the string that contains the first post.
            for(int i=0; i<para1p1.length(); i++)
            {
                if(para1p1.charAt(i)=='>')
                {
                    para1p1=para1p1.substring(0,i-1) + " style=\"float:right\"" + para1p1.substring(i);
                    //Adds float styling to the image.
                    break;
                }
            }
            para1 = para1.substring(0, para1.indexOf("<img src=")) + para1p1;
            htmlString = htmlString.replace("$p1", para1);
            //Finds where $p1 is in the HTML template and replaces it with the first post.
            int index = lastly.indexOf("<br><br><br><br><p class=");
            ArrayList<String> ptwotopten = new ArrayList<String>();
            int numiter=0;
            while (index >= 0) {
                //If it enters this loop, then it means that there is at least one more post to look at from the HTML source code.
                if(lastly.indexOf("<br><br><br><br><p class=", index + 1)>0)
                {
                    ptwotopten.add(lastly.substring(index, lastly.indexOf("<br><br><br><br><p class=", index + 1)));
                    index = lastly.indexOf("<br><br><br><br><p class=", index + 1);
                    //Gets the entire string containing the source text code for the post as well as the image source for the html.
                }
                else
                {
                    //In this case, it is at the last post in the HTML source code.
                    ptwotopten.add(lastly.substring(index));
                    index = -1;
                    //Gets the entire string containing the source text code for the post as well as the image source for the html.
                }
                numiter++;
                //Uses numiter as a pointer to see which post it is currently at in the list.
            }

            int numIterTwo =0;
            for(String b: ptwotopten)
            {
                //Properly formats the image source of this post.
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
                int whydoesthisevenhappen = numIterTwo+2;
                String toReplace = "$p" + whydoesthisevenhappen;
                //Makes it so that you can dynamically in the number of posts that are there to the new.html file.
                //For example, if you had 30 posts, then you could just choose to display the first two posts with adding $p1 and $p2 to the new.html file.
                htmlString = htmlString.replace(toReplace, b);
                //Replaces the new.html file with the $p2, $p3, $p4, etc.
                //Uses numIterTwo as a pointer to see which post it is currently at in the list.
                numIterTwo++;
            }
            //Writes these changes to index.html file.
            File newHtmlFile = new File("C:\\Users\\alex.nanda\\IdeaProjects\\java-maven-yammersource\\output\\index.html");
            FileUtils.writeStringToFile(newHtmlFile, htmlString, "UTF-8");
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }
    }


    public static void getYammerFeed()
    {
        //First part of the program, logs onto yammer through Chrome browser, gets post and img html source code, and saves it to a file.
        String currTime = Instant.now().toString();
        int pass = 0;
        int fail = 0;
        int uniqueFail = 0;
        double prRate = 0.0;
        //double avgRuntime = 0.0000;
        //double timeAtStart  = System.currentTimeMillis()/1000;
        //double timeAtEnd = 0.0;
        int x = 1250;
        //This is for testing purposes only, collects data on runtime, pass fail rate, average runtime, and number of unique fails.
        try {
            //long firstTime = System.currentTimeMillis();
            //long lastTime = System.currentTimeMillis();
            //Until it has properly got the source code and html code as a text file, it will keep trying.
            while (pass != 1 && x > 0) {
                //Get data method logs into yammer and gets the source code of the post and the html code of the image.
                String val = getData("1559814952", "null", "", "");
                if (val.equals("failcase1")) {
                    //lastTime = System.currentTimeMillis();
                    //Fails are common issues caused by a number of formatting issues with Yammer and getting these elements through Selenium.
                    fail++;
                } else if (val.equals("passcase1")) {
                    //lastTime = System.currentTimeMillis();
                    //timeAtEnd  = System.currentTimeMillis()/1000;
                    //avgRuntime = (avgRuntime + (timeAtEnd - timeAtStart))/(1250-x);
                    //Passes are cases when the program successfully got the source code and html code as a text file.
                    pass++;
                } else {
                    //lastTime = System.currentTimeMillis();
                    //Unique fails are fails that I have not seen before, i.e. unhandled exception, new error, etc.
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
            //If it fails anywhere in this process then it counts it as a fail.
        }
    }

    public static String getData(String userID, String target, String username, String pass) throws IOException {
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
            //Goes to Yammer Microsoft login page
            driver.get("https://login.microsoftonline.com/common/oauth2/authorize?client_id=00000005-0000-0ff1-ce00-000000000000&domain_hint=lakeshore.com&msafed=0&nonce=3ff7b976fcfdf4036f7f800c00b067f9555977d10dd53d00112f0565f9a8e79c&redirect_uri=https%3A%2F%2Fpersona.yammer.com%2Foffice_sessions%3F&resource=https%3A%2F%2Fwww.yammer.com%2F&response_mode=form_post&response_type=id_token+code&scope=open_id&site_id=501393&state=1f5398bb9ab572287b8c42027101dc60caba89709b2d8787c963835a1a5474dc&sso_reload=true");
            try {
                Thread.sleep(2500);
            } catch (Exception e) {
                return "failcase1";
                //If this fails, you likely don't have a network connection.
            }
            //On the yammer login page now, locates the input button for your username.
            List<WebElement> someElements = driver.findElements(By.cssSelector("input"));
            for (WebElement anElement : someElements) {
                if (anElement.getAttribute("name").equals("loginfmt")) {
                    anElement.sendKeys(username);
                    //Sends username to login box on yammer login page.
                }
            }
            //Locates the submit username button.
            List<WebElement> someElements2 = driver.findElements(By.id("idSIButton9"));
            for (WebElement anElement : someElements2) {
                if (anElement.getAttribute("type").equals("submit")) {
                    anElement.click();
                    //Clicks the submit username button.
                }
            }
            //Waits for yammer to redirect you.
            try {
                Thread.sleep(2500);
            } catch (Exception e) {
                return "failcase1";
            }
            //Redirects you to the password submit page, locates the password input box.
            List<WebElement> Pass = driver.findElements(By.id("i0118"));
            for (WebElement anElement : Pass) {
                if (anElement.getAttribute("name").equals("passwd")) {
                    //Types in your password.
                    anElement.sendKeys(pass);
                }
            }
            List<WebElement> passSubmit = driver.findElements(By.id("idSIButton9"));
            //Finds the submit password button.
            for (WebElement anElement : passSubmit) {
                anElement.click();
                //Clicks the submit password button.
            }
            //Waits for yammer to redirect you.
            try {
                Thread.sleep(2500);
            } catch (Exception e) {
                return "failcase1";
            }
            //Exits out of the do you want to stay signed in page.
            List<WebElement> noSignIn = driver.findElements(By.id("idBtn_Back"));
            for (WebElement anElement : noSignIn) {
                if (anElement.getAttribute("class").equals("win-button button-secondary button ext-button secondary ext-secondary")) {
                    anElement.click();
                    //Clicks the button to not store my sign in.
                }
            }
            //Waits for yammer to redirect you.
            try {
                Thread.sleep(3500);
            } catch (Exception e) {
                return "failcase1";
            }
            //Checks if it redirected you to the two-factor login page.
            if (!driver.getCurrentUrl().equals("https://web.yammer.com/main/org/lakeshore.com/feed")) {
                if (driver.getCurrentUrl().equals("https://www.yammer.com/login")) {
                    //if you are on the two-factor login page then logs in again.
                    List<WebElement> clickUsername = driver.findElements(By.id("login"));
                    //Finds the username submit button.
                    for (WebElement anElement : clickUsername) {
                        if (anElement.getAttribute("type").equals("email")) {
                            anElement.click();
                            anElement.sendKeys(username);
                            anElement.sendKeys(Keys.ENTER);
                            //Types your username, submits it.
                        }
                    }
                }
            }
            //Waits for yammer to redirect you.
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                return "failcase1";
            }
            //Takes you to the yammer feed page.
            while (!driver.getCurrentUrl().equals("https://web.yammer.com/main/org/lakeshore.com/feed")) {
                //Waits for yammer to redirect you.
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    return "failcase1";
                }
            }
            //Waits for yammer to redirect you.
            try {
                Thread.sleep(2500);
            } catch (Exception e) {
                return "failcase1";
            }
            //Goes to the product development tab.
            driver.get("https://web.yammer.com/main/org/lakeshore.com/groups/eyJfdHlwZSI6Ikdyb3VwIiwiaWQiOiIxMTMxODUwMzAxNDQifQ/all");
            //Waits for yammer to redirect you.
            try {
                Thread.sleep(3500);
            } catch (Exception e) {
                return "failcase1";
            }
            //Finds all buttons on the page
            List<WebElement> seeMore = driver.findElements(By.tagName("button"));
            if (seeMore.size() == 0) {
                return "failcase1";
            }
            //If any of the buttons are the see more button, then it clicks it and opens up all of the posts.
            for (WebElement anElement : seeMore) {
                if (anElement.getAttribute("class").equals("link-98") && anElement.getText().equals("see more")) {
                    anElement.click();
                    //Clicks see more button.
                }
            }
            //Makes a list of all of the posts.
            ArrayList<WebElement> pathList = new ArrayList<WebElement>();
            //This x path here specifies the x path of the posts.
            List<WebElement> textBoxes = driver.findElements(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[2]/div/div/div/div/div/div[2]/ul/li[1]/div/div/div/div/div/div/div[1]/div[3]/div/div/div/span[1]"));
            //Up to 50 posts, loops through all of them.
            for (int i = 1; i < 50; i++) {
                if (driver.findElements(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[2]/div/div/div/div/div/div[2]/ul/li[" + i + "]/div/div/div/div/div/div/div[1]/div[3]/div/div/div/span[1]")).size() != 0) {
                    //If a post does exist at that x path, then it adds it to the list of posts as web elements.
                    pathList.add(driver.findElement(By.xpath(new String("//*[@id=\"root\"]/div/div[2]/div/div[2]/div/div/div/div/div/div[2]/ul/li[" + i + "]/div/div/div/div/div/div/div[1]/div[3]/div/div/div/span[1]"))));
                }
            }
            String allTexts = "";
            int j=1;
            //Loops through all of the posts.
            for (WebElement anElement : pathList) {
                allTexts = allTexts + anElement.getAttribute("innerHTML");
                for (int i = 0; i < 50; i++) {
                    if (i==j && driver.findElements(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[2]/div/div/div/div/div/div[2]/ul/li[" + i + "]/div/div/div/div/div/div/div[1]/div[4]/ul/li/div/button/div/img")).size() != 0) {
                        //For each of the web elements in the post list, it gets the image source by using j as a pointer and the x path of the post.
                        String finder = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[2]/div/div/div/div/div/div[2]/ul/li[" + i + "]/div/div/div/div/div/div/div[1]/div[4]/ul/li/div/button/div/img")).getAttribute("src");
                        String htmlFinder = "<img src=\"" + finder + "\">";
                        allTexts = allTexts + "<br>";
                        allTexts = allTexts + htmlFinder;
                        allTexts = allTexts + "<br>";
                        numPosts++;
                        //Adds each of the image sources to the end of the jth post and puts a break line in between them.
                    }
                }
                j++;
                allTexts = allTexts + new String("<br>");
                allTexts = allTexts + new String("<br>");
                allTexts = allTexts + new String("<br>");
                //Increments pointer J and then adds breaks to separate posts.
            }
            //Constructs a buffered writer to write the text to a file.
            BufferedWriter writer = new BufferedWriter(new FileWriter("output" + month + day + year));
            writer.write(allTexts);
            writer.close();
            driver.quit();
            //Closes the chrome window and the posts are now written as html to the file called output and your date.
            //Example: output6282022.txt
            File exists = new File("C:\\Users\\alex.nanda\\IdeaProjects\\java-maven-yammersource\\output\\output" + month + day + year + ".txt");
            lastly = allTexts;
            return "passcase1";
        } catch (Exception e) {
            //If this fails at any point, it returns failcase1 and then it will delete the file if it exists. This is to prevent the file from being empty the next iteration.
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
        //Takes in a string and formats it properly.
        String value = result;
        String last = result;
        ArrayList<String> paragraphInserts = new ArrayList<String>();
        ArrayList<String> imageNameInserts = new ArrayList<String>();
        if (result.contains("<br>")) {
            //if the post contains a break line, then it properly formats the start of the post with larger text.
            value = result.substring(0, result.indexOf("<span class="));
            last = result.substring(result.indexOf("<span class="), result.indexOf("</span>"));
            result = result.substring(0, result.indexOf("<span class=")+23)
                    + "<B><big><big><big>"
                    + result.substring(result.indexOf("<span class=")+23);
            result = result.substring(0, result.indexOf("</span>")+7)
                    + "</B></big></big></big>"
                    + result.substring(result.indexOf("</span>")+7);
            //Adds in the proper formatting to the header of the post.
        }
        if(result.substring(0, 16).equals("<br><br><br><br>")) {
            //Special case for the first post.
            result = result.substring(16);
        }
        return result;
    }
}
