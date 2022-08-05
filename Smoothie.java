import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Smoothie extends Options
{
	public static final int cost = 2500;
	
	public void set() throws IOException
	{
		CupsCount();
		Drink dr = new Drink("cold", " ", drinkCountOption);
		Cart.vc.add(dr);
	}
}
