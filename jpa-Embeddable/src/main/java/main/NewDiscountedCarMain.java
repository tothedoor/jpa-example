package main;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jpabasic.reserve.domain.Car;
import jpabasic.reserve.domain.DiscountedCar;
import jpabasic.reserve.domain.Money;
import jpabasic.reserve.jpa.EMF;

import java.time.LocalDate;

public class NewDiscountedCarMain {
    public static void main(String[] args) {
        EMF.init();
        EntityManager entityManager = EMF.createEntityManager();
        EntityTransaction trsc = entityManager.getTransaction();

        try {
            trsc.begin();

            Money carPrice = new Money(6000, 5, "KRW");
            Money discountPrice = new Money(2000, 5, null);
            DiscountedCar newDiscountedCar = new DiscountedCar("newCar", "Benz", carPrice, discountPrice, LocalDate.now());

            entityManager.persist(newDiscountedCar);
            trsc.commit();
        } catch(Exception e) {
            trsc.rollback();
        } finally {
            entityManager.close();
        }

        EMF.close();
    }
}
