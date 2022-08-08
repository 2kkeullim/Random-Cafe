import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class DrinkUI
{
	public static int sel = 1;
	
	static String[] category = {"[coffee]", "[non-coffee]", "[juice]", "[smoothie]", "[tea]", "[ade]"};
	
	// 각 카테고리에 해당하는 음료를 정리해놓은 2차원 배열
	static String[][] drink = {{"1. 아메리카노 : 1500원", "2. 카페라떼   : 2000원", "3. 바닐라라떼 : 2500원", "4. 카페모카   : 2500원", "5. 돌체라떼   : 3500원", "6. 랜덤커피   : 2000원", "7. 뒤로가기"},
		{"1. 녹차라떼   : 3000원", "2. 초코라떼   : 3500원", "3. 고구마라떼 : 4000원", "4. 곡물라떼   : 4000원", "5. 딸기라떼   : 4500원", "6. 랜덤라떼   : 3500원", "7. 뒤로가기"},
		{"1. 사과주스   : 3000원", "2. 오렌지주스 : 3500원", "3. 포도주스   : 3500원", "4. 망고주스   : 4000원", "5. 딸기주스   : 4000원", "6. 랜덤주스   : 3500원","7. 뒤로가기"},
		{"1. 오렌지스무디 : 4000원", "2. 청포도스무디 : 4000원", "3. 망고스무디   : 4500원", "4. 딸기스무디   : 4500원", "5. 요거트스무디 : 5000원", "6. 랜덤스무디   : 4000원", "7. 뒤로가기"},
		{"1. 그린티     : 2000원", "2. 얼그레이티 : 2500원", "3. 페퍼민트티 : 2500원", "4. 복숭아티   : 3000원", "5. 캐모마일티 : 3000원", "6. 랜덤티     : 2500원", "7. 뒤로가기"},
		{"1. 레몬에이드   : 3000원", "2. 유자에이드   : 3000원", "3. 망고에이드   : 4000원", "4. 자몽에이드   : 4000원", "5. 청포도에이드 : 4000원", "6. 랜덤에이드   : 3500원", "7. 뒤로가기"}};
	
	public static void drinkRun() throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		do
		{
			System.out.println("\n                      " + category[CategoryUI.sel - 1]);
			System.out.println("──────────────────────────────────────────────────────");
			// 수업시간에 배운 2차원 배열 요소 출력하기 방법 활용
			// CategoryUI에서 입력받은 sel을 활용하여 처리.
			// ex) 1을 입력받았으면 drink[0][i] 요소인 아메리카노~ 랜덤커피가 출력되게함
			for (int i = 0; i < drink[CategoryUI.sel-1].length; i++)
				System.out.printf(" - %s%n", drink[CategoryUI.sel - 1][i]);
			System.out.println("──────────────────────────────────────────────────────");


			System.out.print("\n>> 음료를 선택하세요 : ");
			sel = Integer.parseInt(br.readLine()); 
			
			if (sel >= 1 && sel <= 6)
				switch (CategoryUI.sel)
				{
					// 입력받은 선택값으로 해당 음료카테고리 클래스의 set()메서드 호출
					// ex) 커피를 입력했으면 Coffe.set() 호출
					// 아메리카노를 골랐다고 가정하면 sel = 1 이 됨
					case CategoryUI.coffee		: new Coffee().set(Coffee.drinkName[sel - 1], Coffee.drinkPrice[sel - 1]);			break;
					case CategoryUI.nonCoffee	: new NonCoffee().set(NonCoffee.drinkName[sel - 1], NonCoffee.drinkPrice[sel - 1]);	break;
					case CategoryUI.juice		: new Juice().set(Juice.drinkName[sel - 1], Juice.drinkPrice[sel - 1]);				break;
					case CategoryUI.smoothie	: new Smoothie().set(Smoothie.drinkName[sel - 1], Smoothie.drinkPrice[sel - 1]);	break;
					case CategoryUI.tea			: new Tea().set(Tea.drinkName[sel - 1], Tea.drinkPrice[sel - 1]);					break;
					case CategoryUI.ade			: new Ade().set(Ade.drinkName[sel - 1], Ade.drinkPrice[sel - 1]);					break;
				}
			else if (sel != 7)
				System.out.println("\n다시 입력하세요\n");
		}
		while(sel != 7);
	}
}
