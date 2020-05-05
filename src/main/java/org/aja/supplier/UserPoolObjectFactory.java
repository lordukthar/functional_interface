package org.aja.supplier;

import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.PooledObjectFactory;
import org.apache.commons.pool2.impl.DefaultPooledObject;

public class UserPoolObjectFactory<T> implements PooledObjectFactory<User> {

    @Override
    public PooledObject<User> makeObject() throws Exception {
        User u = new User("Jonas");
        return new DefaultPooledObject<>(u);
    }

    @Override
    public void destroyObject(PooledObject<User> pooledObject) throws Exception {

    }

    @Override
    public boolean validateObject(PooledObject<User> pooledObject) {
        return false;
    }

    @Override
    public void activateObject(PooledObject<User> pooledObject) throws Exception {

    }

    @Override
    public void passivateObject(PooledObject<User> pooledObject) throws Exception {

    }
}
