package org.prigorelo.page

import geb.Page

class TestPage extends Page{
    static url = "/test"

    static content = {
        inputFormsMenu(wait:true){ $("ul.navbar-nav li.dropdown a")[0] }
        simpleFormDemoMenu(wait:true){ $("ul.navbar-nav li.dropdown.open ul.dropdown-menu a")[0] }
    }

    static at = {
        inputFormsMenu.displayed
    }
}
