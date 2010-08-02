package com.jomartigcal.tea

import org.codehaus.groovy.grails.commons.ApplicationHolder 

import grails.test.*

class TeaTagLibTests extends TagLibUnitTestCase {
    protected void setUp() {
        super.setUp()
    }

    protected void tearDown() {
        super.tearDown()
    }

    void testCopyright() {//FIXME failing test case
		mockTagLib(TeaTagLib)
		
		def tagLib = new TeaTagLib()
		def output = tagLib.copyright()
		def expectedOutput = ApplicationHolder.application.metadata['app.version'] + "&copy; 2010"
		assertEquals "Taglib should display the correct output", expectedOutput, output 
    }
}
