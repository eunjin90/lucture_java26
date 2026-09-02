package fruit;

public class Fruit {

	String name;
	int price;
	
	public Fruit(String name, int price) {
		this.name = name;
		this.price = price;
	}
	
	public String toString() {
		return (name + "(" + price + ")");
	}

	@Override
	public int hashCode() {
		return name != null ? name.hashCode() : 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Fruit)
			return ((Fruit)obj).name.equals(name);
		return false;
	}
	
	
}
