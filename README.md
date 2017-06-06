Deployment
----------

1. `mvn clean install`
2. `java -jar target/war-paint-challenge-1.0-SNAPSHOT.jar`

Usage
-----

To view the prices of the provided sample file:
`GET http://localhost:8080/price/last-day-closes/sample`

To upload a custom CSV file:
`curl -F file=@SPY.csv http://localhost:8080/price/last-day-closes`
