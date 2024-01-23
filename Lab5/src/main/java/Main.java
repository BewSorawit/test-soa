import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;


public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Client client = Client.create();
			WebResource webResource = client.resource("http://localhost:8080/jersey/rest/services/customers/A");
			ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);
			if (response.getStatus() != 200) {
				throw new RuntimeException("Failed : HTTP errorcode : " + response.getStatus());
			}
			String output = response.getEntity(String.class);
			System.out.println("Output from Server .... \n");
			System.out.println(output);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
