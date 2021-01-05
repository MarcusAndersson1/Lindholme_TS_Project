package controllers;


import objects.Message;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MessageController {
   private static String currentDateTime;
   private static int senderID;
   private static String senderName;


    public static void createMessage(int receiverID, String text){
        currentDateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy - H:mm:ss"));
        senderID = Controller.getCurrentUser().getID();
        senderName = Controller.getCurrentUser().getName();
        String text2 = "From: " + senderName + "\n" + currentDateTime + "\n" + text;
        Message message = new Message(messageID(currentDateTime) ,senderID, senderName, receiverID, text2, currentDateTime);
        UserController.getUser(senderID).addMessage(messageID(currentDateTime), message);
        UserController.getUser(receiverID).addMessage(messageID(currentDateTime), message);

    }
    public static void replyMessage(Message oldMessage, String replyText, int receiverID){
        currentDateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy - H:mm:ss"));
        senderID = Controller.getCurrentUser().getID();
        senderName = Controller.getCurrentUser().getName();
        String newMessage = oldMessage.getMessage() + "\n\n" + "From: " + senderName + "\n" + currentDateTime + "\n" + replyText;
        Message reply = new Message(oldMessage.getMessageID(),senderID,senderName,receiverID,newMessage,currentDateTime);
        UserController.getUser(senderID).replaceMessage(oldMessage.getMessageID(), oldMessage, reply);
        UserController.getUser(receiverID).replaceMessage(oldMessage.getMessageID(), oldMessage, reply);

    }
    public static void deleteMessage(long messageID){
        UserController.getUser(Controller.currentUser.getID()).removeMessage(messageID);
    }

    public static long messageID(String currentDateTime){
        //Takes the date and time that the message was created and turns it into a unique message ID
        String s = currentDateTime.replaceAll("[^\\d]", "");
        long messageID = Long.parseLong(s);
        return messageID;
    }

}
