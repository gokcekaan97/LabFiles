import java.util.ArrayList;

public class kaangokcekLAB4 {
	public static void main (String[]args) {
		Car ferrari=new Car("ferrari");
		ferrari.addPart(new EngineParts("crankchaft",500));
		ferrari.addPart(new Parts("chasis",100));
		System.out.println("'"+ferrari.getName()+"' the car you want");
		ferrari.displayParts();
		ferrari.totalPrice();
	}
}

interface CreatePart{
	public int getPrice();
	public String getName();
}
class EngineParts extends Parts{
	public EngineParts(String name,int price) {
		super(name,price);
	}
}
class Parts implements CreatePart{
	private String name;
	private int price;
	public Parts(String name, int price) {
		this.name=name;
		this.price=price;
	}
	public int getPrice() {
		return price;
	}
	public String getName() {
		return name;
	}
}
class Car {
	private String name;
	public Car (String name) {
		this.name=name;
	}
	private	ArrayList<Parts> parts = new ArrayList<Parts>();
	public void addPart(Parts p) {parts.add(p);
	}
	public void removePart(Parts p) {
		for (int i = 0; i< parts.size(); i++) {
			if (parts.get(i).getName() == p.getName()) {
				parts.remove(i);
				return;
			}
		}
	}
	public void displayParts() {
		for (int i= 0; i<parts.size(); i++) {
			System.out.println("name of the part is: "+parts.get(i).getName());
		}
	}
	public void totalPrice() {
		int price=0;
		int temp;
		for (int i= 0; i< parts.size(); i++) {
			temp=parts.get(i).getPrice();
			price+=temp;
		}
		System.out.println("total price is : "+price+" dollars.");
	}
	public String getName() {
		return name;
	}
}

