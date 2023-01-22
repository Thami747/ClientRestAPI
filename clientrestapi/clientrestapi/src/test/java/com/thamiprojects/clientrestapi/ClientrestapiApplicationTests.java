package com.thamiprojects.clientrestapi;

import com.thamiprojects.clientrestapi.model.Client;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ClientrestapiApplicationTests {
	@LocalServerPort
	private int port;
	private String baseUrl = "http://localhost";

	private static RestTemplate restTemplate;

	@BeforeAll
	public static void init() {
		restTemplate = new RestTemplate();
	}

	@BeforeEach
	public void setUp() {
		baseUrl = baseUrl.concat(":").concat(port+"").concat("/client");
	}

	/**
	 * The below tests are to test creating a client.
	 */
	@Test
	public void testCreateClientEmptyFirstName() {
		Client client = new Client();
		client.setFirstName("");

		Client clientResponse = restTemplate.postForObject(baseUrl+"/saveClient", client, Client.class);
		assertEquals("Client firstName cannot be empty or null.", clientResponse.getMessage());
	}

	@Test
	public void testCreateClientNullFirstName() {
		Client client = new Client();
		client.setFirstName(null);

		Client clientResponse = restTemplate.postForObject(baseUrl+"/saveClient", client, Client.class);
		assertEquals("Client firstName cannot be empty or null.", clientResponse.getMessage());
	}

	@Test
	public void testCreateClientEmptyLastName() {
		Client client = new Client();
		client.setFirstName("Peter");
		client.setLastName("");

		Client clientResponse = restTemplate.postForObject(baseUrl+"/saveClient", client, Client.class);
		assertEquals("Client lastName cannot be empty or null.", clientResponse.getMessage());
	}

	@Test
	public void testCreateClientNullLastName() {
		Client client = new Client();
		client.setFirstName("Peter");
		client.setLastName(null);

		Client clientResponse = restTemplate.postForObject(baseUrl+"/saveClient", client, Client.class);
		assertEquals("Client lastName cannot be empty or null.", clientResponse.getMessage());
	}

	@Test
	public void testCreateClientEmptyIdNumber() {
		Client client = new Client();
		client.setFirstName("Peter");
		client.setLastName("Nkosi");
		client.setIdNumber("");

		Client clientResponse = restTemplate.postForObject(baseUrl+"/saveClient", client, Client.class);
		assertEquals("South African ID number should contain 13 digits and cannot be empty or null.", clientResponse.getMessage());
	}

	@Test
	public void testCreateClientNullIdNumber() {
		Client client = new Client();
		client.setFirstName("Peter");
		client.setLastName("Nkosi");
		client.setIdNumber(null);

		Client clientResponse = restTemplate.postForObject(baseUrl+"/saveClient", client, Client.class);
		assertEquals("South African ID number should contain 13 digits and cannot be empty or null.", clientResponse.getMessage());
	}

	@Test
	public void testCreateClientIdNumberContainsLessThanThirteendigits() {
		Client client = new Client();
		client.setFirstName("Peter");
		client.setLastName("Nkosi");
		client.setIdNumber("921007533508");

		Client clientResponse = restTemplate.postForObject(baseUrl+"/saveClient", client, Client.class);
		assertEquals("South African ID number should contain 13 digits and cannot be empty or null.", clientResponse.getMessage());
	}

	@Test
	public void testCreateClientIdNumberDuplicate() {
		Client client = new Client();
		client.setFirstName("Peter");
		client.setLastName("Nkosi");
		client.setIdNumber("9210075335089");

		Client clientResponse = restTemplate.postForObject(baseUrl+"/saveClient", client, Client.class);
		assertEquals("Filed to create Client, either ID number or mobile number is duplicate.", clientResponse.getMessage());
	}

	@Test
	public void testCreateClientMobileNumberDuplicate() {
		Client client = new Client();
		client.setFirstName("Peter");
		client.setLastName("Nkosi");
		client.setIdNumber("9210075335085");
		client.setMobileNumber("0721612718");

		Client clientResponse = restTemplate.postForObject(baseUrl+"/saveClient", client, Client.class);
		assertEquals("Filed to create Client, either ID number or mobile number is duplicate.", clientResponse.getMessage());
	}

	@Test
	public void testCreateClientSuccess() {
		Client client = new Client();
		client.setFirstName("Peter");
		client.setLastName("Nkosi");
		client.setIdNumber("9210075335082");
		client.setMobileNumber("0721612712");
		client.setAddress("109 Grant Street, Lilyvale, Benoni, 1515");

		Client clientResponse = restTemplate.postForObject(baseUrl+"/saveClient", client, Client.class);
		assertEquals("Successfully created Client.", clientResponse.getMessage());
	}

	/**
	 * The below tests are  for updating a client
	 */

	@Test
	public void testUpdateClientEmptyFirstName() {
		Client client = new Client();
		client.setFirstName("");

		Client clientResponse = restTemplate.postForObject(baseUrl+"/updateClient", client, Client.class);
		assertEquals("Client firstName cannot be empty or null.", clientResponse.getMessage());
	}

	@Test
	public void testUpdateClientNullFirstName() {
		Client client = new Client();
		client.setFirstName(null);

		Client clientResponse = restTemplate.postForObject(baseUrl+"/updateClient", client, Client.class);
		assertEquals("Client firstName cannot be empty or null.", clientResponse.getMessage());
	}

	@Test
	public void testUpdateClientEmptyLastName() {
		Client client = new Client();
		client.setFirstName("Peter");
		client.setLastName("");

		Client clientResponse = restTemplate.postForObject(baseUrl+"/updateClient", client, Client.class);
		assertEquals("Client lastName cannot be empty or null.", clientResponse.getMessage());
	}

	@Test
	public void testUpdateClientNullLastName() {
		Client client = new Client();
		client.setFirstName("Peter");
		client.setLastName(null);

		Client clientResponse = restTemplate.postForObject(baseUrl+"/updateClient", client, Client.class);
		assertEquals("Client lastName cannot be empty or null.", clientResponse.getMessage());
	}

	@Test
	public void testUpdateClientEmptyIdNumber() {
		Client client = new Client();
		client.setFirstName("Peter");
		client.setLastName("Nkosi");
		client.setIdNumber("");

		Client clientResponse = restTemplate.postForObject(baseUrl+"/updateClient", client, Client.class);
		assertEquals("South African ID number should contain 13 digits and cannot be empty or null.", clientResponse.getMessage());
	}

	@Test
	public void testUpdateClientNullIdNumber() {
		Client client = new Client();
		client.setFirstName("Peter");
		client.setLastName("Nkosi");
		client.setIdNumber(null);

		Client clientResponse = restTemplate.postForObject(baseUrl+"/updateClient", client, Client.class);
		assertEquals("South African ID number should contain 13 digits and cannot be empty or null.", clientResponse.getMessage());
	}

	@Test
	public void testUpdateClientIdNumberContainsLessThanThirteendigits() {
		Client client = new Client();
		client.setFirstName("Peter");
		client.setLastName("Nkosi");
		client.setIdNumber("921007533508");

		Client clientResponse = restTemplate.postForObject(baseUrl+"/updateClient", client, Client.class);
		assertEquals("South African ID number should contain 13 digits and cannot be empty or null.", clientResponse.getMessage());
	}

	@Test
	public void testUpdateClientDoesNotExist() {
		Client client = new Client();
		client.setFirstName("Peter");
		client.setLastName("Nkosi");
		client.setIdNumber("9210075335085");
		client.setMobileNumber("0721612715");
		client.setAddress("777 Grant Street, Daveyton, Benoni, 2020");

		Client clientResponse = restTemplate.postForObject(baseUrl+"/updateClient", client, Client.class);
		assertEquals("Client does not exist!", clientResponse.getMessage());
	}

	@Test
	public void testUpdateClientSuccess() {
		Client client = new Client();
		client.setFirstName("Peter");
		client.setLastName("Nkosi");
		client.setIdNumber("9210075335089");
		client.setMobileNumber("0721612718");
		client.setAddress("777 Grant Street, Daveyton, Benoni, 2020");

		Client clientResponse = restTemplate.postForObject(baseUrl+"/updateClient", client, Client.class);
		assertEquals("Successfully updated Client.", clientResponse.getMessage());
	}

	/**
	 * The below tests are to test searching for a client
	 */
	@Test
	public void testGetClientDoesNotExist() {
		Client clientResponse = restTemplate.getForObject(baseUrl+"/getClientById/9210075335088", Client.class);
		assertEquals("Client does not exist.", clientResponse.getMessage());
	}

	@Test
	public void testGetClientSuccess() {
		Client clientResponse = restTemplate.getForObject(baseUrl+"/getClientById/9210075335089", Client.class);
		assertEquals("Successfully found client.", clientResponse.getMessage());
	}

}
