package com.sunro.RedisCreateAuthorNameSuggestion.domain.chat.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

@Data
public class ChatRoom implements Serializable {

    private static final long serialVersionUID = 6494678977089006639L;

    private String roomId;
    private String name;

    public static ChatRoom create(String name) {
        ChatRoom chatRoom = new ChatRoom();
        chatRoom.roomId = UUID.randomUUID().toString();
        chatRoom.name = name;
        return chatRoom;
    }
}
