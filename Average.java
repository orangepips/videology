public class Average {
    int observations = 0;
    double average = 0;

    public void update(double x) {
        average = (average * observations + x) / (++observations);
    }

    public double getAverage() {
        return this.average;
    }

    public static void main(String... args) {
        Average oAvg = new Average();

        int[] numbers = new int[]{10,20,15,25,16,60,100};
        int sum = 0;

        for(int i=0; i < numbers.length ; i++) {
            sum = sum + numbers[i];
            oAvg.update(numbers[i]);
        }

        //calculate average value
        double average = sum / numbers.length;

        System.out.println("Average value of array elements evaluated once is : " + average);
        System.out.println("Average value of array elements evaluated dynamically is : " + oAvg.getAverage());
    }
}
