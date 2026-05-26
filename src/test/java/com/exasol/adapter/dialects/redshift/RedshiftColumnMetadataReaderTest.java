package com.exasol.adapter.dialects.redshift;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.when;

import java.sql.Types;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.exasol.ExaMetadata;
import com.exasol.adapter.AdapterProperties;
import com.exasol.adapter.dialects.BaseIdentifierConverter;
import com.exasol.adapter.jdbc.AbstractColumnMetadataReaderTestBase;
import com.exasol.adapter.jdbc.JDBCTypeDescription;
import com.exasol.adapter.metadata.DataType;
import com.exasol.adapter.metadata.DataType.ExaCharset;

@ExtendWith(MockitoExtension.class)
class RedshiftColumnMetadataReaderTest extends AbstractColumnMetadataReaderTestBase {
    @Mock
    ExaMetadata exaMetadataMock;

    @BeforeEach
    void beforeEach() {
        when(exaMetadataMock.getDatabaseVersion()).thenReturn("3.2.1");
        this.columnMetadataReader = new RedshiftColumnMetadataReader(null, AdapterProperties.emptyProperties(), exaMetadataMock,
                BaseIdentifierConverter.createDefault());
    }

    @Test
    void testMapJdbcTypeNumeric() {
        assertNumericMappedToDecimalWithPrecisionAndScale(DataType.MAX_EXASOL_DECIMAL_PRECISION, 2);
    }

    @Test
    void testMapJdbcTypeNumericExceedingExsolMaxPrecisionToDouble() {
        assertNumericMappedToDoubleWithPrecsionAndScale(DataType.MAX_EXASOL_DECIMAL_PRECISION + 1, 2);
    }

    @Test
    void testMapJdbcTypeFallbackToParent() {
        assertThat(this.columnMetadataReader.mapJdbcType(new JDBCTypeDescription(Types.BOOLEAN, 0, 0, 0, "")),
                equalTo(DataType.createBool()));
    }

    @Test
    void testMapJdbcTypeOtherDouble() {
        assertThat(this.columnMetadataReader.mapJdbcType(new JDBCTypeDescription(Types.OTHER, 0, 0, 0, "double")),
                equalTo(DataType.createDouble()));
    }

    @Test
    void testMapJdbcTypeOtherUnknownToMaxVarChar() {
        assertThat(this.columnMetadataReader.mapJdbcType(new JDBCTypeDescription(Types.OTHER, 0, 0, 0, "unknown")),
                equalTo(DataType.createMaximumSizeVarChar(ExaCharset.UTF8)));
    }
}
