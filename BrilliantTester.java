
public class BrilliantTester {
	public static void main(String[] args) {
		
		BrilliantNumbers n1 = new BrilliantNumbers(341);
		System.out.println(n1.getPrimeFactors());
		System.out.println(n1.isBrilliant());
		
		BrilliantNumbers n2 = new BrilliantNumbers(25);
		System.out.println(n2.getPrimeFactors());
		System.out.println(n2.isBrilliant());
		
		BrilliantNumbers n3 = new BrilliantNumbers(75);
		System.out.println(n3.getPrimeFactors());
		System.out.println(n3.isBrilliant());
		
		BrilliantNumbers n4 = new BrilliantNumbers(474689);
		System.out.println(n4.getPrimeFactors());
		System.out.println(n4.isBrilliant());
		
		//should get true true false true
	}
}
