package claudioteles.com.github.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import claudioteles.com.github.dao.CarDao;
import claudioteles.com.github.models.Car;

@Service
public class CarService {
	
	@Autowired
	private CarDao carDao;
	
	public Car save(Car car) {
		return carDao.save(car);
	}
	
	public Car getById(Long id) {
		return carDao.findById(id).get();
	}
	
	public List<Car> getAllCars() {
		return carDao.findAll();
	}

}
