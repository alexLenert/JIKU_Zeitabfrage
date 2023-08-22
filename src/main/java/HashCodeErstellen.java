public class HashCodeErstellen {



    static String hashBerechnen(String passwort){

        String x;

        x = passwort + "einsZweiDreiGeheim";

        String hashWert = String.valueOf(x.hashCode());

        return  hashWert;
    }





}
