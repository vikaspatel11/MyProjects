package test;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/messages")
public class Hello {

	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Message> getMessages() {
		System.out.println("Message Got....");
		return Service.getInstance().getMessages();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void addMessage(Message message) {
		System.out.println("Message added....");
		Service.getInstance().addMessage(message);
	}
}
