import java.util.Random;

public class RandomDrink
{
	static int n;
	
	public static void main(String[] args)
	{
		Random rd = new Random();
		n = rd.nextInt(5);
		System.out.println(n);	
	}
}