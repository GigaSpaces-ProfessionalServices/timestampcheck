package com.gigaspaces.timestampcheck.client;

import com.gigaspaces.timestampcheck.common.Person;
import com.j_spaces.core.client.SQLQuery;
import org.openspaces.core.GigaSpace;
import org.openspaces.core.GigaSpaceConfigurer;
import org.openspaces.core.space.SpaceProxyConfigurer;

public class RemoveUsingAgeDay {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Connecting to data grid ...");
        SpaceProxyConfigurer configurer = new SpaceProxyConfigurer("shoppingcart-space");
        configurer.lookupGroups("xap-12.0.1");
        GigaSpace gigaSpace = new GigaSpaceConfigurer(configurer).create();
        System.out.println("Connected to data grid");
        String queryStr = "AGE_DAY(lastUpdated) > 30";
        System.out.println("Removing data using [" + queryStr + "] ... ");
        SQLQuery query = new SQLQuery(Person.class, queryStr);
        gigaSpace.clear(query);
        System.out.println("Removed data using [" + queryStr + "]");
        configurer.close();
    }

}
