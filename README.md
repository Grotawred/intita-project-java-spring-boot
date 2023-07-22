# How to set up project
- First, download the Java SDK from the official Oracle website, 
download the latest version, namely 20


- Add Java to Environment variables as JAVA_HOME


- Check if you have java added to Environment Variables
  using a command in the console
```bash
  java -version
```
- Download maven from Apache official site,
  necessarily version 4.0.0


- Add Maven to Environment variables as MAVEN_HOME


- Check if you have maven added to Environment Variables
  using a command in the console
```bash
  mvn --version
```

- Download MySQL installer from official website and select in installation configuration: Workbench (8.0.32), Server (8.0.32) and JConnector (8.0.32)


- Clone the project
```bash
  git clone https://github.com/Grotawred/intita-project-java-spring-boot
```
- Create new schema named "db_to_project" in your MySQL Workbench


- Create OS environment variables from .env file. 
File could be obtained after contact of Grisha Vlasko "grishavlasko200@gmail.com".


- Start project in your IDE