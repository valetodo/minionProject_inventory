/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.exceptions.NonexistentEntityException;
import controller.exceptions.PreexistingEntityException;
import model.ProductInventory;
import model.ProductInventoryPK;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author yerel-estalin
 */
public class ProductInventoryJpaController implements Serializable {

    public ProductInventoryJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(ProductInventory productInventory) throws PreexistingEntityException, Exception {
        if (productInventory.getProductInventoryPK() == null) {
            productInventory.setProductInventoryPK(new ProductInventoryPK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(productInventory);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findProductInventory(productInventory.getProductInventoryPK()) != null) {
                throw new PreexistingEntityException("ProductInventory " + productInventory + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(ProductInventory productInventory) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            productInventory = em.merge(productInventory);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                ProductInventoryPK id = productInventory.getProductInventoryPK();
                if (findProductInventory(id) == null) {
                    throw new NonexistentEntityException("The productInventory with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(ProductInventoryPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            ProductInventory productInventory;
            try {
                productInventory = em.getReference(ProductInventory.class, id);
                productInventory.getProductInventoryPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The productInventory with id " + id + " no longer exists.", enfe);
            }
            em.remove(productInventory);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<ProductInventory> findProductInventoryEntities() {
        return findProductInventoryEntities(true, -1, -1);
    }

    public List<ProductInventory> findProductInventoryEntities(int maxResults, int firstResult) {
        return findProductInventoryEntities(false, maxResults, firstResult);
    }

    private List<ProductInventory> findProductInventoryEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(ProductInventory.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public ProductInventory findProductInventory(ProductInventoryPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(ProductInventory.class, id);
        } finally {
            em.close();
        }
    }

    public int getProductInventoryCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<ProductInventory> rt = cq.from(ProductInventory.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
