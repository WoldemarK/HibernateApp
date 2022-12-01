package org.example;

import org.example.model.Item;
import org.example.model.Person;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {
    public static void main(String[] args) {
        Configuration configuration = new Configuration()
                .addAnnotatedClass(Person.class)
                .addAnnotatedClass(Item.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            Transaction transaction = session.beginTransaction();
//
//          List<Person> people = session.createQuery("select p  from Person p").getResultList();
//          people.forEach(System.out::println);
//
//          List<Person> people1 = session.createQuery("select p from  Person p where p.age>30").getResultList();
//          people1.forEach(System.out::println);
//
//          List<Person> people2 = session.createQuery("select p from Person p where p.name like'T%'").getResultList();
//          people2.forEach(System.out::println);
//
//          session.createQuery("update Person p set p.name='Tset' where p.age < 30").executeUpdate();
//
//          session.createQuery("delete from Person p where p.age < 30").executeUpdate();
//
///**
// * создание
// */
//          Person ivan = new Person("Ivan", 22);
//          Person olga = new Person("Olga", 23);
//          Person tom = new Person("Tom", 25);
//
//          session.save(ivan);
//          session.save(olga);
//          session.save(tom);
//            /**
//             * обновление
//             */
//           Person newOlga = session.get(Person.class,2);
//           newOlga.setName("Bill");
//            /**
//             * удаление
//          */
//           Person newOlga = session.get(Person.class, 2);
//           session.delete(newOlga);
//           session.getTransaction().commit();
//            System.out.println("V-----------------------------------------------V");

//            Person person = session.get(Person.class, 3);
//            System.out.println(person);
//            List<Item> items = person.getItems();
//            System.out.println(items);
//
//            System.out.println("V-----------------------------------------------V");
//
//            Item item = session.get(Item.class, 5);
//            System.out.println(item);
//
//            Person person1 = item.getOwner();
//            System.out.println(person1);
//
//            System.out.println("V-----------------------------------------------V");

//            Person person2 = session.get(Person.class, 2);
//            Item newItem = new Item("Item from Hibernate", person2);
//
//            person2.getItems().add(newItem);
//
//            session.save(newItem);
//
//            System.out.println(newItem);
//
//            System.out.println("V-----------------------------------------------V");
//
//            Person person3 = new Person("Roki", 34);
//
//            Item item1 = new Item("Item from Hibernate 2", person3);
//
//            person3.setItems(new ArrayList<>(Collections.singleton(item1)));
//
//            session.save(person3);
//            session.save(item1);
//
//            System.out.println("V-----------------------------------------------V");

//            Person p = session.get(Person.class, 3);
//            List<Item> item2 = p.getItems();
//
//            for (Item item3 : item2)
//                session.remove(item3);
//
//            p.getItems().clear();

//            Person person = session.get(Person.class, 2);
//            session.remove(person);
//
//            person.getItems().forEach(i->i.setOwner(null));
//            System.out.println("V-----------------------------------------------V");
//
//            Person person = session.get(Person.class, 4);
//            Item items = session.get(Item.class, 1);
//
//            items.getOwner()
//                    .getItems()
//                    .remove(items);
//
//            items.setOwner(person);
//            person.getItems()
//                    .add(items);
            Person person = session.get(Person.class, 1);
            System.out.println(person);
            Hibernate.initialize(person.getItems());


            transaction.commit();
            session.close();

            System.out.println(person.getItems());

        } finally {
            sessionFactory.close();
        }
    }
}