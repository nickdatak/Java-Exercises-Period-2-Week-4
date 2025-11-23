public interface SensorListener {
    /**
     * Called for every new sensor reading.
     */
    void onReading(double value);
    /**
     * Called when the reading strictly exceeds the threshold.
     */
    void onThresholdCross(double value, double threshold);
}
