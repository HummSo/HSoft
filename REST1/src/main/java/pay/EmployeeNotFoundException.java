package pay;

@SuppressWarnings("serial")
public class EmployeeNotFoundException extends RuntimeException {
	  EmployeeNotFoundException(long id){
		  super("No employee: " + id);
	  }
}