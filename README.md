# The Otello showcase

## Introduction
The Otello project is an ongoing initiative. It is rooted on three pillars to specifically show:

- How to quickly start with provisioning required ressources, including
  - How to jump start with [Oracle Cloud Infrastructure OCI](https://www.oracle.com/cloud/), the Oracle Cloud.
  - How to set up [Oracle OpenJDK](https://www.oracle.com/java/technologies/downloads/) on a public cloud system utilized by OCI.
  - How to run modern Java versions (17+) with its recent language features on it.
- A 101 on applied observability based on the [OpenTelemetry](https://opentelemetry.io/) standard: Why and how to perform Jave bytecode instrumentation for observability purposes, including
  - How to generate and examine logs from instrumented Java code.
  - How to generate and examine traces from instrumented Java code.
  - How to generate and examine metrics from instrumented Java code.
- Latest features of most recent Java release versions, e.g. 
  - *Pattern Matching for switch*. Originally introduced as preview with JDK 17 and proposed via [JEP 406](https://openjdk.org/jeps/406), this feature was subsequently refined by following JEPs, e.g. [JEP 441](https://openjdk.org/jeps/441) (JDK 21). 
  - *Record Patterns*. Relating to the language feature of pattern matching, this feature extends pattern matching to destructive instances of record classes and adds nested patterns, see [JEP 440](https://openjdk.org/jeps/440) (JDK 21). 

This lab is used as:
- A self-contained starter package for OpenTelemetry for students and beginners loosely based on pieces of the offical documentation [here](https://opentelemetry.io/docs/languages/java/getting-started/).
- A demo kit based on underlying primitives for interactive meetups and conferences.
- A sandbox to work on and test modern Java features in conjunction with telemetry.

## Installation

### Oracle Cloud

#### Setup connect

tbd

#### Configure a compute instance

tbd

The demo setup was e.g. tested on Canonical Ubuntu 24.04.

### Oracle JDK

Download and install the desired version [here](https://www.oracle.com/java/technologies/downloads/). Consult the specific documentation at *docs.oracle.com* for detailed guidance. For example, for a *64-Bit Oracle JDK 23 for a Linux system*, look at the detailed documentation [here](https://docs.oracle.com/en/java/javase/23/install/installation-jdk-linux-platforms.html). Example:

```
curl -O https://download.oracle.com/java/21/latest/jdk-21_linux-x64_bin.deb
dpkg -i jdk-21_linux-x64_bin.deb
```

This results in:
```
java --version
java version "21.0.6" 2025-01-21 LTS
Java(TM) SE Runtime Environment (build 21.0.6+8-LTS-188)
Java HotSpot(TM) 64-Bit Server VM (build 21.0.6+8-LTS-188, mixed mode, sharing)
```

## Setup the baseline

- Clone this repository. 
- Fetch the Java agent of OpenTelemetry: ```curl -L -O https://github.com/open-telemetry/opentelemetry-java-instrumentation/releases/latest/download/opentelemetry-javaagent.jar```.
- Review the config file and its path, and set environmental configuration to focus on tracing based on automatic instrumentation: ```source configs/export-tracing```.
- Perform:
```
gradle assemble
java -jar build/libs/otello.jar
```

## Run&inspect the example
In a different shell, execute a call to the endpoint:
```
curl localhost:8080/rolldice
```

In the first shell, inspect the console output:
```
2025-03-19T10:27:31.564Z  INFO 2306 --- [           main] otel.MyApplication                       : Starting MyApplication using Java 21.0.6 with PID 2306 (/home/ubuntu/otello/build/libs/otello.jar started by root in /home/ubuntu/otello)
2025-03-19T10:27:31.955Z  INFO 2306 --- [           main] otel.MyApplication                       : No active profile set, falling back to 1 default profile: "default"
2025-03-19T10:27:42.145Z  INFO 2306 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat initialized with port(s): 8080 (http)
2025-03-19T10:27:42.446Z  INFO 2306 --- [           main] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
2025-03-19T10:27:42.447Z  INFO 2306 --- [           main] o.apache.catalina.core.StandardEngine    : Starting Servlet engine: [Apache Tomcat/10.1.8]
2025-03-19T10:27:43.151Z  INFO 2306 --- [           main] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
2025-03-19T10:27:43.160Z  INFO 2306 --- [           main] w.s.c.ServletWebServerApplicationContext : Root WebApplicationContext: initialization completed in 10407 ms
2025-03-19T10:27:48.147Z  INFO 2306 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8080 (http) with context path ''
2025-03-19T10:27:48.249Z  INFO 2306 --- [           main] otel.MyApplication                       : Started MyApplication in 20.516 seconds (process running for 39.879)
2025-03-19T10:28:00.452Z  INFO 2306 --- [nio-8080-exec-1] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring DispatcherServlet 'dispatcherServlet'
2025-03-19T10:28:00.453Z  INFO 2306 --- [nio-8080-exec-1] o.s.web.servlet.DispatcherServlet        : Initializing Servlet 'dispatcherServlet'
2025-03-19T10:28:00.457Z  INFO 2306 --- [nio-8080-exec-1] o.s.web.servlet.DispatcherServlet        : Completed initialization in 3 ms
2025-03-19T10:28:01.063Z  INFO 2306 --- [nio-8080-exec-1] otel.RollController                      : Anonymous player is rolling the dice: 1
2025-03-19T10:28:01.141Z  INFO 2306 --- [nio-8080-exec-1] otel.RollController                      : Operate on DiceValue: 1
2025-03-19T10:28:01.142Z  INFO 2306 --- [nio-8080-exec-1] otel.RollController                      : Computation ... 
2025-03-19T10:28:01.158Z  INFO 2306 --- [nio-8080-exec-1] otel.RollController                      : Result of computation: A DiceValue!
2025-03-19T10:28:01.269Z  INFO 2306 --- [nio-8080-exec-1] otel.RollController                      : Ping ...
2025-03-19T10:28:02.861Z  INFO 2306 --- [nio-8080-exec-2] otel.GreetingController                  : ... pong!
[otel.javaagent 2025-03-19 10:28:03:057 +0000] [http-nio-8080-exec-2] INFO io.opentelemetry.exporter.logging.LoggingSpanExporter - 'GET /greeting' : 9cfeeda64e3ef5ca14860bf9bef4ed0c ca575a4b939c45ab SERVER [tracer: io.opentelemetry.tomcat-10.0:2.13.3-alpha] AttributesMap{data={url.path=/greeting, server.address=localhost, client.address=127.0.0.1, network.peer.address=127.0.0.1, http.route=/greeting, http.request.method=GET, server.port=8080, thread.id=24, http.response.status_code=200, user_agent.original=Java/21.0.6, network.protocol.version=1.1, network.peer.port=35176, url.scheme=http, thread.name=http-nio-8080-exec-2}, capacity=128, totalAddedValues=14}
[otel.javaagent 2025-03-19 10:28:03:148 +0000] [http-nio-8080-exec-1] INFO io.opentelemetry.exporter.logging.LoggingSpanExporter - 'GET' : 9cfeeda64e3ef5ca14860bf9bef4ed0c 0a0b6fcd96c2700a CLIENT [tracer: io.opentelemetry.http-url-connection:2.13.3-alpha] AttributesMap{data={server.address=localhost, network.protocol.version=1.1, http.request.method=GET, server.port=8080, thread.id=23, thread.name=http-nio-8080-exec-1, url.full=http://localhost:8080/greeting, http.response.status_code=200}, capacity=128, totalAddedValues=8}
[otel.javaagent 2025-03-19 10:28:03:166 +0000] [http-nio-8080-exec-1] INFO io.opentelemetry.exporter.logging.LoggingSpanExporter - 'GET /rolldice' : 9cfeeda64e3ef5ca14860bf9bef4ed0c 1ddcb64d2ae1cf30 SERVER [tracer: io.opentelemetry.tomcat-10.0:2.13.3-alpha] AttributesMap{data={url.path=/rolldice, server.address=localhost, client.address=0:0:0:0:0:0:0:1, network.peer.address=0:0:0:0:0:0:0:1, http.route=/rolldice, http.request.method=GET, server.port=8080, thread.id=23, http.response.status_code=200, user_agent.original=curl/8.5.0, network.protocol.version=1.1, network.peer.port=57706, url.scheme=http, thread.name=http-nio-8080-exec-1}, capacity=128, totalAddedValues=14}
```

