package com.javacode.UserFunctionallity.checkDiscount;

import com.javacode.AdminFunctionality.Discounts.Discount;
import com.javacode.Command;
import com.javacode.FormUI;

import java.util.*;

public class DicountForm implements FormUI {
    Command command;
    String serviceName;
    @Override
    public void setCommand(Command c) {
        this.command=c;
    }

    @Override
    public void getInfoFromUser() {
        Map m = new HashMap<>();
        List<String> name = new ArrayList<>();
        name.add("Mobile Recharge Services");
        name.add("Internet Payment Services");
        name.add("Landline Services");
        name.add("Donation Services");

        System.out.println("Enter number of service you want to check discount fot it : ");
        for (int i =0 ; i<name.size() ; i++)
            System.out.println((i+1) +". "+name.get(i));
        System.out.print("choose: ");
        Scanner in = new Scanner(System.in);
        String choose = in.nextLine();
        while (Integer.parseInt(choose) < 1 ||Integer.parseInt(choose) > name.size())
        {
            System.out.print("try again! choose: ");
            choose = in.nextLine();
        }
        serviceName = name.get(Integer.parseInt(choose)-1);
        m.put("service",serviceName);
        m.put("form", this);
        command.execute(m);
    }
    public void DiscountResult(List<Discount> result){
        System.out.println("Discounts for " + serviceName);
        if(result.size() == 0){
            System.out.println("No discounts for this service yet! ");
            return;
        }
        for (int i=0;i<result.size();i++)
            System.out.println(result.get(i).getName()+": "+result.get(i).getAmount() + "%.");

        System.out.println("Do you want to go to this service? y/n");
        Scanner in = new Scanner(System.in);
        char again = in.next().charAt(0);
        while (again != 'y' && again !='n')
        {
            System.out.print("Please enter y or n (y for yes and n for no) to continue: ");
            again = in.next().charAt(0);
        }
        if (again == 'y') {
            Map m = new HashMap<>();
            m.put("name", serviceName);
            command.execute(m);
        }
    }
}
