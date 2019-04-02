package model;

public class Library {
	
	private final int MAX_BOOKS = 1000;
	private final int MAX_MAGAZINE = 1000;
	private Book[] books = new Book[MAX_BOOKS];
	private Magazine[] magazines = new Magazine[MAX_MAGAZINE];
	private int booksNumber;
	private int magazinesNumber;
	
	public void addBook(Book book) {
		if(booksNumber < MAX_BOOKS) {
			books[booksNumber] = book;
			booksNumber++;
		}else {
			System.out.println("Maksymalna liczba ksi¹¿ek zosta³a osi¹gniêta");
		}
	}
	
	
	public void printBooks() {
		if(booksNumber==0) {
			System.out.println("Brak ksi¹zki");
		}
		for(int i=0; i<booksNumber; i++) {
			books[i].printInfo();
		}
	}
	
	public void addMagazine(Magazine magazine) {
		if(magazinesNumber < MAX_MAGAZINE) {
			magazines[magazinesNumber] = magazine;
			magazinesNumber++;
		}else {
			System.out.println("Maksymalna liczba magazynów zost³a osi¹gniêta!");
		}
	}
	
	public void printMagazine() {
		if(magazinesNumber==0) {
			System.out.println("Brak magazynu");
		}
		for(int i = 0; i<magazinesNumber; i++) {
			magazines[i].printInfo();
		}
	}

}
