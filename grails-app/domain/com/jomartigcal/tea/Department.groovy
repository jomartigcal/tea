package com.jomartigcal.tea

class Department {

	String code
	String name
	
	static hasMany = [teachers: Teacher]
	
    static constraints = {
		code(blank:false, nullable:false, unique:true)
		name(blank:false, nullable:false)
		teachers(nullable:true)
    }
	
	String toString(){
		code
	}
}
