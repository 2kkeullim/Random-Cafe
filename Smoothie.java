import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Smoothie extends Options
{
	public static final int cost = 2500;
	public String hotOrCold; 
	public String ice; 
	public int drinkCount;
	
	public void set() throws IOException
	{
		cupsCount();
		hotOrCold = "cold";
		ice = "  ";
		drinkCount = drinkCountOption;
	}
}
