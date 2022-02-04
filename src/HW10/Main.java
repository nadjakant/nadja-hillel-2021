package HW10;

import HW10.SimpleCollection.SimpleIterator;

import java.util.NoSuchElementException;

public class Main {
    public static void main(String[] args) {
        SimpleCollection simpleList = new SimpleCollection();
        SimpleCollection simpleList1 = new SimpleCollection();

        System.out.println(simpleList.toString());

        simpleList.add("1");
        simpleList.add("2");
        simpleList.add("3");
        simpleList.add("4");

        SimpleIterator it = simpleList.getIterator();

        while (it.hasNext()) {
            System.out.println(it.next());
        }
        // test for exceptions
        try {
            System.out.println(it.next());
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }




        System.out.println("---End printing by iterator----");

        if (simpleList.add(0,"я")){
            System.out.println(simpleList.toString());
        } else {
            System.out.println("element was not added");
        }

        if (simpleList.add("тут")){
            System.out.println(simpleList.toString());
        } else {
            System.out.println("element was not added");
        }


        if (simpleList.add("был")){
            System.out.println(simpleList.toString());
        } else {
            System.out.println("element was not added");
        }


        if (simpleList.add(4,"!")) {
            System.out.println(simpleList.toString());
        } else {
            System.out.println("element was not added");
        }

        if (simpleList.add(1,"!!!")) {
            System.out.println(simpleList.toString());
        } else {
            System.out.println("element was not added");
        }

        if (simpleList.delete(1)) {
            System.out.println(simpleList.toString());
        } else {
            System.out.println("element was not deleted");
        }

        if (simpleList.delete("я")){
            System.out.println(simpleList.toString());
        } else {
            System.out.println("element was not deleted");
        }

        String elem = simpleList.get(1);

        if (elem != null) {
            System.out.println(elem);
        } else {
            System.out.println("could not find the element");
        }

        if  (simpleList.contain("был")) {
            System.out.println("match");
        } else {
            System.out.println("not match");
        }

        simpleList1 = simpleList;
        if (simpleList.equals(simpleList1)){
            System.out.println("equal collections");
        } else {
            System.out.println("not equal collections");
        }


        System.out.println("Before clear: ");
        System.out.println(simpleList.toString());
        simpleList.clear();
        System.out.println("After clear: ");
        System.out.println(simpleList.toString());
    }
}

