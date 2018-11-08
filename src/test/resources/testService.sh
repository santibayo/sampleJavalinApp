#!/usr/bin/env bash
curl -X POST \
  http://localhost:7000/service \
  -H 'Content-Type: application/json' \
  -H 'Postman-Token: 0d2230d9-ba86-4d50-9ac9-a54151aa8a4c' \
  -H 'cache-control: no-cache' \
  -d '{
	"curp" :"sdfasdfasdfasdfa",
	"amount" : "1239123897162,123",
	"contributionType" : "SDFASDFASDFA"
}'