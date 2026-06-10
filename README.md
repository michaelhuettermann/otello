# The Otello showcase

> In addition to the form of a typical website documentation, this project provides a frequently updated list of blog posts, to 
> continuously offer logically sliced chunks of nuanced and more content with alternative entry points [here](blog/README.md).

This entry point introduces *Otello*.

## Motivation
This lab is used as:
- A community-driven, self-contained starter package for students and beginners to learn about telemetry.
- A demo kit based on underlying primitives for interactive meetups and conferences.
- A sandbox to work on and test modern Java features in conjunction with telemetry.
- A one-stop-shop to describe easy paths how to set up and use services of Oracle Cloud to unbox the points above. 

## Introduction
The Otello project is an ongoing initiative. It is rooted on three pillars to specifically show:

- How to quickly jump start with provisioning resources und utilizing them on [Oracle Cloud Infrastructure OCI](https://www.oracle.com/cloud/), including
  - How to set up a [Compute Instance](https://www.oracle.com/cloud/compute/) as a sandbox for your workload on OCI.
  - How to set up [Oracle OpenJDK](https://www.oracle.com/java/technologies/downloads/) on a public cloud system utilized by OCI.
  - How to leverage observability on OCI, with [Oracle APM](https://www.oracle.com/manageability/application-performance-monitoring/).
  - How to run modern [Java versions](https://www.oracle.com/java/technologies/downloads/) with its recent language features on OCI.
- A 101 on applied observability introducing concepts based on the [OpenTelemetry](https://opentelemetry.io/) standard: Why and how to perform Java bytecode instrumentation for observability purposes, including
  - How to generate and examine logs from instrumented Java code.
  - How to generate and examine traces from instrumented Java code.
  - How to generate and examine metrics from instrumented Java code.
- Latest features of most recent Java release versions, as part of a [Java application](app/README.md), e.g. 
  - *Pattern Matching for switch*. Originally introduced as preview with JDK 17 and proposed via [JEP 406](https://openjdk.org/jeps/406), this feature was subsequently refined by following JEPs, e.g. [JEP 441](https://openjdk.org/jeps/441) (JDK 21). 
  - *Record Patterns*. Relating to the language feature of pattern matching, this feature extends pattern matching to destructive instances of record classes and adds nested patterns, see [JEP 440](https://openjdk.org/jeps/440) (JDK 21). 

## Installation on OCI

Here we explore how to install Otello, on OCI.

[here](install/README.md)

## Running Otello on OCI

This element covers the smoke test after installation. We explore the application and if it is running successfully to proceed to the following sections.

[here](run/README.md)

## Leveraging OpenTelemetry on OCI

Here we discuss OpenTelemetry. To explore concepts of observability, and/or learn about tooling that ships with that standard, this
is the right place to learn more.

[here](otel/README.md)

## Leveraging OCI Observability

Here we further explore concepts and learn more details on how to leverage OCI for observability.

[here](oci/README.md)

## Utility

The utility folder contains convenience scripts as part of Otello.

[here](util/README.md)

## FAQ

[here](faq/README.md)