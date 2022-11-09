import java.util.ArrayList;

public class JosephusProblem {
    public static void main(String[] args) {
        System.out.println(josephus1(1000));
        System.out.println(josephus2(100));
        System.out.println(josephus3(10000));
    }
  
    public static void populateList(ArrayList<Integer> list, int n) {
    	for (int i = 1; i < n+1; i++) {
    		list.add(i);
    	}
    }
    
    private static int josephus1(int i) {
    	ArrayList<Integer> list = new ArrayList<Integer>();
    	populateList(list, i);
    	int k = 1;
    	while(list.size() > 1) {
    		list.remove(k);
    		k++;
    		if (k >= list.size()) {
    			k = k % list.size();
    		}
    	}
    	return list.get(0);
    }
   
    private static int josephus2(int i) {
    	return Integer.parseInt(Integer.toBinaryString(i).substring(1) + "1", 2);
    }
    
    private static int josephus3(int i) {
    	return (int) (2 * (i - Math.pow(2, (int) (Math.log(i)/Math.log(2)))) + 1);
    }
}