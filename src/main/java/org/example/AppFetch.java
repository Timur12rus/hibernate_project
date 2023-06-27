package org.example;


import org.example.model.Item;
import org.example.model.Person;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.w3c.dom.ls.LSOutput;

public class AppFetch {
    public static void main(String[] args) {

        Configuration configuration = new Configuration().addAnnotatedClass(Person.class).addAnnotatedClass(Item.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();

        try {
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();
//
//            // Получим товары для человека
//            Person person = session.get(Person.class, 2);
//            System.out.println("Получили человека");
//
//            // Получим связанные сущности(Lazy)
//            System.out.println(person.getItems());


            // не ленивая загрузка, у item при загрузке уже лежит человек, и когда мы вызываем геттер чтобы получить этого человека hibernate
            // не вызывает дополнительного sql запроса, чтобы получить этого человека, это и характеризует нашу не ленивую загрузку
//            Item item = session.get(Item.class, 3);
//            System.out.println("Получили товар");

            Person person = session.get(Person.class, 2);
            System.out.println("Получили человека из таблицы");
            System.out.println(person);

            person.getItems();  // java компилятор оптимизирует этот код, не подгружает данные, т.к. они в данном случае не используются
//          если же вызвать
            System.out.println(person.getItems());       // то здесь будут подгружен связанные данные, код не будет оптимизирован компилятором
            Hibernate.initialize(person.getItems());    // подгружаем связанные ленивые сущности

            session.getTransaction().commit();
//            session.close()   // здесь hibernate закрывает сессию
            System.out.println("Вне сессии");

            System.out.println(person.getItems());
//            System.out.println(person.getItems()); // вне сессии ошибки не будет, т.к. товары уже подгружены благодаря указанному способу загрузки в классе Person(EAGER)
        } finally {
            sessionFactory.close();
        }
    }
}
