import java.util.ArrayList;
abstract class Stock {
	public Stock(String symbol, 
			     double price) {
		_symbol = symbol;
		_price = price;
	}
	//Register the Observers
	public void Attach (Investor investor) {
		investors.add(investor);
	}
	//Notify the Observers.
	public void Notify() {
		// set argument to something that helps
		// tell the Observers what happened
		for(int i = 0;i<investors.size();i++){
			investors.get(i).Update(this);
		}
	}
	public String getSymbol() {return _symbol;}
	void setSymbol(String value) {_symbol = value;}
	public double	getPrice() {return 0;};
	abstract public void setPrice(double valuei);
	protected String _symbol;          // Internal Subject state
	protected double _price;			// Internal Subject state
	protected ArrayList<Investor> investors = new ArrayList<Investor>();
}

//'ConcreteSubject' ==> IBM

class IBM extends Stock {
	// Constructor
	public IBM(String symbol, double price) {
		super(symbol, price);
	}
	public double getPrice() {return _price;}
	public void setPrice(double value) {
		// Whenever a change happens to _price, notify
		// observers.
		_price = value;
		Notify();
	}

}

//'Observer'  ==> Abstract Observer.

interface Observer {
	public void Update(Stock stock);
}

//'ConcreteObserver' ==> Investor

class Investor implements Observer {
	private Stock _stock;
	private String _investor_name;
	private String _stock_name;     // Internal Observer state
	private double _stock_price;	// Internal Observer state
	private String _type;
	// Constructor
	public Investor(String name,String type) {
		_investor_name = name;
		_type=type;
	}
	public void Update(Stock stock) {
		 _stock = stock; 				 // Reference to Subject
		 _stock_price = stock.getPrice();
		 _stock_name = stock.getSymbol();
			System.out.println(
					"Notified " + _investor_name + " of " + _stock_name + "'s " + "change to " + _stock_price);
	 }
	public Stock getStock() { return _stock; }
	public void setStock(Stock value) { _stock = value; }
	public String getName() { return _investor_name; }
	public String getType(){return _type;}
}

//MainApp test application
public class ObserverPattern {
	public static void main(String[] args) {
		// Create investors
	    Investor s = new Investor("Ahmet","UP");
	    Investor b = new Investor("Ayse","DOWN");
	    Investor c = new Investor("Mehmet","UP");

	    // Create IBM stock and attach investors
	    IBM ibm = new IBM("IBM", 120.00);
	    c.setStock(ibm);
	    s.setStock(ibm);
	    b.setStock(ibm);	    
	    ibm.Attach(s);
	    ibm.Attach(b);
	    ibm.Attach(c);
	    // Change price, which notifies investors
	    ibm.setPrice(120.10);
	    ibm.setPrice(121.00);
	    ibm.setPrice(120.50);
	    ibm.setPrice(120.75);
	    ibm.setPrice(121);
	    ibm.setPrice(122);
	    ibm.setPrice(123);
	    ibm.setPrice(124);
	    ibm = null; // Candidate for Garbage Collection  // DANGER !!!!!!!     
	    // We have a dangling reference in our Observer. Remember our
	    // "implementation issues" discussion in the lecture.
	    System.out.println(s.getStock()); // Reference has a value. 
	}
}