package ru.liga;

import ru.liga.fileprocessing.ScannerFile;

import ru.liga.parcel.Parcels;
import ru.liga.tuuck.Garage;
import ru.liga.tuuck.Truck;
import ru.liga.sevice.ProcessLoaderService;
import ru.liga.sevice.imp.ProcessLoaderServiceNewImpl;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите пруть к файлу :");
        ScannerFile scannerFile = new ScannerFile ();
        Parcels parcels = new Parcels(scannerFile.parsFile("src/main/resources/data"));
        ProcessLoaderService processLoaderServiceImpl = new ProcessLoaderServiceNewImpl();

        Garage garage = processLoaderServiceImpl.runLoader(parcels,6,6,"Single");

        for(Truck trucks : garage.getTrucks()){

            for(String str : trucks.getTruck()){

                System.out.println(str);

            }
            System.out.println();
            System.out.println();
        }


    }
}