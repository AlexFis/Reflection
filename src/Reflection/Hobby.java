package Reflection;

public class Hobby {
    public int period;
    public String title;
    private int privateField = 1;

    public static void main(String[] args) {

    }

    public Hobby(int period, String title) {
        this.period = period;
        this.title = title;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Hobby{" +
                "period=" + period +
                ", title='" + title + '\'' +
                '}';
    }

    public int test(int a, String b, double c) {
        return Integer.parseInt("a" + a + "b" + b + "c" + c);
    }
}
