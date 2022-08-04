public class DrinkUI
{
	static String[][] category = {{"1. 아메리카노", "2. 카페라떼", "3. 바닐라라떼", "4. 카페모카", "5. 돌체라떼", "6. 랜덤커피"},
		{"1. 녹차라떼", "2. 초코라떼", "3. 고구마라떼", "4. 곡물라떼", "5. 딸기라떼", "6. 랜덤라떼"},
		{"1. 사과주스", "2. 오렌지주스", "3. 포도주스", "4. 망고주스", "5. 딸기주스", "6. 랜덤주스"},
		{"1. 오렌지스무디", "2. 청포도스무디", "3. 망고스무디", "4. 딸기스무디", "5. 요거트스무디", "6. 랜덤스무디"},
		{"1. 그린티", "2. 얼그레이티", "3. 페퍼민트", "4. 복숭아티", "5. 캐모마일", "6. 랜덤티"},
		{"1. 레몬에이드", "2. 유자에이드", "3. 망고에이드", "4. 자몽에이드", "5. 청포도에이드", "6. 랜덤에이드"}};
	
	public static void drinkUISelect()
	{
			switch (CategoryUI.sel)
			{
				case 1: 
				case 2: 
				case 3: 
				case 4: 
				case 5: 
				case 6: drinkPrint(); break;
			}
	}

	public static void drinkPrint()
	{
		System.out.println();
		for (int i = 0; i < category[CategoryUI.sel-1].length; i++)
			System.out.printf("%s%n", category[CategoryUI.sel-1][i]);
		System.out.println();
		
	}

}
