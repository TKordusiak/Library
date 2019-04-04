package io;

import model.Book;
import model.Magazine;
import model.Publication;

public class ConsolePrinter {
	
	public void printBook(Publication[] publications) {
		int counter = 0;
		for(Publication publication: publications) {
			if(publication instanceof Book) {
				printLine(publication.toString());
				counter++;
			}
		}
		if(counter == 0) {
			System.out.println("Brak ksi¹zki w bibliotece");
		}
	}
	
	public void printMagazine(Publication[] publications) {
		int counter = 0;
		for(Publication publication: publications) {
			if(publication instanceof Magazine) {
				printLine(publication.toString());
				counter++;
			}
		}
	}

	public void printLine(String text) {
		System.out.println(text);
	}

}
