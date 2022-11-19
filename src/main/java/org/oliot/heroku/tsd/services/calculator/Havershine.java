package main.java.org.oliot.heroku.tsd.services.calculator;

import java.util.Scanner;

//https://www.movable-type.co.uk/scripts/latlong.html
//
public class Havershine{

    public static void main(String[] args) {

        Scanner scanner= new Scanner(System.in);
        System.out.println("Enter lon1:");
        String str=scanner.next();
        Double lon1=Double.parseDouble(str);
        System.out.println("Enter lat1:");
        str=scanner.next();
        Double lat1=Double.parseDouble(str);
        System.out.println("Enter lon2:");
        str=scanner.next();
        Double lon2=Double.parseDouble(str);
        System.out.println("Enter lat2:");
        str=scanner.next();
        Double lat2=Double.parseDouble(str);
        //Double distance=Havershine.havershineMethod(127.363653, 36.366058, 127.356156, 36.37042);
        Double distance=Havershine.havershineMethod(lon1, lat1, lon2, lat2);
        System.out.println(distance);
        scanner.close();
    }

    public static Double havershineMethod(Double lon1, Double lat1, Double lon2, Double lat2){
        int R=6731000; //Earth's radius in metres

        Double phi1=lat1*Math.PI/180;
        //Double lambda1=lon1*Math.PI/180;
        Double phi2=lat2*Math.PI/180;
        //Double lambda2=lon2*Math.PI/180;
        Double deltaphi=(lat2-lat1)*Math.PI/180;
        Double deltalambda=(lon2-lon1)*Math.PI/180;
        
        Double a=Math.sin(deltaphi/2)*Math.sin(deltaphi/2)+Math.cos(phi1)*Math.cos(phi2)*Math.sin(deltalambda/2)*Math.sin(deltalambda/2);
        Double c=2*Math.atan2(Math.sqrt(a), Math.sqrt(1-a));

        return R*c;
    }


}