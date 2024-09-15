package ru.liga.service.impl;

import ru.liga.parcel.ParcelContainer;
import ru.liga.parcel.Parcels;
import ru.liga.service.MachineLoaderService;
import ru.liga.service.ProcessLoaderService;
import ru.liga.truck.Garage;
import ru.liga.truck.Truck;

import java.util.Map;
import java.util.Objects;

public class ProcessLoaderServiceImpl implements ProcessLoaderService {

    private final MachineLoaderService machineLoaderServiceImpl;
    private final MachineLoaderService baseLoader;
    private Garage garage;

    public ProcessLoaderServiceImpl() {
        baseLoader = new MachineLoaderServiceBaseImpl();
        garage = new Garage();
        machineLoaderServiceImpl = new MachineLoaderServiceOptimalImpl();

    }

    public Garage getGarage() {
        return garage;
    }

    @Override
    public Garage runLoader(Parcels parcels, int truckHeight, int truckWidth, String algorithmName) {

        Truck truck = new Truck(truckHeight, truckWidth, "name");
        int k = 0;

        for (Map.Entry<ParcelContainer, Integer> parcel : parcels.getParcel().entrySet()) {
            k++;
            for (int i = 0; i < parcel.getValue(); i++) {

                int[][] scheme = truck.getScheme();
                scheme = addParcels(parcel.getKey().getParcel(), scheme, algorithmName, truckHeight, truckWidth);
                if (scheme != null) {
                    truck.setTruck(scheme);
                }
                if ((scheme == null) || (i == parcel.getValue() - 1 && k == parcels.getParcel().size() - 1)) {

                    garage.addTruck(truck);
                    truck = new Truck(truckHeight, truckWidth, "name");
                    scheme = addParcels(parcel.getKey().getParcel(), truck.getScheme(), algorithmName, truckHeight, truckWidth);
                    truck.setTruck(scheme);

                }
            }
        }
        return garage;
    }

    private String[] convertTruck(int[][] scheme, ParcelContainer parcels, String[] truck) {

        int k = 0;
        String[] str = new String[7];

        for (int i = scheme.length - 1; i >= 0; i--) {
            str[k] = "+";
            for (int j = 0; j < scheme.length; j++) {
                if (scheme[i][j] != 0 && truck[k].charAt(j + 1) == ' ') {
                    truck[k] = truck[k].substring(0, j + 1) + parcels.getParcel()[0][0] + truck[k].substring(j + 2);
                }
            }
            k++;
        }
        return truck;
    }

    public int[][] addParcels(int[][] parcel, int[][] scheme, String algorithmName, int height, int width) {
        int[][] field1 = new int[height][width];
        if (Objects.equals(algorithmName, "Base")) {
            field1 = baseLoader.addParcels(parcel, height, width, scheme);
        } else {
            field1 = machineLoaderServiceImpl.addParcels(parcel, height, width, scheme);
        }
        if (field1 != null) {
            return field1;
        }
        return null;
    }

}
