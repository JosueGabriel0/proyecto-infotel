package pe.edu.upeu.infotelspringboot.controller.chatbot;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upeu.infotelspringboot.model.chatbot.RasaResponse;
import pe.edu.upeu.infotelspringboot.model.chatbot.UserMessage;

import java.util.*;

@RestController
@RequestMapping("/chat")
public class ChatController {

    private static final String RASA_URL = "http://localhost:5005/webhooks/rest/webhook";
    private final ObjectMapper objectMapper = new ObjectMapper();

    @PostMapping("/message")
    public ResponseEntity<Map<String, Object>> chat(@RequestBody UserMessage userMessage) {
        try (CloseableHttpClient client = HttpClients.createDefault()) {
            HttpPost post = new HttpPost(RASA_URL);

            // Si no viene sender, generamos uno por defecto
            String sender = userMessage.getSender() != null ? userMessage.getSender() : UUID.randomUUID().toString();

            Map<String, String> rasaRequest = new HashMap<>();
            rasaRequest.put("sender", sender);
            rasaRequest.put("message", userMessage.getMessage());

            StringEntity entity = new StringEntity(objectMapper.writeValueAsString(rasaRequest));
            post.setEntity(entity);
            post.setHeader("Content-Type", "application/json");

            HttpResponse response = client.execute(post);
            String jsonResponse = EntityUtils.toString(response.getEntity());

            List<RasaResponse> rasaResponses = objectMapper.readValue(jsonResponse, new TypeReference<List<RasaResponse>>() {});

            List<String> replies = new ArrayList<>();
            for (RasaResponse rasaResponse : rasaResponses) {
                if (rasaResponse.getText() != null) {
                    replies.add(rasaResponse.getText());
                }
            }

            Map<String, Object> responseBody = new HashMap<>();
            responseBody.put("replies", replies.isEmpty() ? List.of("Lo siento, no entendí eso.") : replies);
            return ResponseEntity.ok(responseBody);

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body(Map.of("error", "Error al contactar con el asistente."));
        }
    }

    @GetMapping("/")
    public String home() {
        return "Chatbot con Rasa está corriendo";
    }
}
