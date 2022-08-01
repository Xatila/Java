import entities.C_class;
import entities.E_class;
import entities.WarAirplane;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("mercedessFactory");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        WarAirplane f16 = new WarAirplane();
        C_class w206 = new C_class();
        E_class w214 = new E_class();

        em.persist(f16);
        em.persist(w206);
        em.persist(w214);

        em.getTransaction().commit();
        em.close();
    }
}