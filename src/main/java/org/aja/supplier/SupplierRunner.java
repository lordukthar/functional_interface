package org.aja.supplier;

import org.apache.commons.pool2.impl.DefaultPooledObject;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

public class SupplierRunner {




    public static void main(String...args) {
        SupplierRunner sr = new SupplierRunner();
        sr.callPool();
    }

    private void callPool() {

        GenericObjectPoolConfig config = new GenericObjectPoolConfig();
        config.setMaxTotal(10);

        UserCachePool ucp = new UserCachePool();

        for (int i = 0 ; i < 25; i++) {
            System.out.println(ucp.getUser());
        }
    }
}
