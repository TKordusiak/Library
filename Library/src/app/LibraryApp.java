package app;

public class LibraryApp {

	public static void main(String[] args) {
		
		final String APP_NAME = "Biblioteka v0.7 4.04";
		System.out.println(APP_NAME);
		LibraryControl libraryControl = new LibraryControl();
		libraryControl.controlLoop();
	}

	
	
}
