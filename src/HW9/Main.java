package HW9;

public class Main {
    public static void main(String[] args) {
        LinkedCollection list1 = new LinkedCollection();
        list1.addAll(new String[]{"я", "тут", "был"});
        LinkedCollection list2 = new LinkedCollection();
        list2.addAll(new String[]{"был", "тут", "я"});

        list1.print();
        list2.print();
        System.out.println("---Compare---");
        System.out.println(list1.compare(list2));

        System.out.println("---Contains---");
        System.out.println(list2.contains("я"));
        System.out.println(list2.contains("тут"));
        System.out.println(list2.contains("был"));
        System.out.println(list2.contains("щдщд"));

        System.out.println("---Delete by index---");
        System.out.println(list2.delete(2));
        System.out.println(list2.delete(0));
        System.out.println(list2.delete(0));
        System.out.println(list2.delete(0));
        System.out.println(list2.delete(0));
        list2.print();

        System.out.println("---AddAll---");
        list2.addAll(list1);
        list2.print();

        System.out.println("---Delete by value---");
        System.out.println(list2.delete("был"));
        System.out.println(list2.delete("я"));
        System.out.println(list2.delete("тут"));
        System.out.println(list2.delete("был"));
        list2.print();

        System.out.println("---Just Add---");
        LinkedCollection list3 = new LinkedCollection();

        list3.add("я");
        list3.add("тут");
        list3.add("был");
        list3.print();

        System.out.println("---Compare---");
        System.out.println(list1.compare(list3));

        System.out.println("---Add another list---");
        list1.addAll(list3);
        list1.print();

        System.out.println("---Add array---");
        list1.addAll(new String[]{"тутут","тамтам","былбыл"});
        System.out.println(list1.size());
        list1.print();

        System.out.println("---Delete by value---");
        System.out.println(list1.delete("был"));
        System.out.println(list1.delete("был"));
        System.out.println(list1.delete("был"));
        list1.print();

        System.out.println("---Getting by index---");
        System.out.println(list1.get(0));
        System.out.println(list1.get(7));
        System.out.println(list1.get(6));

        System.out.println("---Clearing---");
        list2.clear();
        System.out.println(list2.size());
        list2.print();

        list2.addAll(list1);
        list2.print();
        System.out.println(list1.size());


    }
}
