package com.techelevator;

import java.security.InvalidKeyException;
import java.time.LocalDate;

public interface reservationDAO {
    public void addReservation(int id, String reservedFor, LocalDate fromDate, LocalDate toDate)
            throws IllegalArgumentException, InvalidKeyException;
}
