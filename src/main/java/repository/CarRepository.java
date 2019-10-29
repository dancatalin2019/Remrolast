package repository;

import model.Car;
import model.Client;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class CarRepository {

    private EntityManager entityManager;

    public CarRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Car car) {

        entityManager.getTransaction().begin();//mandatory to start a transaction in order to have file save

        entityManager.persist(car);//in this way we save client in table remorci

        entityManager.getTransaction().commit();//to commit the transaction in database
    }

//    public void someMethod() {
//        for (int i = 0; i< 25; i++) {
//            if(i == 4) {
//                //return;
//                //break;
//
//                continue;
//            }
//            System.out.println(i);
//        }
//        System.out.println("bla bla");
//    }

    public List<Client> findAll() {
        Query query = entityManager.createQuery("SELECT c from Car c");
        System.out.println(query);// SELECT * FROM Remorca
        List<Client> cars = query.getResultList();
        System.out.println(cars);

        return cars;//entityManager.createQuery("SELECT r from Remorca r").getResultList();

    }

    public List<Client> findByName(String serieBuletin) {
        Query query = entityManager.createQuery("SELECT r from Remorca r WHERE r.nr_Inmatriculare LIKE :nrInmatriculare");
        query.setParameter("nrInmatriculare", serieBuletin);
        List<Client> clients = query.getResultList();
        System.out.println(clients);

//        return entityManager.createQuery("SELECT r from Remorca r WHERE r.nr_Inmatriculare LIKE :nrInmatriculare")
//                .setParameter("nrInmatriculare", nrInmatriculare)
//                .getResultList();
        return clients;
    }


}
