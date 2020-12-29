package controllers;


import objects.Message;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MessageController {


    public static void createMessage(int receiverID, String text){
        String currentDateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy - H:mm:ss"));
        int senderID = Controller.getCurrentUser().getID();
        String senderName = Controller.getCurrentUser().getName();
        Message message = new Message(messageID(currentDateTime) ,senderID, senderName, receiverID, text, currentDateTime);
        UserController.getUser(receiverID).addMessage(messageID(currentDateTime), message);
        System.out.println(message);

    }

    public static void deleteMessage(long messageID){
        UserController.getUser(Controller.currentUser.getID()).removeMessage(messageID);
    }

    public static long messageID(String currentDateTime){
        //Takes the date and time that the message was created and turns it into a unique message ID
        String s = currentDateTime.replaceAll("[^\\d]", "");
        System.out.println(s);
        long messageID = Long.parseLong(s);
        System.out.println(messageID);
        return messageID;
    }

}
