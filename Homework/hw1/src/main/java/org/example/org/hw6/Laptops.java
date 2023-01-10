package org.hw6;

public class Laptops {
    /** производитель ноутбука*/
    private String producer;
    /** модель ноутбука*/
    private String model;
    /** операционная система */
    private String os;
    /** процессор */
    private String cup;
    /** ОЗУ */
    private int ram;
    /** объем твердого напопителя */
    private int hd;

    public Laptops(String producer, String model, String os, String cup, int ram, int hd) {
        this.producer = producer;
        this.model = model;
        this.os = os;
        this.cup = cup;
        this.ram = ram;
        this.hd = hd;
    }

    public String getProducer() {
        return producer;
    }

    public String getModel() {
        return model;
    }

    public String getOs() {
        return os;
    }

    public String getCup() {
        return cup;
    }

    public int getRam() {
        return ram;
    }

    public int getHd() {
        return hd;
    }

    @Override
    public String toString() {
        return "Laptops{" +
                "producer='" + producer + '\'' +
                ", model='" + model + '\'' +
                ", os='" + os + '\'' +
                ", cup='" + cup + '\'' +
                ", ram=" + ram +
                ", hd=" + hd +
                '}';
    }
}
