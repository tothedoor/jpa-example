package main;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jpabasic.reserve.domain.Car;
import jpabasic.reserve.jpa.EMF;

import java.time.LocalDate;

public class NewCarMain {
    public static void main(String[] args) {
        EMF.init();
        EntityManager entityManager = EMF.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();

            Car newCar1 = new Car("myCar1", "KIA", LocalDate.now());
            Car newCar2 = new Car("myCar2", "HYUNDAI", LocalDate.now());

            entityManager.persist(newCar1);
            entityManager.persist(newCar2);

            transaction.commit();
        } catch(Exception e) {
            transaction.rollback();
        } finally {
            entityManager.close();
        }

        EMF.close();
    }
}
