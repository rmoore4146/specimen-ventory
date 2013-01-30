specimen-ventory project

Notes:

-requires Maven 3.0.x for the android package
-war works with Tomcat, but you must add jsp-api-2.1.jar, jstl-1.2.jar to $CATALINA_HOME/lib **MANUALLY**
-mysql: db ddl in specimen-ventory-persistence/resources/schema

running:

-'mvn clean install' builds Android APK, webapp WAR, local/external dependencies
-start mysql, tomcat6 & deploy .war (ROOT.war on aws)
-war also configured for Google App Engine

