FROM openjdk:11
ADD ./target/expr-1.0.0.jar /expr-1.0.0.jar
ENV LANG C.UTF-8
ENV JAVA_OPTS=""
ENV APP_OPTS=""
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS  -jar /expr-1.0.0.jar  $APP_OPTS" ]
