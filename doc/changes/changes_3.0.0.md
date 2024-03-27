# Virtual Schema for Redshift 3.0.0, released 2024-03-27

Code name: Charset is always `utf-8`, deprecated IMPORT_DATA_TYPES `FROM_RESULT_SET` value .

## Summary

The behaviour when it comes to character sets is now simplified,
The target charset is now always UTF-8.
The `IMPORT_DATA_TYPES` property (and value `FROM_RESULT_SET`) are now deprecated (change in vs-common-jdbc):
An exception will be thrown when users use`FROM_RESULT_SET`. The exception message warns the user that the value is no longer supported and the property itself is also deprecated.

## Refactoring

* #14: Updated tests to include Exasol V8/ Update to vsjdbc 12.0.0

## Dependency Updates

### Compile Dependency Updates

* Updated `com.exasol:error-reporting-java:0.4.1` to `1.0.1`
* Updated `com.exasol:virtual-schema-common-jdbc:9.0.4` to `12.0.0`

### Test Dependency Updates

* Updated `com.exasol:virtual-schema-common-jdbc:9.0.4` to `12.0.0`
* Updated `org.junit.jupiter:junit-jupiter:5.8.1` to `5.9.2`
* Updated `org.mockito:mockito-junit-jupiter:4.1.0` to `5.1.1`

### Plugin Dependency Updates

* Updated `com.exasol:artifact-reference-checker-maven-plugin:0.3.2` to `0.4.2`
* Updated `com.exasol:error-code-crawler-maven-plugin:0.1.1` to `2.0.1`
* Updated `com.exasol:project-keeper-maven-plugin:1.3.1` to `4.2.0`
* Updated `io.github.zlika:reproducible-build-maven-plugin:0.13` to `0.16`
* Updated `org.apache.maven.plugins:maven-assembly-plugin:3.3.0` to `3.6.0`
* Updated `org.apache.maven.plugins:maven-compiler-plugin:3.8.1` to `3.12.1`
* Updated `org.apache.maven.plugins:maven-enforcer-plugin:3.0.0-M3` to `3.4.1`
* Updated `org.apache.maven.plugins:maven-jar-plugin:3.2.0` to `3.3.0`
* Updated `org.apache.maven.plugins:maven-surefire-plugin:3.0.0-M3` to `3.2.5`
* Added `org.apache.maven.plugins:maven-toolchains-plugin:3.1.0`
* Added `org.basepom.maven:duplicate-finder-maven-plugin:2.0.1`
* Added `org.codehaus.mojo:flatten-maven-plugin:1.6.0`
* Updated `org.codehaus.mojo:versions-maven-plugin:2.7` to `2.16.2`
* Updated `org.jacoco:jacoco-maven-plugin:0.8.5` to `0.8.11`
* Added `org.sonarsource.scanner.maven:sonar-maven-plugin:3.10.0.2594`
* Updated `org.sonatype.ossindex.maven:ossindex-maven-plugin:3.1.0` to `3.2.0`
