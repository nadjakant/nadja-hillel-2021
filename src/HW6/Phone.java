package HW6;

//Phone: id, Фамилия, Имя, Отчество, Адрес, Номер телфона, Номер кредитной карточки, Дебет, Кредит, Время городских ,
// время междугородных разговоров, трафик интернета
public class Phone  {

    int id;
    String lastName;
    String firstName;
    String patronym;
    String address;
    String telephoneNumber;
    String creditCardNumber;
    int debit;
    int credit;
    double innerCalls;
    double internationalCalls;
    double internetTraffic;

    public Phone() {

    }

    public Phone(int id, String lastName, String firstName, String patronym, String address, String telephoneNumber, String creditCardNumber, int debit, int credit,double innerCalls, double internationalCalls, double internetTraffic) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.patronym = patronym;
        this.address = address;
        this.telephoneNumber = telephoneNumber;
        this.creditCardNumber = creditCardNumber;
        this.debit = debit;
        this.credit = credit;
        this.innerCalls = innerCalls;
        this.internationalCalls = internationalCalls;
        this.internetTraffic = internetTraffic;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPatronym() {
        return patronym;
    }

    public void setPatronym(String patronym) {
        this.patronym = patronym;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public int getDebit() {
        return debit;
    }

    public void setDebit(int debit) {
        this.debit = debit;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public double getInnerCalls() {
        return innerCalls;
    }

    public void setInnerCalls(double innerCalls) {
        this.innerCalls = innerCalls;
    }

    public double getInternationalCalls() {
        return internationalCalls;
    }

    public void setInternationalCalls(double internationalCalls) {
        this.internationalCalls = internationalCalls;
    }

    public double getInternetTraffic() {
        return internetTraffic;
    }

    public void setInternetTraffic(double internetTraffic) {
        this.internetTraffic = internetTraffic;
    }

    @Override
    public String toString() {
        return
                "id: " + id +
                        " lastName: " + lastName +
                        " firstName: " + firstName +
                        " patronym: " + patronym +
                        " address: " + address +
                        " telephoneNumber: " + telephoneNumber +
                        " creditCardNumber: " + creditCardNumber +
                        " debit: " + debit +
                        " credit: " + credit +
                        " internationalCalls: " + internationalCalls +
                        " internetTraffic: " + internetTraffic;
    }

    public String getWholeInfo() {
        return          "lastName: " + lastName +
                        " firstName: " + firstName +
                        " patronym: " + patronym +
                        " address: " + address +
                        " telephoneNumber: " + telephoneNumber +
                        " creditCardNumber: " + creditCardNumber +
                        " debit: " + debit +
                        " credit: " + credit +
                        " internationalCalls: " + internationalCalls +
                        " internetTraffic: " + internetTraffic;
    }
}
