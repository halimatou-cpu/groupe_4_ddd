package use_case;

public class NotFoundException extends RuntimeException{
		public NotFoundException(String message) {
				super(message);
		}
}
