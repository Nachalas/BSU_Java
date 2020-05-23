package com.company.mobile;

import com.company.mobile.Mobile;

public abstract class SamsungMobile implements Mobile {
    protected final String MADEBY = "Samsung";
    boolean isOn = false;
    protected byte opMemory;
    protected short memory;

    public void turnOn() {
        if(isOn != true) {
            System.out.println(MADEBY + " " + getModel() + " was turned on");
            isOn = true;
        } else {
            System.out.println("Your phone is already on");
        }
    }

    public void turnOff() {
        if(isOn != false) {
            System.out.println(MADEBY + " " + getModel() + " was turned off");
            isOn = false;
        } else {
            System.out.println("Your phone is already off");
        }
    }

    public abstract String getModel();
}
