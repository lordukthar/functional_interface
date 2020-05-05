package org.aja.supplier;

import org.apache.commons.pool2.ObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPool;


public class UserCachePool<T> {

    private ObjectPool<User> pool;

    public UserCachePool() {
        UserPoolObjectFactory factory = new UserPoolObjectFactory<User>();
        pool = new GenericObjectPool<User>(factory);
    }

    public User getUser() {
        User t = null;
        try {
            t = pool.borrowObject();
        } catch (Exception ex) {
            System.out.println("Exception: " + ex.getMessage());
        } finally {
            try {
                pool.returnObject(t);

            } catch (Exception e) {
                System.out.println("Exceon: " + e.getMessage());
            }
        }
        return t;
    }
}
