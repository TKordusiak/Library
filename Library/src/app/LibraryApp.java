package app;

import io.DataReader;
import model.Book;

public class LibraryApp {

	public static void main(String[] args) {
		
		final String appName = "Biblioteka v0.6";
		System.out.println(appName);
		LibraryControl libraryControl = new LibraryControl();
		libraryControl.controlLoop();
	}

	
	
}
