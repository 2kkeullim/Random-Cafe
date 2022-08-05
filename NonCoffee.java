import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class NonCoffee extends Options
{
	public static final int cost = 2000;

	public void set() throws IOException
	{	
		option1();
		Drink dr = new Drink(hotOrColdOption, iceOption, drinkCountOption);
		Cart.vc.add(dr);
	}
}
