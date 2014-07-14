package com.taxapp

class RuleInfo {

	String title
	String content
	String year
	
	byte[] imageData
	
	Date dateCreated
	Date lastUpdated
	
    static constraints = {
		title(blank: false)
		content(blank: false, maxSize: 40960)
		dateCreated()
		imageData(nullable:true)
    }
	
	static mapping = {
		content(type:'text')
		imageData(type: 'materialized_blob')
	}
	
	def beforeInsert() {
		dateCreated = new Date()
	}
	
	def beforeUpdate() {
		lastUpdated = new Date()
	}
}
