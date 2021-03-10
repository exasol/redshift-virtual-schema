# Redshift Virtual Schema 2.0.0, released 2021-??-??

Code name: Remove `SQL_DIALECT` property

## Summary

The `SQL_DIALECT` property used when executing a `CREATE VIRTUAL SCHEMA` from the Exasol database is obsolete from this version. Please, do not provide this property anymore.

## Dependency updates

* Updated `com.exasol:virtual-schema-common-jdbc:8.0.0` to `9.0.1`
* Updated `com.exasol:error-reporting-java:jar:0.2.0` to `0.2.2`
* Updated `org.junit.jupiter:junit-jupiter:jar:5.7.0` to `5.7.1`
* Updated `org.mockito:mockito-junit-jupiter:jar:3.6.28` to `3.8.0`