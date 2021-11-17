package claudioteles.com.github.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import claudioteles.com.github.models.Car;
import claudioteles.com.github.services.CarService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/v1")
public class CarController {
	
	@Autowired
	private CarService carService;
	
	@PostMapping("/car")
	@ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Save Car", authorizations = { @Authorization(value="basicAuth") })
	@PreAuthorize("hasRole('ROLE_USER')")
	public Car save(@RequestBody Car car) {
		return carService.save(car);
	}
	
	@GetMapping("/car/{id}")
	@ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Get Car", authorizations = { @Authorization(value="basicAuth") })
	@PreAuthorize("hasRole('ROLE_USER')")
	public Car getById(@PathVariable("id") Long id) {
		return carService.getById(id);
	}
	
	@GetMapping("/cars")
	@ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Get All Cars", authorizations = { @Authorization(value="basicAuth") })
	@PreAuthorize("hasRole('ROLE_USER')")
	public List<Car> getAll() {
		return carService.getAllCars();
	}

}
