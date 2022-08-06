public class AddSales
{
	public static final int[] COST = {1000 , 2000 , 1500, 2500 ,1000 ,1500};
	//카테고리별 원가.  각 카테고리 클래스 안에 있는 원가는 삭제하여도 됨 (이곳에서만 쓰임.)
	
	// 밑의 두 메소드는 관리자 메뉴 1 2 번 항목을 위한 메소드로 영수증 출력에서 이루어짐.
	public static void addSales()     
	{
		for(int i=0 ; i < Cart.vc.size(); i++)
		{
			Sales.drinkOrder[Cart.vc.get(i).getCategoryNumber()][Cart.vc.get(i).getDrinkNumber()] += Cart.vc.get(i).getCount();
			Sales.categoryOrder[Cart.vc.get(i).getCategoryNumber()] += Cart.vc.get(i).getCount();
			Sales.totalOrder += Cart.vc.get(i).getCount();
			Sales.profit += Cart.vc.get(i).getCount() * (Cart.vc.get(i).getPrice() - COST[Cart.vc.get(i).getCategoryNumber()]);
		}
	}
}
