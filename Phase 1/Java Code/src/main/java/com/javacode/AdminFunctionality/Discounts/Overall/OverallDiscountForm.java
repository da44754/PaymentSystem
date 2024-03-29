package com.javacode.AdminFunctionality.Discounts.Overall;

import com.javacode.Controller;
import com.javacode.FormUI;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class OverallDiscountForm  implements FormUI {
    private Controller controller;

    @Override
    public void setController(Controller c) {
        controller = c;
    }
    @Override
    public void getInfoFromUser() {
        //create map to store values
        Map m = new HashMap<>();
        Scanner in = new Scanner(System.in);
        System.out.println("Now you will make discount for all services based on number of transaction!");
        System.out.print("Enter the number of transaction you want to add discount to it: ");
        String transaction = in.nextLine();
        while (Integer.parseInt(transaction) <= 0)
        {
            System.out.print("please enter positive value: ");
            transaction= in.nextLine();
        }
        System.out.print("Enter the DiscountPercent you want (e.g., write 10 for 10%): ");
        String DiscountPercent = in.nextLine();
        while (Integer.parseInt(DiscountPercent) <= 0)
        {
            System.out.print("please enter positive value: ");
            DiscountPercent= in.nextLine();
        }
        //set values to map
        m.put("transaction",Integer.parseInt(transaction));
        m.put("DiscountPercent",Double.parseDouble(DiscountPercent));
        m.put("type", "overall");
        //send values to command
        try {
            controller.execute(m);
            System.out.println("Success");
            System.out.println();
        }catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
