package com.zwk.producers_and_consumers;

public class Car {
	private String name=null;
	private String card=null;
	private Car(){}
	public Car(String name,String card){
		this.name=name;
		this.card=card;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCard() {
		return card;
	}

	public void setCard(String card) {
		this.card = card;
	}

	public void showInformation() {
		System.out.println("车型:"+name+"车牌:"+card);
	}
}
