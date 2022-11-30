package com.javacode.AdminFunctionality.Discounts;

import com.javacode.Command;
import com.javacode.Services.Service;
import com.javacode.Services.ServiceFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OverallDiscountCommand implements Command {
    List<String> services;
    public OverallDiscountCommand()
    {
        services = new ArrayList<>();
        services.add("Mobile Recharge Services");
        services.add("Internet Payment Services");
        services.add("Landline Services");
        services.add("Donation Services");
    }
    @Override
    public void execute(Map m) {
        Discount discount = new DiscountFactory().makeDiscount(m);
        for (String service : services)
        {
            Service srv = new ServiceFactory().createService(service);
            srv.addDiscount(discount);
        }
    }
}