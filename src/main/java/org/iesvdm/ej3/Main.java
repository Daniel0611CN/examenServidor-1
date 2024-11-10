package org.iesvdm.ej3;

import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws NoSuchAlgorithmException {
        Scanner sc = new Scanner(System.in);
        Login l1 = new Login();
        l1.login(sc);
        sc.close();
    }

}
