package com.exasol.adapter.dialects.redshift;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.instanceOf;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.exasol.adapter.dialects.JDBCAdapterContext;

public class RedshiftSqlDialectFactoryTest {
    private RedshiftSqlDialectFactory factory;

    @BeforeEach
    void beforeEach() {
        this.factory = new RedshiftSqlDialectFactory();
    }

    @Test
    void testGetName() {
        assertThat(this.factory.getSqlDialectName(), equalTo("REDSHIFT"));
    }

    @Test
    void testCreateDialect() {
        assertThat(this.factory.createSqlDialect(JDBCAdapterContext.builder().build()),
                instanceOf(RedshiftSqlDialect.class));
    }
}
