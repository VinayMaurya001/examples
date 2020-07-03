package com.examples.programs;

import java.io.Serializable;

public final class ExcellentPojoClass implements Serializable, Comparable<ExcellentPojoClass>, Cloneable {

	private static final long serialVersionUID = 6505139163533413958L;

	private final int id;
	private final String description;

	public ExcellentPojoClass(int id, String description) {
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ExcellentPojoClass other = (ExcellentPojoClass) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public int compareTo(ExcellentPojoClass obj) {
		int idsCompareTo = ((Integer) this.id).compareTo(obj.id);
		return idsCompareTo == 0 ? this.description.compareTo(obj.description) : idsCompareTo;
	}

	@Override
	public ExcellentPojoClass clone() throws CloneNotSupportedException {
		return (ExcellentPojoClass) super.clone();

	}

	public ExcellentPojoClass withId(int id) {
		return new ExcellentPojoClass(id, this.description);
	}

	public ExcellentPojoClass withDescription(String description) {
		return new ExcellentPojoClass(this.id, description);
	}

	public static void main(String[] args) {

	}
}
