Api Test

Added all the required dependencies of cucumber and rest assured in pom.xml.

Added a feature file with the 3 required scenarios.
Created a pojo class and methods inside it for retriving particularly the keys and values of conversion_rates using HashaMap.
Implemented a Utilities class to add utilities, for example converting jsonPayloads to string.

Used JsonPath to extract values from json.

Created a TestRunner file under src/test/java/chromeOptions package.

Created a stepDefinition and mapped all the scenarios with the methods defined in stepDefinition.