<h1> Yammer Web Scraping Tool <h1>
<h2> made for Lake Shore Cryotronics <h2>

This project can be generalized to fit any yammer website by changing the url, and changing the static approach to 
logging into the website.


> Alexander Nanda\
> LakeShore Yammer TV Guide
>
> What does the project use heavily?
>
> Maven

Used to get external dependencies

> Java

Programming Language

> Selenium

Library for java to interact with the web

> Github

To store updates to the project

> Installation:\
> Download Intellij Idea\
> Download any extensions needed (maven, java)\
> Download corretto jdk 16 in intellij\
> (if maven is not already installed then install it through extensions
> window intellij)\
> Download project file here:\
> Run it and make sure it works properly\
> Replace the file=new file for html template file with the absolute
> path of the source access file\
> Replace the file new html file = new file (index.html) with the
> absolute path of where the index.html file is located\
> Do the same for where the buffered reader in constructed\
> Open textpad\
> Copy the first line of the run output from intellij (something like
> C;/....) Paste that in the txt file\
> Press ctrl+s and name it yammerlakeshoretv.**bat**\
> ***[Setup whatever IT wants to use in place of task
> scheduler]{.ul}***\
> My guess for errors:\
> Yammer updates style of website\
> Look at the method getYammerFeed, follow code comments and see if this
> has changed when you have a browser open. The error should be obvious
> in the UI.
>
> If a problem like this does occur, then follow the code comments,
> identify in which locator comment this occurs, and then enter inspect
> element mode on chrome to find if the element itself has changed
> because\
> Selenium cannot locate it.
>
> Github updates style of website
>
> Look at the method publishChanges, follow code comments and see if
> this has changed when you have a browser open. The error should be
> obvious in the UI.
>
> If a problem like this does occur, then follow the code comments,
> identify in which locator comment this occurs, and then enter inspect
> element mode on chrome to find if the element itself has changed
> because\
> Selenium cannot locate it.
>
> The thread.sleeps are not long enough.
>
> The error like this might look it is running forever or it simply
> never stops running. Make the thread.sleep() parts take in a larger ms
> value and it should load just fine then. If this does not work, you
> could have someone attempt to make a thread.sleep that is relative to
> your current processor % dedicated to chrome and current % it is using
> so you can get effective yet not wasteful thread.sleep's.
>
> Dependency no longer supported.
>
> Redownload from the azure repository and follow setup instructions
> again. If prompted to update dependencies, click NO.
>
> You updated a dependency and it no longer works
>
> Redownload from the azure repository and follow setup instructions
> again. If prompted to update dependencies, click NO.
>
> You Don't have chrome installed

Download Chrome

> You don\'t have java installed

Download intellij, install amazon corretto 16

> You don\'t have maven installed

Download intellij, it will already be installed.

> You updated maven
>
> Uninstall and reinstall intellij. OR follow maven version change via
> the command line. (mvn clean etc.....)
>
> One of the dependencies is no longer supported (debugger should show
> this)
>
> Look for other solutions to this if you can't rollback your version,
> otherwise just reinstall and follow setup steps from azure.
>
> Something in your laptop is not configured properly (permissions,
> etc.)

Run as administrator, if this does not solve the issue, talk with IT.

> It doesn't compile
>
> This should be easy to follow. You likely didn't update the file
> paths, install java, or install maven. If you think you did all of
> these, close Intellij
>
> from Task Manager, restart, and try again. There are bugs in
> installing external libraries with maven upon first boot in intellij,
> but this should be solved with time.
>
> The newest version of Intellij does not support some type aspect of
> these projects (maven, java)
>
> Although this would be [highly unlikely]{.ul}, look at the Intellij
> IDEA\
> Community build guidelines. If there is nothing immediate on the
> release notes that resolves this problem, look into installing the
> paid version of Intellij IDEA Ultimate or run this project on
> someone's laptop who does have this.
>
> You have a Unique Fail
>
> Follow the following instructions on how to use the Test Service and
> then let this run. Look at your terminal's output and follow the
> output. If you have a unique fail, likely something is not configured
> properly with your laptop (java, maven, etc.) or yammer, github login
> has changed, or some major change.
>
> Test Service\
> The "Test Service" really is a more verbose output upon running the
> program. To "enable" the test service, just uncomment all lines with a
> System.out.println If some error, resolve those or remove them, but
> the basic Fail/Pass/Unique Fail logic will work no matter what\
> Go in and read the comments for Unique Fails, Passes, and Fails within
> the project to understand what each of them means.
>
> In its current state, NO unique fails occur upon running, even when
> the program fails. Follow the procedure for resolving this in the
> above section.
>
> Unique errors do not occur upon execution and testing with this
> currently.
>
> Other Errors\
> Does it really error?

Be patient. It can take some time to run (avg over 1250 tests was
36.6s).

Make sure you let it run completely [without]{.ul} touching the windows.

> I don't know!!!!
>
> Do you have wifi? Do you have chrome? Intellij? Java? Maven? Are there
> any complaining errors? Have you looked at the terminal? Have you read
> through the code so you can actually understand what is happening?
> Read the comments.
>
> **[Statistics:]{.ul}**
>
> Basic Runtime Stats:

+-------------+--------------+--------------+-----------+--------------+
| > \# Tests  | \% Pass Rate | > \# Success | > \# Fail | > \# UniqueF |
+=============+==============+==============+===========+==============+
| > 10 Tests  | > 80         | > 8          | > 2       | > 0          |
+-------------+--------------+--------------+-----------+--------------+
| > 25 Tests  | > 72         | > 18         | > 7       | > 0          |
+-------------+--------------+--------------+-----------+--------------+
| > 192 Tests | > 77.1       | > 148        | > 44      | > 0          |
+-------------+--------------+--------------+-----------+--------------+

> (Note, when it fails, it runs again, so it never really "fails")\
> More info:

+-------------+-------------+-------------+-------------+-------------+
| > Runtime\  | > Runtime   | > Runtime   | > Runtime   | > Total\    |
| > Breakdown | > to get    | > to\       | > to\       | > Runtime   |
|             | > yammer    | > parse,    | > copy HTML | > (approx)  |
|             | > source    | > format,   | > to Github |             |
|             |             | > HTML      |             |             |
+=============+=============+=============+=============+=============+
|             | > 27.3 s    | > 0.3 s     | > \~9 s     | > 36.6 s    |
|             | > (avg of   | > (avg of   |             |             |
|             | > 674)      | > 674)      |             |             |
+-------------+-------------+-------------+-------------+-------------+

+------------+-----------+-------------+-----------+--------------+
| > \# Tests | > \% Pass | > \#Success | > \# Fail | > \# UniqueF |
+============+===========+=============+===========+==============+
| > 674      | > 77.8    | > 525       | > 149     | > 0          |
+------------+-----------+-------------+-----------+--------------+
