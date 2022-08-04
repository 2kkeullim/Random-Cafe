import java.util.HashMap;

public class Change
{
	public static HashMap<Integer, Integer> change;
	
	static
	{
		change = new HashMap<Integer, Integer>();
		change.put(500,0);
		change.put(1000,0);
		change.put(5000,0);
		change.put(10000,0);
	}
	
	public static int sumCal()
	{
		int sum = 0;
		sum += 500 * change.get(500);
		sum += 1000 * change.get(1000);
		sum += 5000 * change.get(5000);
		sum += 10000 * change.get(10000);

		return sum;
	}
}