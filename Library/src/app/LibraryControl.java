package app;

import io.DataReader;
import model.Book;
import model.Library;
import model.Magazine;

public class LibraryControl {
	
	// zmienne do kontrolowania programy
	private final int EXIT = 0;
	private final int ADD_BOOK = 1;
	private final int ADD_MAGAZINE = 2;
	private final int PRINT_BOOK = 3;
	private final int PRINT_MAGAZINE = 4;
	
	// zmienne do komunikacji z u¿ytkownikiem
	DataReader dataReader = new DataReader();
	
	// Biblioteka - przechpwuj¹ca dane
	private Library library = new Library();
	
	/*
	 * G³ona metoda do wyboru opcji i interakcji 
	 */
	
	public void controlLoop() {
		int option;
		
		do {
			printOption();
			option = dataReader.getInt();
			switch(option) {
			case ADD_BOOK:
				addBook();
				break;
			case ADD_MAGAZINE:
				addMagazine();
				break;
			case PRINT_BOOK:
				printBooks();
				break;
			case PRINT_MAGAZINE:
				printMagazine();
				break;
			case EXIT:
				exit();
				break;
			default:
				System.out.println("Nie ma takiej opcji, wybierz ponownie");
			}
		}while(option != EXIT);
	}

	private void printMagazine() {
		library.printMagazine();
	}

	private void addMagazine() {
		Magazine magazine = dataReader.readAndCreateMagazine();
		library.addMagazine(magazine);
	}

	private void addBook() {
		Book book = dataReader.readAndCreateBook();
		library.addBook(book);
	}

	private void printBooks() {
		library.printBooks();
	}

	private void exit() {
		System.out.println("Koniec pracy");
		// zamykanie systemu
		dataReader.close();
	}

	private void printOption() {
		System.out.println("Wybie¿ opcje:");
		System.out.println(EXIT +" - Wyjœcie");
		System.out.println(ADD_BOOK + " - Dodaj ksi¹¿kê");
		System.out.println(ADD_MAGAZINE + " - Dodaj magazyn");
		System.out.println(PRINT_BOOK + " - Wyœwietkl ksi¹¿ki");
	}
}
