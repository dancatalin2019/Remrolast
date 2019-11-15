package repository;

import model.Antreprenor;
import model.Client;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.security.acl.Owner;
import java.util.List;

public class OwnerRepository {
    private EntityManager entityManager;
    public OwnerRepository(EntityManager entityManager){
        this.entityManager=entityManager;
    }
    public void saveOwner(Antreprenor owner){
        entityManager.getTransaction().begin();
        entityManager.persist(owner);
        entityManager.getTransaction().commit();
    }
    public void updateOwnerStreet(String ownerCNP, String newOwnerStreet){
        Antreprenor antreprenor =entityManager.find(Antreprenor.class,ownerCNP);
        entityManager.getTransaction().begin();
        antreprenor.setStrada(newOwnerStreet);
        entityManager.getTransaction().commit();

    }
    public List<Antreprenor> findAll() {
        Query query = entityManager.createQuery("SELECT a from Antreprenor a");
        System.out.println(query);// SELECT * FROM Remorca
        List<Antreprenor> antreprenorall = query.getResultList();
        System.out.println(antreprenorall);

        return antreprenorall;//entityManager.createQuery("SELECT r from Remorca r").getResultList();

    }

    public List<Antreprenor> findCNP(String acnp) {
        Query query = entityManager.createQuery("SELECT a from Antreprenor a WHERE a.cnp LIKE :acnp");
        query.setParameter("acnp", acnp);
        List<Antreprenor> antreprenorsCNP = query.getResultList();
        System.out.println(antreprenorsCNP);

//        return entityManager.createQuery("SELECT r from Remorca r WHERE r.nr_Inmatriculare LIKE :nrInmatriculare")
//                .setParameter("nrInmatriculare", nrInmatriculare)
//                .getResultList();
        return antreprenorsCNP;
    }
    public void updateTelefonOwner(String o_cnp,String newNumber) {
        Antreprenor antre =entityManager.find(Antreprenor.class,o_cnp);
        entityManager.getTransaction().begin();
        antre.setA_telefon(newNumber);
        entityManager.getTransaction().commit();


    }
    public void updateHouseNrOwner(String ownerCNP, String newOwnerHouseNr){
        Antreprenor antreprenor =entityManager.find(Antreprenor.class,ownerCNP);
        entityManager.getTransaction().begin();
        antreprenor.setA_nr_Casa(newOwnerHouseNr);
        entityManager.getTransaction().commit();

    }
    public void updateBIOwner(String ownerCNP, String newOwnerBI){
        Antreprenor antreprenor =entityManager.find(Antreprenor.class,ownerCNP);
        entityManager.getTransaction().begin();
        antreprenor.setSerie_Buletin(newOwnerBI);
        entityManager.getTransaction().commit();

    }
    public void updateCityOwner(String ownerCNP, String newOwnerCity){
        Antreprenor antreprenor =entityManager.find(Antreprenor.class,ownerCNP);
        entityManager.getTransaction().begin();
        antreprenor.setSerie_Buletin(newOwnerCity);
        entityManager.getTransaction().commit();

    }

}
