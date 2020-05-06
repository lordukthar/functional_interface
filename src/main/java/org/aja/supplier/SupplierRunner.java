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



        ObjectPool<Client> pool = new GenericObjectPool<Client>(new ClientPoolObjectFactory());

/*

        GenericObjectPoolConfig config = new GenericObjectPoolConfig();
        config.setMaxTotal(100);

        ClientCachePool ucp = new ClientCachePool();*/

        List<Client> clients = new ArrayList<>();

        for (int i = 0 ; i < 5; i++) {
            clients.add(pool.borrowObject());
        }

       for (int i = 0 ; i < 5; i++) {
            System.out.println(clients.get(i));
        }


        System.out.println("DHDHDH");
        for (int i = 0 ; i < 5; i++) {
            pool.returnObject(clients.get(i));
        }

       System.exit(1);
    }
}
