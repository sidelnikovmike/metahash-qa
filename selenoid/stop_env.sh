#!/usr/bin/env bash

#stop and remove all containers
docker stop $(docker ps -q)
docker rm $(docker ps -aq)
