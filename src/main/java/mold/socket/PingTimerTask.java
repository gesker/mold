package mold.socket;

import javax.websocket.Session;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimerTask;


public class PingTimerTask extends TimerTask {
    private Session session;
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");

    public PingTimerTask(Session session) {
        this.session = session;
    }

    @Override
    public void run() {
        session.getAsyncRemote().sendText("ping : " + simpleDateFormat.format(new Date()));
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }
}
