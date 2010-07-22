package com.jomartigcal.tea

import org.codehaus.groovy.grails.plugins.GrailsPluginManager;
import org.codehaus.groovy.grails.plugins.PluginManagerHolder;

import grails.test.*

class TeacherTests extends GrailsUnitTestCase {
    protected void setUp() {
        super.setUp()
		PluginManagerHolder.pluginManager = [hasGrailsPlugin: { String name -> true}] as GrailsPluginManager
    }

    protected void tearDown() {
        super.tearDown()
		PluginManagerHolder.pluginManager = null
    }

    void testConstraintsBlank() {
		mockForConstraintsTests(Teacher)
		
		def teacher = new Teacher(firstName: "", lastName:"")
		assertFalse "Teacher instance should not pass validation", teacher.validate()
		assertTrue "Teacher instance should have errors", teacher.hasErrors()
		assertEquals "First name cannot be blank", "blank", teacher.errors["firstName"]
		assertEquals "Last name cannot be blank", "blank", teacher.errors["lastName"];
    }
	
	void testConstraintsNull() {
		mockForConstraintsTests(Teacher)
		
		def teacher = new Teacher()
		assertFalse "Teacher instance should not pass validation", teacher.validate()
		assertTrue "Teacher instance should have errors", teacher.hasErrors()
		assertEquals "First name cannot be null", "nullable", teacher.errors["firstName"]
		assertEquals "Last name cannot be null", "nullable", teacher.errors["lastName"];
	}
	
	void testConstraintsValid() {
		mockForConstraintsTests(Teacher)
		
		def teacher = new Teacher(firstName: "Jomar", middleInitial: "C", lastName:"Tigcal")
		assertTrue "Teacher instance should pass validation", teacher.validate()
	}
	
	void testToString(){
		mockDomain(Teacher)
		
		def teacher = new Teacher(firstName: "Jomar", lastName:"Tigcal")
		assertToString teacher, "Tigcal, Jomar"
		teacher["middleInitial"] = "C"
		assertToString teacher, "Tigcal, Jomar C."
	}
}
