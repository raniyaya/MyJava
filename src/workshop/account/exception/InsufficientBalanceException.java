package workshop.account.exception;

public class InsufficientBalanceException extends Exception {
	//private String errMessage;
	public InsufficientBalanceException(String errMessage) {
		//ºÎ¸ðÀÇ »ý¼ºÀÚ¸¦ È£Ãâ
		//this.errMessage = errMessage;
		super(errMessage);
	}
}