public class AddSales
{
	public static final int[] COST = {1000 , 2000 , 1500, 2500 ,1000 ,1500};
	//카테고리별 원가.  각 카테고리 클래스 안에 있는 원가는 삭제하여도 됨 (이곳에서만 쓰임.)
	public static void addSales(Drink dr)
	{
		Sales.drinkOrder[CategoryUI.sel-1][DrinkUI.sel-1] += dr.getCount();
		Sales.categoryOrder[CategoryUI.sel-1] += dr.getCount();
		Sales.totalOrder -= dr.getCount();
		Sales.profit += dr.getCount() * (dr.getPrice() - COST[CategoryUI.sel-1]);
	}

	public static void removeSales(int temp)
	{
		Sales.drinkOrder[Cart.vc.get(temp-1).getCategoryNumber()][Cart.vc.get(temp-1).getDrinkNumber()] -= Cart.vc.get(temp-1).getCount();
		Sales.categoryOrder[Cart.vc.get(temp-1).getDrinkNumber()] -= Cart.vc.get(temp-1).getCount();
		Sales.totalOrder -= Cart.vc.get(temp-1).getCount();
		Sales.profit -= Cart.vc.get(temp-1).getCount() * (Cart.vc.get(temp-1).getPrice() - COST[Cart.vc.get(temp-1).getCategoryNumber()]);
	}
}
