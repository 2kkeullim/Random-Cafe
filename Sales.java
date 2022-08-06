import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Sales
{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static String str;
	public static int totalSale;   //총매출
	public static int totalCard;   //카드매출
	public static int totalCash;   //현금매출
	public static int totalCoupon; //무상판매금액
	public static int totalOrder;   //총주문건수
	public static int profit;       //순이익
	public static int[] categoryOrder = new int[6];      //카테고리 별 주문건수(개수) 를 담을 배열
	public static int[][] drinkOrder = new int[6][6];    //메뉴별 주문건수(개수)를 담을배열 [카테고리][메뉴 주문건수]

	public static void salesManage() throws IOException
	{
		do
		{
			System.out.println("총매출(카드 + 현금 ) : " + totalSale);
			System.out.println("카드 결제 매출 : " + totalCard);
			System.out.println("현금 결제 매출 : " + totalCash);
			System.out.println("무상판매금액 :  (할인총액) " + totalCoupon);
			System.out.println("순이익 : " + profit);
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
		if(totalOrder == 0)
		{
			System.out.println("현재 판매된 음료가 없습니다. ");
			System.out.println("============================ ");
			return;
		}
		else
		{
			System.out.printf("%n1. [커피] %.1f%%",((double)categoryOrder[0] / totalOrder) *100);             // 커피 카테고리 주문건수 / 총주문건수.
			System.out.printf("%n2. [논커피] %.1f%%",((double)categoryOrder[1] / totalOrder) *100);
			System.out.printf("%n3. [주스] %.1f%%",((double)categoryOrder[2] / totalOrder) *100);
			System.out.printf("%n4. [스무디] %.1f%%",((double)categoryOrder[3] / totalOrder) *100);
			System.out.printf("%n5. [티] %.1f%%",((double)categoryOrder[4] / totalOrder *100));
			System.out.printf("%n6. [에이드] %.1f%%",((double)categoryOrder[5] / totalOrder *100));
			System.out.printf("%n7. 뒤로 가기%n");
			System.out.print("상세 항목 조회 (1 ~ 6) : ");
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
	}

	//상세항목 조회시 각 메뉴들 출력 메소드
	public static void coffeeSales() throws IOException
	{
		if(categoryOrder[0] == 0)
		{
			System.out.println("현재 해당 카테고리 내 판매된 음료가 없습니다. ");
			System.out.println("============================ ");
			eachDrinkSales();
		}
		
		else
		{
			for (int i = 0; i < Coffee.drinkName.length; i++)
				System.out.printf("%s : %.1f%%%n",Coffee.drinkName[i], (((double)drinkOrder[0][i] / categoryOrder[0] ) *100)); 
			System.out.println("뒤로 가기 [ctrl+z]");
			str = br.readLine();

			if (str == null)
				eachDrinkSales();
		}
	}

	public static void nonCoffeeSales() throws IOException
	{
		if(categoryOrder[1] == 0)
		{
			System.out.println("현재 해당 카테고리 내 판매된 음료가 없습니다. ");
			System.out.println("============================ ");
			eachDrinkSales();
		}
		
		else
		{
			for (int i = 0; i < NonCoffee.drinkName.length; i++)
				System.out.printf("%s : %.1f%%%n",NonCoffee.drinkName[i], (((double)drinkOrder[1][i] / categoryOrder[1]) *100));
			
			System.out.println("뒤로 가기 [ctrl+z]");
			str = br.readLine();

			if (str == null)
				eachDrinkSales();
		}
	}

	public static void juiceSales() throws IOException
	{
		if(categoryOrder[2] == 0)
		{
			System.out.println("현재 해당 카테고리 내 판매된 음료가 없습니다. ");
			System.out.println("============================ ");
			eachDrinkSales();
		}
		
		else
		{
			for (int i = 0; i < Juice.drinkName.length; i++)
				System.out.printf("%s : %.1f%%%n",Juice.drinkName[i],(((double)drinkOrder[2][i] / categoryOrder[2]) *100));

			System.out.println("뒤로 가기 [ctrl+z]");
			str = br.readLine();

			if (str == null)
				eachDrinkSales();
		}
	}

	public static void smoothieSales() throws IOException
	{
		if(categoryOrder[3] == 0)
		{
			System.out.println("현재 해당 카테고리 내 판매된 음료가 없습니다. ");
			System.out.println("============================ ");
			eachDrinkSales();
		}
		
		else
		{
			for (int i = 0; i < Smoothie.drinkName.length; i++)
				System.out.printf("%s : %.1f%%%n",Smoothie.drinkName[i],(((double)drinkOrder[3][i] / categoryOrder[3]) *100));

			System.out.println("뒤로 가기 [ctrl+z]");
			str = br.readLine();

			if (str == null)
				eachDrinkSales();
		}
	}

	public static void teaSales() throws IOException
	{
		if(categoryOrder[4] == 0)
		{
			System.out.println("현재 해당 카테고리 내 판매된 음료가 없습니다. ");
			System.out.println("============================ ");
			
		}
		
		else
		{
			for (int i = 0; i < Tea.drinkName.length; i++)
				System.out.printf("%s : %.1f%%%n",Tea.drinkName[i],(((double)drinkOrder[4][i] / categoryOrder[4]) *100));

			System.out.println("뒤로 가기 [ctrl+z]");
			str = br.readLine();

			if (str == null)
				eachDrinkSales();
		}
	}

	public static void adeSales() throws IOException
	{
		if(categoryOrder[5] == 0)
		{
			System.out.println("현재 해당 카테고리 내 판매된 음료가 없습니다. ");
			System.out.println("============================ ");
			eachDrinkSales();
		}
		
		else
		{
			for (int i = 0; i < Ade.drinkName.length; i++)
				System.out.printf("%s : %.1f%%%n",Ade.drinkName[i],(((double)drinkOrder[5][i] / categoryOrder[5]) *100));

			System.out.println("뒤로 가기 [ctrl+z]");
			str = br.readLine();

			if (str == null)
				eachDrinkSales();
		}
	}
}
