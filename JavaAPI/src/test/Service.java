package test;

import java.util.ArrayList;
import java.util.List;

public class Service {

	private static Service service;
	private Service () {
		
	}
	
	public static Service getInstance() {
		if (service==null) {
			service = new Service();
		}
		return service;
	}
	List<Message> messageList = new ArrayList<Message>();
	
	public List<Message> getMessages() {
		
		Message msg1 = new Message("vikas", "Jan 20", 1001, "Hello Vikas, how are you?");
		Message msg2 = new Message("dharmendra", "April 11", 1001, "Hello Dharmendra, how are you?");
		
		
		messageList.add(msg1);
		messageList.add(msg2);
		
		return messageList;
		
	}
	
	public void addMessage(Message message) {
		messageList.add(message);
	}
	
	
}
