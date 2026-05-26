package com.exasol.adapter.dialects.redshift;

import java.sql.Connection;
import java.util.*;

import com.exasol.ExaMetadata;
import com.exasol.adapter.AdapterProperties;
import com.exasol.adapter.dialects.BaseIdentifierConverter;
import com.exasol.adapter.dialects.IdentifierConverter;
import com.exasol.adapter.jdbc.*;

/**
 * This class implements a Redshift-specific metadata reader.
 */
public class RedshiftMetadataReader extends AbstractRemoteMetadataReader {
    /**
     * Create a new instance of the {@link RedshiftMetadataReader}.
     *
     * @param connection  JDBC connection to the remote data source
     * @param properties  user-defined adapter properties
     * @param exaMetadata Exasol metadata
     */
    public RedshiftMetadataReader(final Connection connection, final AdapterProperties properties, final ExaMetadata exaMetadata) {
        super(connection, properties, exaMetadata);
    }

    @Override
    protected ColumnMetadataReader createColumnMetadataReader() {
        return new RedshiftColumnMetadataReader(this.connection, this.properties, this.exaMetadata, getIdentifierConverter());
    }

    @Override
    protected TableMetadataReader createTableMetadataReader() {
        return new RedshiftTableMetadataReader(this.connection, getColumnMetadataReader(), this.properties, this.exaMetadata,
                getIdentifierConverter());
    }

    @Override
    public Set<String> getSupportedTableTypes() {
        return Collections
                .unmodifiableSet(new HashSet<>(Arrays.asList("TABLE", "VIEW", "SYSTEM TABLE", "EXTERNAL TABLE")));
    }

    @Override
    protected IdentifierConverter createIdentifierConverter() {
        return BaseIdentifierConverter.createDefault();
    }
}
