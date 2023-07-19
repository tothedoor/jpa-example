package main;

import collection.set.domain.UserForLazy;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jpabasic.reserve.jpa.EMF;

import java.util.Set;

public class ModifyUserMain {
    public static void main(String[] args) {
        UserForLazy user = findUser(1);
        user.
    }

    public static UserForLazy findUser(long userId) {
        EMF.init();
        EntityManager entityManager = EMF.createEntityManager();
        EntityTransaction trsc = entityManager.getTransaction();

        UserForLazy userForLazy = null;
        try {
            userForLazy = entityManager.find(UserForLazy.class, userId);
            System.out.println(userForLazy.getTelNoSet().toString());
        } catch(Exception e) {
            trsc.rollback();
        } finally {
            entityManager.close();
        }

        EMF.close();
        return userForLazy;
    }

}
