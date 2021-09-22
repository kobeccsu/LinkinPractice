package com.leizhou.roomwebapp.async;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.leizhou.roomwebapp.models.Room;
import com.leizhou.roomwebapp.service.RoomService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class RoomCleanerListener {
    private static final Logger log = LoggerFactory.getLogger(RoomCleanerListener.class);

    private final ObjectMapper mapper;
    private final RoomService roomService;

    public RoomCleanerListener(ObjectMapper mapper, RoomService roomService) {
        this.mapper = mapper;
        this.roomService = roomService;
    }

    public void receiveMessage(String message){
        try {
            AsyncPayload asyncPayload = mapper.readValue(message, AsyncPayload.class);
            if("ROOM".equals(asyncPayload.getModel())){
                Room room = roomService.getById(asyncPayload.getId());
                log.info("Room {}:{} needs to be cleaned", room.getNumber(), room.getName());
            }else{
                log.warn("Unknown model type");
            }
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
