## Utility

This entry point introduces utilities provided, for work on OCI.

The [traffic.sh](traffic.sh) script provides a convenience util to simulate traffic, on OCI.

```
#!/bin/bash
for i in {1..10}
do
  curl -s http://localhost:8080/rolldice
  sleep 5
  echo 
done
```

The script, run on the shell, calls the endpoint of our application. As a result, we get much more data, conveniently, than calling the endpoint manually.