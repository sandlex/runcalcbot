For those who uses Jack Daniels Running Formula book to create workouts. I've created a Telegram bot @RunCalcBot which estimates workout distance and time by workout schema.

Supported pace constants: E, L, M, T, I, H, R, jg, rest

Workout can be specified as:
* template: L = lesser of 15 miles (24 km) & 100 min
* flexible format, e.g.: 2E + 3 x 1T w/2 min rest + 3 x 3 min H w/2 min jg + 4 x 200 R w/200 jg + 1E. Numbers less than 100 are given in miles (2E, 1T, etc.), larger than 100 are given in meters (200R, 400 jg, etc.)

Bot expects a message in a form: pace_values;workout_schema

For example: E=4:45,L=4:45,M=4:14,T=4:00,I=3:41,H=3:41,R=3:25,jg=5:00,rest=5:20;2E + 3T + 3 min rest + 2T + 2 min rest + 2 x 400R w/400 jg + 2 x 1T w/1 min rest + 1E + 4 x 200R w/200jg + 1E

You need to supply only those constants which are used in the workout schema.

Because application is hosted on free hosting it periodically goes offline after 30 minutes of inactivity. Normally it should stay online from 7am till 12pm Amsterdam time zone. If you need it in off-work hours visit this link to wake it up: https://runcalc.herokuapp.com/wakeup. It may take around 15-20 second till app wakes up, shows "Ready to roll" message and send you your results.


See calculation module: https://github.com/sandlex/jd
 
## Deployment steps
Environment variables (Config Vars on Heroku):
* BOT_NAME
* BOT_TOKEN

Install dependency to the project repository

`mvn deploy:deploy-file -Durl=file:///Users/apeskov/Developer/runcalc/repo/ -Dfile=/Users/apeskov/Developer/jd/target/jd-1.0-SNAPSHOT.jar -DgroupId=com.sandlex.running -DartifactId=jd -Dpackaging=jar -Dversion=1.0-SNAPSHOT`

Deploy bot

`git push heroku master`
