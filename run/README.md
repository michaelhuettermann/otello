## Run&inspect Otello

This entry point introduces the smoke test of *Otello*.

Run the Otello app. Execute: ```java -jar app/build/libs/otello.jar```.

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
```

The application is started.

Open a second shell, and execute a call to the endpoint:
```
curl localhost:8080/rolldice
```

In the first shell, inspect the console output:
```
2025-03-19T10:28:00.452Z  INFO 2306 --- [nio-8080-exec-1] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring DispatcherServlet 'dispatcherServlet'
2025-03-19T10:28:00.453Z  INFO 2306 --- [nio-8080-exec-1] o.s.web.servlet.DispatcherServlet        : Initializing Servlet 'dispatcherServlet'
2025-03-19T10:28:00.457Z  INFO 2306 --- [nio-8080-exec-1] o.s.web.servlet.DispatcherServlet        : Completed initialization in 3 ms
2025-03-19T10:28:01.063Z  INFO 2306 --- [nio-8080-exec-1] otel.RollController                      : Anonymous player is rolling the dice: 1
2025-03-19T10:28:01.141Z  INFO 2306 --- [nio-8080-exec-1] otel.RollController                      : Operate on DiceValue: 1
2025-03-19T10:28:01.142Z  INFO 2306 --- [nio-8080-exec-1] otel.RollController                      : Computation ... 
2025-03-19T10:28:01.158Z  INFO 2306 --- [nio-8080-exec-1] otel.RollController                      : Result of computation: A DiceValue!
2025-03-19T10:28:01.269Z  INFO 2306 --- [nio-8080-exec-1] otel.RollController                      : Ping ...
2025-03-19T10:28:02.861Z  INFO 2306 --- [nio-8080-exec-2] otel.GreetingController                  : ... pong!
```

The output of JDK 17's *Pattern Matching for switch* in conjunction with *Record Patterns* is reported by the output:
```Result of computation: A DiceValue!```, and its coding can be found in [RollController.java](../app/RollController.java).

For details on the layout, see e.g. [here](https://opentelemetry.io/docs/languages/java/getting-started/).

This setup is the base for our [zero-code instrumentation](https://opentelemetry.io/docs/zero-code/), as follows next.

