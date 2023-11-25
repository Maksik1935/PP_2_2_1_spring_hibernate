package hiber.dao.impl;

import hiber.dao.*;
import hiber.model.*;
import org.hibernate.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import javax.persistence.*;

@Repository
public class CarDaoImpl implements CarDao {

    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public void add(Car car) {
        sessionFactory.getCurrentSession().save(car);
    }

    @Override
    public Car getByModelAndSeries(String model, int series) {
        TypedQuery<Car> query = sessionFactory.getCurrentSession().createQuery("FROM car c WHERE c.model = :model AND c.series = :series");
        query.setParameter("model", model);
        query.setParameter("series", series);
        return query.getSingleResult();
    }

}
