package org.example;

import org.example.controller.AuthController;
import org.example.db.DataBase;
import org.example.db.InitDataBase;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {

//
//        InitDataBase.adminInit();
//       InitDataBase.addCompanyCard();
        ApplicationContext context = new  ClassPathXmlApplicationContext("spring-config.xml");
        AuthController authController = (AuthController) context.getBean("authController");
        authController.start();
//        DataBase.initTable();

    }
}
