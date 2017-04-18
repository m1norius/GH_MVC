package com.minorius.controllers;

import com.minorius.entity.Book;
import com.minorius.entity.Car;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.*;

@Controller
public class IndexController {

    private static final Comparator<LocalDateTime> REV_DATE_COMP = Comparator.reverseOrder();

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String main(){
        return "main";
    }

    @RequestMapping(value = "/add-book", method = RequestMethod.GET)
    public String addBook(){
        return "add-book";
    }


    @RequestMapping(value = "/list-book", method = RequestMethod.POST)
    public ModelAndView listBook(Book book, HttpSession httpSession){
        httpSession.setMaxInactiveInterval(600);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("add-book");

        Map<LocalDateTime, Book> sessionDataMap = (Map<LocalDateTime, Book>) httpSession.getAttribute("sessionDataMap");
        if(sessionDataMap == null){
            sessionDataMap = new TreeMap<>(REV_DATE_COMP);
            httpSession.setAttribute("sessionDataMap", sessionDataMap);
        }

        book.setTime(LocalDateTime.now());

        sessionDataMap.put(book.getTime(), book);
        modelAndView.addObject("sessionDataMap", sessionDataMap);
        httpSession.setAttribute("sessionDataMap", sessionDataMap);
        return modelAndView;

    }

    @RequestMapping(value = "/get-car", method = RequestMethod.GET)
    public ModelAndView getAllBook(String mark){

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("get-car");

        modelAndView.addObject("listOfCars", getListOfCar(mark));
        for (Car car :getListOfCar(mark)){
            System.out.println(car.getModel());
        }

        return modelAndView;
    }

    private ArrayList<Car> getListOfCar(String mark){
        ArrayList<Car> listOfCars = new ArrayList<>();
        ArrayList<Car> listByMarkCars = new ArrayList<>();

        listOfCars.add(new Car("BMW", "X5", 2007, 210, 1600));
        listOfCars.add(new Car("BMW", "X6", 2012, 220, 1800));
        listOfCars.add(new Car("BMW", "m3", 2006, 280, 1400));
        listOfCars.add(new Car("BMW", "m5", 2006, 300, 1500));
        listOfCars.add(new Car("BMW", "m7", 2008, 300, 1650));
        listOfCars.add(new Car("Audi", "100", 1987, 180, 1300));
        listOfCars.add(new Car("Mazda", "RX8", 2010, 250, 1380));
        listOfCars.add(new Car("Mazda", "RX7", 2008, 280, 1580));
        listOfCars.add(new Car("Shkoda", "Fabia", 2005, 240, 1300));
        listOfCars.add(new Car("Shkoda", "Octavia", 2005, 270, 1400));

        for (Car car :listOfCars){
            if (car.getMark().equals(mark)){
                listByMarkCars.add(car);
            }
        }

        return listByMarkCars;
    }
}
