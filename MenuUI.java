import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class MenuUI
{

   public static int sel = 1;

   public static void menuRun() throws IOException
   {
		CategoryUI.category();
		CategoryUI.categoryRun();
   }

   public static void main(String[] args) throws IOException
	{
		menuRun();
	}
}