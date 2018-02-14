# Lambda example for AWS

This is just a simple Hello World app for lambda

## How to upload to AWS

Run this maven command:

```
mvn package
```

Then upload lambdaexample-1.0-SNAPSHOT.jar to your Lambda AWS service

The compilation process uses maven-shade-plugin to package the artifact in an uber-jar
