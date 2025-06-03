package pe.edu.upeu.infotelspringboot.model.chatbot;

public class UserMessage {
    private String sender;
    private String message;

    // Constructores
    public UserMessage() {}
    public UserMessage(String sender, String message) {
        this.sender = sender;
        this.message = message;
    }

    // Getters y setters
    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
