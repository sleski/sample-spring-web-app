package it.tostao.sswa.mapper;

import it.tostao.sswa.model.Car;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by sleski on 02.05.2015.
 */
public class CarMapper implements RowMapper<Car> {

    @Override
    public Car mapRow(ResultSet rs, int rowNum) throws SQLException {

        Car c = new Car();
        c.setBrand(rs.getString("brand"));
        c.setDoorsNumber(rs.getInt("doorsNumber"));
        c.setModel(rs.getString("model"));
        c.setPlate(rs.getString("plate"));
        c.setYear(rs.getInt("year"));
        return c;
    }
}
