package controller;

import entity.Book;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class JapPractice {
    public static void main(String[] args) {


        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("NewPersistenceUnit");
        EntityManager manager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();
        List<Book> list = new ArrayList<Book>();
        Book book = null;

        for (int i = 0; i < 1000; i++) {
            book = new Book();
            book.setAuthor("罗贯中");
            book.setName("三国演义");
            list.add(book);
        }

        try {
            long t1 = System.currentTimeMillis();
            for (int i = 0; i < list.size(); i++) {
                manager.persist(list.get(i));
                if (i % 100 == 0) {//一次一百条插入
                    manager.flush();
                    manager.clear();
                }
            }
            long t2 = System.currentTimeMillis();
            System.out.println("耗时：" + (t2 - t1));

        } catch (Exception e) {
            System.out.println("batch insert data failuer.");
            e.printStackTrace();
        }


        transaction.commit();
        manager.close();
        entityManagerFactory.close();
    }
}
