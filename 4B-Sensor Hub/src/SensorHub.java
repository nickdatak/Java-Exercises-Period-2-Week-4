import java.util.*;

public class SensorHub {

    private final List<SensorListener> listeners = new ArrayList<>();
    private final double threshold;

    public SensorHub(double threshold) {

        // store threshold and prepare any internal state you need
        this.threshold = threshold;

    }

    public void addListener(SensorListener listener) {
        if (!listeners.contains(listener)) {
            listeners.add(listener);
        }
    }

    public void removeListener(SensorListener listener) {
            listeners.remove(listener);
    }

    public void push(double value) {
        for (SensorListener listener : listeners) {
            try {
                listener.onReading(value);
                if (value > threshold) {
                    listener.onThresholdCross(value, threshold);
                }
            } catch (Exception e) {
                System.err.println("Listener threw exception: " + e);
            }
        }
    }
}

