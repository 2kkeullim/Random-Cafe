import java.util.HashMap;

public class Change
{
	public static HashMap<Integer, Integer> change;
	
	static
	{
		// Hash맵구조를 이용해 (액수, 갯수)로 잔돈 자료구조 생성
		change = new HashMap<Integer, Integer>();
		change.put(500,0);
		change.put(1000,0);
		change.put(5000,0);
		change.put(10000,0);
	}
	
	// 잔돈 총액을 반환해주는 메서드
	public static int sum()
	{
		// 잔돈 총합을 변수 sum에 더해줌
		int sum = 0;
		sum += 500 * change.get(500);
		sum += 1000 * change.get(1000);
		sum += 5000 * change.get(5000);
		sum += 10000 * change.get(10000);

		return sum;
	}
}