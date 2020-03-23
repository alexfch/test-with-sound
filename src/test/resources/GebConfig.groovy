import geb.PageEventListenerSupport
import geb.report.ReportState
import geb.report.Reporter
import geb.report.ReportingListener
import org.openqa.selenium.chrome.ChromeOptions
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.UnexpectedAlertBehaviour
import org.openqa.selenium.remote.*

import geb.Browser
import geb.navigator.Navigator
import geb.navigator.event.NavigatorEventListenerSupport
import org.prigorelo.support.BackgroundHelper
import org.prigorelo.support.SoundPlayer
import geb.Page

System.setProperty("webdriver.chrome.driver", System.getProperty("webdriver.chrome.driver", "./BrowserDrivers/chromedriverMac"))
System.setProperty("geb.build.baseUrl", System.getProperty("geb.build.baseUrl", "https://www.seleniumeasy.com/"))
System.setProperty("prigorelo.theme", System.getProperty("prigorelo.theme", "coronavirus"))

driver = {
    ChromeOptions options = new ChromeOptions()
    options.addArguments("--start-maximized")
    options.addArguments("--no-sandbox")
    options.addArguments("disable-infobars")
    options.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.ACCEPT)

    def driver = new ChromeDriver(options)
    return driver
}

environments {
    "chrome" {
        driver = {
            ChromeOptions options = new ChromeOptions()
            options.addArguments("--start-maximized")
            options.addArguments("--no-sandbox")
            options.addArguments("disable-infobars")
            options.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.ACCEPT)

            def driver = new ChromeDriver(options)
            return driver
        }
    }
}

reportsDir = "build/geb-reports"
atCheckWaiting = 5
reportOnTestFailureOnly = false

navigatorEventListener = new NavigatorEventListenerSupport() {
    void afterClick(Browser browser, Navigator navigator) {
        SoundPlayer.playSound("click")
        sleep 1000
    }
    void afterSendKeys(Browser browser, Navigator navigator, Object value){
        SoundPlayer.playSound("sendKeys")
        sleep 1000
    }
    void afterValueSet(Browser browser, Navigator navigator, Object value){
        SoundPlayer.playSound("setValue")
        sleep 1000
    }
}

pageEventListener = new PageEventListenerSupport() {
    void beforeAtCheck(Browser browser, Page page){
        BackgroundHelper.customizeBackground(browser)
    }
}

reportingListener = new ReportingListener() {
    void onReport(Reporter reporter, ReportState reportState, List<File> reportFiles) {
        if(reportState.label.toLowerCase().endsWith("failure")){
            SoundPlayer.playSound("failure")
        }
    }
}