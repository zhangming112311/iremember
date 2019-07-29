docker run -it --rm --name my-maven-project --network app --network-alias api  -p 80 -v "$(pwd)":/usr/src/mymaven -v "$HOME/.m2":/root/.m2 -w /usr/src/mymaven maven:3.3-jdk-8 mvn spring-boot:run
