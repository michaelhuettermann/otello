## Metrics

Open a shell, and check and then apply the config file. Review the file and its path, and set environmental configuration to focus on tracing based on automatic instrumentation:
```source logs/export-metrics```.

Specifically, we customize the system properties for setting the [exporters](https://opentelemetry.io/docs/languages/java/configuration/#properties-exporters), and utilize the *OTEL_METRICS_EXPORTER*.

Run the Otello app:
```java -jar build/libs/otello.jar```.

Open a second shell, and execute a call to the endpoint:
```curl localhost:8080/rolldice```

Watch the first shell. Metrics are logged to JUL in the OTLP JSON encoding. The output from the *OtlpJsonLoggingMetricExporter* (see [MetricExporter](https://opentelemetry.io/docs/languages/java/sdk/#metricexporter) for configuration options) is shown here (excerpt):

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
          "intValue": "500016"
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
          "stringValue": "373da473-04ed-4e32-9007-d46f4dc63726"
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
  "scopeMetrics": [
    {
      "scope": {
        "name": "io.opentelemetry.runtime-telemetry-java8",
        "version": "2.13.3-alpha",
        "attributes": [

        ]
      },
      "metrics": [
        {
          "name": "jvm.gc.duration",
          "description": "Duration of JVM garbage collection actions.",
          "unit": "s",
          "histogram": {
            "dataPoints": [
              {
                "startTimeUnixNano": "1746174971554684438",
                "timeUnixNano": "1746175331650431728",
                "count": "48",
                "sum": 0.6250000000000001,
                "min": 0.001,
                "max": 0.08,
                "bucketCounts": [
                  "42",
                  "6",
                  "0",
                  "0",
                  "0"
                ],
                "explicitBounds": [
                  0.01,
                  0.1,
                  1.0,
                  10.0
                ],
                "exemplars": [

                ],
                "attributes": [
                  {
                    "key": "jvm.gc.action",
                    "value": {
                      "stringValue": "end of minor GC"
                    }
                  },
                  {
                    "key": "jvm.gc.name",
                    "value": {
                      "stringValue": "Copy"
                    }
                  }
                ]
              },
              {
                "startTimeUnixNano": "1746174971554684438",
                "timeUnixNano": "1746175331650431728",
                "count": "2",
                "sum": 0.235,
                "min": 0.112,
                "max": 0.123,
                "bucketCounts": [
                  "0",
                  "0",
                  "2",
                  "0",
                  "0"
                ],
                "explicitBounds": [
                  0.01,
                  0.1,
                  1.0,
                  10.0
                ],
                "exemplars": [

                ],
                "attributes": [
                  {
                    "key": "jvm.gc.action",
                    "value": {
                      "stringValue": "end of major GC"
                    }
                  },
                  {
                    "key": "jvm.gc.name",
                    "value": {
                      "stringValue": "MarkSweepCompact"
                    }
                  }
                ]
              }
            ],
            "aggregationTemporality": 2
          }
        },
        {
          "name": "jvm.memory.used_after_last_gc",
          "description": "Measure of memory used, as measured after the most recent garbage collection event on this pool.",
          "unit": "By",
          "sum": {
            "dataPoints": [
              {
                "startTimeUnixNano": "1746174971554684438",
                "timeUnixNano": "1746175331650431728",
                "asInt": "22574544",
                "exemplars": [

                ],
                "attributes": [
                  {
                    "key": "jvm.memory.pool.name",
                    "value": {
                      "stringValue": "Tenured Gen"
                    }
                  },
                  {
                    "key": "jvm.memory.type",
                    "value": {
                      "stringValue": "heap"
                    }
                  }
                ]
              },
              {
                "startTimeUnixNano": "1746174971554684438",
                "timeUnixNano": "1746175331650431728",
                "asInt": "0",
                "exemplars": [

                ],
                "attributes": [
                  {
                    "key": "jvm.memory.pool.name",
                    "value": {
                      "stringValue": "Eden Space"
                    }
                  },
                  {
                    "key": "jvm.memory.type",
                    "value": {
                      "stringValue": "heap"
                    }
                  }
                ]
              },
              {
                "startTimeUnixNano": "1746174971554684438",
                "timeUnixNano": "1746175331650431728",
                "asInt": "1297344",
                "exemplars": [

                ],
                "attributes": [
                  {
                    "key": "jvm.memory.pool.name",
                    "value": {
                      "stringValue": "Survivor Space"
                    }
                  },
                  {
                    "key": "jvm.memory.type",
                    "value": {
                      "stringValue": "heap"
                    }
                  }
                ]
              }
            ],
            "aggregationTemporality": 2
          }
        },
        {
          "name": "jvm.memory.limit",
          "description": "Measure of max obtainable memory.",
          "unit": "By",
          "sum": {
            "dataPoints": [
              {
                "startTimeUnixNano": "1746174971554684438",
                "timeUnixNano": "1746175331650431728",
                "asInt": "1073741824",
                "exemplars": [

                ],
                "attributes": [
                  {
                    "key": "jvm.memory.pool.name",
                    "value": {
                      "stringValue": "Compressed Class Space"
                    }
                  },
                  {
                    "key": "jvm.memory.type",
                    "value": {
                      "stringValue": "non_heap"
                    }
                  }
                ]
              },
              {
                "startTimeUnixNano": "1746174971554684438",
                "timeUnixNano": "1746175331650431728",
                "asInt": "5828608",
                "exemplars": [

                ],
                "attributes": [
                  {
                    "key": "jvm.memory.pool.name",
                    "value": {
                      "stringValue": "CodeHeap 'non-nmethods'"
                    }
                  },
                  {
                    "key": "jvm.memory.type",
                    "value": {
                      "stringValue": "non_heap"
                    }
                  }
                ]
              },
              {
                "startTimeUnixNano": "1746174971554684438",
                "timeUnixNano": "1746175331650431728",
                "asInt": "167772160",
                "exemplars": [

                ],
                "attributes": [
                  {
                    "key": "jvm.memory.pool.name",
                    "value": {
                      "stringValue": "Tenured Gen"
                    }
                  },
                  {
                    "key": "jvm.memory.type",
                    "value": {
                      "stringValue": "heap"
                    }
                  }
                ]
              },
              {
                "startTimeUnixNano": "1746174971554684438",
                "timeUnixNano": "1746175331650431728",
                "asInt": "67108864",
                "exemplars": [

                ],
                "attributes": [
                  {
                    "key": "jvm.memory.pool.name",
                    "value": {
                      "stringValue": "Eden Space"
                    }
                  },
                  {
                    "key": "jvm.memory.type",
                    "value": {
                      "stringValue": "heap"
                    }
                  }
                ]
              },
              {
                "startTimeUnixNano": "1746174971554684438",
                "timeUnixNano": "1746175331650431728",
                "asInt": "8388608",
                "exemplars": [

                ],
                "attributes": [
                  {
                    "key": "jvm.memory.pool.name",
                    "value": {
                      "stringValue": "Survivor Space"
                    }
                  },
                  {
                    "key": "jvm.memory.type",
                    "value": {
                      "stringValue": "heap"
                    }
                  }
                ]
              },
              {
                "startTimeUnixNano": "1746174971554684438",
                "timeUnixNano": "1746175331650431728",
                "asInt": "122912768",
                "exemplars": [

                ],
                "attributes": [
                  {
                    "key": "jvm.memory.pool.name",
                    "value": {
                      "stringValue": "CodeHeap 'profiled nmethods'"
                    }
                  },
                  {
                    "key": "jvm.memory.type",
                    "value": {
                      "stringValue": "non_heap"
                    }
                  }
                ]
              },
              {
                "startTimeUnixNano": "1746174971554684438",
                "timeUnixNano": "1746175331650431728",
                "asInt": "122916864",
                "exemplars": [

                ],
                "attributes": [
                  {
                    "key": "jvm.memory.pool.name",
                    "value": {
                      "stringValue": "CodeHeap 'non-profiled nmethods'"
                    }
                  },
                  {
                    "key": "jvm.memory.type",
                    "value": {
                      "stringValue": "non_heap"
                    }
                  }
                ]
              }
            ],
            "aggregationTemporality": 2
          }
        },
        {
          "name": "jvm.cpu.recent_utilization",
          "description": "Recent CPU utilization for the process as reported by the JVM.",
          "unit": "1",
          "gauge": {
            "dataPoints": [
              {
                "startTimeUnixNano": "1746174971554684438",
                "timeUnixNano": "1746175331650431728",
                "asDouble": 0.002002002002002002,
                "exemplars": [

                ],
                "attributes": [

                ]
              }
            ]
          }
        },
        {
          "name": "jvm.class.unloaded",
          "description": "Number of classes unloaded since JVM start.",
          "unit": "{class}",
          "sum": {
            "dataPoints": [
              {
                "startTimeUnixNano": "1746174971554684438",
                "timeUnixNano": "1746175331650431728",
                "asInt": "1",
                "exemplars": [

                ],
                "attributes": [

                ]
              }
            ],
            "aggregationTemporality": 2,
            "isMonotonic": true
          }
        },
        {
          "name": "jvm.thread.count",
          "description": "Number of executing platform threads.",
          "unit": "{thread}",
          "sum": {
            "dataPoints": [
              {
                "startTimeUnixNano": "1746174971554684438",
                "timeUnixNano": "1746175331650431728",
                "asInt": "1",
                "exemplars": [

                ],
                "attributes": [
                  {
                    "key": "jvm.thread.daemon",
                    "value": {
                      "boolValue": false
                    }
                  },
                  {
                    "key": "jvm.thread.state",
                    "value": {
                      "stringValue": "runnable"
                    }
                  }
                ]
              },
              {
                "startTimeUnixNano": "1746174971554684438",
                "timeUnixNano": "1746175331650431728",
                "asInt": "2",
                "exemplars": [

                ],
                "attributes": [
                  {
                    "key": "jvm.thread.daemon",
                    "value": {
                      "boolValue": true
                    }
                  },
                  {
                    "key": "jvm.thread.state",
                    "value": {
                      "stringValue": "timed_waiting"
                    }
                  }
                ]
              },
              {
                "startTimeUnixNano": "1746174971554684438",
                "timeUnixNano": "1746175331650431728",
                "asInt": "2",
                "exemplars": [

                ],
                "attributes": [
                  {
                    "key": "jvm.thread.daemon",
                    "value": {
                      "boolValue": false
                    }
                  },
                  {
                    "key": "jvm.thread.state",
                    "value": {
                      "stringValue": "timed_waiting"
                    }
                  }
                ]
              },
              {
                "startTimeUnixNano": "1746174971554684438",
                "timeUnixNano": "1746175331650431728",
                "asInt": "6",
                "exemplars": [

                ],
                "attributes": [
                  {
                    "key": "jvm.thread.daemon",
                    "value": {
                      "boolValue": true
                    }
                  },
                  {
                    "key": "jvm.thread.state",
                    "value": {
                      "stringValue": "runnable"
                    }
                  }
                ]
              },
              {
                "startTimeUnixNano": "1746174971554684438",
                "timeUnixNano": "1746175331650431728",
                "asInt": "12",
                "exemplars": [

                ],
                "attributes": [
                  {
                    "key": "jvm.thread.daemon",
                    "value": {
                      "boolValue": true
                    }
                  },
                  {
                    "key": "jvm.thread.state",
                    "value": {
                      "stringValue": "waiting"
                    }
                  }
                ]
              },
              {
                "startTimeUnixNano": "1746174971554684438",
                "timeUnixNano": "1746175331650431728",
                "asInt": "1",
                "exemplars": [

                ],
                "attributes": [
                  {
                    "key": "jvm.thread.daemon",
                    "value": {
                      "boolValue": false
                    }
                  },
                  {
                    "key": "jvm.thread.state",
                    "value": {
                      "stringValue": "waiting"
                    }
                  }
                ]
              }
            ],
            "aggregationTemporality": 2
          }
        },
        {
          "name": "jvm.memory.used",
          "description": "Measure of memory used.",
          "unit": "By",
          "sum": {
            "dataPoints": [
              {
                "startTimeUnixNano": "1746174971554684438",
                "timeUnixNano": "1746175331650431728",
                "asInt": "6966080",
                "exemplars": [

                ],
                "attributes": [
                  {
                    "key": "jvm.memory.pool.name",
                    "value": {
                      "stringValue": "Compressed Class Space"
                    }
                  },
                  {
                    "key": "jvm.memory.type",
                    "value": {
                      "stringValue": "non_heap"
                    }
                  }
                ]
              },
              {
                "startTimeUnixNano": "1746174971554684438",
                "timeUnixNano": "1746175331650431728",
                "asInt": "1372032",
                "exemplars": [

                ],
                "attributes": [
                  {
                    "key": "jvm.memory.pool.name",
                    "value": {
                      "stringValue": "CodeHeap 'non-nmethods'"
                    }
                  },
                  {
                    "key": "jvm.memory.type",
                    "value": {
                      "stringValue": "non_heap"
                    }
                  }
                ]
              },
              {
                "startTimeUnixNano": "1746174971554684438",
                "timeUnixNano": "1746175331650431728",
                "asInt": "28315904",
                "exemplars": [

                ],
                "attributes": [
                  {
                    "key": "jvm.memory.pool.name",
                    "value": {
                      "stringValue": "Tenured Gen"
                    }
                  },
                  {
                    "key": "jvm.memory.type",
                    "value": {
                      "stringValue": "heap"
                    }
                  }
                ]
              },
              {
                "startTimeUnixNano": "1746174971554684438",
                "timeUnixNano": "1746175331650431728",
                "asInt": "934328",
                "exemplars": [

                ],
                "attributes": [
                  {
                    "key": "jvm.memory.pool.name",
                    "value": {
                      "stringValue": "Eden Space"
                    }
                  },
                  {
                    "key": "jvm.memory.type",
                    "value": {
                      "stringValue": "heap"
                    }
                  }
                ]
              },
              {
                "startTimeUnixNano": "1746174971554684438",
                "timeUnixNano": "1746175331650431728",
                "asInt": "1297344",
                "exemplars": [

                ],
                "attributes": [
                  {
                    "key": "jvm.memory.pool.name",
                    "value": {
                      "stringValue": "Survivor Space"
                    }
                  },
                  {
                    "key": "jvm.memory.type",
                    "value": {
                      "stringValue": "heap"
                    }
                  }
                ]
              },
              {
                "startTimeUnixNano": "1746174971554684438",
                "timeUnixNano": "1746175331650431728",
                "asInt": "53485272",
                "exemplars": [

                ],
                "attributes": [
                  {
                    "key": "jvm.memory.pool.name",
                    "value": {
                      "stringValue": "Metaspace"
                    }
                  },
                  {
                    "key": "jvm.memory.type",
                    "value": {
                      "stringValue": "non_heap"
                    }
                  }
                ]
              },
              {
                "startTimeUnixNano": "1746174971554684438",
                "timeUnixNano": "1746175331650431728",
                "asInt": "11243904",
                "exemplars": [

                ],
                "attributes": [
                  {
                    "key": "jvm.memory.pool.name",
                    "value": {
                      "stringValue": "CodeHeap 'profiled nmethods'"
                    }
                  },
                  {
                    "key": "jvm.memory.type",
                    "value": {
                      "stringValue": "non_heap"
                    }
                  }
                ]
              },
              {
                "startTimeUnixNano": "1746174971554684438",
                "timeUnixNano": "1746175331650431728",
                "asInt": "3107840",
                "exemplars": [

                ],
                "attributes": [
                  {
                    "key": "jvm.memory.pool.name",
                    "value": {
                      "stringValue": "CodeHeap 'non-profiled nmethods'"
                    }
                  },
                  {
                    "key": "jvm.memory.type",
                    "value": {
                      "stringValue": "non_heap"
                    }
                  }
                ]
              }
            ],
            "aggregationTemporality": 2
          }
        },
        {
          "name": "jvm.cpu.count",
          "description": "Number of processors available to the Java virtual machine.",
          "unit": "{cpu}",
          "sum": {
            "dataPoints": [
              {
                "startTimeUnixNano": "1746174971554684438",
                "timeUnixNano": "1746175331650431728",
                "asInt": "2",
                "exemplars": [

                ],
                "attributes": [

                ]
              }
            ],
            "aggregationTemporality": 2
          }
        },
        {
          "name": "jvm.cpu.time",
          "description": "CPU time used by the process as reported by the JVM.",
          "unit": "s",
          "sum": {
            "dataPoints": [
              {
                "startTimeUnixNano": "1746174971554684438",
                "timeUnixNano": "1746175331650431728",
                "asDouble": 74.46,
                "exemplars": [

                ],
                "attributes": [

                ]
              }
            ],
            "aggregationTemporality": 2,
            "isMonotonic": true
          }
        },
        {
          "name": "jvm.class.count",
          "description": "Number of classes currently loaded.",
          "unit": "{class}",
          "sum": {
            "dataPoints": [
              {
                "startTimeUnixNano": "1746174971554684438",
                "timeUnixNano": "1746175331650431728",
                "asInt": "11358",
                "exemplars": [

                ],
                "attributes": [

                ]
              }
            ],
            "aggregationTemporality": 2
          }
        },
        {
          "name": "jvm.memory.committed",
          "description": "Measure of memory committed.",
          "unit": "By",
          "sum": {
            "dataPoints": [
              {
                "startTimeUnixNano": "1746174971554684438",
                "timeUnixNano": "1746175331650431728",
                "asInt": "7340032",
                "exemplars": [

                ],
                "attributes": [
                  {
                    "key": "jvm.memory.pool.name",
                    "value": {
                      "stringValue": "Compressed Class Space"
                    }
                  },
                  {
                    "key": "jvm.memory.type",
                    "value": {
                      "stringValue": "non_heap"
                    }
                  }
                ]
              },
              {
                "startTimeUnixNano": "1746174971554684438",
                "timeUnixNano": "1746175331650431728",
                "asInt": "2555904",
                "exemplars": [

                ],
                "attributes": [
                  {
                    "key": "jvm.memory.pool.name",
                    "value": {
                      "stringValue": "CodeHeap 'non-nmethods'"
                    }
                  },
                  {
                    "key": "jvm.memory.type",
                    "value": {
                      "stringValue": "non_heap"
                    }
                  }
                ]
              },
              {
                "startTimeUnixNano": "1746174971554684438",
                "timeUnixNano": "1746175331650431728",
                "asInt": "37625856",
                "exemplars": [

                ],
                "attributes": [
                  {
                    "key": "jvm.memory.pool.name",
                    "value": {
                      "stringValue": "Tenured Gen"
                    }
                  },
                  {
                    "key": "jvm.memory.type",
                    "value": {
                      "stringValue": "heap"
                    }
                  }
                ]
              },
              {
                "startTimeUnixNano": "1746174971554684438",
                "timeUnixNano": "1746175331650431728",
                "asInt": "15204352",
                "exemplars": [

                ],
                "attributes": [
                  {
                    "key": "jvm.memory.pool.name",
                    "value": {
                      "stringValue": "Eden Space"
                    }
                  },
                  {
                    "key": "jvm.memory.type",
                    "value": {
                      "stringValue": "heap"
                    }
                  }
                ]
              },
              {
                "startTimeUnixNano": "1746174971554684438",
                "timeUnixNano": "1746175331650431728",
                "asInt": "1835008",
                "exemplars": [

                ],
                "attributes": [
                  {
                    "key": "jvm.memory.pool.name",
                    "value": {
                      "stringValue": "Survivor Space"
                    }
                  },
                  {
                    "key": "jvm.memory.type",
                    "value": {
                      "stringValue": "heap"
                    }
                  }
                ]
              },
              {
                "startTimeUnixNano": "1746174971554684438",
                "timeUnixNano": "1746175331650431728",
                "asInt": "54263808",
                "exemplars": [

                ],
                "attributes": [
                  {
                    "key": "jvm.memory.pool.name",
                    "value": {
                      "stringValue": "Metaspace"
                    }
                  },
                  {
                    "key": "jvm.memory.type",
                    "value": {
                      "stringValue": "non_heap"
                    }
                  }
                ]
              },
              {
                "startTimeUnixNano": "1746174971554684438",
                "timeUnixNano": "1746175331650431728",
                "asInt": "11272192",
                "exemplars": [

                ],
                "attributes": [
                  {
                    "key": "jvm.memory.pool.name",
                    "value": {
                      "stringValue": "CodeHeap 'profiled nmethods'"
                    }
                  },
                  {
                    "key": "jvm.memory.type",
                    "value": {
                      "stringValue": "non_heap"
                    }
                  }
                ]
              },
              {
                "startTimeUnixNano": "1746174971554684438",
                "timeUnixNano": "1746175331650431728",
                "asInt": "3145728",
                "exemplars": [

                ],
                "attributes": [
                  {
                    "key": "jvm.memory.pool.name",
                    "value": {
                      "stringValue": "CodeHeap 'non-profiled nmethods'"
                    }
                  },
                  {
                    "key": "jvm.memory.type",
                    "value": {
                      "stringValue": "non_heap"
                    }
                  }
                ]
              }
            ],
            "aggregationTemporality": 2
          }
        },
        {
          "name": "jvm.class.loaded",
          "description": "Number of classes loaded since JVM start.",
          "unit": "{class}",
          "sum": {
            "dataPoints": [
              {
                "startTimeUnixNano": "1746174971554684438",
                "timeUnixNano": "1746175331650431728",
                "asInt": "11359",
                "exemplars": [

                ],
                "attributes": [

                ]
              }
            ],
            "aggregationTemporality": 2,
            "isMonotonic": true
          }
        }
      ]
    },
    {
      "scope": {
        "name": "io.opentelemetry.http-url-connection",
        "version": "2.13.3-alpha",
        "attributes": [

        ]
      },
      "metrics": [
        {
          "name": "http.client.request.duration",
          "description": "Duration of HTTP client requests.",
          "unit": "s",
          "histogram": {
            "dataPoints": [
              {
                "startTimeUnixNano": "1746174971554684438",
                "timeUnixNano": "1746175331650431728",
                "count": "6",
                "sum": 0.223412161,
                "min": 0.003605533,
                "max": 0.201876236,
                "bucketCounts": [
                  "4",
                  "1",
                  "0",
                  "0",
                  "0",
                  "0",
                  "1",
                  "0",
                  "0",
                  "0",
                  "0",
                  "0",
                  "0",
                  "0",
                  "0"
                ],
                "explicitBounds": [
                  0.005,
                  0.01,
                  0.025,
                  0.05,
                  0.075,
                  0.1,
                  0.25,
                  0.5,
                  0.75,
                  1.0,
                  2.5,
                  5.0,
                  7.5,
                  10.0
                ],
                "exemplars": [
                  {
                    "timeUnixNano": "1746175318146000000",
                    "asDouble": 0.003997774,
                    "spanId": "db68dc439de5676d",
                    "traceId": "a19a9e50d297c87aeb183f2f35903683",
                    "filteredAttributes": [
                      {
                        "key": "url.full",
                        "value": {
                          "stringValue": "http://localhost:8080/greeting"
                        }
                      }
                    ]
                  }
                ],
                "attributes": [
                  {
                    "key": "http.request.method",
                    "value": {
                      "stringValue": "GET"
                    }
                  },
                  {
                    "key": "http.response.status_code",
                    "value": {
                      "intValue": "200"
                    }
                  },
                  {
                    "key": "network.protocol.version",
                    "value": {
                      "stringValue": "1.1"
                    }
                  },
                  {
                    "key": "server.address",
                    "value": {
                      "stringValue": "localhost"
                    }
                  },
                  {
                    "key": "server.port",
                    "value": {
                      "intValue": "8080"
                    }
                  }
                ]
              }
            ],
            "aggregationTemporality": 2
          }
        }
      ]
    },
    {
      "scope": {
        "name": "io.opentelemetry.tomcat-10.0",
        "version": "2.13.3-alpha",
        "attributes": [

        ]
      },
      "metrics": [
        {
          "name": "http.server.request.duration",
          "description": "Duration of HTTP server requests.",
          "unit": "s",
          "histogram": {
            "dataPoints": [
              {
                "startTimeUnixNano": "1746174971554684438",
                "timeUnixNano": "1746175331650431728",
                "count": "6",
                "sum": 1.7671249599999999,
                "min": 0.008569543,
                "max": 1.710061982,
                "bucketCounts": [
                  "0",
                  "1",
                  "4",
                  "0",
                  "0",
                  "0",
                  "0",
                  "0",
                  "0",
                  "0",
                  "1",
                  "0",
                  "0",
                  "0",
                  "0"
                ],
                "explicitBounds": [
                  0.005,
                  0.01,
                  0.025,
                  0.05,
                  0.075,
                  0.1,
                  0.25,
                  0.5,
                  0.75,
                  1.0,
                  2.5,
                  5.0,
                  7.5,
                  10.0
                ],
                "exemplars": [
                  {
                    "timeUnixNano": "1746175318150000000",
                    "asDouble": 0.010474753,
                    "spanId": "80de1f38f3d55abf",
                    "traceId": "a19a9e50d297c87aeb183f2f35903683",
                    "filteredAttributes": [
                      {
                        "key": "client.address",
                        "value": {
                          "stringValue": "0:0:0:0:0:0:0:1"
                        }
                      },
                      {
                        "key": "network.peer.address",
                        "value": {
                          "stringValue": "0:0:0:0:0:0:0:1"
                        }
                      },
                      {
                        "key": "network.peer.port",
                        "value": {
                          "intValue": "34514"
                        }
                      },
                      {
                        "key": "server.address",
                        "value": {
                          "stringValue": "localhost"
                        }
                      },
                      {
                        "key": "server.port",
                        "value": {
                          "intValue": "8080"
                        }
                      },
                      {
                        "key": "url.path",
                        "value": {
                          "stringValue": "/rolldice"
                        }
                      },
                      {
                        "key": "user_agent.original",
                        "value": {
                          "stringValue": "curl/8.5.0"
                        }
                      }
                    ]
                  }
                ],
                "attributes": [
                  {
                    "key": "http.request.method",
                    "value": {
                      "stringValue": "GET"
                    }
                  },
                  {
                    "key": "http.response.status_code",
                    "value": {
                      "intValue": "200"
                    }
                  },
                  {
                    "key": "http.route",
                    "value": {
                      "stringValue": "/rolldice"
                    }
                  },
                  {
                    "key": "network.protocol.version",
                    "value": {
                      "stringValue": "1.1"
                    }
                  },
                  {
                    "key": "url.scheme",
                    "value": {
                      "stringValue": "http"
                    }
                  }
                ]
              },
              {
                "startTimeUnixNano": "1746174971554684438",
                "timeUnixNano": "1746175331650431728",
                "count": "6",
                "sum": 0.11066755900000001,
                "min": 0.001996142,
                "max": 0.095233515,
                "bucketCounts": [
                  "5",
                  "0",
                  "0",
                  "0",
                  "0",
                  "1",
                  "0",
                  "0",
                  "0",
                  "0",
                  "0",
                  "0",
                  "0",
                  "0",
                  "0"
                ],
                "explicitBounds": [
                  0.005,
                  0.01,
                  0.025,
                  0.05,
                  0.075,
                  0.1,
                  0.25,
                  0.5,
                  0.75,
                  1.0,
                  2.5,
                  5.0,
                  7.5,
                  10.0
                ],
                "exemplars": [
                  {
                    "timeUnixNano": "1746175318146000000",
                    "asDouble": 0.002435782,
                    "spanId": "2046937f72216bb2",
                    "traceId": "a19a9e50d297c87aeb183f2f35903683",
                    "filteredAttributes": [
                      {
                        "key": "client.address",
                        "value": {
                          "stringValue": "127.0.0.1"
                        }
                      },
                      {
                        "key": "network.peer.address",
                        "value": {
                          "stringValue": "127.0.0.1"
                        }
                      },
                      {
                        "key": "network.peer.port",
                        "value": {
                          "intValue": "40418"
                        }
                      },
                      {
                        "key": "server.address",
                        "value": {
                          "stringValue": "localhost"
                        }
                      },
                      {
                        "key": "server.port",
                        "value": {
                          "intValue": "8080"
                        }
                      },
                      {
                        "key": "url.path",
                        "value": {
                          "stringValue": "/greeting"
                        }
                      },
                      {
                        "key": "user_agent.original",
                        "value": {
                          "stringValue": "Java/21.0.6"
                        }
                      }
                    ]
                  }
                ],
                "attributes": [
                  {
                    "key": "http.request.method",
                    "value": {
                      "stringValue": "GET"
                    }
                  },
                  {
                    "key": "http.response.status_code",
                    "value": {
                      "intValue": "200"
                    }
                  },
                  {
                    "key": "http.route",
                    "value": {
                      "stringValue": "/greeting"
                    }
                  },
                  {
                    "key": "network.protocol.version",
                    "value": {
                      "stringValue": "1.1"
                    }
                  },
                  {
                    "key": "url.scheme",
                    "value": {
                      "stringValue": "http"
                    }
                  }
                ]
              }
            ],
            "aggregationTemporality": 2
          }
        }
      ]
    }
  ],
  "schemaUrl": "https://opentelemetry.io/schemas/1.24.0"
}
```
The element *metrics* is of special interest here. It contains a list of standard metrics collected during runtime.
Grouped by *scope*, they are related to the VM and its runtime telemetry, or, in case of ```io.opentelemetry.http-url-connection```, 
related to the request to the application. The ```http.client.request.duration``` contains data points as a list of start/end times for the 
number of http client requests, i.e. data related to */greeting*. The ```io.opentelemetry.tomcat-10.0``` shows the duration of http server requests, with further
context data, e.g. the *http route* (our entry point that is */rolldice*). *traceId* and *spanId* allow the deep integration with
logging and tracing. They are included in the *examplars*. [exemplars](https://opentelemetry.io/docs/specs/otel/metrics/data-model/#exemplars)
are recorded values that associates OpenTelemetry context to a metric event within a Metric. As part of the data model of
OpenTelemetry, with [histograms](https://opentelemetry.io/docs/specs/otel/metrics/data-model/#histogram), we gather histogram metric data points, 
i.e. a population of recorded measurements in a compressed format. A histogram sums events into populations with an overall event count and aggregate sum for all events.
