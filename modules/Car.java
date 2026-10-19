package modules; // 1. Khai báo file này thuộc package/thư mục 'models'

public class Car { // 2. Phải có 'public' để bên ngoài nhìn thấy
    public String color;
    int n = 0;

    public void Plus(){
        n = n + 1;
    }

    public static void Print(){
        System.out.println("Hello World!");
    }

    public void honk() {
        System.out.println("Bíp bíp!");
    }
}