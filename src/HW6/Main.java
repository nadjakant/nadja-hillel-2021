package HW6;
//Создать классы, спецификации которых приведены ниже. Определить конструкторы и методы setТип(), getТип(), toString().
//Phone: id, Фамилия, Имя, Отчество, Адрес, Номер телфона, Номер кредитной карточки, Дебет, Кредит, Время городских ,
// время междугородных разговоров, трафик интернета


public class Main {
    public static void main(String[] args) {
        PhoneStore phones = new PhoneStore();
        phones.getDurationOfInnerCalls();
        System.out.println();
        phones.getDurationOfInternationalCalls();
        System.out.println();
        phones.getClientsByLastName();
        System.out.println();
        phones.getClientByTrafficUsage();
        }
    }

