package com.exasol.adapter.dialects.redshift;

import com.exasol.adapter.dialects.*;
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
    public SqlDialect createSqlDialect(final JDBCAdapterContext context) {
        return new RedshiftSqlDialect(context);
    }

    @Override
    public String getSqlDialectVersion() {
        final VersionCollector versionCollector = new VersionCollector(
                "META-INF/maven/com.exasol/redshift-virtual-schema/pom.properties");
        return versionCollector.getVersionNumber();
    }

    @Override
    public String getAdapterProjectShortTag() {
        return "VSRDSH";
    }
}
