
```
[...]
"scope":{
   "name":"io.opentelemetry.http-url-connection",
   "version":"2.13.3-alpha",
   [...]
   "spans":[
      {
         "traceId":"5290940d490618bad88ffec4ff53a19b",
         "spanId":"f537be0b620bb106",
         "parentSpanId":"73d99edf515522b6",
         "name":"GET",
         "kind":3,   //CLIENT
         "startTimeUnixNano":"1742995854234091612",
         "endTimeUnixNano":"1742995854428981256",
      [...]
"scope":{
   "name":"io.opentelemetry.tomcat-10.0",
   "version":"2.13.3-alpha",
   [...]
   "spans":[
      {
         "traceId":"5290940d490618bad88ffec4ff53a19b",
         "spanId":"bbfe39bed43e0845",
         "parentSpanId":"f537be0b620bb106",
         "name":"GET /greeting",
         "kind":2,   //SERVER  
         "startTimeUnixNano":"1742995854250264892",
         "endTimeUnixNano":"1742995854348942125",
      [...]
      {
         "traceId":"5290940d490618bad88ffec4ff53a19b",
         "spanId":"73d99edf515522b6",
         "name":"GET /rolldice",
         "kind":2,    //SERVER
         "startTimeUnixNano":"1742995852739946325",
         "endTimeUnixNano":"1742995854439477979",
      [...]
}
```
[CLIENT](https://opentelemetry.io/docs/concepts/signals/traces/#client)
[SERVER](https://opentelemetry.io/docs/concepts/signals/traces/#server)