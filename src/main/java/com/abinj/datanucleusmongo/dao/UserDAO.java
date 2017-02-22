package com.abinj.datanucleusmongo.dao;

import com.abinj.datanucleusmongo.model.Book;
import com.abinj.datanucleusmongo.model.Inventory;
import com.abinj.datanucleusmongo.model.Product;
import com.abinj.datanucleusmongo.utilities.MongoUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Transaction;
import java.util.Properties;

public class UserDAO {
    private static final Logger logger = LoggerFactory.getLogger(UserDAO.class);

    public static void addProduct() {
//        Properties properties = new Properties();
//        properties.setProperty("javax.jdo.PersistenceManagerFactoryClass",
//                "org.datanucleus.api.jdo.JDOPersistenceManagerFactory");
//        properties.setProperty("javax.jdo.option.ConnectionURL","mongodb:/nucleus");
//        properties.setProperty("datanucleus.schema.autoCreateAll", "true");
//        properties.setProperty("datanucleus.schema.validateTables","false");
//        properties.setProperty("datanucleus.schema.validateConstraints", "false");
        PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("Tutorial");
        PersistenceManager pm =  pmf.getPersistenceManager();
        Transaction tx = pm.currentTransaction();

        Object inventoryId = null;
        try {
            tx.begin();
            logger.info("Persisting inventory of products");
            Inventory inv = new Inventory("My Inventory");
            Product product = new Product("productX", "Laurum ipsum", 500.00);
            Book book = new Book("BookX", "Laurum Ipsum", 230.00, "Author_1"
                    , "XYZ1234", "XYZ");
            inv.getProducts().add(product);
            inv.getProducts().add(book);
            pm.makePersistent(inv);

            tx.commit();
            inventoryId = pm.getObjectId(inv);
            logger.info("Inventory, product and book have been persisted");

        } catch (Exception ex) {
            ex.printStackTrace();
            logger.info("Exception occured----> {}", ex.getCause().getMessage());
        } finally {
            if (tx.isActive())
            {
                logger.info("Transaction rollback begin--->");
                tx.rollback();
            }
            logger.info("Persistance manager closed");
            pm.close();
        }
    }
}
