package main;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jpabasic.reserve.domain.Employee;
import jpabasic.reserve.jpa.EMF;

import java.sql.Statement;
import java.time.LocalDate;

public class NewEmployeeMain {

    public static void main(String[] args) {
        EMF.init();
        EntityManager entityManager = EMF.createEntityManager();

        EntityTransaction transaction =entityManager.getTransaction();

        try {
            transaction.begin();

            Employee emp = new Employee("양민규", LocalDate.now());
            entityManager.persist(emp);

            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            entityManager.close();
        }

        EMF.close();
    }
}
