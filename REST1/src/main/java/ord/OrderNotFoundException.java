package ord;

@SuppressWarnings("serial")
public class OrderNotFoundException extends RuntimeException {
	OrderNotFoundException(long id){
		  super("No order: " + id);
	}
}