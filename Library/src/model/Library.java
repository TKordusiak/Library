package model;

public class Library {
	
	private final int MAX_PUBLICATION = 2000;
	private int publicationNumber;
	private Publication[] publications = new Publication[MAX_PUBLICATION];

	public Publication[]getPublications() {
		Publication[] result = new Publication[publicationNumber];
			for(int i=0; i<publicationNumber; i++) {
				result[i] = publications[i];
			}
		return result;
		
	}
	
	public void addBook(Book book) {
		addPublicatio(book);
	}
	

	public void addMagazine(Magazine magazine) {
		addPublicatio(magazine);
	}

	private void addPublicatio(Publication publication) {
		if(publicationNumber >= MAX_PUBLICATION) {
			throw new ArrayIndexOutOfBoundsException("Max publication exceeded"+MAX_PUBLICATION);
		}
		publications[publicationNumber]=publication;
		publicationNumber++;
		
	}
	
	

}
