package com.company.mobile;

import com.company.mobile.SamsungMobile;

import java.util.Scanner;

public class GalaxyA50 extends SamsungMobile {
    final String MODEL = "Galaxy A50";

    public String getModel() {
        return MODEL + " " + opMemory + "/" + memory;
    }

    public GalaxyA50(byte opMem, short mem) {
        this.opMemory = opMem;
        this.memory = mem;
    }

    public void call() {
        if(isOn) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("*special Galaxy A50 window opens*");
            System.out.println("Enter a number to call:");
            scanner.nextLine();
            System.out.println("Sorry, we couldn't reach the number you entered :(");
        } else {
            System.out.println("Your phone is off");
        }
    }
}
