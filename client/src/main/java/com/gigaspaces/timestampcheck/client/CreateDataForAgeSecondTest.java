package com.gigaspaces.timestampcheck.client;

import com.gigaspaces.timestampcheck.common.Person;
import org.openspaces.core.GigaSpace;
import org.openspaces.core.GigaSpaceConfigurer;
import org.openspaces.core.space.SpaceProxyConfigurer;

import java.util.concurrent.TimeUnit;

public class CreateDataForAgeSecondTest {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Connecting to data grid");
        SpaceProxyConfigurer configurer = new SpaceProxyConfigurer("shoppingcart-space");
        configurer.lookupGroups("xap-12.0.1");
        GigaSpace gigaSpace = new GigaSpaceConfigurer(configurer).create();
        System.out.println("Connected to data grid");
        for (int i = 1; i <= 120; i++) {
            Person p = new Person(i, "p"+i);
            Long tsVal = System.currentTimeMillis();
            p.setLastUpdated(tsVal);
            gigaSpace.write(p);
            TimeUnit.SECONDS.sleep(1);
        }
        configurer.close();
    }

}
