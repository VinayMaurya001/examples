package com.examples.programs;

public class LiskovSubstitutionPrinciple {

	public static void main(String[] args) {
		displayNameAndSpeed(new DevicesWithoutEngines("Hero:", 10.0));
		displayNameAndSpeed(new DevicesWithEngines("Maruti:", 50.0, new Engine(1, "Generation1")));
		displayNameAndSpeed(new Bicycle("Atlas:", 5.0));
		displayNameAndSpeed(new Car("BMW:", 60.0, new Engine(1, "Generation1")));

	}

	static void displayNameAndSpeed(TransportationDevice td) {
		System.out.println(td.getName() + ": " + td.getSpeed());
	}
}

class TransportationDevice {
	String name;
	double speed;

	public TransportationDevice(String name, double speed) {
		super();
		this.name = name;
		this.speed = speed;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

}

class DevicesWithoutEngines extends TransportationDevice {

	public DevicesWithoutEngines(String name, double speed) {
		super(name, speed);
	}

	void startMoving() {
		System.out.println("DevicesWithoutEngines:startMoving");
	}
}

class DevicesWithEngines extends TransportationDevice {
	Engine engine;

	public DevicesWithEngines(String name, double speed, Engine engine) {
		super(name, speed);
		this.engine = engine;
	}

	public Engine getEngine() {
		return engine;
	}

	public void setEngine(Engine engine) {
		this.engine = engine;
	}

	void startEngine() {
		System.out.println("DevicesWithEngines:startEngine");
	}
}

class Bicycle extends DevicesWithoutEngines {

	public Bicycle(String name, double speed) {
		super(name, speed);
	}

	@Override
	void startMoving() {
		System.out.println("DevicesWithoutEngines:startMoving: Bicycle");
	}
}

class Car extends DevicesWithEngines {

	public Car(String name, double speed, Engine engine) {
		super(name, speed, engine);
	}

	@Override
	void startEngine() {
		System.out.println("DevicesWithEngines:startEngine: Car");
	}
}