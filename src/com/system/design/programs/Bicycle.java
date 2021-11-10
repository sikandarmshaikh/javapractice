package com.system.design.programs;

/**
 * Design a Bicycle using Object Oriented Principles
 * 
 */
public class Bicycle {

	int pedalRpm;
	int gear;
	double wheelDiameter;
	int numberOfGears;

	/**
	 * Constructor for objects of class Bicycle
	 *
	 * @oparam wheelDiameter in meters
	 * @param numberOfGears
	 */
	public Bicycle(double wheelDiameter, int numberOfGears) {
		// initialize instance variables
		this.pedalRpm = 300;
		this.gear = 1;
		this.wheelDiameter = wheelDiameter;
		this.numberOfGears = numberOfGears;
	}

	/**
	 * Constructor for objects of class Bicycle
	 */
	public Bicycle() {
		// initialise instance variables
		this.pedalRpm = 300;
		this.gear = 1;
		this.wheelDiameter = 0.5;
		this.numberOfGears = 3;
	}
}
