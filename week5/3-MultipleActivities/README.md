### Multiple Activities
![Imgur](http://i.imgur.com/vSiW47v.png)

Create google-like multifield:  

The users enter information and chooses what to do with it:
He can make a call, open a web browser, or set the alarm clock.

Format (using regex notation):
- call: `[0-9\+]{3,20}` (for instance 088512131415)
- open a webpage: `[a-z]+\.[a-z]+(\.[a-z])+` (for instance abv.bg or wearemorons.gov.bg)
- set the alarm: `[0-9][0-9]:[0-9][0-9]` (for instance 05:30) 

Hints and clues (important!):
- If you want to **call**, press the call button and **prepend the userinput with `tel:`**
- If you want to **open** a website, **prepend the user input with `https://`**
- You will need a looot of permissions here. 
- You will need to search for the relevant intent "action" here. Some of them are **static fields** in `Intent`, but others are not - for instance, see the static field actions in `AlarmClock`... you might need one of them
- Bonus: no more than 50 lines of code for all your `*.java` files


