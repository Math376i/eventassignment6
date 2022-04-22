package gui.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TicketReferenceNumberTest {

    @Test
    void getTicketRefNum() {

        //Triple a pattern

        // Arrange - setup our test objects etc.
        TicketReferenceNumber ticketReferenceNumber = new TicketReferenceNumber();

        // act - do the actualy convertion of the string to UUID
        String actualUUID = ticketReferenceNumber.getTicketRefNum("Peter hansen1001");
        String expectedUUID = "32aa2090-efff-3982-acfc-1184dc2a9edf";

        //assert - checks if actual val is equal to expected val
        Assertions.assertEquals(expectedUUID, actualUUID);
    }
    
}