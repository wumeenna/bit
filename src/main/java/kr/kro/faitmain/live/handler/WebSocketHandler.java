package kr.kro.faitmain.live.handler;

import com.fasterxml.jackson.databind.ObjectMapper;

import kr.kro.faitmain.live.domain.ChatMessage;
import kr.kro.faitmain.live.domain.ChatRoom;
import kr.kro.faitmain.live.repository.ChatRoomRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Slf4j
@Component
@RequiredArgsConstructor
public class WebSocketHandler extends TextWebSocketHandler {
    private final ChatRoomRepository chatRoomRepository;
    private final ObjectMapper objectMapper;

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
    	log.info("�޼��� ���� = {} : {}",session,message.getPayload());
        String msg = message.getPayload();
        ChatMessage chatMessage = objectMapper.readValue(msg,ChatMessage.class);
        ChatRoom chatRoom = chatRoomRepository.findRoomById(chatMessage.getChatRoomId());
        chatRoom.handleMessage(session, chatMessage, objectMapper);
    }

}