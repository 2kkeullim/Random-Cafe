import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Options
{
	public String hotOrColdOption; 
	public String iceOption; 
	public String hoc;
	public int iceAmount;
	public int drinkCountOption;
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public void option1() throws IOException
	{
		do
		{
			System.out.print(">> Hot 또는 Cold 를 선택하세요. (h(H) or c(C)) 입력 : ");
			hoc = br.readLine();

			if (hoc.equals("c") || hoc.equals("C"))
			{	
				hotOrColdOption = "cold";
				iceSelect();
			}
			else if (hoc.equals("h") || hoc.equals("H"))
			{
				hotOrColdOption = "hot";
				iceOption = "         ";
			}
			cupsCount();

			if (!((hoc.equals("c") || hoc.equals("C") || hoc.equals("h") || hoc.equals("H"))))
				System.out.println("\n잘못 입력하셨습니다. 다시 입력해주세요.\n");
		}
		while (!((hoc.equals("c") || hoc.equals("C") || hoc.equals("h") || hoc.equals("H"))));
	}

	public void option2() throws IOException
	{
		iceSelect();
		cupsCount();
	}

	public void iceSelect() throws IOException
	{		
		do
		{
			System.out.print(">> 얼음양을 선택해 주세요. (1 : 없음, 2 : 보통, 3 : 많이) 입력 : ");
			iceAmount = Integer.parseInt(br.readLine());
			if (iceAmount < 1 || iceAmount > 3)
				System.out.println("\n얼음양을 다시 선택해 주세요.\n");
		}
		while (iceAmount < 1 || iceAmount > 3);
		
		switch (iceAmount)
		{
			case 1: iceOption = "얼음 없음" ; break;
			case 2: iceOption = "얼음 보통" ; break;
			case 3: iceOption = "얼음 많이" ; break;
		}
	}

	public void cupsCount() throws IOException
	{
		if (DrinkUI.sel == 6)
		{
			drinkCountOption = 1;
			return;
		}

		drinkCountOption = 0;

		do
		{
			System.out.print(">> 선택하신 음료의 개수를 선택하세요.");
			System.out.print(">> 한번에 최대 음료 갯수는 30개의 음료를 입력받을 수 있습니다. : ");
			drinkCountOption = Integer.parseInt(br.readLine());

			if (drinkCountOption < 1 || drinkCountOption > 30)
				System.out.println("\n음료의 개수를 다시 입력해주세요.\n");
		}
		while (drinkCountOption < 1 || drinkCountOption > 30);
	}
}