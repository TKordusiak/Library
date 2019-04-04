package io;

import java.util.Scanner;

import model.Book;
import model.Magazine;

public class DataReader {
	 
	private Scanner sc = new Scanner(System.in);
	private ConsolePrinter printer;
	
	public DataReader(ConsolePrinter printer){
		this.printer = printer;
	}
	
	public void close() {
		sc.close();
	}
	
	public int getInt() {
		try {
			return sc.nextInt();
		}finally {
			sc.nextLine();
		}
		
	}
	
	public Book readAndCreateBook() {
		
		System.out.println("Tytu³: ");
        String title = sc.nextLine();
        System.out.println("Autor: ");
        String author = sc.nextLine();
        System.out.println("Wydawnictwo: ");
        String publisher = sc.nextLine();
        System.out.println("ISBN: ");
        String isbn = sc.nextLine();
        System.out.println("Rok wydania: ");
        int releaseDate = getInt();
        System.out.println("Iloœæ stron: ");
        int pages = getInt();
	
		
		return new Book(title, author, releaseDate, pages, publisher, isbn);
		
	}
	
	public Magazine readAndCreateMagazine() {
		System.out.println("Tytu³:");
		String title = sc.nextLine();
		System.out.println("Wydawca");
		String publisher = sc.nextLine();
		System.out.println("Rok:");
		int year = getInt();
		System.out.println("Miesi¹c:");
		int month = getInt();
		System.out.println("Dzieñ:");
		int day = getInt();
		String language = sc.nextLine();
		return new Magazine(year, title, publisher, month, day, language);
		
	}

}
