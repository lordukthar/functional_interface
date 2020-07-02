package org.aja.supplier;

import org.apache.commons.pool2.ObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPool;


public class ClientCachePool<T> {

    private ObjectPool<Client> pool;

    public ClientCachePool() {
        ClientPoolObjectFactory factory = new ClientPoolObjectFactory();
        pool = new GenericObjectPool<Client>(factory);
    }

    public Client getClient() {
        Client t = null;
        try {
            System.out.println("Borrow");
            t =  pool.borrowObject();
        } catch (Exception ex) {
            System.out.println("Exception: " + ex.getMessage());
        } finally {
            try {
               // pool.returnObject(t);
                //System.out.println("Returning object: " + t);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return t;
    }


    public void returnObject(Client c) {
        try {
            System.out.println("Returning");
            pool.returnObject(c);

        } catch (Exception e) {
            System.out.println("Exceon: " + e.getMessage());
        }
    }
}
