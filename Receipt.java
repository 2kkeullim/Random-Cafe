import java.util.Vector;

public class Receipt
{
	public static Vector<Drink> vc = new Vector<Drink>();

	public static void receiptDisp()
	{
		System.out.println(" [영	수	  증] ");
		System.out.println(" 선택한메뉴	  옵션	 개수 ");
		System.out.println("------------------------------------");
		for(int i=0;i < vc.size();i++)
		{
			System.out.printf("\n%d번 %s  %s  %s  %d원  %d개\n",i+1, vc.get(i).getName(), vc.get(i).getHoc(), vc.get(i).getIce()
				, vc.get(i).getPrice() * vc.get(i).getCount() ,vc.get(i).getCount());
		}
	}
}