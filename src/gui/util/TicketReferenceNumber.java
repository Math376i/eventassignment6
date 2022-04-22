package gui.util;

import java.nio.charset.StandardCharsets;
import java.util.UUID;

public class TicketReferenceNumber{

    public String getTicketRefNum(String name){

        UUID uuid = UUID.nameUUIDFromBytes(name.getBytes(StandardCharsets.UTF_8));
        System.out.println(uuid);
        return uuid.toString();
    }

}
