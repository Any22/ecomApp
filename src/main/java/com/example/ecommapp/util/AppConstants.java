package com.example.ecommapp.util;

public enum AppConstants {
	
	
	GENERAL_EXCEPTION("general.excpetion");
	
    private final String type;
    
    private AppConstants(String type) {
    	this.type = type ;
    }
    
    @Override 
    public String toString() {
    	return this.type;
    }

}
