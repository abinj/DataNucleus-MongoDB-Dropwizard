package com.abinj.datanucleusmongo.utilities;

import io.dropwizard.lifecycle.Managed;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import java.util.Properties;


/**
 * Created by dxuser on 8/2/17.
 */
public class MongoUtil implements Managed {
    public static PersistenceManager pm;
    private static PersistenceManagerFactory pmf;


    @Override
    public void start() throws Exception {
        getPm();
    }

    @Override
    public void stop() throws Exception {
        if (pm != null) {
            pmf.close();
            pm.close();
        }
    }

    public static PersistenceManager getPm() {
        if (pm == null) {
            try {
//                Properties properties = new Properties();
//                properties.setProperty("javax.jdo.PersistenceManagerFactoryClass",
//                        "org.datanucleus.api.jdo.JDOPersistenceManagerFactory");
//                properties.setProperty("javax.jdo.option.ConnectionDriverName","com.mysql.jdbc.Driver");
//                properties.setProperty("javax.jdo.option.ConnectionURL","jdbc:mysql://localhost/myDB");
//                properties.setProperty("javax.jdo.option.ConnectionUserName","login");
//                properties.setProperty("javax.jdo.option.ConnectionPassword","password");
                pmf = JDOHelper.getPersistenceManagerFactory("mongoUnit");
                pm = pmf.getPersistenceManager();
                return pm;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        } else {
            return pm;
        }
    }
}
