package com.example.sprigstudy.controller;

import com.example.sprigstudy.config.WebSocketServer;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.IOException;
@Api(tags="Socket")
@RestController
@CrossOrigin
public class SocketController {
    @Resource
    private WebSocketServer webSocketServer;

    /**
     * 给指定用户推送消息
     * @param userName 用户名
     * @param message 消息
     * @throws IOException
     */
    @RequestMapping(value = "/socket", method = RequestMethod.GET)
    public void testSocket1(@RequestParam String userName, @RequestParam String message){
        webSocketServer.sendInfo(userName, message);
    }

    /**
     * 给所有用户推送消息
     * @param message 消息
     * @throws IOException
     */
    @RequestMapping(value = "/socket/all", method = RequestMethod.GET)
    public void testSocket2(@RequestParam String message){
        try {
            webSocketServer.onMessage(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
