#!/bin/bash
for i in {1..10}
do
  curl -s http://localhost:8080/rolldice
  sleep 5
  echo 
done
