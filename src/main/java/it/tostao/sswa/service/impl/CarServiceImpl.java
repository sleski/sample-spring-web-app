package it.tostao.sswa.service.impl;

import it.tostao.sswa.mapper.CarMapper;
import it.tostao.sswa.model.Car;
import it.tostao.sswa.service.CarService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Collections;
import java.util.List;

/**
 * Created by sleski on 28.04.2015.
 */
public class CarServiceImpl implements CarService {

    Logger LOG = LoggerFactory.getLogger(CarServiceImpl.class);

    private final String CAR_FIELDS = "brand, model, year, doorsNumber, plate";
    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * Default constructor.
     */
    public CarServiceImpl() {

    }

    /**
     * Constructor with param.
     *
     * @param jdbcTemplate
     */
    public CarServiceImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int sizeInGarage() {
        String query = "SELECT count(*) FROM car";
        int counter = jdbcTemplate.queryForObject(query, Integer.class);
        LOG.info("No of cars = " + counter);
        return counter;
    }

    @Override
    public Car findByPlate(String plate) {
        String query = "SELECT " + CAR_FIELDS + " FROM car WHERE plate = ?";
        List<Car> cars = jdbcTemplate.query(query, new CarMapper(), plate);
        if (!cars.isEmpty()) {
            return cars.get(0);
        }
        LOG.warn("Car with given plate doesn't exist, plate = " + plate);
        return null;
    }

    @Override
    public List<Car> findByModel(String model) {
        return null;
    }
}
