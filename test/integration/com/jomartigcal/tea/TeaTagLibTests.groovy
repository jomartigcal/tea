package com.jomartigcal.tea

import org.codehaus.groovy.grails.commons.ApplicationHolder 

import grails.test.*

class TeaTagLibTests extends TagLibUnitTestCase {
	StringWriter out

    void setUp() {
		super.setUp()
        out = new StringWriter()
        TeaTagLib.metaClass.out = out
    }

    void tearDown() {
		super.tearDown()
        def remove = GroovySystem.metaClassRegistry.&removeMetaClass
        remove TeaTagLib
    }

    void testCopyright() {
		def tagLib = new TeaTagLib()
		def output = tagLib.copyright()
		def appName = ApplicationHolder.application.metadata['app.name'].toUpperCase()
		def appVersion = ApplicationHolder.application.metadata['app.version']
		def expectedOutput = appName + " " + appVersion + " Copyright &copy; 2010"	
		assertEquals "Taglib should display the correct output", expectedOutput, out.toString() 
    }
}
