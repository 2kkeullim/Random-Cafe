public class AddSales
{
	public static void addSales(Drink dr)
	{
		Sales.drinkOrder[CategoryUI.sel-1][DrinkUI.sel-1] += dr.getCount();
		Sales.categoryOrder[CategoryUI.sel-1] += dr.getCount();
		Sales.totalOrder -= dr.getCount();
	}

	public static void removeSales(int temp)
	{
		Sales.drinkOrder[Cart.vc.get(temp-1).getCategoryNumber()][Cart.vc.get(temp-1).getDrinkNumber()] -= Cart.vc.get(temp-1).getCount();
		Sales.categoryOrder[Cart.vc.get(temp-1).getDrinkNumber()] -= Cart.vc.get(temp-1).getCount();
		Sales.totalOrder -= Cart.vc.get(temp-1).getCount();
	}
}
