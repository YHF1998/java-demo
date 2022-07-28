package com.getdream.demo.d20220522;

public class Main {
    public static void main(String[] args) {
        Weekday day = Weekday.MON;
        if (day.dayValue == 6 || day.dayValue == 0) {
            System.out.println("work at home,today is " + day);
        } else {
            System.out.println("work at office,today is " + day);
        }
        //System.out.println(day);

        switch (day) {
            case MON:
            case TUE:
            case WED:
            case FRI:
            case THU:
                System.out.println("work at office,today is " + day);
                break;
            case SAT:
            case SUN:
                System.out.println("work at home,today is " + day);
                break;
            default:
                throw new RuntimeException("错误内容");
        }
    }
}

enum Weekday {
    MON(1, "周一"), TUE(2, "周二"), WED(3, "周三"), THU(4, "周四"), FRI(5, "周五"), SAT(6, "周六"), SUN(0, "周日");
    public final int dayValue;
    public final String chinese;

    private Weekday(int dayValue, String chinese) {
        this.dayValue = dayValue;
        this.chinese = chinese;
    }

    @Override
    public String toString() {
        return this.chinese;
    }
}
