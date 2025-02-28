# Introduction

In this poc we use quarkus framework with native compilation option
this produces a native executable in docker container
The main rule engine is the kogito-drools dependency from redhat

To compile the project use maven 3.9+ or maven wrapper included

```
./mvnw install -Dnative -DskipTests -Dquarkus.native.container-build=true
```

compile a docker image next using the micro image as container

```
docker build -f ruleunit-quarkus-example/src/main/docker/Dockerfile.native-micro -t quarkus-ruleunit-runner:3.0.0-SNAPSHOT ruleunit-quarkus-example
```

Timing for kubernetes deployment on ready and live check were adjusted see probe.yaml file

See postman folder for example http request, Junit tests are also available;

For compatibility with quarkus 3+ we are using kogito modules from version 3.0.0-SNAPSHOT from parent
https://repository.jboss.org/org/kie/kogito/kogito-build-no-bom-parent/

references:

https://quarkus.io/guides/building-native-image

https://docs.drools.org/8.34.0.Final/drools-docs/docs-website/drools/language-reference/index.html

# logging

## access logs

to enable http access logs add property to quarkus application ( application.properties or ENV)

Changeable at runtime with native - **YES**

````
quarkus.http.access-log.enabled=true
````

## Rule execution

to debug rule execution activate RuleEventListenerConfig using the following property

Changeable at runtime with native - **YES**

````
#debug data change ( includes first input)
com.acn.poc.debug.rule=true
#debug all steps very verbos
com.acn.poc.debug.agenda=true
#custom logger listener
com.acn.poc.debug.custom=true
````

# Other properties

````
drools.externaliseCanonicalModelLambda=true
drools.sequential=true
````
