package hiber.dao;

import hiber.model.*;

public interface CarDao {
    void add(Car car);

    Car getByModelAndSeries(String model, int series);

}
