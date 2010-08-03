package com.jomartigcal.tea

import org.codehaus.groovy.grails.commons.ApplicationHolder 

class TeaTagLib {
	
	def copyright = { 
		out << ApplicationHolder.application.metadata['app.name'].toUpperCase()
		out << " "
		out << ApplicationHolder.application.metadata['app.version']
		out << " Copyright &copy; 2010"
	}
}
