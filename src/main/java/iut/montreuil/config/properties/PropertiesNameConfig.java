package iut.montreuil.config.properties;

public interface PropertiesNameConfig {

    String PROPERTY_NAME_HIBERNATE_DIALECT = "hibernate.dialect";
    String PROPERTY_NAME_HIBERNATE_SHOW_SQL = "hibernate.show_sql";
    String PROPERTY_NAME_HIBERNATE_MAX_ACTIVE = "hibernate.dbcp.maxActive";

    /**
     * The maximum number of connections that can remain idle in the pool,
     * without extra ones being released, or negative for no limit.
     */
    String PROPERTY_NAME_HIBERNATE_MAX_IDLE = "hibernate.dbcp.maxIdle";

    /**
     * The indication of whether objects will be validated before being returned to the pool.
     */
    String PROPERTY_NAME_HIBERNATE_TEST = "hibernate.dbcp.test OnReturn";

    /**
     * The SQL query that will be used to validate connections from this pool before returning them to the caller.
     * If specified, this query MUST be an SQL SELECT statement that returns at least one row.
     * If not specified, connections will be validation by calling the isValid() method.
     */
    String PROPERTY_NAME_HIBERNATE_VALIDATION_QUERY = "hibernate.dbcp.validationQuery";
}
