package com.examples.programs;

/**
 * Following are the requirements: The class must be declared as final (So that
 * child classes can’t be created) Data members in the class must be declared as
 * final (So that we can’t change the value of it after object creation) A
 * parameterized constructor Getter method for all the variables in it. No
 * setters(To not have the option to change the value of the instance variable)
 */
public final class ImmutableClass {

	private final int id;
	private final String description;

	public ImmutableClass(int id, String description) {
		super();
		this.id = id;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public String getDescription() {
		return description;
	}

	public ImmutableClass withId(int id) {
		return new ImmutableClass(id, this.description);
	}

	public ImmutableClass withDescription(String description) {
		return new ImmutableClass(this.id, description);
	}

	public static void main(String[] args) {

	}

}
