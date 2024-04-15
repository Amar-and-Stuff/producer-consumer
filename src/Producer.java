
public class Producer extends Thread{
    Market market;
    final Integer PRODUCT = 1;
    final Integer PRODUCTION_TIME;
    Producer(Market market, Integer PRODUCTION_TIME) {
        super();
        this.market = market;
        this.PRODUCTION_TIME = PRODUCTION_TIME;
    }
    @Override
    public void run() {
        while(true) {
            try {
                // production time
                try {sleep(this.PRODUCTION_TIME);} catch (InterruptedException e) {e.printStackTrace();}
                synchronized(this.market) {
                    // put
                    if (this.market.isFull()) {
                        // System.out.println(this.getName()+" is waiting");
                        this.market.wait();
                    } else {this.market.push(this.PRODUCT);this.market.notify();}
                    // System.out.println("After putting "+this.getName() + " " + this.market.toString());
                }
            } catch(Exception e) {e.printStackTrace();}
        }
    }


    @Override
    public String toString() {
        return getName()+"\t" + PRODUCTION_TIME +"\t"+ getState()+"\n";
    }

    
}