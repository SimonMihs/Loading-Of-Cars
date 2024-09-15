package ru.liga.service;

import ru.liga.parcel.Parcels;
import ru.liga.truck.Garage;

public interface ProcessLoaderService {

    Garage runLoader(Parcels parcels, int truckHeight, int truckWidth, String algoritmName);

}
