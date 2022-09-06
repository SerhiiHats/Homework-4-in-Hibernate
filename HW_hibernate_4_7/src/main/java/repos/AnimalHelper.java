package repos;

import models.Animal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class AnimalHelper {
    private static EntityManagerFactory emf;


    public AnimalHelper() {
        this.emf = Persistence.createEntityManagerFactory("persis");
    }

    public void add(Animal animal){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(animal);
        em.getTransaction().commit();
        em.close();
    }

    @SuppressWarnings("unchecked")
    public List<Animal> getAll(){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Query query = em.createQuery("SELECT animals FROM Animal animals");
        List<Animal> animalList = query.getResultList();
        em.getTransaction().commit();
        em.close();
        return animalList;
    }

    public Animal getById(long id){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Animal animal = em.find(Animal.class, id);
        em.getTransaction().commit();
        em.close();
        return animal;
    }

    public void updateNameById(long id, String newName){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Animal animal = em.find(Animal.class, id);
        animal.setName(newName);
        em.merge(animal);
        em.getTransaction().commit();
        em.close();
    }

    public void removeById(long id){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Animal animal = em.find(Animal.class, id);
        em.remove(animal);
        em.getTransaction().commit();
        em.close();
    }

}
