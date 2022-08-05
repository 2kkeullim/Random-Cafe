import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class NonCoffee extends Options
{
	public static final int cost = 2000;
	public String hotOrCold; 
	public String ice; 
	public int drinkCount;
	
	public void set() throws IOException
	{
		option1();
		hotOrCold = hotOrColdOption;
		ice = iceOption;
		drinkCount = drinkCountOption;
	}
}
