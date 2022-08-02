import java.util.HashMap;
import java.util.Map;

public class AdminList	// 관리자 id와 pw를 담을 구조생성
{	
	// key : id, value: pw
	// account라는 Hashtable 자료구조 생성
	public static HashMap<String, String> account;
	//					 ------key
	//							  ------value
	
	static
	{
		//account 인스턴스 생성
		account = new HashMap<String, String>();
	}
}