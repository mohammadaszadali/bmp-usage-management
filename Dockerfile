FROM adoptopenjdk/openjdk8:latest
ADD target/bmp-usage-management-business-service-1.0.jar bmp-usage-management-business-service.jar
RUN sh -c 'touch /bmp-usage-management-business-service.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/bmp-usage-management-business-service.jar"]