package util;


import javax.persistence.*;

public class JPAUtil {
    private static EntityManagerFactory emf;
    
    public static EntityManager getEntityManager() {
        if(emf == null)
            emf = Persistence.createEntityManagerFactory("jpaPw1");
        return emf.createEntityManager();
    }
    public static void close(){
        emf.close();
    }
}

