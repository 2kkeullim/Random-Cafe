public class Drink
{
	private String name;
	private int price;
	private String hoc;
	private String ice;
	private int count;
	private int categoryNumber;
	private int drinkNumber;
	private boolean couponUse;

	public Drink(String hoc, String ice, int count)
	{
		this.hoc = hoc;
		this.ice = ice;
		this.count = count;
		categoryNumber = CategoryUI.sel-1;
		drinkNumber = DrinkUI.sel-1;
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
