package gui.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TicketReferenceNumberTest {

    @Test
    void getTicketRefNum() {

        // setup
        TicketReferenceNumber ticketReferenceNumber = new TicketReferenceNumber();

        // act
        String actualUUID = ticketReferenceNumber.getTicketRefNum("Peter hansen1001");
        String expectedUUID = "32aa2090-efff-3982-acfc-1184dc2a9edf";

        //assert
        Assertions.assertEquals(expectedUUID, actualUUID);
    }



}