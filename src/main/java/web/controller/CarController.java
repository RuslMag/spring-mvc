package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.service.CarService;

import java.util.Optional;

@Controller
@RequestMapping("/cars")
public class CarController {

    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping()
    public String getCars(@RequestParam(required = false) Optional<Integer> count, Model model) {
        if (!count.isPresent()) {
            model.addAttribute("allCars", carService.getCarList());
        } else {
            model.addAttribute("allCars", carService.getCarList(count));
        }
        return "cars";
    }
}
