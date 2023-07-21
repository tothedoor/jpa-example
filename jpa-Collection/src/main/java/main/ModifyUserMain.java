package main;

import collection.set.UserForLazy;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jpabasic.reserve.jpa.EMF;

import java.util.Set;

public class ModifyUserMain {

    public static void main(String[] args) {
        modifySet();
        allocateSet();
        clearSet();
    }

    public static void modifySet() {
        EMF.init();
        EntityManager entityManager = EMF.createEntityManager();
        EntityTransaction trsc = entityManager.getTransaction();

        try {
            trsc.begin();

            UserForLazy user = entityManager.find(UserForLazy.class, 1);
            user.getTelNoSet().add("01099999999");          // user_tel 대상 insert 쿼리 실행
            user.getTelNoSet().remove("01012341234");    // user_tel 대상 delete 쿼리 실행

            trsc.commit();
        } catch(Exception e) {
            trsc.rollback();
        } finally {
            entityManager.close();
        }

        EMF.close();
        System.out.println("---------------------------------------------\n\n");
    }

    public static void allocateSet() {
        EMF.init();
        EntityManager entityManager = EMF.createEntityManager();
        EntityTransaction trsc = entityManager.getTransaction();

        try {
            trsc.begin();

            UserForLazy user = entityManager.find(UserForLazy.class, 1);
            user.setTelNoSet(Set.of("01098769876", "01067896789"));

            trsc.commit();
        } catch(Exception e) {
            trsc.rollback();
        } finally {
            entityManager.close();
        }

        EMF.close();
        System.out.println("---------------------------------------------\n\n");
    }

    public static void clearSet() {
        EMF.init();
        EntityManager entityManager = EMF.createEntityManager();
        EntityTransaction trsc = entityManager.getTransaction();

        try {
            trsc.begin();

            UserForLazy user = entityManager.find(UserForLazy.class, 1);
            user.getTelNoSet().clear();

            trsc.commit();
        } catch(Exception e) {
            trsc.rollback();
        } finally {
            entityManager.close();
        }

        EMF.close();
        System.out.println("---------------------------------------------\n\n");
    }

}
