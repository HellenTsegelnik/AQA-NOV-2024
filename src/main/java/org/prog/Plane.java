package org.prog;
import org.prog.homework3.HomeWork3;

public class Plane {
    public String flightId;      // Идентификатор рейса
    public String destination;   // Пункт назначения
    public String airlines;

    public String toString(){
        return flightId+destination+airlines;
    }

     @Override
    public int hashCode (){
         return(flightId+destination+airlines).hashCode();

    }
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Plane) {
            Plane p = (Plane) obj;
            boolean itsTheSameAirlines = p.airlines.equels(this.airlines) && this.destination.equals(p.destination)
                    && this.flightId.equals(p.flightId);

            return itsTheSameAirlines;}
        return false;
        }
public int getAirlineLength(){
        return airlines.length();
}
}



