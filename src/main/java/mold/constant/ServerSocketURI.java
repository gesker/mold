package mold.constant;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Logger;


public class ServerSocketURI {
    private Logger logger = Logger.getLogger(this.getClass().getName());
    public static final ServerSocketURI INSTANCE = new ServerSocketURI();
    private static final String DEV_WORKSTATION = "drg-nix"; // Development Workstation
    private static final String DEV_NOTEBOOK= "drg-nbk"; // Development Notebook
    private static final String ECHO_WS_LOCALHOST = "http://localhost:8080/web/echoSWS";
    private static final String ECHO_WS_STAGE = "http://stage.server.mold:8080/web/echoSWS";



    private String host = null;

    public ServerSocketURI() {
        //Defeat Instantiation
        determineHostname();
    }

    private Object readResolve() {
        return INSTANCE;
    }

    private void determineHostname() {
        try {
            host = InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        if (host != null) {
            host = host.toLowerCase();
            logger.info("Hostname is: " + host);
            return;
        }
        host = "unknown_hostname";
        logger.info("Hostname is: " + host);
        return;
    }

    public String getEchoSws() {
        if (host.equalsIgnoreCase(DEV_WORKSTATION)
                || host.equalsIgnoreCase(DEV_NOTEBOOK)) {
            return ECHO_WS_LOCALHOST; // Use the local container end point
        }
        return ECHO_WS_STAGE; // Use the staging server end point
    }
}
