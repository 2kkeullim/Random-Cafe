public class Drink                   // 장바구니 벡터에 담길 인스턴스
{ 
	private String name;             // 음료 이름
	private int price;				 // 음료 한잔 당 가격
	private String hoc;				 // 뜨거운 or 차가운  택1 (옵션)
	private String ice;				 // 얼음양 조절  (옵션)
	private int count;				 // 주문갯수
	private int categoryNumber;		 // 주문한 음료의 카테고리 넘버 (구분자)
	private int drinkNumber;         // 주문한 음료의 메뉴넘버 (구분자) 
	private boolean couponUse;       // 쿠폰사용여부

	public Drink(String hoc, String ice, int count)
	{
		this.hoc = hoc;							  // 온도 옵션 초기화
		this.ice = ice;							  // 얼음양 옵션 초기화
		this.count = count;                       // 갯수초기화 
		categoryNumber = CategoryUI.sel - 1;      // 인스턴스 생성 시 카테고리 넘버 초기화
		drinkNumber = DrinkUI.sel - 1;            // 인스턴스 생성 시 메뉴넘버 초기화
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public int getPrice()
	{
		return price;
	}

	public void setPrice(int price)
	{
		this.price = price;
	}

	public String getHoc()
	{
		return hoc;
	}

	public void setHoc(String hoc)
	{
		this.hoc = hoc;
	}

	public String getIce()
	{
		return ice;
	}

	public void setIce(String ice)
	{
		this.ice = ice;
	}

	public int getCount()
	{
		return count;
	}
	
	public void setCount(int count)
	{
		this.count = count;
	}

	public int getCategoryNumber()
	{
		return categoryNumber;
	}
	
	public void setCategoryNumber(int categoryNumber)
	{
		this.categoryNumber = categoryNumber;
	}

	public int getDrinkNumber()
	{
		return drinkNumber;
	}
	
	public void settDrinkNumber(int drinkNuber)
	{
		this.drinkNumber = drinkNumber;
	}

	public boolean getCouponUse()
	{
		return couponUse;
	}
	
	public void setCouponUse(boolean couponUse)
	{
		this.couponUse = couponUse;
	}

}
