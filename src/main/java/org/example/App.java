package org.example;


import org.example.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().addAnnotatedClass(Person.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();

//            Person person2 = session.get(Person.class, 2);
//            person2.setName("New Person2");
//            ********************************************************************
            // вывести на экран людей, чье имя начинается на 'T' и возраст > 29
//            List<Person> people = session.createQuery("FROM Person WHERE name like 'T%' and age > 29").getResultList();
//            for (Person person : people) {
//                System.out.println(person);
//            }
//            ********************************************************************
            // изменить имена людей, чей возраст меньше 30
//            session.createQuery("update Person  set name = 'Murka' where age < 30").executeUpdate();
//            **********************************************************************
            // Удалить людей, чей возраст меньше 30
//            session.createQuery("delete from Person where age < 30").executeUpdate();

            session.getTransaction().commit();
        } finally {
            sessionFactory.close();     // в любом случае мы закроем сессию
        }
    }
}
