public class Main {
    public static void main(String[] args) throws Exception {
        Ship s = new Ship(25, 5, 100);

        Container c1 = new GasContainer(200, 500, 300, 2000, 2.5);
        Container c2 = new LiquidContainer(200, 400, 300, 2500, true);
        Container c3 = new RefrigeratedContainer(200, 350, 300, 1000, "meat", -5);

        c1.load(1500);
        c2.load(1200);
        c3.load(950);

        s.loadContainer(c1);
        s.loadContainer(c2);
        s.loadContainer(c3);

        s.printInfo();


    }
}