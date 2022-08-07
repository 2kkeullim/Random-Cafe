import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class CategoryUI
{
	public static int sel = 1;

	public static void categoryDisp()
	{
		System.out.println("┌────────────────────────────────────────────────────┐");
		if (InitialUI.sel == 1)
			System.out.println("│                       [매장]                       │");
		else if (InitialUI.sel == 2)
			System.out.println("│                       [포장]                       │");
		System.out.println("│                                                    │");		
		System.out.println("│                      1. coffee                     │");
		System.out.println("│                      2. non-coffee                 │");
		System.out.println("│                      3. juice                      │");
		System.out.println("│                      4. smoothie                   │");
		System.out.println("│                      5. tea                        │");
		System.out.println("│                      6. ade                        │");
		System.out.println("│                      7. 장바구니                   │");
		System.out.println("│                      8. 뒤로가기                   │");
		System.out.println("└────────────────────────────────────────────────────┘");
		System.out.print("\n>> 카테고리를 선택하세요 (1 ~ 8) : ");
	}

	public static void categorySelect() throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		do
		{
			sel = Integer.parseInt(br.readLine());

			if (sel >= 1 && sel <= 6)
				DrinkUI.drinkRun();
			else if (sel != 7 && sel != 8)
				System.out.println("\n다시 입력하세요.\n");
			else if (sel == 7)
				Cart.printVC();
			if (sel == 7 || sel == 8)
				break;
			categoryDisp();
		}
		while (sel != 7 && sel != 8);
	}

	public static void categoryRun() throws IOException
	{
		categoryDisp();
		categorySelect();
	}
}