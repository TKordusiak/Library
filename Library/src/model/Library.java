package model;

public class Library {
	
	private final int MAX_PUBLICATION = 2000;
	private int publicationNumber;
	private Publication[] publications = new Publication[MAX_PUBLICATION];

	
	public void addBook(Book book) {
		if(publicationNumber < MAX_PUBLICATION) {
			publications[publicationNumber] = book;
			publicationNumber++;
		}else {
			System.out.println("Maksymalna liczba ksi��ek zosta�a osi�gni�ta");
		}
	}
	
	
	public void printBooks() {
		int countBooks = 0;
		for(int i=0; i<publicationNumber; i++) {
			if (publications[i] instanceof Book) {
	             System.out.println(publications[i]);
	             countBooks++;
			 }
		}
		if(countBooks==0) {
			System.out.println("Brak ksi�zki");
		}
		 
	}
	
	public void addMagazine(Magazine magazine) {
		if(publicationNumber < MAX_PUBLICATION) {
			publications[publicationNumber] = magazine;
			publicationNumber++;
		}else {
			System.out.println("Maksymalna liczba magazyn�w zost�a osi�gni�ta!");
		}
	}
	
	public void printMagazine() {
		int countMagazin = 0;
		for(int i=0; i<publicationNumber; i++) {
			if(publications[i]instanceof Magazine){
				System.out.println(publications[i]);
				countMagazin++;
			}
		}
		if(countMagazin==0) {
			System.out.println("Brak magazynu");
		}
		
	}

}
