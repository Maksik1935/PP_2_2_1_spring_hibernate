package hiber.service.impl;

import hiber.dao.*;
import hiber.model.*;
import hiber.service.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import javax.transaction.*;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private CarDao dao;
    @Transactional
    @Override
    public void add(Car car) {
        dao.add(car);
    }
}
