package claudioteles.com.github;

import org.hamcrest.CoreMatchers;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;

import claudioteles.com.github.enumarations.Fuel;
import claudioteles.com.github.models.Car;
import claudioteles.com.github.models.Factory;
import claudioteles.com.github.services.CarService;
import claudioteles.com.github.services.FactoryService;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@TestMethodOrder(OrderAnnotation.class)
class ApiSpringSecurityApplicationTests {
	
	@LocalServerPort
	private int port;
	@Autowired
	private MockMvc mockMvc;
	@Autowired
	private ObjectMapper objectMapper;
	
	@Autowired
	private FactoryService factoryService;
	@Autowired
	private CarService carService;
	
	@Test @Order(1) @WithMockUser(username = "user", password = "password_123", roles = {"USER"})
	void carSaveControllerTest() {
		Factory factory1 = factoryService.save(new Factory(null, "FÁBRICA_UM", (short) 150));
		Car car1 = carService.save(new Car(null, factory1, "MODELO_UM", (short) 2015, Fuel.ALCOHOL, (short) 4, 45750.56f, "VERDE"));
		
		try {
			this.mockMvc
			.perform(
					MockMvcRequestBuilders
						.post("/api/v1/car")
						.content(objectMapper.writeValueAsString(car1))
						.contentType(MediaType.APPLICATION_JSON)
						.accept(MediaType.APPLICATION_JSON)
					)
			.andExpect(MockMvcResultMatchers.status().isCreated())
			.andExpect(MockMvcResultMatchers.jsonPath("$.id").exists())
			.andExpect(MockMvcResultMatchers.jsonPath("$.model", CoreMatchers.is("MODELO_UM")));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test @Order(2) @WithMockUser(username = "user", password = "password_123", roles = {"USER"})
	void getCarByIdControllerTest() {
		try {
			this.mockMvc
			.perform(
					MockMvcRequestBuilders
						.get("/api/v1/car/33")
						.contentType(MediaType.APPLICATION_JSON)
						.accept(MediaType.APPLICATION_JSON)
					)
			.andExpect(MockMvcResultMatchers.status().isOk());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test @Order(3) @WithMockUser(username = "user", password = "password_123", roles = {"USER"})
	void getAllCarsControllerTest() {
		try {
			this.mockMvc
			.perform(
					MockMvcRequestBuilders
						.get("/api/v1/cars")
						.contentType(MediaType.APPLICATION_JSON)
						.accept(MediaType.APPLICATION_JSON)
					)
			.andExpect(MockMvcResultMatchers.status().isOk())
			.andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(1)));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test @Order(4) @WithMockUser(username = "user", password = "password_123", roles = {"USER"})
	void spreadsheetSaveControllerTest() {
		try {
			String fileLocationWithExtension = "/files/carro.xlsx";
			this.mockMvc
			.perform(
					MockMvcRequestBuilders
						.post("/api/v1/spreadsheet")
						.content(objectMapper.writeValueAsString(fileLocationWithExtension))
						.contentType(MediaType.APPLICATION_JSON)
						.accept(MediaType.APPLICATION_JSON)
					)
			.andExpect(MockMvcResultMatchers.status().isCreated());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test @Order(5) @WithMockUser(username = "user", password = "password_123", roles = {"USER"})
	void getSpreadsheetByIdControllerTest() {
		try {
			this.mockMvc
			.perform(
					MockMvcRequestBuilders
						.get("/api/v1/spreadsheet/34")
						.contentType(MediaType.APPLICATION_JSON)
						.accept(MediaType.APPLICATION_JSON)
					)
			.andExpect(MockMvcResultMatchers.status().isOk());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test @Order(6) @WithMockUser(username = "user", password = "password_123", roles = {"USER"})
	void getAllSpreadsheetsControllerTest() {
		try {
			this.mockMvc
			.perform(
					MockMvcRequestBuilders
						.get("/api/v1/spreadsheets")
						.contentType(MediaType.APPLICATION_JSON)
						.accept(MediaType.APPLICATION_JSON)
					)
			.andExpect(MockMvcResultMatchers.status().isOk());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
}
