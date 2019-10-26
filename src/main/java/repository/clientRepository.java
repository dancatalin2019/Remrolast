package repository;

import model.Client;
import model.Remorca;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class clientRepository {

    private EntityManager entityManager;

    public clientRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Client client1) {

        entityManager.getTransaction().begin();//mandatory to start a transaction in order to have file save

        entityManager.persist(client1);//in this way we save client in table remorci

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
        Query query = entityManager.createQuery("SELECT c from Client c");
        System.out.println(query);// SELECT * FROM Remorca
        List<Client> clientsall = query.getResultList();
        System.out.println(clientsall);

        return clientsall;//entityManager.createQuery("SELECT r from Remorca r").getResultList();

    }

    public List<Client> findCNP(String ccnp) {
        Query query = entityManager.createQuery("SELECT c from Client c WHERE c.c_cnp LIKE :ccnp");
        query.setParameter("ccnp", ccnp);
        List<Client> clientsCNP = query.getResultList();
        System.out.println(clientsCNP);

//        return entityManager.createQuery("SELECT r from Remorca r WHERE r.nr_Inmatriculare LIKE :nrInmatriculare")
//                .setParameter("nrInmatriculare", nrInmatriculare)
//                .getResultList();
        return clientsCNP;
    }


}
