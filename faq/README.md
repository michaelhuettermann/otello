## FAQ

[Gradle's compile task hangs](#compile)<br/>
[Gradle's build throwing instrumenting errors](#instrument)<br/>
[Shell is not my preferred setup](#shell)<br/>
[What is the relation of OpenTelemetry and OCI, in Otello](#oci)

<!--suppress ALL -->
<a name="compile"/>

### Gradle's compile task hangs
Question: The Gradle's compile task is hanging. What can I do?

Answer: Try to tweak your Gradle build, e.g. add ''--build-cache''. If a free tier solution offers more resources, switch to a VM with more resources.
   You may get further information in the ```Observability & Management``` section in your OCI console. Particularly check the metric ```CpuUtilization``` and ```MemoryUtilization```  in metric namespace ```oci_computeagent```.
   ![Text](../pics/cpu.jpg)

<a name="instrument"/>

### Gradle's build throwing instrumenting errors
Question: The Gradle build is throwing errors stating that instrumentation is not possible. Help?

Answer: If you have set properties for instrumentation after the initial build, and you again want to run the Gradle build,
then reset the instrumentation by executing ```source export-none``` in the *otel* folder. 

<a name="shell"/>

### Shell is not my preferred setup
Question: For editing and running the files, I do not feel comfortable working directly on the shell. Am I required to work
as described?

Answer: Aligned with the general approach, the described paths describe the easiest path, however, you might want to try to 
leverage a smart IDE, e.g. [IntelliJ WebStorm](https://www.jetbrains.com/help/webstorm).

<a name="oci"/>

### Relation of OpenTelemetry and OCI, in Otello
Question: What is the relation of OpenTelemetry and OCI, in Otello?

Answer: Both work complementary. As the [OpenTelemetry web page](https://opentelemetry.io/) states, OpenTelemetry 
is a collection of APIs, SDKs, and tools, and it can be used to instrument generate, collect, and 
export telemetry data (metrics, logs, and traces) to help you analyze your software’s performance 
and behavior. Thus, first, OpenTelemetry in Otello serves as an entry point to illustrate concepts 
and to provide simple examples. Second, concepts are implemented by OCI, or systems can be integrated with OCI, accordingly.
