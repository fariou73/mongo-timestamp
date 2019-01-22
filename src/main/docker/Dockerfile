FROM openjdk:8-jre-alpine

ENV SPRING_OUTPUT_ANSI_ENABLED=ALWAYS \
    JAVA_OPTS=""

CMD echo "The application starting.." && \
    java -Djava.security.egd=file:/dev/./urandom -jar /app.jar ${JAVA_OPTS}

ADD *.jar /app.jar