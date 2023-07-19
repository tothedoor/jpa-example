package main;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jpabasic.reserve.domain.Car;
import jpabasic.reserve.domain.Money;
import jpabasic.reserve.jpa.EMF;

import java.time.LocalDate;

public class NewCarMain {
    public static void main(String[] args) {
        EMF.init();
        EntityManager entityManger = EMF.createEntityManager();
        EntityTransaction trsc = entityManger.getTransaction();

        try {
            trsc.begin();

            Money newCarPrice = new Money(6000, 5, "KRW");
            Car newCar = new Car("newCar", "Benz", newCarPrice, LocalDate.now());

            entityManger.persist(newCar);
            trsc.commit();
        } catch(Exception e) {
            trsc.rollback();
        } finally {
            entityManger.close();
        }

        EMF.close();
    }
}
