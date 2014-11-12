#### Flappy High Score

###### Description
![login](http://i.imgur.com/0UiVo8t.png)

Build up on FlappyBird. 
- Create a 'login' form and take the player's details - what is his name, what is his email, and where is he from - FMI, TU, UNWE or and on.
- When the player enter's his details, begin the game.
- When the game finishes, collect his score (if you don't count score in the game - use 0 for score)
- When you have all the information needed,  **send the player details - name, email, where he is from + score to our server to upload his score to our server.**
Do this on the UI thread, for the moment. Later on we will see how and why this is a bad idea and will teach you the proper way to networking on Android.

###### Details:
The game should be made of one activity, with two fragments - a `Login` fragment and a `Game` fragment
You should make a `FragmentTransition` between the two when a player fills everything and presses `Play` or `login` or whatever you choose for your button text : ) 

Server and calls location:  http://95.111.103.224:8080/Flappy/scores

- `GET` all scores (you will need this just to test whether your `PUT` call has succeeded)
```
	URL: http://95.111.103.224:8080/Flappy/scores
        Method: GET
        Response format: JSON
        Example response:  [ { "name" : "Ceco" , "mail" : "ceco@abv.bg" , "whereFrom" : "FMI" , "score" : 21} , { "name" : "Todor" , "mail" : "teo_hacker@gmail.com" , "whereFrom" : "TU-Sofia" , "score" : 32} ]
```

- `PUT` a player score
```
        URL: http://95.111.103.224:8080/Flappy/scores
        Method: PUT
        Content-type: application/json (don't forget to add this, please)
        Example request (entity) body: { "name" : "Dimitar" , "mail" : "phd@mitkoland.eu" , "whereFrom" : "Tijuana" , "score" : 96}
```


###### Hints

- Both fragments are contained in the same activity
- Only one fragment is visible at a time

###### Bonus (easy)
- Do some cool transition between the switching of the fragments
