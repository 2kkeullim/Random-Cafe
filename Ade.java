import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Ade extends Options
{
	public static final int cost = 1500;
	
	public void set() throws IOException
	{
		option2();
		Drink dr = new Drink("cold", iceOption, drinkCountOption);
		Cart.vc.add(dr);
	}
}
