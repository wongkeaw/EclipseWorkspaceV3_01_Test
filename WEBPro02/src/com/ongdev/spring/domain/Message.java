package com.ongdev.spring.domain;


public class Message {
	String name;
    String text;
    
	public Message(String name, String text) {
		super();
		this.name = name;
		this.text = text;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getTextModifiler() {
		return "Ongart test" ;
	}
    
    
}