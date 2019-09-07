/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;

import controller.HistoryJpaController;
import controller.ProductJpaController;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.History;
import model.InventoryManager;
import model.Product;

public class consulta {

    public static void main(String[] arg){
        
        InventoryManager.executeProgram();
        
    }
}
