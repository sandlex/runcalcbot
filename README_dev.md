## Deployment steps
Environment variables (Config Vars on Heroku):
* BOT_NAME
* BOT_TOKEN

Install dependency to the project repository:

`mvn deploy:deploy-file -Durl=file:///Users/apeskov/Developer/runcalcbot/repo/ -Dfile=/Users/apeskov/Developer/runcalc/target/runcalc-2.0.jar -DgroupId=com.sandlex -DartifactId=runcalc -Dpackaging=jar -Dversion=2.0`

Deploy bot:

`git push heroku master`
