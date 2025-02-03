
package com.cts.Flexride.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.cts.Flexride.Entity.CarEntity;
import com.cts.Flexride.Repo.CarRepo;

@Service
public class CarService {

    @Autowired
    private CarRepo carRepo;

    // Create or Update Car
    public void saveCar(CarEntity car) {
        carRepo.save(car);
    }

    // Retrieve All Cars
    public List<CarEntity> getAllCars() {
        return carRepo.findAll();
    }

    // Delete Car
    public void deleteCar(int id) {
        carRepo.deleteById(id);
    }

    // Retrieve Car by ID
    public CarEntity getCarById(int id) {
        return carRepo.findById(id).orElse(null);
    }
}

