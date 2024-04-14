import java.util.StringJoiner;

public class Market {
    private int[] store;
    private int capacity;
    private int top;

    Market(int capacity) {
        this.capacity = capacity;
        this.store = new int[this.capacity];
        this.top = -1;
    }

    public void push(int product) {
        if (!this.isFull()) {
            store[++top] = 1;
        }
    }

    public void pop() {
        if (!this.isEmpty()) {
            top--;
        }
    }

    public boolean isEmpty() {
        return (this.top == -1) ? (true) : (false);
    }

    public boolean isFull() {
        return (this.top == this.capacity - 1) ? (true) : (false);
    }

    @Override
    public String toString() {
        StringJoiner arrjoin = new StringJoiner(",", "[", "]");
        for (int i = 0; i <= top; i++) {
            arrjoin.add(String.valueOf(store[i]));
        }
        return String.valueOf(arrjoin);
    }
}
