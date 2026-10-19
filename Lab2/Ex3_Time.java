package Lab2;

public class Ex3_Time {
    private int hour;
    private int minute;
    private int second;

    public Ex3_Time(){
        hour = 0;
        minute = 0;
        second = 0;
    }

    public Ex3_Time(int h, int m, int s){
        if (0 > h || h > 23){
            throw new IllegalArgumentException("Invalid hour!");
        } else if (0 > m || m > 59){
            throw new IllegalArgumentException("Invalid minute!");
        } else if (0 > s || s > 59){
            throw new IllegalArgumentException("Invalid second!");
        }

        hour = h;
        minute = m;
        second = s;
    }

    public void display(){
        System.out.println("Time:   " + hour + ":" + minute + ":" + second);
    }

    public void refine(){
        if (second >= 0){
            if (second > 59){
                int m = second / 60;
                second %= 60;
                minute += m;
            }

            if (minute > 59){
                int h = minute / 60;
                minute %= 60;
                hour += h;
            }
            
            if (hour > 23){
                hour %= 24;
            }
        } else {
            if (second < 0){
                int m = second / 60  - 1;
                second = 60 - Math.abs(second % 60);
                minute += m;
            }

            if (minute < 0){
                int h = minute / 60  - 1;
                minute = 60 - Math.abs(minute % 60);
                hour += h;
            }
            
            if (hour < 0){
                hour = 24 - Math.abs(hour % 24);
            }
        }
    }

    public void addseconds(int s){
        second += s;
        refine();
    }

    public void subtractseconds(int s){
        second -= s;
        refine();
    }


    public static void main(String[] args) {
        Ex3_Time A = new Ex3_Time(23, 50, 50);

        A.display();
        A.addseconds(720);
        A.display();
        A.subtractseconds(360);
        A.display();
    }
}
