### [@RunCalcBot](https://t.me/RunCalcBot) - Telegram bot which helps you in planning your running workouts

**Your coach**: today you do _15 minutes warming up, then 3 kilometers in 10 km pace, then 5 times of 400 meters in 5 km pace followed by 30 seconds rest, after 5 repetitions do a 1.5 km in easy pace and then 1.5 hours in marathon pace._

**Your spouse**: how long are you going to be away?

**You**: I have no idea :-( 2 hours. Maybe 3. Today's training schema is quite complex. Oh... wait! Let me check my bot!

**You**: copy pasting and sending a message to the bot _WU=5:00,T10=3:40,E=4:30,T5=3:30,Rest=10:00,M=4:00;15:00WU + 3T10 + 1.5E + 5 * (0.4T5 + 00:30Rest) + 1.5E + 1:30:00M_

**Bot**: replies _Estimated distance - 33.750, time - 02:19:00_

**You**: honey, I'm going to be back in two and a half hours. It's gonna be almost 34 kilometers

**Your spouse**: ok, I'll call an ambulance

***

### How it works
* add [@RunCalcBot](https://t.me/RunCalcBot) to your Telegram messenger
* write down your pace values as a pace block: _Easy=5:00,Tempo10k=3:35,Tempo5k=3:25,Rest=10:00_
* write down your training schema: _15:00Easy + 3Tempo10k + 1.5Easy + 5 * (0.4Tempo5k + 00:30Rest) + 1:30:00Easy_
* combine _pace block_ with _training schema_ using _;_ and send it as a message to the bot: _Easy=5:00,Tempo10k=3:35,Tempo5k=3:25,Rest=10:00;15:00Easy + 3Tempo10k + 1.5Easy + 5 * (0.4Tempo5k + 00:30Rest) + 1:30:00Easy_

### Rules
* pace name can be a single word and can't start with a number
* training schema can use only pace names listed in the pace block
* training schema consists of multiple phases. Phases can be:
  * **time based**: _15:00Easy_ - 15 minutes of easy pace, _1:30:00Easy_ - 1.5 hour of easy pace
  * **distance based**: _3Tempo10k_ - 3 km/mile in 10 km pace, _0.4Tempo5k_ - 0.4 km/mile (400 meters) in 5 km pace
  * **repeated**: _5 * (0.4Tempo5k + 00:30Rest)_ - 5 repetitions of two phases inside the brackets. Nested repetitions are not supported

### Limitations
* Application is hosted on a free hosting and to save costs goes offline from 00:00 till 07:00AM CET.
* If you still want your results open [this link](https://runcalc.herokuapp.com/wakeup) and wait for 15-20 seconds till app wakes up, shows "Ready to roll" message and sends you your results.
* Also let me know at [@sandlex](https://t.me/sandlex) if you want to use app when it is normally not available and I may adjust a schedule.

### And more
If you don't like bots you can use calculation engine as a standalone Java application as described [here](https://github.com/sandlex/runcalc). 
