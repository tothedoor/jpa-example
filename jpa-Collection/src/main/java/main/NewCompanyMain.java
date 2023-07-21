package main;

import collection.list.Department;
import collection.Company;
import collection.set.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jpabasic.reserve.jpa.EMF;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class NewCompanyMain {

    public static void main(String[] args) {
        EMF.init();
        EntityManager entityManager = EMF.createEntityManager();
        EntityTransaction trsc = entityManager.getTransaction();

        try {
            trsc.begin();

            Company newCompany = new Company(
                    "회사3",
                    Set.of(new Employee("회사원1", 25)),
                    List.of(new Department("인사과", "1층"),
                            new Department("총무부", "2층")),
                    Map.of("상품1", (long)10, "싱픔2", (long)20)
                    );
            entityManager.persist(newCompany);

            trsc.commit();
        } catch(Exception e) {
            trsc.rollback();
        } finally {
            entityManager.close();
        }

        EMF.close();
    }
}
