import modules.Car;

public class Main {
    public static void Meow(){
        System.out.println("Meow");
    }

    public static void main(String[] args) {
        // 1. Tạo ra đối tượng cụ thể từ khuôn Car
        Car myCar = new Car(); 

        // 2. Gán dữ liệu thực tế cho đối tượng đó
        // myCar.color = "Đỏ";
        myCar.color = "Red";
        
        System.out.print("The " + myCar.color + " car: ");

        // 3. Ra lệnh cho đối tượng hoạt động
        myCar.honk(); // In ra: Bíp bíp!
        

        // myCar.Hello();
        // Car.Hello();
    }
}