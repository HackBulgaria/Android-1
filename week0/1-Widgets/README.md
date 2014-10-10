#### Color Previewer

![Image](http://i.imgur.com/83diMs5.jpg)

Create a simple android application, containing an `EditText` and a button.  
The user enters a hexademical code of a color, e.g. `#FF0000` and clicks the button.  

Everything  below the `EditText` should filled with the same color as entered. (Check the example above)  


#### Help Ludogorets

![Imgur](http://i.imgur.com/MBeDkdn.jpg)

Was it a penalty? Was it not?  
It's not easy to decide.  

Write an application, that has plays a *very specific video* (the `.mp4` file in this folder)  
Draw several buttons, like the ones below, with the following functionality:
- If a user hits the **'Play'** button, the video starts/resumes playing **and the button 'play' image is replaced by a 'pause' image**
- If a user hits the **'Pause'** button (seen after the user hits 'Play'), the video pauses and **the button image becomes 'play' again**
- If a user hits the **'Seek Left'/'Prev'** button, the video goes back 3 seconds **(pauses playing state)**
- If a user hits the **'Seek Right'/'Next'** button, the video goes forth 3 seconds **(pauses playing state)**

Hints:
- Use the assets provided in this github folder
- You can play the video **directly** from github, but you should NOT do that
- See `setVideoUri` method in VideoView.
- See `Uri.fromFile` method
- Copy/Download/`adb push` the video in the external storage of your device (the one your computer sees when you connect the USB cable). 
- Use `Environment.getExternalStorageDirectory()` -> this returns a file pointing to the external storage of your device.
- - If your file is in /sdcard/A.mp4, you can obtain it doing `new File(Environment.getExternalStorageDirectory(), "A.mp4")`
- - Add the 'READ_EXTERNAL_STORAGE' permission to your AndroidManifest.xml
