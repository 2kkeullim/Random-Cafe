import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PayCard 
{
	public static void cardInsert() throws IOException
	{
		// 카드 계산시 Pay클래스 pay 메서드 매개변수에 "card" 대입
		// 매출액 계산을 위해서.
		Pay.insert();
		Pay.pay("card");
	}
}