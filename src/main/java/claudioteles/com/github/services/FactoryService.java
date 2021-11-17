package claudioteles.com.github.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import claudioteles.com.github.dao.FactoryDao;
import claudioteles.com.github.models.Factory;

@Service
public class FactoryService {
	
	@Autowired
	private FactoryDao factoryDao;
	
	public Factory save(Factory factory) {
		return factoryDao.save(factory);
	}
	
	public Factory getById(Long id) {
		return factoryDao.findById(id).get();
	}
	
	public List<Factory> getAllFactories() {
		return factoryDao.findAll();
	}

}
