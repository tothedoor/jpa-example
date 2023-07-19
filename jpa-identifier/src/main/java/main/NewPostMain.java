package main;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.transaction.Transaction;
import jpabasic.reserve.domain.Post;
import jpabasic.reserve.jpa.EMF;

import java.sql.Statement;
import java.time.LocalDate;

public class NewPostMain {
    public static void main(String[] args) {
        EMF.init();
        EntityManager entityManager = EMF.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            Post newPost = new Post("newTitle", "new content", LocalDate.now());

            entityManager.persist(newPost);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            entityManager.close();
        }

        EMF.close();
    }
}
