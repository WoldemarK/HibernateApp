package org.example;


import org.example.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class App {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().addAnnotatedClass(Person.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();

            List<Person> people = session.createQuery("select p  from Person p").getResultList();
            people.forEach(System.out::println);

            List<Person> people1 = session.createQuery("select p from  Person p where p.age>30").getResultList();
            people1.forEach(System.out::println);

            List<Person> people2 = session.createQuery("select p from Person p where p.name like'T%'").getResultList();
            people2.forEach(System.out::println);

            session.createQuery("update Person p set p.name='Tset' where p.age < 30").executeUpdate();

            session.createQuery("delete from Person p where p.age < 30").executeUpdate();

/**
 * создание
 */
//            Person ivan = new Person("Ivan", 22);
//            Person olga = new Person("Olga", 23);
//            Person tom = new Person("Tom", 25);
//
//            session.save(ivan);
//            session.save(olga);
//            session.save(tom);
            /**
             * обновление
             */
//            Person newOlga = session.get(Person.class,2);
//            newOlga.setName("Bill");
            /**
             * удаление
             */
//            Person newOlga = session.get(Person.class, 2);
//            session.delete(newOlga);
//            session.getTransaction().commit();

            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }
    }
}