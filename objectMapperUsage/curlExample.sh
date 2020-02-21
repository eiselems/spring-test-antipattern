#!/usr/bin/env bash
curl -H "Content-Type: application/json" --data '{"content":"this is some content"}' -X POST http://localhost:8080/example/test/1