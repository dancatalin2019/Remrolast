package repository;

import model.Client;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class ClientRepository {

    private EntityManager entityManager;

    public ClientRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Client client1) {

        entityManager.getTransaction().begin();//mandatory to start a transaction in order to have file save

        entityManager.persist(client1);//in this way we save client in table remorci

        entityManager.getTransaction().commit();//to commit the transaction in database
    }



    public void FindClientbyCMP(String c_cnp) {
        Client clientt =entityManager.find(Client.class,c_cnp);
        System.out.println("Clientul este : "+clientt);

    }
    public void DeleteClientbyCMP(String c_cnp) {
        Client clientt =entityManager.find(Client.class,c_cnp);
        entityManager.getTransaction().begin();
        entityManager.remove(clientt);
        entityManager.getTransaction().commit();


    }
    public void updateTelefon(String c_cnp,String newNumber) {
        Client clientt =entityManager.find(Client.class,c_cnp);
        entityManager.getTransaction().begin();
        clientt.setC_nr_Telefon(newNumber);
        entityManager.getTransaction().commit();


    }
    public void updateStreetClient(String c_cnp,String newStreet) {
        Client clientt =entityManager.find(Client.class,c_cnp);
        entityManager.getTransaction().begin();
        clientt.setC_nr_Telefon(newStreet);
        entityManager.getTransaction().commit();


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
