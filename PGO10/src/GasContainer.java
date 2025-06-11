public class GasContainer extends Container implements IHazardNotifier{
    private final double pressure;

    public GasContainer(double h, double w, double d, double m, double pressure) {
        super("G", h, w, d, m);
        this.pressure = pressure;
    }

    @Override
    public void load(double mass) throws OverfillException {
        if (mass > maxLoad * 0.9) {
            notifyHazard("Może wystąpić przepełnienie  " + getSerialNumber());
            throw new OverfillException("Za dużo gazu");
        }
        currentLoad = mass;
    }

    @Override
    public void unload() {
        currentLoad *= 0.05;
    }

    @Override
    public void notifyHazard(String msg) {
        System.out.println("!!! " + msg);
    }
}
