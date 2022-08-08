import java.io.IOException;

public class Coffee extends Options
{	
	// 커피 카테고리의 음료 목록
	public static String drinkName[] = {"아메리카노", "카페라떼", "바닐라라떼", "카페모카", "돌체라떼", "랜덤커피"};
	// 커피 카테고리 각 음료의 가격 목록 
	public static int drinkPrice[] = {1500, 2000, 2500, 2500, 3500, 2000};

	public void set(String drinkName, int drinkPrice) throws IOException
	{
		// DrinkUI에서 입력받은 음료 선택값인 sel을 받아와
		// 위 drinkName[] drinkPrice[] 배열에서 해당하는 정보를
		// 아래 Drink 객체에 대입
		System.out.println("\n" + Coffee.drinkName[DrinkUI.sel - 1] + " 을(를) 선택하셨습니다.\n");
		// 음료에 따라 option1(), option2() 메소드 호출
		option1();
		
		//옵션 클래스에서 결정한 옵션들을 활용해 Drink타입 객체 생성
		Drink dr = new Drink(hotOrColdOption, iceOption, drinkCountOption);
		
		// new Coffee().set(Coffee.drinkName[sel - 1], Coffee.drinkPrice[sel - 1]);
		// 예시에서 커피 -> 아메리카노를 골랐으므로 아래에 정리해보면
		// drinkName = Coffe.drinkName[0] = 아메리카노
		// drinkPrice = Coffe.drinkPrice[0] = 1500이 대입됨.
		dr.setName(drinkName);
		dr.setPrice(drinkPrice);
		// 그렇게 옵션, 이름, 가격, 갯수가 대입된 Drink 객체를
		// 장바구니 벡터인 vc에 대입
		Cart.vc.add(dr);
		
		// 옵션,이름,가격,갯수가 완전히 똑같은 Drink 객체가 있다면
		// 해당하는 메뉴의 갯수만 증가시키도록 중첩시킴
		if (DrinkUI.sel != 6)
			Cart.overLap(dr);
		
		// 장바구니 출력
		Cart.printVC();
	}
}