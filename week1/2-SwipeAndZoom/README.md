#### Swipe And Zoom

###### Description
Create a minimalistic image gallery. The image is centred vertically and horizontally, and below it there is a text based progress indicator. The user navigates through the gallery with the left/right swipe gestures. When the user double taps the image should be upscaled (and downscaled when he double taps again).
![original](http://i.imgur.com/fSK0qac.png)
![upscaled](http://i.imgur.com/9jJsnxJ.png)

###### Hints
- Extend `GestureDetector.SimpleOnGestureListener` and override the `onFling` and `onDoubleTap` methods
- Don't recycle the `TypedArray` object, since you will always need all the images
- The images are in the `images` folder in the repo

###### Bonus 
- Calculate the exact distance between your down and up events in `onFling` ... just be creative







 



