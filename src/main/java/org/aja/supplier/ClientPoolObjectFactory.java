package org.aja.supplier;

import org.apache.commons.pool2.BasePooledObjectFactory;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.PooledObjectFactory;
import org.apache.commons.pool2.impl.DefaultPooledObject;

public class ClientPoolObjectFactory extends BasePooledObjectFactory<Client> {

    @Override
    public Client create() throws Exception {
        return new Client();
    }

    @Override
    public PooledObject<Client> wrap(Client client) {

        System.out.println("wrap");
        return new DefaultPooledObject<Client>(client);
    }

    @Override
    public void passivateObject(PooledObject<Client> pooledObject) {
        System.out.println("deallocate");
       pooledObject.deallocate();
    }

}
