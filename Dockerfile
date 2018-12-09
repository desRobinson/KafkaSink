FROM java:8

RUN mkdir -p /data/app/bin /data/app/run
RUN apt-get update && apt-get -y --no-install-recommends install net-tools

COPY build/libs/Kafka-example-sink-1.0.jar /data/app/bin/sink.jar

ENV JAVA_OPTS "-Djava.security.egd=file:/dev/./urandom"

ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -jar /data/app/bin/sink.jar" ]