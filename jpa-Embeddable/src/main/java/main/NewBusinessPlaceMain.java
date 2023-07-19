package main;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jpabasic.reserve.domain.tablemapping.Address;
import jpabasic.reserve.domain.tablemapping.BusinessPlace;
import jpabasic.reserve.domain.tablemapping.TelphoneNumber;
import jpabasic.reserve.jpa.EMF;

public class NewBusinessPlaceMain {
    public static void main(String[] args) {
        EMF.init();
        EntityManager entityManger = EMF.createEntityManager();
        EntityTransaction trsc = entityManger.getTransaction();

        try {
            trsc.begin();

            BusinessPlace newBusinessPlace = new BusinessPlace(
                    "사업장1",
                    new Address("부산광역시", "동구"),
                    new TelphoneNumber("010", "1234", "1234")
            );
            entityManger.persist(newBusinessPlace);

            trsc.commit();
        } catch(Exception e) {
            trsc.rollback();
        } finally {
            entityManger.close();
        }

        EMF.close();
    }
}
