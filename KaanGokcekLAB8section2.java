import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class KaanGokcekLAB8section2 {
    public static void main(String[] args) {
        MaxOfTwo MoT = new MaxAdapter(new MaxOfFour());
        Scanner scan = new Scanner(System.in);
        ArrayList<Integer> listOfFour = new ArrayList<Integer>();
        int f = 0;
        int s = 0;
        int t = 0;
        int fo = 0;
        boolean cond = true;

        while (cond == true) {
            cond = false;
            System.out.println("Please enter a number: ");
            f = scan.nextInt();
            System.out.println("Please enter the second number: ");
            s = scan.nextInt();
            System.out.println("Please enter the third number: ");
            t = scan.nextInt();
            System.out.println("Please enter the fourth number: ");
            fo = scan.nextInt();
            if(f<=0 || s<=0 || t<=0 || fo<=0 ){cond=true;System.out.println("Numbers must be positive! Try Again...");}
        }

        listOfFour.add(f);
        listOfFour.add(s);
        listOfFour.add(t);
        listOfFour.add(fo);
        int max=MoT.findMaxAdapter(listOfFour);
        System.out.println("Max number is " + max +" " + "!!!");
    }
}
class MaxAdapter implements MaxOfTwo {
	private MaxOfFour mof;
	MaxAdapter(MaxOfFour mof){
		this.mof=mof;
	}
	public int findMax(int first,int second) {
        if(first >= second)
            return first;
        else
            return second;
	}
	public int findMaxAdapter(ArrayList<Integer> list){
		int first =findMax(list.get(0),list.get(1));
		int second =findMax(list.get(2),list.get(2));
		int max = findMax(first,second);
		return max;
	}
	
}
class MaxOfFour{

    public int findMaxF(ArrayList<Integer> listOfFour){
        int max = Collections.max(listOfFour);
        return max;
    }
}
interface MaxOfTwo {
    public int findMax(int first,int second);

	public int findMaxAdapter(ArrayList<Integer> listOfFour);
}
