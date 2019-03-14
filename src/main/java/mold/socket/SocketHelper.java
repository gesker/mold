package mold.socket;

import javax.websocket.ContainerProvider;
import javax.websocket.Session;
import javax.websocket.WebSocketContainer;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;


public class SocketHelper {
    public static int SECONDS = 7;
    public static CountDownLatch messageLatch = new CountDownLatch(SECONDS);
    private Logger logger = Logger.getLogger(this.getClass().getName());
    private Timer timer = new Timer();

    public SocketHelper() {
    }

    public URI setupSession_URI(String socketUriString) {
        URI webSocketServerURI = null;
        logger.info(String.format("SocketClient >>> websocketServer: " + socketUriString));
        try {
            webSocketServerURI = new URI(socketUriString);
            logger.info(String.format("SocketClient >>> websocketServerURI: " + webSocketServerURI.toURL()));
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return webSocketServerURI;
    }

    public WebSocketContainer setupSession_WebSocketContainer() {
        WebSocketContainer webSocketContainer;
        webSocketContainer = ContainerProvider.getWebSocketContainer();
        logger.info("SocketClient >>> webSocketContainer (getWebSocketContainer)");
        return webSocketContainer;
    }

    public Session setupSessionVariables(Session session) {
        logger.info(String.format("SocketTest >>> My Object is of type ...." + session.getClass()));
        logger.info("SocketTest >>> webSocketSession (connectToServer)");
        session
                .getUserProperties()
                .put("finished", false); // Add property so we know the work is all done
        session
                .getUserProperties()
                .put("pingTimerTask", new PingTimerTask(session)); // Add a TimerTask to act as a heart beat (overkill)
        timer.schedule(
                (TimerTask) session.getUserProperties().get("pingTimerTask"),
                0,
                1000 * SECONDS); // Put TimerTask to work
        return session;
    }

    public void tearDownSession(Session session) {
        if (!session.isOpen()) {
            return;
        }
        if (!session.getUserProperties().containsKey("finished")) {
            return; // Don't know status -- no finished property
        }
        if (!((Boolean) session.getUserProperties().get("finished"))) {
            return; // Session still has work to do
        }
        if (!session.getUserProperties().containsKey("pingTimerTask")) {
            return; // No keep alive TimerTask???
        }
        PingTimerTask ptt = (PingTimerTask) session.getUserProperties().get("pingTimerTask");
        ptt.cancel();
        try {
            ptt.getSession().close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            messageLatch.await(SECONDS, TimeUnit.SECONDS);
            session.close();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
