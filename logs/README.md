## Logging

Open a shell, and check and then apply the config file. Review the file and its path, and set environmental configuration to focus on tracing based on automatic instrumentation: 
```source logs/export-logging```. 

Specifically, we customize the system properties for setting the [exporters](https://opentelemetry.io/docs/languages/java/configuration/#properties-exporters), and utilize *logging-otlp*.

Run the Otello app:
```java -jar build/libs/otello.jar```.

Open a second shell, and execute a call to the endpoint:
```curl localhost:8080/rolldice```

Watch the first shell. Logging output from the *OtlpJsonLoggingLogRecordExporter* is shown:

```yaml
{
  "resource": {
    "attributes": [
      {
        "key": "host.arch",
        "value": {
          "stringValue": "amd64"
        }
      },
      {
        "key": "host.name",
        "value": {
          "stringValue": "instance-20241121-1211"
        }
      },
      {
        "key": "os.description",
        "value": {
          "stringValue": "Linux 6.8.0-1021-oracle"
        }
      },
      {
        "key": "os.type",
        "value": {
          "stringValue": "linux"
        }
      },
      {
        "key": "process.command_args",
        "value": {
          "arrayValue": {
            "values": [
              {
                "stringValue": "/usr/lib/jvm/jdk-21.0.6-oracle-x64/bin/java"
              },
              {
                "stringValue": "-jar"
              },
              {
                "stringValue": "build/libs/otello.jar"
              }
            ]
          }
        }
      },
      {
        "key": "process.executable.path",
        "value": {
          "stringValue": "/usr/lib/jvm/jdk-21.0.6-oracle-x64/bin/java"
        }
      },
      {
        "key": "process.pid",
        "value": {
          "intValue": "479691"
        }
      },
      {
        "key": "process.runtime.description",
        "value": {
          "stringValue": "Oracle Corporation Java HotSpot(TM) 64-Bit Server VM 21.0.6+8-LTS-188"
        }
      },
      {
        "key": "process.runtime.name",
        "value": {
          "stringValue": "Java(TM) SE Runtime Environment"
        }
      },
      {
        "key": "process.runtime.version",
        "value": {
          "stringValue": "21.0.6+8-LTS-188"
        }
      },
      {
        "key": "service.instance.id",
        "value": {
          "stringValue": "868d06c6-56a2-48ed-ba3f-979d57cb67e1"
        }
      },
      {
        "key": "service.name",
        "value": {
          "stringValue": "otello"
        }
      },
      {
        "key": "telemetry.distro.name",
        "value": {
          "stringValue": "opentelemetry-java-instrumentation"
        }
      },
      {
        "key": "telemetry.distro.version",
        "value": {
          "stringValue": "2.13.3"
        }
      },
      {
        "key": "telemetry.sdk.language",
        "value": {
          "stringValue": "java"
        }
      },
      {
        "key": "telemetry.sdk.name",
        "value": {
          "stringValue": "opentelemetry"
        }
      },
      {
        "key": "telemetry.sdk.version",
        "value": {
          "stringValue": "1.47.0"
        }
      }
    ]
  },
  "scopeLogs": [
    {
      "scope": {
        "name": "org.apache.catalina.core.ContainerBase.[Tomcat].[localhost].[/]",
        "attributes": []
      },
      "logRecords": [
        {
          "timeUnixNano": "1746006003432000000",
          "observedTimeUnixNano": "1746006003432522818",
          "severityNumber": 9,
          "severityText": "INFO",
          "body": {
            "stringValue": "Initializing Spring DispatcherServlet 'dispatcherServlet'"
          },
          "attributes": [],
          "flags": 1,
          "traceId": "6c8516e1bd2061db65df7bd1d414dbe5",
          "spanId": "bce0acb9304993a4"
        }
      ]
    },
    {
      "scope": {
        "name": "otel.RollController",
        "attributes": []
      },
      "logRecords": [
        {
          "timeUnixNano": "1746006003836392214",
          "observedTimeUnixNano": "1746006003838760520",
          "severityNumber": 9,
          "severityText": "INFO",
          "body": {
            "stringValue": "Anonymous player is rolling the dice: 3"
          },
          "attributes": [],
          "flags": 1,
          "traceId": "6c8516e1bd2061db65df7bd1d414dbe5",
          "spanId": "bce0acb9304993a4"
        },
        {
          "timeUnixNano": "1746006003839652495",
          "observedTimeUnixNano": "1746006003839740571",
          "severityNumber": 9,
          "severityText": "INFO",
          "body": {
            "stringValue": "Operate on DiceValue: 3"
          },
          "attributes": [],
          "flags": 1,
          "traceId": "6c8516e1bd2061db65df7bd1d414dbe5",
          "spanId": "bce0acb9304993a4"
        },
        {
          "timeUnixNano": "1746006003840156417",
          "observedTimeUnixNano": "1746006003840188057",
          "severityNumber": 9,
          "severityText": "INFO",
          "body": {
            "stringValue": "Computation ... "
          },
          "attributes": [],
          "flags": 1,
          "traceId": "6c8516e1bd2061db65df7bd1d414dbe5",
          "spanId": "bce0acb9304993a4"
        },
        {
          "timeUnixNano": "1746006003850941556",
          "observedTimeUnixNano": "1746006003851008984",
          "severityNumber": 9,
          "severityText": "INFO",
          "body": {
            "stringValue": "Result of computation: A DiceValue!"
          },
          "attributes": [],
          "flags": 1,
          "traceId": "6c8516e1bd2061db65df7bd1d414dbe5",
          "spanId": "bce0acb9304993a4"
        },
        {
          "timeUnixNano": "1746006003951768729",
          "observedTimeUnixNano": "1746006003951834914",
          "severityNumber": 9,
          "severityText": "INFO",
          "body": {
            "stringValue": "Ping ..."
          },
          "attributes": [],
          "flags": 1,
          "traceId": "6c8516e1bd2061db65df7bd1d414dbe5",
          "spanId": "bce0acb9304993a4"
        }
      ]
    },
    {
      "scope": {
        "name": "org.springframework.web.servlet.DispatcherServlet",
        "attributes": []
      },
      "logRecords": [
        {
          "timeUnixNano": "1746006003433265552",
          "observedTimeUnixNano": "1746006003433462644",
          "severityNumber": 9,
          "severityText": "INFO",
          "body": {
            "stringValue": "Initializing Servlet 'dispatcherServlet'"
          },
          "attributes": [],
          "flags": 1,
          "traceId": "6c8516e1bd2061db65df7bd1d414dbe5",
          "spanId": "bce0acb9304993a4"
        },
        {
          "timeUnixNano": "1746006003435853752",
          "observedTimeUnixNano": "1746006003435921290",
          "severityNumber": 9,
          "severityText": "INFO",
          "body": {
            "stringValue": "Completed initialization in 2 ms"
          },
          "attributes": [],
          "flags": 1,
          "traceId": "6c8516e1bd2061db65df7bd1d414dbe5",
          "spanId": "bce0acb9304993a4"
        }
      ]
    }
  ],
  "schemaUrl": "https://opentelemetry.io/schemas/1.24.0"
}
```


```yaml
{
  "resource": {
    "attributes": [
      {
        "key": "host.arch",
        "value": {
          "stringValue": "amd64"
        }
      },
      {
        "key": "host.name",
        "value": {
          "stringValue": "instance-20241121-1211"
        }
      },
      {
        "key": "os.description",
        "value": {
          "stringValue": "Linux 6.8.0-1021-oracle"
        }
      },
      {
        "key": "os.type",
        "value": {
          "stringValue": "linux"
        }
      },
      {
        "key": "process.command_args",
        "value": {
          "arrayValue": {
            "values": [
              {
                "stringValue": "/usr/lib/jvm/jdk-21.0.6-oracle-x64/bin/java"
              },
              {
                "stringValue": "-jar"
              },
              {
                "stringValue": "build/libs/otello.jar"
              }
            ]
          }
        }
      },
      {
        "key": "process.executable.path",
        "value": {
          "stringValue": "/usr/lib/jvm/jdk-21.0.6-oracle-x64/bin/java"
        }
      },
      {
        "key": "process.pid",
        "value": {
          "intValue": "479691"
        }
      },
      {
        "key": "process.runtime.description",
        "value": {
          "stringValue": "Oracle Corporation Java HotSpot(TM) 64-Bit Server VM 21.0.6+8-LTS-188"
        }
      },
      {
        "key": "process.runtime.name",
        "value": {
          "stringValue": "Java(TM) SE Runtime Environment"
        }
      },
      {
        "key": "process.runtime.version",
        "value": {
          "stringValue": "21.0.6+8-LTS-188"
        }
      },
      {
        "key": "service.instance.id",
        "value": {
          "stringValue": "868d06c6-56a2-48ed-ba3f-979d57cb67e1"
        }
      },
      {
        "key": "service.name",
        "value": {
          "stringValue": "otello"
        }
      },
      {
        "key": "telemetry.distro.name",
        "value": {
          "stringValue": "opentelemetry-java-instrumentation"
        }
      },
      {
        "key": "telemetry.distro.version",
        "value": {
          "stringValue": "2.13.3"
        }
      },
      {
        "key": "telemetry.sdk.language",
        "value": {
          "stringValue": "java"
        }
      },
      {
        "key": "telemetry.sdk.name",
        "value": {
          "stringValue": "opentelemetry"
        }
      },
      {
        "key": "telemetry.sdk.version",
        "value": {
          "stringValue": "1.47.0"
        }
      }
    ]
  },
  "scopeLogs": [
    {
      "scope": {
        "name": "otel.GreetingController",
        "attributes": []
      },
      "logRecords": [
        {
          "timeUnixNano": "1746006004633750055",
          "observedTimeUnixNano": "1746006004633831239",
          "severityNumber": 9,
          "severityText": "INFO",
          "body": {
            "stringValue": "... pong!"
          },
          "attributes": [],
          "flags": 1,
          "traceId": "6c8516e1bd2061db65df7bd1d414dbe5",
          "spanId": "50e8f06bd3fa443c"
        }
      ]
    }
  ],
  "schemaUrl": "https://opentelemetry.io/schemas/1.24.0"
}
```

OpenTelemetry acknowledges the diversity of existing logging frameworks. Providing a log model and stemming from the concept of correlated telemetry, logs can be integrated with the other parts of the observability data, namely metrics and traces, in three different ways. According to the [OpenTelemetry Spec](https://opentelemetry.io/docs/specs/otel/logs/), approaches are to integrate (1) via time of execution (2) via origin of telemetry (i.e., the resource context) or (3) via the execution context (i.e., the trace context). The latter one is based on the idea to include TraceId and SpanId in the LogRecords. 
