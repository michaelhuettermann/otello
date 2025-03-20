#!/bin/bash
for i in {1..5}
do
  curl -s http://localhost:8080/rolldice
  sleep 10
  echo 
done
