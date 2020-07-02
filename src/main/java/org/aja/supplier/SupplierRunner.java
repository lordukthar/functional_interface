package org.aja.supplier;

import io.dropwizard.cli.Cli;
import org.apache.commons.pool2.ObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

import java.util.ArrayList;
import java.util.List;

public class SupplierRunner {




    public static void main(String...args) throws Exception {
        SupplierRunner sr = new SupplierRunner();
        sr.callPool();
    }

    private void callPool() throws Exception {



        ClientCachePool<Client> pool = new ClientCachePool<Client>();
        GenericObjectPoolConfig config = new GenericObjectPoolConfig();
        config.setMaxTotal(10);


        List<Client> clients = new ArrayList<>();
       // ((GenericObjectPool<Client>) pool).setConfig(config);

        for (int i = 0 ; i < 5; i++) {
            clients.add(pool.getClient());
        }


       // final Client client = pool.getClient();
        //pool.returnObject(client);

       for (int i = 0 ; i < 5; i++) {
            System.out.println(clients.get(i));
        }


        System.out.println("DHDHDH");
        for (int i = 0 ; i < 5; i++) {
            pool.returnObject(clients.get(i));
        }


        final Client client = pool.getClient();
        System.out.println(client);
        pool.returnObject(client);


        System.exit(1);
    }
}
