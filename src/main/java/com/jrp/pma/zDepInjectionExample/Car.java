package com.jrp.pma.zDepInjectionExample;

public class Car {

	Engine carEngine;
	Door carDoor;
	Tire carTire;

	public Car(Engine e, Door d, Tire t) {
		this.carEngine = e;
		this.carDoor = d;
		this.carTire = t;
	}

	public void printCarDetails() {
		System.out.println(this.carEngine + " " + this.carDoor);
	}
}
