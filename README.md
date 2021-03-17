### Telegram bot for Running workout calculator
Calculates estimated distance and completion time of pace based workouts.

Imagine you have to do a training according to the following schema:
**15 minutes warming up, then 3 kilometers in 10 km pace, then 5 times of 400 meters in 5 km pace followed by 30 seconds rest, after 5 repetitions do 1.5 km in easy pace and then 1.5 hours in marathon pace.**

To calculate this you send a message of the following format to the bot: `pace block;workout schema`
For example: `WU=5:00,T10=3:40,E=4:30,T5=3:30,Rest=10:00,M=4:00;15:00WU + 3T10 + 1.5E + 5 * (0.4T5 + 00:30Rest) + 1.5E + 1:30:00M`
Bot will do calculations and send results back to you: `Estimated distance - 33.750, time - 02:19:00`

Notes:
* Pace name can't start with a number: T10 - ok, 10T - not ok
* Nested repetitions are not supported
* Time format - hh:mm:ss or mm:ss
* If distance is given in miles then pace is assumed to be in min/mile. If distance is in kilometers then pace is in min/km
* Mind the difference between imperial and metric systems when working with short intervals (fraction of kilometers/miles): 0.4 is 400 meters in metric system. In imperial system 0.4 will have a different meaning

Because application is hosted on free hosting it periodically goes offline after 30 minutes of inactivity. Normally it should stay online from 7am till 12pm Amsterdam time zone. If you need it in off-work hours visit this link to wake it up: https://runcalc.herokuapp.com/wakeup. It may take around 15-20 second till app wakes up, shows "Ready to roll" message and send you your results.

See calculation module: https://github.com/sandlex/runcalc
