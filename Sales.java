import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Sales
{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static String str;
	public static void salesManage() throws IOException
	{
		do
		{
			System.out.println("총매출(카드 + 현금 ) : XXX");
			System.out.println("카드 결제 매출 : XXX");
			System.out.println("현금 결제 매출 : XXX");
			System.out.println("무상판매금액 : XXX (할인총액)");
			System.out.println("순이익 : XXX");
			System.out.println("뒤로가기 [ctrl+z]");
			str = br.readLine();

			if (str != null)
				System.out.println("다시 입력해주세요.");
		}
		while (str != null);

		System.out.println();
	}

	// 각 카테고리별 판매비율 메소드
	public static void eachDrinkSales() throws IOException
	{
		//0.0은 각 카테고리별 매출비율 변수로 바꿔주면 됨
		System.out.printf("%n1. [커피] %.1f%%",0.0);
		System.out.printf("%n2. [논커피] %.1f%%",0.0);
		System.out.printf("%n3. [주스] %.1f%%",0.0);
		System.out.printf("%n4. [스무디] %.1f%%",0.0);
		System.out.printf("%n5. [티] %.1f%%",0.0);
		System.out.printf("%n6. [에이드] %.1f%%",0.0);
		System.out.printf("%n7. 뒤로 가기%n");
		System.out.print("상세 항목 조회 (1 ~ 6) ");
		AdminUI.sel = Integer.parseInt(br.readLine());
		System.out.println();

		switch (AdminUI.sel)
		{
			case 1 : coffeeSales(); break;
			case 2 : nonCoffeeSales(); break;
			case 3 : juiceSales(); break;
			case 4 : smoothieSales(); break;
			case 5 : teaSales(); break;
			case 6 : adeSales(); break;
			case 7 : return;
		}
	}

	//상세항목 조회시 각 메뉴들 출력 메소드
	public static void coffeeSales() throws IOException
	{
		for (int i = 0; i < Coffee.drinkName.length; i++)
			System.out.printf("%s : %.1f%%%n",Coffee.drinkName[i],0.0); // 0.0은 각 음료 판매비율 변수로 바꿔주면 됨.
		
		System.out.println("뒤로 가기 [ctrl+z]");
		str = br.readLine();

		if (str == null)
			eachDrinkSales();
	}

	public static void nonCoffeeSales() throws IOException
	{
		for (int i = 0; i < NonCoffee.drinkName.length; i++)
			System.out.printf("%s : %.1f%%%n",NonCoffee.drinkName[i],0.0);
		
		System.out.println("뒤로 가기 [ctrl+z]");
		str = br.readLine();

		if (str == null)
			eachDrinkSales();
	}

	public static void juiceSales() throws IOException
	{
		for (int i = 0; i < Juice.drinkName.length; i++)
			System.out.printf("%s : %.1f%%%n",Juice.drinkName[i],0.0);

		System.out.println("뒤로 가기 [ctrl+z]");
		str = br.readLine();

		if (str == null)
			eachDrinkSales();
	}

	public static void smoothieSales() throws IOException
	{
		for (int i = 0; i < Smoothie.drinkName.length; i++)
			System.out.printf("%s : %.1f%%%n",Smoothie.drinkName[i],0.0);

		System.out.println("뒤로 가기 [ctrl+z]");
		str = br.readLine();

		if (str == null)
			eachDrinkSales();
	}

	public static void teaSales() throws IOException
	{
		for (int i = 0; i < Tea.drinkName.length; i++)
			System.out.printf("%s : %.1f%%%n",Tea.drinkName[i],0.0);

		System.out.println("뒤로 가기 [ctrl+z]");
		str = br.readLine();

		if (str == null)
			eachDrinkSales();
	}

	public static void adeSales() throws IOException
	{
		for (int i = 0; i < Ade.drinkName.length; i++)
			System.out.printf("%s : %.1f%%%n",Ade.drinkName[i],0.0);

		System.out.println("뒤로 가기 [ctrl+z]");
		str = br.readLine();

		if (str == null)
			eachDrinkSales();
	}


	public static void mian(String[] args)
	{
		
	}
}