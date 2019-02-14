package ua.lviv.lgs.hbm.xml;

import java.util.HashSet;
import java.util.Set;

public class Car {
	private Integer id;
	private String carModel;
	private Set<Person> persons = new HashSet<>();
	
	public Car() {
	}

	public Car(String carModel) {
		this.carModel = carModel;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((carModel == null) ? 0 : carModel.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Car other = (Car) obj;
		if (carModel == null) {
			if (other.carModel != null)
				return false;
		} else if (!carModel.equals(other.carModel))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCarModel() {
		return carModel;
	}

	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}

	public Set<Person> getPersons() {
		return persons;
	}

	public void setPersons(Set<Person> persons) {
		this.persons = persons;
	}

	@Override
	public String toString() {
		return "Cars [id=" + id + ", carModel=" + carModel + "]";
	}
}
