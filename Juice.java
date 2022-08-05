import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Juice extends Options
{
	public static final int cost = 1500;
	public String hotOrCold; 
	public String ice; 
	public int drinkCount;
	
	public void set() throws IOException
	{
		option2();
		hotOrCold = "cold";
		ice = iceOption;
		drinkCount = drinkCountOption;
	}
}
