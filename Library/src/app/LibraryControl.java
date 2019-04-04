package app;

import java.rmi.NoSuchObjectException;
import java.util.InputMismatchException;

import exeption.NoSuchOptionException;
import io.ConsolePrinter;
import io.DataReader;
import model.Book;
import model.Library;
import model.Magazine;
import model.Publication;

public class LibraryControl {
	
	private ConsolePrinter printer = new ConsolePrinter();
    private DataReader dataReader = new DataReader(printer);

    private Library library = new Library();

    void controlLoop() {
        Option option;

        do {
            printOptions();
            option = getOption();
            switch (option) {
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
                    printMagazines();
                    break;
                case EXIT:
                    exit();
                    break;
                default:
                    printer.printLine("Nie ma takiej opcji, wprowadŸ ponownie: ");
            }
        } while (option != Option.EXIT);
    }

    private Option getOption() {
        boolean optionOk = false;
        Option option = null;
        while (!optionOk) {
            try {
                option = Option.createFromInt(dataReader.getInt());
                optionOk = true;
            } catch (NoSuchOptionException e) {
                printer.printLine(e.getMessage() + ", podaj ponownie:");
            } catch (InputMismatchException ignored) {
                printer.printLine("Wprowadzono wartoœæ, która nie jest liczb¹, podaj ponownie:");
            }
        }

        return option;
    }

    private void printOptions() {
        printer.printLine("Wybierz opcjê: ");
        for (Option option : Option.values()) {
            printer.printLine(option.toString());
        }
    }

    private void addBook() {
        try {
            Book book = dataReader.readAndCreateBook();
            library.addBook(book);
        } catch (InputMismatchException e) {
            printer.printLine("Nie uda³o siê utworzyæ ksi¹¿ki, niepoprawne dane");
        } catch (ArrayIndexOutOfBoundsException e) {
            printer.printLine("Osi¹gniêto limit pojemnoœci, nie mo¿na dodaæ kolejnej ksi¹¿ki");
        }
    }

    private void printBooks() {
        Publication[] publications = library.getPublications();
        printer.printBook(publications);
    }

    private void addMagazine() {
        try {
            Magazine magazine = dataReader.readAndCreateMagazine();
            library.addMagazine(magazine);
        } catch (InputMismatchException e) {
            printer.printLine("Nie uda³o siê utworzyæ magazynu, niepoprawne dane");
        } catch (ArrayIndexOutOfBoundsException e) {
            printer.printLine("Osi¹gniêto limit pojemnoœci, nie mo¿na dodaæ kolejnego magazynu");
        }
    }

    private void printMagazines() {
        Publication[] publications = library.getPublications();
        printer.printMagazine(publications);
    }

    private void exit() {
        printer.printLine("Koniec programu, papa!");
        // zamykamy strumieñ wejœcia
        dataReader.close();
    }
    
    private enum Option {
    	EXIT(0, "Wyjœcie z programu"),
    	ADD_BOOK(1, "Dodaj ksi¹¿kê"),
    	ADD_MAGAZINE(2, "Dodaj magazyn"),
    	PRINT_BOOK(3, "Wyœwietl dostepne ksi¹¿kê"),
    	PRINT_MAGAZINE(4, "Wyœwietl dostêpne magazyny");
    	
    	private int value;
    	private String description;
    	
    	 Option(int value, String description) {
    		this.value = value;
    		this.description = description;
    				}
    	 
    	 @Override
    	 public String toString() {
			return value+" - "+description;
    	 }
    	 
    	 static Option createFromInt(int option) throws NoSuchOptionException {
    		 try {
    			 return Option.values()[option];
    		 }catch (ArrayIndexOutOfBoundsException e) {
				throw new NoSuchOptionException("Brak opcji o id "+ option);
			}
			
    		 
    	 }
    	
    }
}