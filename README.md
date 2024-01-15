## ![Katalon Studio - Wikipedia](https://upload.wikimedia.org/wikipedia/commons/0/00/Katalon-logo-png.png) Katalon Studio Project

### **How to install Katalon Studio**

You just go to Katalon server [https://katalon.com/download](https://katalon.com/download) and click on Download button, Katalon will choose a suitable version for your machine and download it.  
If you are using Windows:

*   Click on downloaded KatalonSetup and it will automatically download Katalon Studio and set up for you.
*   After done, double-click on Katalon shortcut in your Desktop to open it.
*   Log in and enjoy (If you don't have an account, please create it, you must have an account to use Katalon)

If you are using Linux:

*   Extract donwloaded file tar.gz and cd to this folder
*   Double-click on Katalon shortcut in your Desktop to open it.
*   Log in and enjoy (If you don't have an account, please create it, you must have an account to use Katalon)

### Katalon Project

*   I'm using [https://minhtuanmobile.com](https://minhtuanmobile.com) for the test
*   The url was defined at profile with variable name base\_url
*   There are 3 test cases which I will share to you in the presentation, these are main ways to add a test case using Katalon (Spy Object, Record and self scripting)
*   The test suite consist these test cases.
*   There are the setup and tear down for test suite, the setup function is used to open browser and navigate to the URL, the tear down will close the browser after testing. So in case you want to run the specific test case, you must uncomment `openBrowser()` and `closeBrowser()` in that test case.
*   Setup and tear down was defined in Test Listeners folder.

### Reports

You can find the log in _**Reports**_ folder or _**TestOps**_ folder. The reports should be open manually by browser in case your license was expired (You will have license in 1 month)
