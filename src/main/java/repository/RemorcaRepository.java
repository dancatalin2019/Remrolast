package repository;

import model.Remorca;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class RemorcaRepository {

    private EntityManager entityManager;

    public RemorcaRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Remorca rem1) {

        entityManager.getTransaction().begin();//mandatory to start a transaction in order to have file save

        entityManager.persist(rem1);//in this way we save student in table Student

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

    public List<Remorca> findAll() {
        Query query = entityManager.createQuery("SELECT r from Remorca r"); // SELECT * FROM Remorca
        List<Remorca> remorci = query.getResultList();

        return remorci;//entityManager.createQuery("SELECT r from Remorca r").getResultList();

    }

    public List<Remorca> findByName(String nrInmatriculare) {
        Query query = entityManager.createQuery("SELECT r from Remorca r WHERE r.nr_Inmatriculare LIKE :nrInmatriculare");
        query.setParameter("nrInmatriculare", nrInmatriculare);
        List<Remorca> remorci = query.getResultList();

//        return entityManager.createQuery("SELECT r from Remorca r WHERE r.nr_Inmatriculare LIKE :nrInmatriculare")
//                .setParameter("nrInmatriculare", nrInmatriculare)
//                .getResultList();
        return remorci;
    }


}
