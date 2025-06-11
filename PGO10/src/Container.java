public abstract class Container {
    protected static int counter = 0;
    protected  String serialNumber;
    protected  double height;
    protected  double weight;
    protected  double depth;
    protected  double maxLoad;
    protected double currentLoad;

    public Container(String typeCode, double height, double weight, double depth, double maxLoad) {
        this.serialNumber = "KON-" + typeCode + "-" + (++counter);
        this.height = height;
        this.weight = weight;
        this.depth = depth;
        this.maxLoad = maxLoad;
        this.currentLoad = 0;
    }

    public abstract void load(double mass) throws OverfillException;

    public void unload() {
        this.currentLoad = 0;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

}
