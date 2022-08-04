import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class MenuUI
{

   public static int sel = 1;

   public static void menuRun() throws IOException
   {
		if (InitialUI.sel == 1)
		{	System.out.println();
			System.out.println("매장이용을 선택하셨습니다. ");
		}
		else if (InitialUI.sel == 2)
		{
			System.out.println();
			System.out.println("포장을 선택하셨습니다. ");
		}
		CategoryUI.category();
		CategoryUI.categoryRun();
   }

}