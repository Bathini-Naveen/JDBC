package school;

public class LoadDriver {
public static void main(String[] args) {
  try {
	Class.forName("org.postgresql.Driver");
	System.out.println("Driver Loaded");
} 
  catch (ClassNotFoundException e) {
	e.printStackTrace();
}
}
}
