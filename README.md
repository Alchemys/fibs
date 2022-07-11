# fibs
Small java app to calculate a fibonacci sequence (seed 0, 1, max 50 iterations)

## Overview
Note this is a sample application only.  It's not a robust application and has limits.  It is assumed the user knows how to install / use maven and java for building and executing shaded jars.

## Usage

### Build using maven
 * Install maven (3.8 or greater) and java jdk (8 or later)
 * Build the shaded jar : `mvn clean compile package`

### Run the app using java
  * Once successfully built make note of the actual jar (SNAPSHOT version may be different than than the example)
  * Execute using java and the shaded jar : (e.g. `java -jar target/fibs-example-1.0-SNAPSHOT-shaded.jar -i 25`)
