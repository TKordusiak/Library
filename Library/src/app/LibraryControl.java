package app;

import io.DataReader;
import model.Book;
import model.Library;

public class LibraryControl {
	
	// zmienne do kontrolowania programy
	private final int exit = 0;
	private final int addBook = 1;
	private final int printBook = 2;
	
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
			case addBook:
				addBook();
				break;
			case printBook:
				printBooks();
				break;
			case exit:
				exit();
				break;
			default:
				System.out.println("Nie ma takiej opcji, wybierz ponownie");
			}
		}while(option != exit);
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
		System.out.println(exit +" - Wyjœcie");
		System.out.println(addBook + " - Dodaj ksi¹¿kê");
		System.out.println(printBook + " - Wyœwietkl ksi¹¿ki");
	}
}
