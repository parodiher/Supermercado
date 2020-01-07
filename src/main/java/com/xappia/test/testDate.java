package com.xappia.test;

import com.xappia.entities.Carrito;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class testDate {
    public static void main(String[] args) {
        Carrito carr = new Carrito();

        System.out.println(carr.getDate());

        LocalDate fecha = LocalDate.now();

        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String strDate = fecha.format(dateFormat);


        System.out.println(strDate);
    }
}
