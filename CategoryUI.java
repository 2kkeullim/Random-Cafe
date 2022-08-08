import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class CategoryUI
{
	public static final int coffee = 1;
	public static final int nonCoffee = 2;
	public static final int juice = 3;
	public static final int smoothie = 4;
	public static final int tea = 5;
	public static final int ade = 6;
	public static final int cart = 7;
	public static final int back = 8;
	public static int sel = 1;
	
	// 음료 카테고리 출력 메소드
	public static void categoryDisp()
	{
		System.out.println("┌────────────────────────────────────────────────────┐");
		if (InitialUI.sel == InitialUI.forHere)
			System.out.println("│                       [매장]                       │");
		else if (InitialUI.sel == InitialUI.takeOut)
			System.out.println("│                       [포장]                       │");
		else if (InitialUI.sel == InitialUI.couponUse)
			System.out.println("│                    [쿠폰  사용]                    │");
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
	
	// 사용자로부터 선택값 입력받는 메소드
	public static void categorySelect() throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		do
		{
			sel = Integer.parseInt(br.readLine());
			
			// 1 ~ 6 사이를 입력받으면 해당 음료 메뉴판으로 진입
			// 7을 입력받으면 장바구니 진입
			// 8을 입력받으면 뒤로가기. 그 외의 번호는 무한루프
			if (sel >= coffee && sel <= ade)
				DrinkUI.drinkRun();
			else if (sel != cart && sel != back)
				System.out.println("\n다시 입력하세요.\n");
			else if (sel == cart)
				Cart.printVC(); // 장바구니 표시해주는 Cart클래스의 메소드
			
			if (sel == back)
			{
				Cart.vc.clear();
				Cart.totalSum = 0;
				Cafe.operate();
			}

			if (sel == cart || sel == back)
				break;
			
			categoryDisp();

		}
		while (sel != cart || sel != back);
	}
	// 카테고리 출력 및 사용자 입력값 받기 메소드 실행
	public static void categoryRun() throws IOException
	{
		categoryDisp();
		categorySelect();
	}
}