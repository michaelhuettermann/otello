## OCI Observability & Management Metrics

### Application Performance Index (Apdex)

OCI integrates with the open standard Apdex to map measures to user satisfaction.
The spec of this standard can be found [here](https://www.apdex.org/wp-content/uploads/2020/09/ApdexTechnicalSpecificationV11_000.pdf) and a description on the [Apdex user group site](https://www.apdex.org).
On OCI, the configuration is linked to the configuration of the *APM agent*. 
Further information on how to integrate are located [here](https://docs.oracle.com/en-us/iaas/application-performance-monitoring/doc/configure-apdex-thresholds.html).

<img src="../../pics/apdex-thresholds.png" alt="Apdex, on OCI" width="600"/>

### APM: Metric explorer

Navigating to *Observability & Management*'s section *Monitoring*, a *Metric Explorer* is available. Select
your *compartment* and the *metric namespace* you are interested in (here: *oci_computeagent*). We are keen to inspect the utilization of the
CPU, thus we choose the *metric name* called *CpuUtilization*. Values of the metric are shown in the user-defined
time interval.

<img src="../../pics/metrics-explorer.png" alt="Metrics explorer" width="800"/>

The query was configured by selecting entries of predefined fields. The result maps to the query that is shown on the left of the UI:

```CpuUtilization[1m].mean()```
