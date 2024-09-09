package ru.liga.tuuck;


public class Truck {
    private final String name;
    private final int height;
    private final int width;
    private int[][] scheme;
    private String[] truck;
    public Truck(int height, int width, String name) {
        this.width = width;
        this.height = height;
        this.truck = createEmptyTruck(height, width);
        this.name = name;
        this.scheme = new int[height][width];

    }

    private String[] createEmptyTruck(int height, int width) {
        String[] truck = new String[height + 1];
        for (int i = 0; i < height + 1; i++) {
            truck[i] = "+";
            for (int j = 0; j < width; j++) {
                if (i == height) {
                    truck[i] = truck[i] + "+";
                } else {
                    truck[i] = truck[i] + " ";
                }

            }
            truck[i] = truck[i] + "+";
        }
        return truck;
    }

    public String[] getTruck() {
        return truck;
    }

    public void setTruck(int[][] scheme) {

        int k = 0;
        String[] truck = getTruck();
        setScheme(scheme);
        for (int i = scheme.length - 1; i >= 0; i--) {
            for (int j = 0; j < scheme.length; j++) {
                if (scheme[i][j] != 0 && truck[k].charAt(j + 1) == ' ') {
                    truck[k] = truck[k].substring(0, j + 1) + scheme[i][j] + truck[k].substring(j + 2);
                }
            }
            k++;
        }
        this.truck = truck;
    }

    public int[][] getScheme() {
        return scheme;
    }

    public void setScheme(int[][] scheme) {
        this.scheme = scheme;
    }

    public String getName() {
        return name;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

}
