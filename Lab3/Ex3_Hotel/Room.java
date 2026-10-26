package Lab3.Ex3_Hotel;

import java.util.ArrayList;
import java.util.List;

public class Room {
    private String roomType;
    private int dailyPrice;
    private int rentalDays;
    private List<Person> guests = new ArrayList<>();

    public Room() {
    }

    public Room(String roomType, int rentalDays) {
        setRoomType(roomType);
        setRentalDays(rentalDays);
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        if (roomType == null) {
            throw new IllegalArgumentException("Invalid room type!");
        }
        String upper = roomType.trim().toUpperCase();
        if (upper.equals("VIP1") || upper.equals("VIP2") || upper.equals("VIP3")) {
            this.roomType = upper;
            if (upper.equals("VIP1")) {
                this.dailyPrice = 900000;
            } else if (upper.equals("VIP2")) {
                this.dailyPrice = 700000;
            } else {
                this.dailyPrice = 500000;
            }
        } else {
            throw new IllegalArgumentException("Invalid room type! (Only VIP1, VIP2, or VIP3)");
        }
    }

    public int getDailyPrice() {
        return dailyPrice;
    }

    public void setDailyPrice(int dailyPrice) {
        if (dailyPrice <= 0) {
            throw new IllegalArgumentException("Invalid daily price!");
        }
        this.dailyPrice = dailyPrice;
    }

    public int getRentalDays() {
        return rentalDays;
    }

    public void setRentalDays(int rentalDays) {
        if (rentalDays <= 0) {
            throw new IllegalArgumentException("Invalid rental days!");
        }
        this.rentalDays = rentalDays;
    }

    public List<Person> getGuests() {
        return guests;
    }

    public void setGuests(List<Person> guests) {
        this.guests = guests;
    }

    // Các hàm tương thích cũ
    public String getRoomtype() { return getRoomType(); }
    public void setRoomtype(String r) { setRoomType(r); }
    public int getDailyprice() { return getDailyPrice(); }
    public void setDailyprice(int p) { setDailyPrice(p); }
    public int getRentaldays() { return getRentalDays(); }
    public void setRentaldays(int d) { setRentalDays(d); }
    public List<Person> getGuess() { return getGuests(); }
    public void setGuess(List<Person> g) { setGuests(g); }

    // Thêm và xóa khách theo yêu cầu đề bài
    public void addGuest(Person guest) {
        if (guest != null) {
            guests.add(guest);
        }
    }

    public void removeGuest(Person guest) {
        if (guest != null) {
            guests.remove(guest);
        }
    }

    public int calculateRentalCost() {
        return dailyPrice * rentalDays;
    }

    @Override
    public String toString() {
        return String.format("Room Type: %s | Daily Price: %,d VND | Rental Days: %d | Total: %,d VND | Guests: %s",
                roomType, dailyPrice, rentalDays, calculateRentalCost(), guests);
    }
}
