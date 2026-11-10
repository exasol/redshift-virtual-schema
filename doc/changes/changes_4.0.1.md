# Virtual Schema for Redshift 4.0.1, released 2026-11-10

Code name: SonarCloud coverage report

## Summary

This release configures the SonarCloud analysis to import the JaCoCo XML coverage report generated during CI.

## Refactorings

* Configured the SonarCloud analysis to import the JaCoCo XML coverage report

## Security

* Pin transitive dependency `org.objenesis:objenesis:3.6` of Mockito to fix CVE-2026-116486

## Dependency Updates

### Compile Dependency Updates

* Updated `com.exasol:virtual-schema-common-jdbc:14.0.2` to `14.1.1`
* Added `org.objenesis:objenesis:3.6`

### Test Dependency Updates

* Updated `com.exasol:virtual-schema-common-jdbc:14.0.2` to `14.1.1`
* Updated `org.mockito:mockito-junit-jupiter:5.23.0` to `5.24.0`

### Plugin Dependency Updates

* Updated `com.exasol:artifact-reference-checker-maven-plugin:0.4.4` to `1.0.1`
* Updated `com.exasol:error-code-crawler-maven-plugin:2.0.7` to `2.1.3`
* Updated `com.exasol:project-keeper-maven-plugin:5.6.2` to `5.8.2`
* Removed `com.exasol:quality-summarizer-maven-plugin:0.2.1`
* Updated `io.github.git-commit-id:git-commit-id-maven-plugin:10.0.0` to `10.0.1`
* Updated `org.apache.maven.plugins:maven-artifact-plugin:3.6.1` to `3.7.0`
* Updated `org.apache.maven.plugins:maven-compiler-plugin:3.15.0` to `3.16.0`
* Updated `org.apache.maven.plugins:maven-enforcer-plugin:3.6.2` to `3.6.3`
* Updated `org.apache.maven.plugins:maven-install-plugin:3.1.4` to `3.2.0`
* Updated `org.apache.maven.plugins:maven-jar-plugin:3.5.0` to `3.5.1`
* Updated `org.apache.maven.plugins:maven-site-plugin:3.21.0` to `3.22.0`
* Updated `org.apache.maven.plugins:maven-surefire-plugin:3.5.5` to `3.6.1`
* Updated `org.apache.maven.plugins:maven-toolchains-plugin:3.2.0` to `3.3.0`
* Updated `org.codehaus.mojo:flatten-maven-plugin:1.7.3` to `1.8.0`
* Updated `org.codehaus.mojo:versions-maven-plugin:2.21.0` to `2.23.0`
* Updated `org.jacoco:jacoco-maven-plugin:0.8.14` to `0.8.16`
* Updated `org.sonarsource.scanner.maven:sonar-maven-plugin:5.5.0.6356` to `5.8.0.7211`
* Added `org.spdx:spdx-maven-plugin:1.0.4`
