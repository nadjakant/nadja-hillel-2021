package HW4;

public class Car {
    double volumeOfTank;
    double fuelRemains;
    double consumption100km;
    double costsOfFuel;
    double sumForRefill;
    double passedDistance;

    static  final double OdessaToKryweOsero = 177.8;
    static  final double OdessaToSchaschkiw = 330.8;
    static  final double OdessaToKiew = 478.8;

    public Car(double costsOfFuel) {
        this.costsOfFuel = costsOfFuel;
        this.volumeOfTank = 60.0;
        this.consumption100km = 12.0;
        this.fuelRemains = 0.0;
        this.sumForRefill = 0.0;
        this.passedDistance = 0.0;
    }

    //залить полный бак с учетом объема остатка
    void fillFullTank() {
        double diff = volumeOfTank-fuelRemains;
        sumForRefill += costsOfFuel * diff;
        fuelRemains = volumeOfTank;
    }

    //определить остаток топлива по преодолении N км
    double fuelRemainsAfterDistance(double distance) {
        return fuelRemains-(distance * consumption100km / 100);
    }
//    определить сколько надо до заправить топлива при преодолении N км
    double requiredFuelForDistance (double distance) {
        double fuelRemainsAfterDistance =  fuelRemainsAfterDistance(distance);

        if (fuelRemainsAfterDistance >= 0 ) { //хватило на дистанцию
            return 0.0;
        }
        else
        {
            return -1 * fuelRemainsAfterDistance;
        }

    }

    void drive( double distance) {
        if (this.requiredFuelForDistance(distance) > 0) {
            this.fillFullTank();
        }
            this.passedDistance += distance;
            this.fuelRemains = this.fuelRemainsAfterDistance(distance);
        }
     void makeTrip()
        {
         this.drive(OdessaToKryweOsero);
         this.drive(OdessaToSchaschkiw-OdessaToKryweOsero);
         this.drive(OdessaToKiew -OdessaToSchaschkiw);

            System.out.println("Total distance - " + this.passedDistance + " km");
            System.out.println("Total trip cost - " + this.sumForRefill + " UAH");
            System.out.println("Fuel in tank - " + this.fuelRemains);
        }
        public static void main (String[]args){
            Car rav4 = new Car(28);
            rav4.makeTrip();
        }
    }
