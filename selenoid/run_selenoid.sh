#!/usr/bin/env bash

#pull images
#firefox
docker pull selenoid/vnc:firefox_61.0
docker pull selenoid/vnc:firefox_60.0

#chrome
docker pull selenoid/vnc:chrome_67.0
docker pull selenoid/vnc:chrome_66.0

#run selenoid via docker-compose
docker-compose up -d
