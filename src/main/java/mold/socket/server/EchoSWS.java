package mold.socket.server;

import javax.ejb.Stateless;
import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.util.logging.Logger;

@Stateless
@ServerEndpoint("/echoSWS")
public class EchoSWS {
    private Logger logger = Logger.getLogger(this.getClass().getSimpleName());

    @OnOpen
    public void onOpen(Session session) {
        logger.info(String.format("ServerSide >>> Connected to ... %s ", session.getId()));
    }

    @OnClose
    public void onClose(Session session, CloseReason closeReason) {
        logger.info(
                String.format(
                        "ServerSide >>> Session %s closed because of %s", session.getId(), closeReason));
    }

    @OnError
    public void onError(Throwable error) {
        error.printStackTrace();
    }

    @OnMessage
    public String onMessage(String string, Session session) {
        if (string == null || string.isEmpty() || string.contains("ping")) {
            return "pong";
        }
        logger.info(
                String.format("ServerSide >>> got message %s : session: %s ", string, session.getId()));
        String reverse = new StringBuffer(string).reverse().toString();
        logger.info(String.format("Processed: %s", reverse));
        return String.format(reverse);
    }
}
