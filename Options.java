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
			// Hot 혹은 Cold 선택
			if (!((hoc.equals("c") || hoc.equals("C") || hoc.equals("h") || hoc.equals("H"))))
			{
				System.out.println("\n잘못 입력하셨습니다. 다시 입력해주세요.\n");
				continue;
			}
			else if (hoc.equals("c") || hoc.equals("C"))
			{	
				hotOrColdOption = "cold";
				// Cold를 골랐으면 얼음량 선택 메소드 실행
				iceSelect();
			}
			else if (hoc.equals("h") || hoc.equals("H"))
			{
				hotOrColdOption = "hot";
				iceOption = "         ";
			}
			// 음료 갯수 정하는 메소드
			cupsCount();

			
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
		// DrinkUI에서 6을 입력하면 랜덤음료이므로 갯수는 1개로 고정
		if (DrinkUI.sel == 6)
		{
			drinkCountOption = 1;
			return;
		}

		drinkCountOption = 0;
		
		// 그 외의 음료는 1회 주문당 최대 30개까지 입력 가능
		do
		{
			System.out.println(">> 선택하신 음료의 개수를 선택하세요.");
			System.out.print(">> 입력 가능한 최대 음료 갯수는 한 번에 30개입니다. : ");
			// 입력받은 갯수는 drinkCountOption 변수에 저장
			drinkCountOption = Integer.parseInt(br.readLine());

			if (drinkCountOption < 1 || drinkCountOption > 30)
				System.out.println("\n음료의 개수를 다시 입력해주세요.\n");
		}
		while (drinkCountOption < 1 || drinkCountOption > 30);
	}
}