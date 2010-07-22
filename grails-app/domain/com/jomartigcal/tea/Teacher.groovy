package com.jomartigcal.tea

class Teacher {

	String firstName
	String middleInitial
	String lastName
	
	static belongsTo = [department:Department]
	
    static constraints = {
		firstName(blank:false, nullable:false)
		middleInitial(range:'A'..'Z')
		lastName(blank:false, nullable:false)
		department(nullable:true)
    }
	
	String toString(){
		"${lastName}, ${firstName}" + (middleInitial ? " ${middleInitial}." : "")
	}
}
