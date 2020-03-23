package org.prigorelo.support

import geb.Browser

class BackgroundHelper {
    public static void customizeBackground(Browser browser){
        try{
            def theme = System.getProperty("prigorelo.theme")
            def urls = new File("./src/test/resources/themes/${theme}/pictures/background.txt").readLines()
            def index = new Random().nextInt(urls.size())
            def style = "background-image: url(\"${urls[index]}\"); background-position: center; background-repeat: repeat; background-size: initial;"
            if(!browser.driver.pageSource.contains(urls[index])){
                browser.driver.executeScript("document.getElementsByTagName('body')[0].setAttribute('style', '${style}')")
            }
        }
        catch(Exception e){}
    }
}
