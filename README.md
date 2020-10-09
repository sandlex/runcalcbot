# runcalc
Telegram bot which can be used for running workout estimations. See calculation module: https://github.com/sandlex/jd
 
## Deployment steps
Environment variables (Config Vars on Heroku):
* BOT_NAME
* BOT_TOKEN

Install dependency to the project repository

`mvn deploy:deploy-file -Durl=file:///Users/apeskov/Developer/runcalc/repo/ -Dfile=/Users/apeskov/Developer/jd/target/jd-1.0-SNAPSHOT.jar -DgroupId=com.sandlex.running -DartifactId=jd -Dpackaging=jar -Dversion=1.0-SNAPSHOT`

Deploy bot

`git push heroku master`