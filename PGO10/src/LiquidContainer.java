public class LiquidContainer extends Container implements IHazardNotifier{
    private final boolean hazardous;

    public LiquidContainer(double h, double w, double d, double m, boolean hazardous) {
        super("L", h, w, d, m);
        this.hazardous = hazardous;
    }

    @Override
    public void load(double mass) throws OverfillException {
        double limit = hazardous ? maxLoad * 0.5 : maxLoad * 0.9;
        if (mass > limit) {
            notifyHazard("Może wystąpić przelanie " + getSerialNumber());
            throw new OverfillException("Za dużo płynu");
        }
        currentLoad = mass;
    }

    @Override
    public void notifyHazard(String msg) {
        System.out.println("!!! " + msg);
    }
}

