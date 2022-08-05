import java.util.Random;

public class RandomDrink
{
	static int n;

	public static int roll()
	{
		Random rd = new Random();
		n = rd.nextInt(5);

		return n;
	}
}