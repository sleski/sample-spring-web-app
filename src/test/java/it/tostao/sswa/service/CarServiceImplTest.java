package it.tostao.sswa.service;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import it.tostao.sswa.service.impl.CarServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

/**
 * Created by sleski on 30.04.2015.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/it/tostao/sswa/sswai-test.xml"})
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class, DbUnitTestExecutionListener.class})
public class CarServiceImplTest {

    Logger LOG = LoggerFactory.getLogger(CarServiceImplTest.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private CarService carService;

    @Before
    public void setUp() {
        carService = new CarServiceImpl(jdbcTemplate);
    }

    /**
     * Test cars counter.
     */
    @Test
    @DatabaseSetup("cars.xml")
    public void checkCounter() {
        int nbOfCarsInGarage = carService.sizeInGarage();
        LOG.info("No of cars = " + nbOfCarsInGarage);
        Assert.assertEquals(2, nbOfCarsInGarage);
    }
}
