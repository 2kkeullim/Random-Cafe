import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Smoothie
{
	public static final int cost = 2500;
	public String hotOrCold; 
	public String ice; 
	public int drinkCount;     //음료 선택 갯수
	
	public void option() throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String temp; 
		int tempIce;
		drinkCount = 0;

		hotOrCold = " "; 
		ice = " ";

		do
		{
			System.out.print("선택하신 음료의 개수를 선택하세요(최대 주문 갯수 : 30). : ");
			drinkCount = Integer.parseInt(br.readLine());
			if(drinkCount < 1 || drinkCount > 30)
				System.out.println("음료의 개수를 다시 입력해주세요.");
		}
		while (drinkCount < 1 || drinkCount > 30);
		
	}
	
}