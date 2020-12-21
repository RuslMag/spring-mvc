package web.service;

import org.springframework.stereotype.Service;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CarService {

    public List<Car> getCarList() {
        List<Car> carList = new ArrayList<>();
        carList.add(new Car("Ferrari", "RED", 450));
        carList.add(new Car("BMW", "WHITE", 7));
        carList.add(new Car("Aston Martin", "GREY", 99));
        carList.add(new Car("Audi", "PINK", 40));
        carList.add(new Car("Porshe", "YELLOW", 911));

        return carList;
    }

    public List<Car> getCarList(Optional<Integer> count) {

        List<Car> cars = new ArrayList<>();

        if (count.get() < getCarList().size()) {
            for (int i = 0; i < count.get(); i++) {
                cars.add(getCarList().get(i));
            }
        } else {
            cars = getCarList();
        }
        return cars;
    }
}
