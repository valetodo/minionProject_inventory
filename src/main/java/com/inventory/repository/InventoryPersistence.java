package com.inventory.repository;

import com.inventory.models.dbentities.*;
import com.inventory.utilities.PersistenceManager;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class InventoryPersistence {

    private final EntityManager entityManager;

    public InventoryPersistence(){
        entityManager = PersistenceManager.INSTANCE.getEntityManager();
    }

    public List<Product> showProducts(){
        Query query = entityManager.createNamedQuery("Product.findAll", Product.class);
        List<Product> result = query.getResultList();
        return result;
    }

    public Product retrieveProduct(int specificId){
        Query query = entityManager.createNamedQuery("Product.findByIdProduct", Product.class);
        query.setParameter("idProduct", specificId);
        List<Product> result = query.getResultList();
        if(result.size() != 1){
            return null;
        }
        return result.get(0);
    }

    public List<Durable> showDurables(){
        Query query = entityManager.createNamedQuery("Durable.findAll", Durable.class);
        List<Durable> result = query.getResultList();
        return result;
    }

    public Durable retrieveDurable(int specificId){
        Query query = entityManager.createNamedQuery("Durable.findByIdDurable", Durable.class);
        query.setParameter("idDurable", specificId);
        List<Durable> result = query.getResultList();
        if(result.size() != 1){
            return null;
        }
        return result.get(0);
    }

    public List<Consume> showConsumes(){
        Query query = entityManager.createNamedQuery("Consume.findAll", Consume.class);
        List<Consume> result = query.getResultList();
        return result;
    }

    public Consume retrieveConsume(int specificId){
        Query query = entityManager.createNamedQuery("Consume.findByIdConsume", Consume.class);
        query.setParameter("idConsume", specificId);
        List<Consume> result = query.getResultList();
        if(result.size() != 1){
            return null;
        }
        return result.get(0);
    }

    public List<Category> showCategories(){
        Query query = entityManager.createNamedQuery("Category.findAll", Category.class);
        List<Category> result = query.getResultList();
        return result;
    }

    public Category retrieveCategory(int specificId){
        Query query = entityManager.createNamedQuery("Category.findByIdCategory", Category.class);
        query.setParameter(1, specificId);
        List<Category> result = query.getResultList();
        if(result.size() != 1){
            return null;
        }
        return result.get(0);
    }

    public List<Productbrand> showProductBrands(){
        Query query = entityManager.createNamedQuery("Productbrand.findAll", Productbrand.class);
        List<Productbrand> result = query.getResultList();
        return result;
    }

    public Productbrand retrieveProductBrand(int markId){
        Query query =  entityManager.createNativeQuery("SELECT * FROM Productbrand p WHERE p.id_brand =:idBrand");
        //Query query =  entityManager.createNativeQuery("Test", Productbrand.class);

        query.setParameter("idBrand", markId);
        //System.out.println(query.getFirstResult());
        //System.out.println(query.setFirstResult(0));
        //System.out.println(query.getSingleResult());
        List<Productbrand> result = query.getResultList();
        if(result.size() != 1){
            return null;
        }
        return (Productbrand) query.getSingleResult();
    }


    public List<Inventory> showInventories(){
        Query query = entityManager.createNamedQuery("Inventory.findAll", Inventory.class);
        List<Inventory> result = query.getResultList();
        return result;
    }

    public Inventory retrieveInventory(int markId){
        Query query = entityManager.createNamedQuery("Inventory.findByIdInventory", Inventory.class);
        query.setParameter("idInventory", markId);
        List<Inventory> result = query.getResultList();
        if(result.size() != 1){
            return null;
        }
        return result.get(0);
    }


    public List<Stock> showStocks(){
        Query query = entityManager.createNamedQuery("Stock.findAll", Stock.class);
        List<Stock> result = query.getResultList();
        return result;
    }

    public Stock retrieveStock(int markId){
        Query query = entityManager.createNamedQuery("Stock.findByIdStock", Stock.class);
        query.setParameter("idStock", markId);
        List<Stock> result = query.getResultList();
        if(result.size() != 1){
            return null;
        }
        return result.get(0);
    }


    public void saveProductBrand(Productbrand value){
        entityManager.getTransaction()
                .begin();
        entityManager.persist(value);
        entityManager.getTransaction()
                .commit();
        System.out.println("Record Successfully Inserted In The Database");
    }


    public void saveCategory(Category value){
        entityManager.getTransaction()
                .begin();
        entityManager.persist(value);
        entityManager.getTransaction()
                .commit();
        System.out.println("Record Successfully Inserted In The Database");
    }


    public void saveDurable(Durable value){
        entityManager.getTransaction()
                .begin();
        entityManager.persist(value);
        entityManager.getTransaction()
                .commit();
    }

    public void saveConsume(Consume value){
        entityManager.getTransaction()
                .begin();
        entityManager.persist(value);
        entityManager.getTransaction()
                .commit();
    }


    public void saveStock(Stock value){
        entityManager.getTransaction()
                .begin();
        entityManager.persist(value);
        entityManager.getTransaction()
                .commit();
    }

    public void saveProduct(Product value){
        entityManager.getTransaction()
                .begin();
        entityManager.persist(value);
        entityManager.getTransaction()
                .commit();
    }

    public void saveInventory(Inventory value){
        entityManager.getTransaction()
                .begin();
        entityManager.persist(value);
        entityManager.getTransaction()
                .commit();
    }


    public void updateProductBrand(Productbrand value){
        entityManager.getTransaction()
                .begin();
        entityManager.merge(value);
        entityManager.getTransaction()
                .commit();
    }


    public void updateCategory(Category value){
        entityManager.getTransaction()
                .begin();
        entityManager.merge(value);
        entityManager.getTransaction()
                .commit();
    }


    public void updateDurable(Durable value){
        entityManager.getTransaction()
                .begin();
        entityManager.merge(value);
        entityManager.getTransaction()
                .commit();
    }

    public void updateConsume(Consume value){
        entityManager.getTransaction()
                .begin();
        entityManager.merge(value);
        entityManager.getTransaction()
                .commit();
    }


    public void updateStock(Stock value){
        entityManager.getTransaction()
                .begin();
        entityManager.merge(value);
        entityManager.getTransaction()
                .commit();
    }

    public void updateProduct(Product value){
        entityManager.getTransaction()
                .begin();
        entityManager.merge(value);
        entityManager.getTransaction()
                .commit();
    }

    public void updateInventory(Inventory value){
        entityManager.getTransaction()
                .begin();
        entityManager.merge(value);
        entityManager.getTransaction()
                .commit();
    }


    public void removeProductBrand(Productbrand value){
        entityManager.getTransaction()
                .begin();
        entityManager.remove(value);
        entityManager.getTransaction()
                .commit();
    }


    public void removeCategory(Category value){
        entityManager.getTransaction()
                .begin();
        entityManager.remove(value);
        entityManager.getTransaction()
                .commit();
    }


    public void removeDurable(Durable value){
        entityManager.getTransaction()
                .begin();
        entityManager.remove(value);
        entityManager.getTransaction()
                .commit();
    }

    public void removeConsume(Consume value){
        entityManager.getTransaction()
                .begin();
        entityManager.remove(value);
        entityManager.getTransaction()
                .commit();
    }


    public void removeStock(Stock value){
        entityManager.getTransaction()
                .begin();
        entityManager.remove(value);
        entityManager.getTransaction()
                .commit();
    }

    public void removeProduct(Product value){
        entityManager.getTransaction()
                .begin();
        entityManager.remove(value);
        entityManager.getTransaction()
                .commit();
    }

    public void removeInventory(Inventory value){
        entityManager.getTransaction()
                .begin();
        entityManager.remove(value);
        entityManager.getTransaction()
                .commit();
    }

}
