package ru.liga.sevice;

import ru.liga.parcel.Parcels;
import ru.liga.tuuck.Garage;

public interface ProcessLoaderService {

    Garage runLoader(Parcels parcels, int truckHeight, int truckWidth, String algoritmName);

}
