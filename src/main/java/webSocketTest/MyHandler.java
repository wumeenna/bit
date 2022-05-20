package webSocketTest;

import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;
import org.springframework.web.socket.TextMessage;

public class MyHandler extends TextWebSocketHandler{

	@Override
	public void handleTextMessage(WebSocketSession session, TextMessage message) {
		System.out.println(session.toString());
		System.out.println(message.toString());
	}
}
