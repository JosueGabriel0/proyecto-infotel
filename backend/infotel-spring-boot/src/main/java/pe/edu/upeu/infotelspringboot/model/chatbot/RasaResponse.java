package pe.edu.upeu.infotelspringboot.model.chatbot;

public class RasaResponse {
    private String recipient_id;
    private String text;

    // Getters y setters
    public String getRecipient_id() {
        return recipient_id;
    }

    public void setRecipient_id(String recipient_id) {
        this.recipient_id = recipient_id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
