This spring cloud contract study
===
producer with local maven and consumer with test 

How to run?
---

First  
```
/cd producer
./gradlew clean build publishToMavenLocal
```
To
- build the app
- generate and run Spring Cloud Contract Verifier tests
- publish the fatJar and the stubs to Maven Local

---
Second
```
/cd consumer
./gradlew clean build
```
To
- build the app
- use spring-cloud-contract-stub-runner-spring[Stub Runner Spring] to download the stub of Http Server
- run the tests against stubbed server
