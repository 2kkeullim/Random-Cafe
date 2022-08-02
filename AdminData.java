import java.util.HashMap;
import java.util.Map;

public class AdminData
{
	private static final String[] id = {"조", "최", "정", "반"};
	private static final String[] pw = {"1", "2", "3", "4"};

	public static void main(String[] args)
	{
		// 배열(id, pw)에 담겨있는 데이터를 요소로 담아내기
		for (int i=0; i<id.length; i++)
		{
			AdminList.account.put(id[i], pw[i]);
		}
		// 배열에 있는 데이터 출력
		for (int j=0; j<id.length; j++)
		{
			System.out.println(id[j] + "," + AdminList.account.get(id[j]));
		}
	}
}