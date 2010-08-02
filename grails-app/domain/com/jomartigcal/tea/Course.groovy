package com.jomartigcal.tea

class Course {

	String code
	String name
	Integer numberOfYears
	
    static constraints = {
		code(blank:false, nullable:false)
		name(blank:false, nullable:false)
		numberOfYears(min:1, max:5)
    }
	
	String toString(){
		code
	}
}
