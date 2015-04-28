package it.tostao.sswa.service;

import it.tostao.sswa.model.Car;

import java.util.List;

/**
 * Created by sleski on 28.04.2015.
 */
public interface CarService {

    int sizeInGarage();

    Car findByPlate(String plate);

    List<Car> findByModel(String model);

}
