/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;

import controller.ProductJpaController;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import model.History;
import model.Product;

/**
 *
 * @author yerel-estalin
 */
public class terminalHistory {
    private EntityManagerFactory emf;
    private Scanner scanner;
    private ProductJpaController productController; 
    private EntityManager manager;
    
    public terminalHistory(){
        emf = Persistence.createEntityManagerFactory("ejemploPU");
        scanner = new Scanner(System.in);
        productController = new ProductJpaController(emf); 
        manager = emf.createEntityManager();
    }
    
    public List<History> getHistoryBetweenDates(String startDateString, String endDateString){
        Date startDate = getDateFormat(startDateString);
        Date endDate = getDateFormat(endDateString);
        TypedQuery<History> findHistory = 
                manager.createNamedQuery("History.findBetweenDatesHistory", History.class);
        findHistory.setParameter("startDate", startDate);
        findHistory.setParameter("endDate", endDate);
        List<History> historyList = findHistory.getResultList(); 
        
        return historyList;
    }
    
    public List<History> getHistoryByNameProduct(String nameProduct){
        TypedQuery<Product> findProducts = manager.createNamedQuery("Product.findByNameProduct", Product.class);
        findProducts.setParameter("nameProduct", nameProduct);
        Product product = findProducts.getSingleResult();
        TypedQuery<History> findHistory = 
                manager.createNamedQuery("History.findByIdProduct", History.class);
        findHistory.setParameter("idProduct", product.getIdProduct());
        List<History> historyList = findHistory.getResultList(); 
        
        return historyList;
    }
    
    private Date getDateFormat(String dateString){
        Date date = null;
        try {
            String pattern = "yyyy-MM-dd";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            date = simpleDateFormat.parse(dateString);
            
        } catch(Exception e) { //this generic but you can control another types of exception
            // look the origin of excption 
        }
        return date;
    } 
    
    public void showTerminalHistory(){
        
        int operation = 9;
        do {
            System.out.println("=============== Terminal history ==================");
            System.out.println("[ MAIN MENU ]");
            System.out.println("1 - Search history by product");
            System.out.println("2 - Search history between dates");
            System.out.println("0 - exit terminal");
            
            operation = scanner.nextInt();
            switch(operation){
                case 1: {
                    System.out.println("Enter name product to search history");
                    String nameProduct = scanner.next();
                    List<History> listHistoryFind = getHistoryByNameProduct(nameProduct);
                    for (History history: listHistoryFind){
                        Product product = productController.findProduct(history.getIdProduct());
                        System.out.println(history.getIdHistory() + "|" + product.getNameProduct() + "|" + history.getQuantityIni() + "|" + history.getQuantityFinal()+ "|" + history.getDateHistory());
                    }
                    break;
                }
                case 2: {
                    
                    System.out.println("Enter start date to search in format yyyy-MM-dd");
                    String startDate = scanner.next();
                    System.out.println("Enter end date to search in format yyyy-MM-dd");
                    String endDate = scanner.next();
                    List<History> listHistoryFind = getHistoryBetweenDates(startDate, endDate);        
                    for (History history: listHistoryFind){
                        Product product = productController.findProduct(history.getIdProduct());
                        System.out.println(history.getIdHistory() + "|" + product.getNameProduct() + "|" + history.getQuantityIni() + "|" + history.getQuantityFinal() + "|" + history.getDateHistory());
                    }
                    break;
                }
            }
            
        } while(operation != 0);
    }
    
    public static void main(String[] args) {
        terminalHistory t = new terminalHistory();
        t.showTerminalHistory();
    }
}
