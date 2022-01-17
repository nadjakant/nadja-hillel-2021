package HW6;
//Создать интерфейс и его реализацию для выборки данных и вывести эти данные на консоль.
//a) сведения об абонентах, у которых время внутригородских разговоров превышает заданное;
//b) сведения об абонентах, которые пользовались междугородной связью;
//c) сведения об абонентах в алфавитном порядке.
//д) сведения об первых 10 абонентов у который самый большой трафик интернета


import java.util.Arrays;

public class PhoneStore implements Sortable {
    public Phone[] createPhones() {
        Phone[] phones = new Phone[10];
        phones[0] = new Phone(1, "Halenkova", "Nadja", "Olegovna", "Hovorova", "0661747173", "5180 1234 4567 7890", 200, 100, 5.30, 2.30, 170.2);
        phones[1] = new Phone(2, "Schevchenko", "Lisa", "Denisovna", "Klenovaya", "0631190904", "5168 0000 4567 1233", 400, 700, 1.30, 0.30, 200.2);
        phones[2] = new Phone(3, "Holdireva", "Kristina", "Vladimirovna", "Akademicheskaya", "0635678904", "5168 1234 4567 1123", 500, 100, 7.30, 1.30, 500.2);
        phones[3] = new Phone(4, "Trybunski", "Kyryl", "Pavlovich", "Pushkinskaya", "0632349004", "5168 1234 8907 7890", 1000, 600, 1.00, 8.30, 200.0);
        phones[4] = new Phone(5, "Sukhobokov", "Maksym", "Vladimirovich", "Deribasovskaya", "0635007804", "5168 1234 0089 0987", 0, 1200, 6.30, 3.30, 500.0);
        phones[5] = new Phone(6, "Yurchenko", "Egor", "Vladimirovich", "Deribasovskaya", "0635666804", "5168 9999 0089 0987", 0, 2000, 1.30, 6.30, 700.0);
        phones[6] = new Phone(7, "Kolesnichenko", "Katja", "Vladimirovich", "Deribasovskaya", "0635666804", "5168 9999 0089 0987", 0, 2000, 1.30, 6.30, 700.0);
        phones[7] = new Phone(8, "Bondarenko", "Kostya", "Petrov", "Sooparkovaya", "0635655804", "5168 5500 0089 0987", 0, 2000, 1.30, 8.0, 700.0);
        phones[8] = new Phone(9, "Shashkina", "Yana", "Kyrylovna", "Leontovicha", "06900563456", "5168 3309 0089 2298", 100, 100, 5.20, 0.30, 0.0);
        phones[9] = new Phone(10, "Horalevich", "Oleg", "Vladimirovich", "Deribasovskaya", "0635666804", "5168 9999 0089 0987", 0, 20, 1.00, 0.05, 50.0);

        return phones;
    }

    Phone[] phones = createPhones();

    @Override
    public void getDurationOfInnerCalls() {
        for (int i = 0; i < phones.length; i++) {
            if (phones[i].getInnerCalls() >= 3.00) {
                System.out.println(phones[i].toString());
            }
        }
    }

    @Override
    public void getDurationOfInternationalCalls() {
        for (int i = 0; i < phones.length; i++) {
            if (phones[i].getInternationalCalls() > 0) ;
            System.out.println(phones[i].toString());
        }

    }

    @Override
    public void getClientsByLastName() {
        Arrays.sort(phones, new WholeInfoComparator()); //making sort by the whole user info
        for (int i = 0; i < phones.length; i++) {
            System.out.println(phones[i]);
        }
    }

    @Override
    public void getClientByTrafficUsage() {
        Arrays.sort(phones, new TrafficComparatorDesc());
        for (int i = 1; i < phones.length; i++) {
           if (i>9){
               break;
           }
            System.out.println(phones[i]);
        }
    }


}
interface Sortable {
    void getDurationOfInnerCalls();

    void getDurationOfInternationalCalls();

    void getClientsByLastName();

    void getClientByTrafficUsage();
}