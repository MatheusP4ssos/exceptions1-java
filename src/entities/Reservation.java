package entities;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
    private Integer roomNumber;
    private Date ckeckIn;
    private Date ckeckOut;

    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Reservation(){
    }

    public Reservation(Integer roomNumber, Date ckeckIn, Date ckeckOut) {
        this.roomNumber = roomNumber;
        this.ckeckIn = ckeckIn;
        this.ckeckOut = ckeckOut;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Date getCkeckIn() {
        return ckeckIn;
    }

    public Date getCkeckOut() {
        return ckeckOut;
    }

    public long duration() {
        long fiff = ckeckOut.getTime() - ckeckIn.getTime();
        TimeUnit.DAYS.convert(fiff, TimeUnit.MILLISECONDS);
        return fiff;
    }

    public void updateDates(Date ckeckIn, Date ckeckOut) {
        this.ckeckIn = ckeckIn;
        this.ckeckOut = ckeckOut;
    }

    @Override
    public String toString() {
        return "Room number: " + roomNumber +
                "\nCheck-in: " + sdf.format(ckeckIn) +
                "\nCheck-out: " + sdf.format(ckeckOut) +
                "," +
                duration() + " nights";
    }
}