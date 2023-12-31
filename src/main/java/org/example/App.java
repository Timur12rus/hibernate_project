package org.example;


import org.example.model.Item;
import org.example.model.Passport;
import org.example.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().addAnnotatedClass(Person.class).
                addAnnotatedClass(Item.class).addAnnotatedClass(Passport.class);

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

//            ***********************************************************************
            // Получим список товаров у человека с id=3
//            Person person = session.get(Person.class, 3);
//            List<Item> items = person.getItems();
//            System.out.println(items);

//            ************************************************************************
            // получим владельца товара с id=5
//            Item item = session.get(Item.class, 5);
//            Person person = item.getOwner();
//            System.out.println(person);

//            *************************************************************************
            // Добавим новый товар для существующего человека с id = 2
//            Person person = session.get(Person.class, 2);
//            Item item = new Item("Item from hibernate", person);
//            session.save(item);

//            Добавим новый товар и человека
//            Person person = new Person("Test person", 32);
//            Item newItem = new Item("Item from hibernate 2", person);
//
//            person.setItems(new ArrayList<Item>(Collections.singletonList(newItem)));
//            session.save(person);
//            session.save(newItem);

//            ***********************************************************************
            // Удалим человека
//            Person person = session.get(Person.class, 2);
//            session.remove(person);
//            person.getItems().forEach(i -> i.setOwner(null));

//            **********************************************************************
            // Поменяем владельца у существующего товара
//            Person person = session.get(Person.class, 4);
//            Item item = session.get(Item.class, 2);
//
//            item.setOwner(person);
//            person.getItems().add(item);

//            ************************************************************************
            // используем каскадирование
//            Person person = new Person("Test cascadeing", 30);
//
//            person.addItem(new Item("Item 1"));
//            person.addItem(new Item("Item 2"));
//            person.addItem(new Item("Item 3"));
//
//            session.save(person);
//            session.refresh(person);  // обновляет кэш согласно значений из базы данных и будут соответствовать данным из БД

//            *********************************************************************


            // Создадим человека и паспорт
//            Person person = new Person("Test person", 31);
//            Passport passport = new Passport(person, 12345);
//
//            session.save(person);

//            ***********************************************************************
//            // Прочитаем человека и получим его паспорт
//            Person person = session.get(Person.class, 2);
//            System.out.println(person.getPassport().getPassportNumber());

            // Прочитаем паспорт и получим человека
//            Passport passport  = session.get(Passport.class, 4);
//            Person person = passport.getPerson();
//            System.out.println(person.getName());

            // Изменим номер паспорта у какого-то человека 
//            Person person = session.get(Person.class, 4);
//            Passport passport = person.getPassport();
//            passport.setPassportNumber(777777);
//            System.out.println("Person name = " + person.getName() + " with passport number = " + passport.getPassportNumber());

            // Удалим человека, и посмотрим как удалится паспорт, т.к. мы настроили каскадирование в базе данных на удаление
//            Person person = session.get(Person.class, 3);
//            session.remove(person);

            session.getTransaction().commit();
        } finally {
            sessionFactory.close();     // в любом случае мы закроем сессию
        }
    }
}
