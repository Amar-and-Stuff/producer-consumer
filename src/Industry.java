import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Industry {
    private int noOfProducers;
    private int noOfConsumers;
    private int marketCapacity;
    private Market market;
    private ArrayList<Producer> producers;
    private ArrayList<Consumer> consumers;

    public Industry(int noOfProducers, int noOfConsumers, int marketCapacity) {
        this.noOfProducers = noOfProducers;
        this.noOfConsumers = noOfConsumers;
        this.marketCapacity = marketCapacity;
        this.market = new Market(marketCapacity);
        this.producers = new ArrayList<>();
        this.consumers = new ArrayList<>();
        this.initilizeConsumers();
        this.initilizeProducers();
        this.startSimulation();
    }

    private void initilizeProducers() {
        Random rng = new Random();
        for (int i = 0; i < noOfProducers; i++) {
            this.producers.add(new Producer(this.market, rng.nextInt(4000) + 1000));
        }
        this.producers.forEach(i -> i.start());
    }

    private void initilizeConsumers() {
        Random rng = new Random();
        for (int i = 0; i < noOfConsumers; i++) {
            this.consumers.add(new Consumer(this.market, rng.nextInt(4000) + 1000));
        }
        this.consumers.forEach(i -> i.start());
    }

    private void startSimulation() {
        while(true) {
            System.out.println(this.toString());
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                boolean isWindows = System.getProperty("os.name").toLowerCase().startsWith("windows");
                ProcessBuilder processBuilder;
                if(!isWindows)
                processBuilder = new ProcessBuilder("clear");
                else
                processBuilder = new ProcessBuilder("clear");
                Process process = processBuilder.inheritIO().start();
                process.waitFor();
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public String toString() {
        return "\nIndustry: \nnoOfProducers=" + noOfProducers + ", \tnoOfConsumers=" + noOfConsumers + ", \tmarketCapacity="
                + marketCapacity + ", \nproducers:\n" + producers + ", \nconsumers:\n" + consumers + ", \nmarket=" + market;
    }

    
}
