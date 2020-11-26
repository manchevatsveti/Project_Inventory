package project_inv;

public class CD extends Product {
private String artist;
private int numSongs;
private String label;

public CD(int number, String name, int qty, double price,String artist,int numSongs, String label){
	super(number,name,qty,price);
	setArtist(artist);
	setNumSongs(numSongs);
	setLabel(label);
	}
public String toString()
{
     return "\n\nItem Number      : " + super.getItemNumber() 
   			+ "\nName             : " + super.getName() 
   			+ "\nArtist           : " + getArtist()
   			+ "\nSongs on album   : " + getNumSongs()
   			+ "\nRecord label     : " + getLabel()
   			+ "\nQuantity in stock: " + super.getQtyInStock() 
   			+ "\nPrice            : " + super.getPrice()
   			+ "\nStock Value      : " + super.getInventoryValue()
   			+ "\nProduct Status   : " + (super.getActive()?"Active":"Discontinued");
}


public String getArtist() {
	return artist;
}

public void setArtist(String artist) {
	this.artist = artist;
}

public int getNumSongs() {
	return numSongs;
}

public void setNumSongs(int numSongs) {
	this.numSongs = numSongs;
}

public String getLabel() {
	return label;
}

public void setLabel(String label) {
	this.label = label;
}
}
