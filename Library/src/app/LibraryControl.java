package app;

import io.DataReader;
import model.Book;
import model.Library;
import model.Magazine;

public class LibraryControl {
	
	
	// zmienne do komunikacji z u¿ytkownikiem
	DataReader dataReader = new DataReader();
	
	// Biblioteka - przechpwuj¹ca dane
	private Library library = new Library();
	
	/*
	 * G³ona metoda do wyboru opcji i interakcji 
	 */
	
	public void controlLoop() {
		Option option;
		
		do {
			printOption();
			option = Option.createFromInt(dataReader.getInt());
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
		}while(option != Option.EXIT);
	}

	private void printOption() {
		
		System.out.println("Wybie¿ opcje");
		for(Option option: Option.values()) {
			System.out.println(option);
		}
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

}
