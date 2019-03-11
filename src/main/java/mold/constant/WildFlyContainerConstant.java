package mold.constant;


public class WildFlyContainerConstant implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	public static final WildFlyContainerConstant INSTANCE = new WildFlyContainerConstant();
    public static final String JAVAEE_PERSISTANCE_UNIT = "ItoPersistenceUnit";
    public static final String JNDI_US_DATASOURCE = "java:jboss/datasources/PgDsMold";
    public static final String JNDI_US_DATASOURCE_XA = "java:jboss/datasources/PgDsXaMold";
    public static final String JNDI_US_SMTPMAIL_GMAIL = "java:jboss/mail/Gmail";
    public static final String JNDI_US_JMS_CONNECTION_FACTORY =
            "java:jboss/DefaultJMSConnectionFactory";
    public static final String JNDI_US_MANAGED_EXECUTOR_SERVICE =
            "java:jboss/ee/concurrency/executor/default";
    public static final String JNDI_US_MANAGED_SCHEDULED_EXECUTOR_SERVICE =
            "java:jboss/ee/concurrency/scheduler/default";
    public static final String JNDI_US_MANAGED_THREAD_FACTORY =
            "java:jboss/ee/concurrency/factory/default";

    protected WildFlyContainerConstant() {
        //Defeat Instantiation
    }

    private Object readResolve() {
        return INSTANCE;
    }
}
