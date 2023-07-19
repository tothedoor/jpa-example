package main;

import collection.set.domain.UserForEager;
import collection.set.domain.UserForLazy;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jpabasic.reserve.jpa.EMF;

public class FindUserMain {

    public static void main(String[] args) {
        lazyFind();

        System.out.println("-----------------------------");

        eagerFind();
    }

    public static void lazyFind() {
        EMF.init();
        EntityManager entityManager = EMF.createEntityManager();
        EntityTransaction trsc = entityManager.getTransaction();

        try {
            UserForLazy userForLazy1 = entityManager.find(UserForLazy.class, 1);
            System.out.println(userForLazy1.getTelNoSet().toString());
        } catch(Exception e) {
            trsc.rollback();
        } finally {
            entityManager.close();
        }

        EMF.close();
    }

    public static void eagerFind() {
        EMF.init();
        EntityManager entityManager = EMF.createEntityManager();
        EntityTransaction trsc = entityManager.getTransaction();

        try {
            UserForEager userForEager = entityManager.find(UserForEager.class, 1);
            System.out.println(userForEager.getTelNoSet().toString());
        } catch(Exception e) {
            trsc.rollback();
        } finally {
            entityManager.close();
        }

        EMF.close();
    }

}
