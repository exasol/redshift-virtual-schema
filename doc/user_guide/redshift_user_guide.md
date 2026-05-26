# Redshift SQL Dialect User Guide

The Redshift SQL Dialect supports Amazon's [AWS Redshift](https://aws.amazon.com/redshift/) managed data warehouse. Redshift is at its core a relational database based on PostgreSQL.

In addition to reading from the regular relational database, this SQL dialect adapter also supports reading from [Redshift Spectrum](https://docs.aws.amazon.com/redshift/latest/dg/c-getting-started-using-spectrum.html). This allows reading file based data from S3.

## Telemetry

This virtual schema uses `telemetry-java` to send anonymous feature-usage events.

For details on what is collected and how to disable telemetry, see the [documentation](https://github.com/exasol/telemetry-java/blob/main/doc/app-user-guide.md).

## Uploading the JDBC Driver to Exasol BucketFS

1. Download the [Redshift JDBC driver](https://docs.aws.amazon.com/redshift/latest/mgmt/jdbc20-download-driver.html).
2. Upload the driver to BucketFS, see the [BucketFS documentation](https://docs.exasol.com/db/latest/administration/on-premise/bucketfs/accessfiles.htm) for details.

    Hint: Put the driver into folder `default/drivers/jdbc/` to register it for [ExaLoader](#registering-the-jdbc-driver-for-exaloader), too.

## Registering the JDBC driver for ExaLoader

In order to enable the ExaLoader to fetch data from the external database you must register the driver for ExaLoader as described in the [Installation procedure for JDBC drivers](https://github.com/exasol/docker-db/#installing-custom-jdbc-drivers).
1. ExaLoader expects the driver in BucketFS folder `default/drivers/jdbc`.

    If you uploaded the driver for UDF to a different folder, then you need to [upload](#uploading-the-jdbc-driver-to-exasol-bucketfs) the driver again.
2. Additionally you need to create file `settings.cfg` and [upload](#uploading-the-jdbc-driver-to-exasol-bucketfs) it to the same folder in BucketFS:

   ```properties
   DRIVERNAME=REDSHIFT
   JAR=RedshiftJDBC42-<JDBC driver version>.jar
   DRIVERMAIN=com.amazon.redshift.jdbc42.Driver
   PREFIX=jdbc:redshift:
   NOSECURITY=YES
   FETCHSIZE=100000
   INSERTSIZE=-1
   
   ```

   Ensure to add a trailing newline to `settings.cfg`.

## Installing the Adapter Script

Upload the latest available release of [Redshift Virtual Schema](https://github.com/exasol/redshift-virtual-schema/releases) to Bucket FS.

Then create a schema to hold the adapter script.

```sql
CREATE SCHEMA ADAPTER;
```

The SQL statement below creates the adapter script, defines the Java class that serves as entry point and tells the UDF framework where to find the libraries (JAR files) for Virtual Schema and database driver.

```sql
CREATE OR REPLACE JAVA ADAPTER SCRIPT ADAPTER.JDBC_ADAPTER AS
    %scriptclass com.exasol.adapter.RequestDispatcher;
    %jar /buckets/<BFS service>/<bucket>/virtual-schema-dist-14.0.2-redshift-4.0.0.jar;
    %jar /buckets/<BFS service>/<bucket>/RedshiftJDBC42-<JDBC driver version>.jar;
/
;
```

## Defining a Named Connection

Define the connection to Redshift as shown below. We recommend using TLS to secure the connection.

```sql
CREATE OR REPLACE CONNECTION REDSHIFT_CONNECTION
TO 'jdbc:redshift://<cluster>.<region>.redshift.amazonaws.com:<port>/<database>'
USER '<user>'
IDENTIFIED BY '<password>';
```

## Creating a Virtual Schema

Below you see how a Redshift Virtual Schema is created. Please note that you have to provide the name of the database in the property `CATALOG_NAME` since Redshift simulates catalogs.

```sql
CREATE VIRTUAL SCHEMA <virtual schema name>
    USING ADAPTER.JDBC_ADAPTER
    WITH
    CONNECTION_NAME = 'REDSHIFT_CONNECTION'
    CATALOG_NAME = '<database name>'
    SCHEMA_NAME = 'public';
```
