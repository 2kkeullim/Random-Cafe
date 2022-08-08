import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PayCard 
{
	public static void cardInsert() throws IOException
	{
		Pay.insert();
		Pay.pay("card");
	}
}