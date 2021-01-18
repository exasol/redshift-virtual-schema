package com.exasol.adapter.dialects.redshift;

import com.exasol.adapter.AdapterProperties;
import com.exasol.adapter.dialects.SqlDialect;
import com.exasol.adapter.dialects.SqlDialectFactory;
import com.exasol.adapter.jdbc.ConnectionFactory;
import com.exasol.logging.VersionCollector;

/**
 * Factory for the Redshift SQL dialect.
 */
public class RedshiftSqlDialectFactory implements SqlDialectFactory {
    @Override
    public String getSqlDialectName() {
        return RedshiftSqlDialect.NAME;
    }

    @Override
    public SqlDialect createSqlDialect(final ConnectionFactory connectionFactory, final AdapterProperties properties) {
        return new RedshiftSqlDialect(connectionFactory, properties);
    }

    @Override
    public String getSqlDialectVersion() {
        final VersionCollector versionCollector = new VersionCollector(
                "META-INF/maven/com.exasol/redshift-virtual-schema/pom.properties");
        return versionCollector.getVersionNumber();
    }
}