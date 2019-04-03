package app;

 enum Option {
	 
	 EXIT(0, "Wyj�cie z programy"),
	 ADD_BOOK(1, "Dodaj ksi�zk�"),
	 ADD_MAGAZINE(2, "Dodaj magazyn"),
	 PRINT_BOOK(3, "Wy�wietl dostepne ksi�zki"),
	 PRINT_MAGAZINE(4, "Wy�wietl dostepne magazyny");
	 
	 private int value;
	 private String description;
	 
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	 
	 Option(int value, String description){
		 this.value = value;
		 this.description = description;
	 }
	 
	 @Override
	 public String toString() {
		 return value+" - "+description;
	 }
	 
	 public static Option createFromInt( int option) {
		return Option.values()[option];
		 
	 }

}
