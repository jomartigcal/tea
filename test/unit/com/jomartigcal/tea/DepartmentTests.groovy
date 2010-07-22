package com.jomartigcal.tea

import org.codehaus.groovy.grails.plugins.GrailsPluginManager 
import org.codehaus.groovy.grails.plugins.PluginManagerHolder 

import grails.test.*

class DepartmentTests extends GrailsUnitTestCase {
    protected void setUp() {
        super.setUp()
		PluginManagerHolder.pluginManager = [hasGrailsPlugin: { String name -> true}] as GrailsPluginManager
    }

    protected void tearDown() {
        super.tearDown()
		PluginManagerHolder.pluginManager = null
    }

	void testConstraintsBlank() {
		mockForConstraintsTests(Department)
		
		def department = new Department(code:"", name:"")
		assertFalse "Validation should fail", department.validate()
		assertTrue "Validation should have errors", department.hasErrors()
		assertEquals "Code should not be blank", "blank", department.errors["code"]
		assertEquals "Code should not be blank", "blank", department.errors["name"]
	}
	
	void testConstraintsNull() {
		mockForConstraintsTests(Department)
		
		def department = new Department()
		assertFalse "Validation should fail", department.validate()
		assertTrue "Validation should have errors", department.hasErrors()
		assertEquals "Code should not be null", "nullable", department.errors["code"]
		assertEquals "Code should not be null", "nullable", department.errors["name"]
	}
	
	void testConstraintsUnique() {
		def existingDept = new Department(code:"ITD", name:"IT Department")
		mockDomain(Department, [existingDept])
		
		def department = new Department(code:"ITD", name:"IT Department")
		assertFalse "Validation should fail", department.validate()
		assertTrue "Validation should have errors", department.hasErrors()
		assertEquals "Code should be unique", "unique", department.errors["code"]
	}
	
	void testConstraintsValid() {
		mockForConstraintsTests(Department)
		
		def department = new Department(code:"ITD", name:"IT Department")
		assertTrue "Validation should not fail", department.validate()
	}
	
    void testToString() {
		def department = new Department(code:"ITD", name:"IT Department")
		assertToString department, "ITD"
    }
}
