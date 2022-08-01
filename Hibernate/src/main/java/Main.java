import entities.Customer;
import entities.Product;
import entities.Sale;
import entities.Store_location;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {


        EntityManagerFactory ef = Persistence.createEntityManagerFactory("sales");
        EntityManager em = ef.createEntityManager();
        em.getTransaction().begin();

        Sale sale = new Sale();
        Product product = new Product("krastavica",2,20.50);
        Customer customer = new Customer("customer1","email123@abv.bg","445y666678HGJ");
        Store_location store_location = new Store_location("Plovdiv");
        em.persist(sale);
        em.persist(product);
        em.persist(customer);
        em.persist(store_location);

        em.getTransaction().commit();
        em.close();
    }
}
