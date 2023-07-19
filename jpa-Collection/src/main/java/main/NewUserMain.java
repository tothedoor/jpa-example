package main;

import collection.set.domain.UserForLazy;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jpabasic.reserve.jpa.EMF;

import java.util.Set;

public class NewUserMain {

    public static void main(String[] args) {
        EMF.init();
        EntityManager entityManager = EMF.createEntityManager();
        EntityTransaction trsc = entityManager.getTransaction();

        try {
            trsc.begin();

            UserForLazy userForLazy1 = new UserForLazy("user2", Set.of("01012341234", "01043214231"));
            entityManager.persist(userForLazy1);

            trsc.commit();
        } catch(Exception e) {
            trsc.rollback();
        } finally {
            entityManager.close();
        }

        EMF.close();
    }
}
