package org.prigorelo.page

import geb.Page
import geb.module.TextInput

class SimpleFormDemoPage extends Page{
    static content = {
        userMessageInput(wait:true){ $("input#user-message").module(TextInput) }
        showMessageButton(wait:true){ $("form#get-input button") }
        yourMessageText(wait:true){ $("div#user-message span#display") }
    }

    static at = {
        title.contains("Simple Form")
    }

}
