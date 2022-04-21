
import gui.util.TicketReferenceNumber;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TicketReferenceNumberTest {

    @Test
    void getTicketRefNum() {

        // Arrange setup
        TicketReferenceNumber ticketReferenceNumber = new TicketReferenceNumber();

        // Act - convert the string to UUID
        String actualUUID = ticketReferenceNumber.getTicketRefNum("peter Madsen1002");
        String exceptedUUID = "a9e42ade-24bf-3b69-a230-082b35c5dcc5";

        // assert - chech if it is correct
        Assertions.assertEquals(exceptedUUID, actualUUID);
    }
}