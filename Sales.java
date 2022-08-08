import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

// ??
public class Sales
{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static String str;
	public static int totalSale;						// 총 매출
	public static int totalCard;						// 카드 매출
	public static int totalCash;						// 현금 매출
	public static int totalCoupon;						// 무상 판매 금액
	public static int totalOrder;						// 총 주문 건수
	public static int profit;							// 순이익
	public static int[] categoryOrder = new int[6];		// 카테고리 별 주문건수(개수)를 담을 배열
	public static int[][] drinkOrder = new int[6][6];	// 메뉴별 주문건수(개수)를 담을배열 [카테고리][메뉴 주문건수]
	public static final int[] COST = {1000, 2000, 1500, 2500, 1000, 1500};	// 카테고리별 원가

	public static void salesDisp() throws IOException
	{
		do
		{
			System.out.println("\n┌────────────────────────────────────────────────────┐");
			System.out.println("│                    [판매  통계]                    │");
			System.out.println("└────────────────────────────────────────────────────┘");
			System.out.println(" ▶ 총매출(카드 + 현금)      : " + totalSale);
			System.out.println(" ▶ 카드 결제 매출           : " + totalCard);
			System.out.println(" ▶ 현금 결제 매출           : " + totalCash);
			System.out.println(" ▶ 무상판매금액(할인총액)   : " + totalCoupon);
			System.out.println(" ▶ 순이익                   : " + profit);
			System.out.println("──────────────────────────────────────────────────────");
			System.out.println("                                     뒤로가기 [ctrl+z]");
			str = br.readLine();

			if (str != null)
				System.out.println("다시 입력해주세요.");
		}
		while (str != null);
		System.out.println();
	}

	// 각 카테고리별 판매비율 메소드
	public static void drinkDisp() throws IOException
	{
		if (totalOrder == 0)
		{
			System.out.println("┌────────────────────────────────────────────────────┐");
			System.out.println("│             현재 판매된 음료가 없습니다.           │");
			System.out.println("└────────────────────────────────────────────────────┘");
			return;
		}
		else
		{
			System.out.println("\n┌────────────────────────────────────────────────────┐");
			System.out.println("│               [카테고리별  판매비율]               │");
			System.out.println("└────────────────────────────────────────────────────┘");
			System.out.printf("%n1. [커피] %20.1f%%", ((double)categoryOrder[0] / totalOrder) * 100);		// 커피 카테고리 주문건수 / 총 주문 건수
			System.out.printf("%n2. [논커피] %20.1f%%", ((double)categoryOrder[1] / totalOrder) * 100);
			System.out.printf("%n3. [주스] %20.1f%%", ((double)categoryOrder[2] / totalOrder) * 100);
			System.out.printf("%n4. [스무디] %20.1f%%", ((double)categoryOrder[3] / totalOrder) * 100);
			System.out.printf("%n5. [티] %20.1f%%", ((double)categoryOrder[4] / totalOrder) * 100);
			System.out.printf("%n6. [에이드] %20.1f%%", ((double)categoryOrder[5] / totalOrder) * 100);
			System.out.println("\n──────────────────────────────────────────────────────");
			System.out.printf("7. 뒤로 가기%n");
			System.out.print(">> 상세 항목 조회 (1 ~ 6) : ");

			AdminUI.sel = Integer.parseInt(br.readLine());
			System.out.println();
			if (AdminUI.sel == 7)
				return;
			sales();
		}
	}

	// 상세항목 조회시 각 메뉴들 출력 메소드
	public static void sales() throws IOException
	{
		if (categoryOrder[AdminUI.sel - 1] == 0)
		{
			System.out.println("┌────────────────────────────────────────────────────┐");
			System.out.println("│    현재 해당 카테고리 내 판매된 음료가 없습니다.   │");
			System.out.println("└────────────────────────────────────────────────────┘");
			drinkDisp();
		}		
		else
		{
			System.out.println("\n┌────────────────────────────────────────────────────┐");
			System.out.println("│                 [메뉴별  판매비율]                 │");
			System.out.println("└────────────────────────────────────────────────────┘");
			for (int i = 0; i < Coffee.drinkName.length; i++)
			{
				if (AdminUI.sel == 1)
						System.out.printf(" ▶ %s : %.1f%%%n", Coffee.drinkName[i], (((double)drinkOrder[0][i] / categoryOrder[0]) * 100));
				else if (AdminUI.sel == 2)
						System.out.printf(" ▶ %s : %.1f%%%n",NonCoffee.drinkName[i], (((double)drinkOrder[1][i] / categoryOrder[1]) *100));
				else if (AdminUI.sel == 3)
						System.out.printf(" ▶ %s : %.1f%%%n",Juice.drinkName[i],(((double)drinkOrder[2][i] / categoryOrder[2]) *100));
				else if (AdminUI.sel == 4)
						System.out.printf(" ▶ %s : %.1f%%%n",Smoothie.drinkName[i],(((double)drinkOrder[3][i] / categoryOrder[3]) *100));
				else if (AdminUI.sel == 5)
						System.out.printf(" ▶ %s : %.1f%%%n",Tea.drinkName[i],(((double)drinkOrder[4][i] / categoryOrder[4]) *100));
				else if (AdminUI.sel == 6)
						System.out.printf(" ▶ %s : %.1f%%%n",Ade.drinkName[i],(((double)drinkOrder[5][i] / categoryOrder[5]) *100));
			}
			System.out.println("──────────────────────────────────────────────────────");
			System.out.println("                                     뒤로가기 [ctrl+z]");
			str = br.readLine();

			if (str == null)
				drinkDisp();
		}
	}

	public static void addSales()
	{
		for (int i = 0; i < Cart.vc.size(); i++)
		{
			drinkOrder[Cart.vc.get(i).getCategoryNumber()][Cart.vc.get(i).getDrinkNumber()] += Cart.vc.get(i).getCount();
			categoryOrder[Cart.vc.get(i).getCategoryNumber()] += Cart.vc.get(i).getCount();
			totalOrder += Cart.vc.get(i).getCount();
			profit += Cart.vc.get(i).getCount() * (Cart.vc.get(i).getPrice() - COST[Cart.vc.get(i).getCategoryNumber()]);
		}
	}
}
