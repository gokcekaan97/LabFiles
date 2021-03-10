package se311lab6;
import java.util.ArrayList;

//=======================================================================
//Name        : AbstractFactory.cpp
// 1. AbstractFactory  ( CarFactory )
//	  Declares an interface for operations that create abstract products
// 2. ConcreteFactory  (OPELFactory,FordFactory)
//	  Implements the operations to create concrete product objects
// 3. AbstractProduct   (Part, Engine, Transmission)
//	  Declares an interface for a type of product object
// 4. Product  (OPEL_Engine, OPEL_Transmission,
//				 FORD_Engine, FORD_Transmission.)
//	  Defines a product object to be created by the corresponding 
//    concrete factory implements the AbstractProduct interface
// 5. Client  (BuildCar)
//	  Uses interfaces declared by AbstractFactory and AbstractProduct 
//    classes
//=======================================================================

abstract class Tools{
	abstract public String displayName();
	abstract double getPrice();
	protected double price;
}
abstract class Wrench extends Tools{
	abstract public String displayName();
	abstract double getPrice();
	protected double price;
}
abstract class Socket extends Tools{
	abstract public String displayName();
	abstract double getPrice();
	protected double price;
}
class FacomWrench extends Wrench{
	public FacomWrench(double p) {price=p;}
	public String displayName() {return new String("\tFacom Wrench");}
	double getPrice() {return price;}
}
class StanleyWrench extends Wrench{
	public StanleyWrench(double p) {price=p;}
	public String displayName() {return new String("\tStanley Wrench");}
	double getPrice() {return price;}
}
class MyWrench extends Wrench{
	public MyWrench (double p ) {price=p;}
	public String displayName() {return new String("\tMy Wrench");}
	double getPrice() {return price;}
}
class BoschSocket extends Socket{
	public BoschSocket(double p) {price=p;}
	public String displayName() {return new String("\tBosch Socket");}
	double getPrice() {return price;}
}
class DewaltSocket extends Socket{
	public DewaltSocket(double p) {price=p;}
	public String displayName() {return new String("\tDewalt Socket");}
	double getPrice() {return price;}
}
class MySocket extends Socket{
	public MySocket(double p) {price=p;}
	public String displayName() {return new String("\tMy Socket");}
	double getPrice() {return price;}
}
abstract class FixFactory {
	abstract public Tools Fix(Tools t);
}

//A 'Concrete Factory' class
class WrenchFactory extends FixFactory {
	public Wrench Fix(Tools t) {
		if(t.displayName().equals("\tStanley Wrench")) {
			return new StanleyWrench(100);
		}else if (t.displayName().equals("\tFacom Wrench")) {
			return new FacomWrench(200);
		}else if (t.displayName().equals("\tMy Wrench")) {
			return new MyWrench(300);
		}
		return null;
	}
}

//The 'Client'.
class FixCar {
	// Object creation is delegated to factory.
	public void Fix(FixFactory factory,Tools t) {
		fix = new ArrayList<Tools>();
		fix.add(factory.Fix(t));
		displayParts();
	}
	void displayParts() {
		System.out.println("\tListing recipe about fixing \n\t-------------");
		fix.forEach(p  -> System.out.println(p.displayName() + 
				            " " + p.getPrice()));
	}
	private ArrayList<Tools> fix;
}

//Abstract Factory Method Design Pattern.
//Entry point into main application.
public class factoryPattern {
	public static void main(String[] args) {

	   // Create and run banking system.

	   FixFactory fix = new WrenchFactory();
	   Tools stanley=new StanleyWrench(100);
	   Tools facom=new FacomWrench(200);

	   FixCar car = new FixCar();
	   System.out.println("Fixing With Wrench");
	   car.Fix(fix,stanley);
	   car.Fix(fix,facom);


	}
}