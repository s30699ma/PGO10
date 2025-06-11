import java.util.*;
public class Ship {
    private final double maxSpeed;
    private final int maxContainers;
    private final double maxWeightTons;
    private final List<Container> containers = new ArrayList<>();

    public Ship(double maxSpeed, int maxContainers, double maxWeightTons) {
        this.maxSpeed = maxSpeed;
        this.maxContainers = maxContainers;
        this.maxWeightTons = maxWeightTons;
    }

    public void loadContainer(Container c) throws Exception {
        if (containers.size() >= maxContainers) {
            throw new Exception("Za dużo kontenerów");
        }
        double total = containers.stream().mapToDouble(con -> con.weight + con.currentLoad).sum();
        double newTotal = total + c.weight + c.currentLoad;
        if (newTotal > maxWeightTons * 1000) {
            throw new Exception("Przekroczono limit wagowy");
        }
        containers.add(c);
    }

    public void unloadContainer(String serial) {
        containers.removeIf(c -> c.getSerialNumber().equals(serial));
    }

    public void replaceContainer(String serial, Container replacement) {
        for (int i = 0; i < containers.size(); i++) {
            if (containers.get(i).getSerialNumber().equals(serial)) {
                containers.set(i, replacement);
                return;
            }
        }
    }

    public void transferContainerTo(Container c, Ship target) throws Exception {
        unloadContainer(c.getSerialNumber());
        target.loadContainer(c);
    }

    public void printInfo() {
        System.out.println("Ship @ " + maxSpeed + " ma kontenery:");
        for (Container c : containers) {
            System.out.println(" - " + c.getSerialNumber());
        }
    }
}
