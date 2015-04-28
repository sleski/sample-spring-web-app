package it.tostao.sswa.service.impl;

import it.tostao.sswa.model.Car;
import it.tostao.sswa.service.CarService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * Created by sleski on 28.04.2015.
 */
public class CarServiceImpl implements CarService {

    Logger LOG = LoggerFactory.getLogger(CarServiceImpl.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int sizeInGarage() {
        String query = "SELECT count(*) FROM car";
        int counter = jdbcTemplate.queryForObject(query, Integer.class);
        LOG.info("No of cars = " + counter);
        return counter;
    }

    @Override
    public Car findByPlate(String plate) {
        return null;
    }

    @Override
    public List<Car> findByModel(String model) {
        return null;
    }
}
