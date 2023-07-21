package main;

import domain.User;
import domain.UserBySubSelect;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jpabasic.reserve.jpa.EMF;

public class FindUserBySubSelectMain {
    public static void main(String[] args) {
        EMF.init();
        EntityManager em = EMF.createEntityManager();
        EntityTransaction trsc = em.getTransaction();

        try {
            UserBySubSelect user1 = em.find(UserBySubSelect.class, 1);
            System.out.println(user1);
        } catch(Exception e) {
            trsc.rollback();
        } finally {
            em.close();
        }

        EMF.close();

    }
}
