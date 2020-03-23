package org.prigorelo.spec

import geb.spock.GebReportingSpec
import org.prigorelo.page.SimpleFormDemoPage
import org.prigorelo.page.TestPage
import org.prigorelo.support.SoundPlayer

class SeleniumEasySpec extends GebReportingSpec{

    def setupSpec(){
        SoundPlayer.playSound("setupSpec")
    }

    def "Selenium Easy UI Flow"(){
        when:
            to TestPage
            inputFormsMenu.click()
            simpleFormDemoMenu.click()
        then:
            at SimpleFormDemoPage
        when:
            def message = "Some test message 1"
            userMessageInput.text = message
            showMessageButton.click()
        then:
            yourMessageText.text() != message
    }

    def "Selenium Easy UI Flow 2"(){
        when:
            to TestPage
            inputFormsMenu.click()
            simpleFormDemoMenu.click()
        then:
            at SimpleFormDemoPage
        when:
            def message = "Some test message 2"
            userMessageInput.text = message
            showMessageButton.click()
        then:
            yourMessageText.text() == message
    }
    def "Selenium Easy UI Flow 3"(){
        when:
            to TestPage
            inputFormsMenu.click()
            simpleFormDemoMenu.click()
        then:
            at SimpleFormDemoPage
        when:
            def message = "Some test message 3"
            userMessageInput.text = message
            showMessageButton.click()
        then:
            yourMessageText.text() == message
    }
}
