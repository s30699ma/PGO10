public class RefrigeratedContainer extends Container{
    private final String productType;
    private final double temperature;

    public RefrigeratedContainer(double h, double w, double d, double m,
                                 String productType, double temperature) {
        super("C", h, w, d, m);
        this.productType = productType;
        this.temperature = temperature;
    }

    @Override
    public void load(double mass) throws OverfillException {
        if (mass > maxLoad) {
            throw new OverfillException("Za dużo znajduje się w kontenerze");
        }
        currentLoad = mass;
    }
}
