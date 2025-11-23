public class SensorDemo {
    public static void main(String[] args) {
        SensorHub hub = new SensorHub(25.0);

        hub.addListener(new SensorListener() {
            public void onReading(double value) {
                System.out.println("Reading: " + value);
            }
            public void onThresholdCross(double value, double threshold) {
                System.out.println("!! Warning: " + value + " crossed threshold " + threshold);
            }
        });

        // Example faulty listener
        hub.addListener(new SensorListener() {
            public void onReading(double value) {
                throw new RuntimeException("Simulated error");
            }
            public void onThresholdCross(double value, double threshold) {
                System.out.println("Threshold crossed [" + value + "]");
            }
        });

        hub.push(20.0);
        hub.push(25.0);
        hub.push(30.0);
    }
}
