# The Otello showcase

## Introduction
The Otello project is an ongoing initiative. It specifically shows:

- How to quickly start with the Oracle Cloud.
- How to set up Oracle OpenJDK on a public (Oracle) cloud system, and run modern Java versions (17+) on it.
- A 101 on applied telemetry: How to perform Jave bytecode instrumentation for observability purposes.
-- How to generate and examine logs from instrumented Java code.
-- How to generate and examine traces from instrumented Java code.
-- How to generate and examine metrics from instrumented Java code.
- Latest features of most recent Java release versions, e.g. 
-- *Pattern Matching for switch*. Originally introduced as preview with JDK 17 and proposed via [JEP 406](https://openjdk.org/jeps/406), this feature was subsequently refined by following JEPs, e.g. [JEP 441](https://openjdk.org/jeps/441) (JDK 21). 
-- *Record Patterns*. Relating to the language feature of pattern matching, this feature extends pattern matching to destructive instances of record classes and adds nested patterns, see [JEP 440](https://openjdk.org/jeps/440) (JDK 21). 

It is used as:
- A self-contained starter package for students and beginners.
- A demo kit for interactive meetups and conferences.
- A sandbox to work on and test modern Java features in relation to telemetry.

## Installation

### Oracle Cloud

#### Setup connect

tbd

#### Configure a compute instance

tbd

The demo setup was e.g. tested on Canonical Ubuntu 24.04.

### Oracle JDK

Download the desired version [hier](https://www.oracle.com/java/technologies/downloads/).

Consult the specific documentation at *docs.oracle.com* for detailed guidance. For example,for a 64-Bit Oracle JDK 23 for a Linux system [here](https://docs.oracle.com/en/java/javase/23/install/installation-jdk-linux-platforms.html). Install the JDK:

```
curl -O https://download.oracle.com/java/23/latest/jdk-23_linux-x64_bin.deb
dpkg -i jdk-23_linux-x64_bin.deb
```

This results in:
```
java --version
java 23.0.2 2025-01-21
Java(TM) SE Runtime Environment (build 23.0.2+7-58)
Java HotSpot(TM) 64-Bit Server VM (build 23.0.2+7-58, mixed mode, sharing)
```

## Setup the baseline

tbd


## Remarks

In parts, this sandbox is loosely based on pieces of the offical documentation of OpenTelemetry [here](https://opentelemetry.io/docs/languages/java/getting-started/). 
