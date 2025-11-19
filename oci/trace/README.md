## OCI Observability & Management: Tracing

### Inspect reports in OCI

Inside OCI console, navigate to the *Trace Explorer*. We see a table with a list of traces, one entry per each call via *curl*. 
In this overview, we see some details including the amount of containing spans.

<img src="../../pics/service-traces.png" alt="Traces" width="800"/>

We can zoom in to show details on the included spans.

<img src="../../pics/spans.png" alt="Spans" width="800"/>

The elements are defined as output fields of the [Java agent](https://docs.oracle.com/en-us/iaas/application-performance-monitoring/doc/attributes-java-agent.html).
The component is the software package, framework, library, or module that generated the associated span, 
see the [semantic conventions of the OpenTracing specification](https://opentelemetry.io/docs/concepts/semantic-conventions/).

We can work on those spans, compare and inspect them.

A graph of our trace with its spans can be displayed, and in our example, it looks like this:

<img src="../../pics/spans-graphic.png" alt="Spans graph" width="400"/>

This topology contains the units utilized for the spans.
