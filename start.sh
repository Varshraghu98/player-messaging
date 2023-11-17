#!/usr/bin/env bash

java -jar target/player-messaging-different-PID-1.0-SNAPSHOT-jar-with-dependencies.jar startServer &
java -jar target/player-messaging-different-PID-1.0-SNAPSHOT-jar-with-dependencies.jar startClient &
exit 1