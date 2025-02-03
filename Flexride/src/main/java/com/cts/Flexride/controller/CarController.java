
package com.cts.Flexride.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.cts.Flexride.Entity.CarEntity;
import com.cts.Flexride.Service.CarService;

@Controller
@RequestMapping("/car")
public class CarController {

    @Autowired
    private CarService carService;

    // Show all cars in CarDetails page
    @GetMapping("/list")
    public String showCarDetailsPage(Model model) {
        model.addAttribute("cars", carService.getAllCars());
        model.addAttribute("car", new CarEntity());
        return "Cardetails";
    }

   
    // Add or Update Car
    @PostMapping("/save")
    public String saveCar(@ModelAttribute("car") CarEntity car) {
        carService.saveCar(car);
        return "redirect:/car/list";
    }

    // Delete Car
    @GetMapping("/delete/{id}")
    public String deleteCar(@PathVariable int id) {
        carService.deleteCar(id);
        return "redirect:/car/list";
    }

    // Edit Car (Load existing data into form)
    @GetMapping("/edit/{id}")
    public String editCar(@PathVariable int id, Model model) {
    	CarEntity car = carService.getCarById(id);
        if (car != null) {
            model.addAttribute("car", car);
        } else {
            model.addAttribute("car", new CarEntity()); // Ensures form does not break
        }
        model.addAttribute("cars", carService.getAllCars());
        return "Cardetails"; // Loads the page with populated form data
    }

    
}
