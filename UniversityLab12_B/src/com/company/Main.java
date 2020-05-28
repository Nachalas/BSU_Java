package com.company;

import com.company.view.View;
import org.apache.log4j.BasicConfigurator;

public class Main {
    public static void main(String[] args) {
        BasicConfigurator.configure();
        View view = new View();
        view.showInterface();
    }
}
