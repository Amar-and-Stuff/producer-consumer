
public class Consumer extends Thread {
    Market market;
    final Integer CONSUMPTION_TIME;

    Consumer(Market market, Integer CONSUMPTION_TIME) {
        this.market = market;
        this.CONSUMPTION_TIME = CONSUMPTION_TIME;
    }

    public void run() {
        while (true) {
            // take
            try {
                synchronized (this.market) {
                    if (!this.market.isEmpty()) {
                        market.pop();
                        this.market.notify();
                    } else {
                        // System.out.println(this.getName() + " is waiting");
                        this.market.wait();
                    }
                    // System.out.println("After taking " + this.getName() + " " + market.toString());

                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            // consumption time
            try {
                sleep(this.CONSUMPTION_TIME);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public String toString() {
        return getName()+"\t" + CONSUMPTION_TIME +"\t"+ getState()+"\n";
    }
}
