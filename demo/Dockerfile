FROM openjdk:8u232-jre

VOLUME /var/conf
ADD ./target/demo*.jar demo.jar
RUN sh -c 'touch /demo.jar'

EXPOSE 8080

ENTRYPOINT [ "sh", "-c","java -XX:+UseStringDeduplication -jar /demo.jar" ]