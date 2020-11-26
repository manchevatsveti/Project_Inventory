package project_inv;

public class DVD extends Product{
	 private int lenght;
	 private int ageRating;
	 private String filmStudio;

	public DVD(int number, String name, int qty, double price,int lenght,int ageRating, String filmStudio){
	super(number,name,qty,price);
	this.setLenght(lenght);
	this.setAgeRating(ageRating);
	this.setFilmStudio(filmStudio);
	}
	public String toString()
	{
	     return "\n\nItem Number      : " + super.getItemNumber() 
	   			+ "\nName             : " + super.getName() 
	   			+ "\nMovie Length     : " + getLenght()
	   			+ "\nAge Rating       : " + getAgeRating()
	   			+ "\nFilm Studio      : " + getFilmStudio()
	   			+ "\nQuantity in stock: " + super.getQtyInStock() 
	   			+ "\nPrice            : " + super.getPrice()
	   			+ "\nStock Value      : " + super.getInventoryValue()
	   			+ "\nProduct Status   : " + (super.getActive()?"Active":"Discontinued");
	}
	  public double getInventoryValue()
	    {
	      return super.getPrice() * super.getQtyInStock()*105/100;
	    }

	public double getLenght() {
		return lenght;
	}

	public void setLenght(int lenght) {
		this.lenght = lenght;
	}

	public int getAgeRating() {
		return ageRating;
	}

	public void setAgeRating(int ageRating) {
		this.ageRating = ageRating;
	}

	public String getFilmStudio() {
		return filmStudio;
	}

	public void setFilmStudio(String filmStudio) {
		this.filmStudio = filmStudio;
	}
	}
