package hiber.dao.impl;

import hiber.dao.*;
import hiber.model.*;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

   @Autowired
   private SessionFactory sessionFactory;

   @Override
   public void add(User user) {
      sessionFactory.getCurrentSession().save(user);
   }

   @Override
   @SuppressWarnings("unchecked")
   public List<User> listUsers() {
      TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery("from User");
      return query.getResultList();
   }

   @Override
   public User getByCar(Car car) {
      TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("FROM user u WHERE id = :id");
      query.setParameter("id", car.getUser().getId());
      return query.getSingleResult();
   }

}
