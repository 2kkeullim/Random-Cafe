
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Coffee extends Options
{
	public static final int cost = 1000;  //원가
		                 //음료 선택 갯수
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
