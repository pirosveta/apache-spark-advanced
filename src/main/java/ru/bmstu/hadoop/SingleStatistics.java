package ru.bmstu.hadoop;

public class SingleStatistics {
    private int delay, cancelled;

    public SingleStatistics(String delay, String cancelled) {
        try {
            this.cancelled = Integer.parseInt(cancelled);
            if (this.cancelled == 0) this.delay = Integer.parseInt(delay);
            else this.delay = 0;
        }
        catch (NumberFormatException e) {
            System.out.println(e);
        }
    }
}
