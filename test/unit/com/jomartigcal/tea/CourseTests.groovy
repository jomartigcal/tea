package com.jomartigcal.tea

import org.codehaus.groovy.grails.plugins.GrailsPluginManager 
import org.codehaus.groovy.grails.plugins.PluginManagerHolder 

import grails.test.*

class CourseTests extends GrailsUnitTestCase {
    protected void setUp() {
        super.setUp()
		PluginManagerHolder.pluginManager = [hasGrailsPlugin: { String name -> true}] as GrailsPluginManager
    }

    protected void tearDown() {
        super.tearDown()
		PluginManagerHolder.pluginManager = null
    }

    void testConstraintsBlank() {
		mockForConstraintsTests(Course)
		
		def course = new Course(code:"", name:"")
		assertFalse "Should have failed", course.validate()
		assertTrue "Should have errors", course.hasErrors()
		assertEquals "Code should not be blank", "blank", course.errors['code']
		assertEquals "Code should not be blank", "blank", course.errors['name']
    }
	
	void testConstraintsNull() {
		mockForConstraintsTests(Course)
		
		def course = new Course()
		assertFalse "Should have failed", course.validate()
		assertTrue "Should have errors", course.hasErrors()
		assertEquals "Code should not be null", "nullable", course.errors['code']
		assertEquals "Code should not be null", "nullable", course.errors['name']
	}
	
	void testConstraintsRange(){
		mockForConstraintsTests(Course)
		
		def course = new Course(code:"BSCoE", name:"BS Computer Engineering", numberOfYears:0)
		assertFalse "Should fail", course.validate()
		assertTrue "Should have error", course.hasErrors()
		assertEquals "The error should be range", "range", course.errors['numberOfYears']
		
		def aboveRangeYear = 10
		course['numberOfYears'] = aboveRangeYear
		assertEquals aboveRangeYear, course.'numberOfYears'
		assertEquals "The error should be range", "range", course.errors['numberOfYears']
	}
	
	void testConstraintsValid() {
		mockForConstraintsTests(Course)
		
		def course = new Course(code:"BSCS", name:"BS Computer Science", numberOfYears:4)
		assertTrue "Should have passed", course.validate()
    }
	
	void testToString(){
		mockForConstraintsTests(Course)
		
		def course = new Course(code:"BSIT", name:"BS Information Technology", numberOfYears:4)
		assertToString(course, "BSIT")
	}
}
