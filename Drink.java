public class Drink
{
	private String name; // 해당 음료의 이름							 ex) 아메리카노
	private int price;   // 해당 음료의 한잔 가격						 ex) 1500
	private String hoc;  // option 메소드로 초기화된 hot or cold		 ex) cold
	private String ice;  // option 메소드로 초기화된 얼음양			     ex) 얼음 많이
	private int count;   // cupsCount 메소드로 초기화 된 주문 갯수		 ex)  3
	private int categoryNumber; // 해당 카테고리의 선택번호를 담을 변수	 ex)  0  (밑의 생성자에서 초기화됨.) - Sales 내 addSales 메소드사용을위해서 존재
	private int drinkNumber;    // 해당 음료의     선택번호를 담을 변수  ex)  0  (밑의 생성자에서 초기화됨.) - 위와 동일
	private boolean couponUse;

	public Drink(String hoc, String ice, int count)  // Option 메소드로 받아온 값을 매개변수로 인스턴스 생성.
	{
		this.hoc = hoc;                        
		this.ice = ice;
		this.count = count;
		categoryNumber = CategoryUI.sel - 1; 
		drinkNumber = DrinkUI.sel - 1;
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
