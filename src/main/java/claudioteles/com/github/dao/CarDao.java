package claudioteles.com.github.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import claudioteles.com.github.models.Car;

@Repository
public interface CarDao extends JpaRepository<Car, Long> {

}
