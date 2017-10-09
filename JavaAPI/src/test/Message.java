package test;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Message {

	private String author;
	private String created;
	private int id;
	private String message;
	
	public Message(String author, String created, int id, String message){
		this.author = author;
		this.created = created;
		this.id = id;
		this.message = message;
	}
	
	public Message() {
		
	}
	
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getCreated() {
		return created;
	}
	public void setCreated(String created) {
		this.created = created;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}
