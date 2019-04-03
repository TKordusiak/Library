package app;

 enum Option {
	 
	 EXIT(0, "Wyjœcie z programy"),
	 ADD_BOOK(1, "Dodaj ksi¹zkê"),
	 ADD_MAGAZINE(2, "Dodaj magazyn"),
	 PRINT_BOOK(3, "Wyœwietl dostepne ksi¹zki"),
	 PRINT_MAGAZINE(4, "Wyœwietl dostepne magazyny");
	 
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
