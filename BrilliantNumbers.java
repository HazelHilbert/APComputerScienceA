import java.util.ArrayList;

public class BrilliantNumbers {

	private int n;

	private ArrayList<Integer> factors = new ArrayList<Integer>();

	public BrilliantNumbers(int number){
		n = number;
	}

	//checks if a number n is a prime number
	public static boolean isPrime(int n) { //static: one copy for the whole class
		for(int i = 2; i < n; i++) {
			if(n % i == 0) { return false; }
		}
		return true;
	}

	//places all the prime factors for n into an arrayList
	public ArrayList<Integer> getPrimeFactors() {
		int i = 2;
		while (n > 1) {
			if (isPrime(i) && n % i == 0) {
				n /= i;
				factors.add(i);
			}
			else { i++;}
		}
		return factors;
	}	

	//counts the number of digits in number
	public int countDigits(int n) {
		int counter = 0;
		while(n > 0) {
			n /= 10;
			counter++;
		}
		return counter;
	}

	//determines if a number is a brilliant number
	public boolean isBrilliant() {
		if(factors.size() == 2 &&
				countDigits(factors.get(0)) == countDigits(factors.get(1))) 
		{return true;}
		else {return false;}
	}
}