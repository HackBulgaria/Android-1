#### Gesture Image

###### Description
Insert an image which you can control with your fingers.
The user has to be able to pan, rotate and scale the image.

![original](http://i.imgur.com/ywpFCGK.png)
![pan](http://i.imgur.com/cVqAkgg.png)
![rotate](http://i.imgur.com/ppFhc8v.png)
![scale](http://i.imgur.com/kwxIc65.png)

Panning can be achieved by using one or two fingers. Rotate and scale require two fingers. If the user is moving the image with two of his finger and suddenly lifts one of them, the image should continue panning. If then the user decides to drop his second finger again, then he should again be able to rotate and scale the image.

###### Hints
- Use `event.getMaskedAction()` to get the user action - `ACTION_DOWN`, `ACTION_MOVE`, `ACTION_UP`, `ACTION_CANCEL`, `ACTION_POINTER_DOWN`, `ACTION_POINTER_UP`
- Gather data for all pointers at every touch event
- At every touch event calculate the delta (the difference between the current and previous value of the property) of each property you are interested in
- Use `ImageView`'s `setTranslationX`, `setTranslationY`, `setRotation`, `setScaleX`, `setScaleY` setters to set the respective properties
- For panning with two fingers use the middle of the line between them as a reference point

###### Bonus 
- Detect if your finger/s is/are actually within the bounds of the image
- Handle double tap gesture which resets the image into its original state







 



