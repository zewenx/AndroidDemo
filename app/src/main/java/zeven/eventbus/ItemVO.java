package zeven.eventbus;

public class ItemVO {
	private String message;

	public String getMessage() {
		return message;
	}

	public ItemVO setMessage(String message) {
		this.message = message;
		return this;
	}
	
	public String toString(){
		return message;
	}
	
}
