package HW7;

public class Main {
    public static void main(String[] args) {
        SimpleStringList simpleList = new SimpleStringList();


        System.out.println(simpleList.toString());


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
    }
}
