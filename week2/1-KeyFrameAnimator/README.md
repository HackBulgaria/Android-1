#### Key Frame Animator

###### Description
Build up on [GestureImage](https://github.com/HackBulgaria/Android-1/tree/master/week1/1-GestureImage)
Now add two buttons - "save frame" and "play". When the "save" button is pressed, the current state of the image should be saved as a key frame.
The user should be able to do this as many time as he wants. When he clicks the "play" button all in-between frames should be generated and played sequentially.
All transformations should be saved - translation, rotation, scale.

###### Hints 
- Save each state as an `Animator` and each property of that state as a `PropertyValueHolder`
- Play the animations sequentially using the `AnimatorSet`