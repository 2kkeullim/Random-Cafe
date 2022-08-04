import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class MenuUI
{
   public static int sel = 1;

   public static void menuUI()
   {
      System.out.println("1. 매장이용");
      System.out.println("2. 포장");
      System.out.println("3. 쿠폰 사용");
      System.out.println("4. 관리자 모드");
      System.out.println("-------------");
      System.out.print("메뉴를 선택하세요(1 ~ 4) : ");
   }

   public static void menuSelect() throws IOException
   {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      do
      {
         sel = Integer.parseInt(br.readLine());

         if (sel >= 1 && sel <= 4)
            break;
         else
         {
            System.out.println("다시 입력하세요");
            menuUI();
         }
      }
      while (true);
   }

   public static void menuRun() throws IOException
   {
      switch (sel)
      {
		 case 1: 
		 case 2: CategoryUI.categorySelect(); break;
      }
   }

   public static void main(String[] args) throws IOException
   {
      
			menuUI();
			menuSelect();
			menuRun();
		
   }
}