import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Vector;
import java.io.IOException;

public class Cart
{
	public static Vector<Drink> vc = new Vector<Drink>();
	public static int sel;
	public static void printVC() throws IOException
	{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		System.out.println();
		System.out.println("선택한 음료명 ");
		System.out.println("------------------------------------");
		for(int i=0;i < vc.size();i++)
		{
			System.out.printf("\n%d번 %s  %s  %s  %d원  %d개\n",i+1, vc.get(i).getName(), vc.get(i).getHoc(), vc.get(i).getIce()
				, vc.get(i).getPrice() * vc.get(i).getCount() ,vc.get(i).getCount());
		}
		System.out.println("------------------------------------");
		System.out.print("1. 결제하기   2.항목 삭제하기 3. 뒤로가기");
		sel = Integer.parseInt(br.readLine());
		switch(sel)
		{
			case 1: 
			case 2: remove(); break;
		}
	}

	public static void overLap(Drink dr)
	{
		for(int i=0;i < vc.size()-1; i++)
		{
			if((dr.getName()).equals(vc.get(i).getName()) && (dr.getHoc()).equals(vc.get(i).getHoc()) && dr.getIce().equals(vc.get(i).getIce()))
			{
				int x = vc.get(i).getCount();
				 x += dr.getCount();
				vc.get(i).setCount(x);
				vc.remove(vc.size()-1);
			}
		}	
	}

	public static void remove() throws IOException
	{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		System.out.print("삭제할 항목의 번호를 입력하세요. : " );
		int temp = Integer.parseInt(br.readLine());
		vc.remove(temp-1);
	}

	


}