### Splash Screen
Show a simple splash screen on the first run. 

Here is what should happen:
The user:
- Enters your application.
- Sees your splash screen for exactly **3 seconds** (Ahem, `handler.postDelayed`)
- After 3 seconds have passed, your splash screen is removed and the user sees the default and awesome "Hello world" ui that your applicaion has!

Choose one of the available below, or whatever .png you'd like.
Using `SharedPreferences`, show the splash screen only the **first** time!

![Splash_screen_one](https://raw.githubusercontent.com/HackBulgaria/Android-1/master/week6/3-SplashScreen/Splash_Screen.png)
![Splash_screen_two](https://raw.githubusercontent.com/HackBulgaria/Android-1/master/week6/3-SplashScreen/Splash_Screen_2.png)
![Splash_screen_three](https://raw.githubusercontent.com/HackBulgaria/Android-1/master/week6/3-SplashScreen/Splash_Screen_3.png)

Hints:
- Use dark theme for the application - dark logos are good with dark themes
- Use `getViewOverlay.add..` to implement the splash screen
Oh and the way, force your app in landscape, so you'd be able to more properly show the splashscreens :D
