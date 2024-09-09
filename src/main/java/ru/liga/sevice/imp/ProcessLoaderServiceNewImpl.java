package ru.liga.sevice.imp;

import ru.liga.parcel.Parcels;
import ru.liga.sevice.MachineLoaderService;
import ru.liga.sevice.ProcessLoaderService;
import ru.liga.truck.Garage;
import ru.liga.truck.Truck;

import java.util.Arrays;
import java.util.List;

public class ProcessLoaderServiceNewImpl implements ProcessLoaderService {

    private final MachineLoaderService baseLoader;
    private final Garage garage;
    private final MachineLoaderService machineLoaderServiceOptimalImpl;
    private final MachineLoaderService machineLoaderServiceSingleImpl;

    public ProcessLoaderServiceNewImpl() {
        machineLoaderServiceOptimalImpl = new MachineLoaderServiceOptimalImpl();
        baseLoader = new MachineLoaderServiceBaseService();
        garage = new Garage();
        machineLoaderServiceSingleImpl = new MachineLoaderServiceSingleImpl();
    }


    @Override
    public Garage runLoader(Parcels parcels, int truckHeight, int truckWidth, String algorithmName) {
        garage.addTruck(new Truck(truckHeight, truckWidth, "name"));
        List<int[][]> parcelList = parcels.getParcelList();
        int parcelIndex = 0;
        while (!parcelList.isEmpty()) {

            int[][] scheme = garage.getTruck().getScheme();
            if (addParcelToTruck(parcelList.get(parcelIndex), scheme, algorithmName, truckHeight, truckWidth)) {
                parcelList.remove(parcelIndex);
                parcelIndex = 0;
                continue;
            }
            if (parcelIndex + 1 >= parcelList.size()) {
                garage.addTruck(new Truck(truckHeight, truckWidth, "name"));
                if (!addParcelToTruck(parcelList.get(parcelIndex), garage.getTruck().getScheme(), algorithmName, truckHeight, truckWidth)) {
                    garage.removeTruc(garage.getTrucks().size() - 1);
                    System.err.println("Невалидная поылка : " + Arrays.deepToString(parcelList.get(parcelIndex)));
                }
                parcelList.remove(parcelIndex);
                parcelIndex = 0;
            } else {
                parcelIndex++;
            }

        }
        return garage;
    }

    private boolean addParcelToTruck(int[][] parcel, int[][] scheme, String algorithmName, int height, int width) {
        int[][] field1 = addParcels(parcel, scheme, algorithmName, height, width);
        if (field1 != null) {
            garage.getTruck().setTruck(field1);
            return true;
        }
        return false;
    }

    private int[][] addParcels(int[][] parcel, int[][] scheme, String algorithmName, int height, int width) {
        int[][] field1 = new int[height][width];
        switch (algorithmName) {
            case "Base":
                field1 = baseLoader.addParcels(parcel, height, width, scheme);
                break;
            case "Optimal":
                field1 = machineLoaderServiceOptimalImpl.addParcels(parcel, height, width, scheme);
                break;
            case "Single":
                field1 = machineLoaderServiceSingleImpl.addParcels(parcel, height, width, scheme);
                break;
            default:
                System.err.println("Неверный алгоритм: " + algorithmName);
        }

        if (field1 != null) {
            return field1;
        }
        return null;
    }

}
