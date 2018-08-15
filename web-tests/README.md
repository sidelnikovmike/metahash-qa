# Web tests

This module contains all web tests


## Functional tests

package `ru.metahash.tests.functional` contains functional tests:
* LocalizationTests - tests to check localization
* NavigationTests - tests to check sidebar navigation
* PromoBlockTests - tests to check main behaviour of first `promo` block of the main page

To run tests locally in chrome browser, run the following command:

    mvn clean test -Dtest=LocalizationTests,NavigationTests,PromoBlockTests -Dbrowser.name=chrome
    
Or you may run them in selenoid. For this:
* go to `selenoid` folder
* run `run_selenoid.sh` file
* run tests via command:
            

    mvn clean test -Dis.local=false -Dbrowser.name=chrome -Dbrowser.version=67.0 -Dremote.hub.url=http://localhost:4444/wd/hub    

To make an allure report after tests run, use command:

    mvn allure:serve
    
and it will open report in your browser    

## ScreenshotMaker tests

Also here is "test" to make full, "smart" screenshots for specified browsers. 
List of browsers you could find in `ru.metahash.tests.core.browser.configuration.reader.impl.LocalConfigurationReader`.
By modifing this file you could add or remove browsers, or check, how to run browser - locally, in selenoid or in 
<a href="http://crossbrowsertesting.com">crossbrowsertesting</a> 

To run tests to get screenshots:

    mvn clean test -Dtest=ScreenShotMakerTest -Dcbt.user.name=your_cbt_account -Dcbt.api.key=your_cbt_api_key

To make an allure report after tests run, use command:

    mvn allure:serve
    
and it will open report in your browser    

## Configuration parameters

You could configure url to run your tests on by adding parameter to run command:

    -Dbase.site.url=http://metahash.org    