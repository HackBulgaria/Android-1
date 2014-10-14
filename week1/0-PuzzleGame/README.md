#### Puzzle

###### Preparing the pieces
Make a cool puzzle game.
![Puzzle](http://i.imgur.com/8V7E0ef.jpg)

What do you need to create a puzzle-like game for Android?
First, you need to **choose an image**. You can either:
- Choose one from google images (It would be good to use the resolution of the device you are going to work with. Easier.)
- Use kerrigan.jpg from this folder

Second, you need to **split the image** in little puzzle parts.
- Use the provided ImageSlicer.jar. (For instance `java -jar ImageSlicer.jar kerrigan.jpg 4 4` will create 16 puzzle pieces for the image **kerrigan.jpg**)
- Write your own (advanced) slicer (with curves and peaks) ([ImageSlicer.jar is the simplest slicer](https://gist.github.com/GeorgiPachov/cfe5027b1eca5dd97fa4))


Later we will migrate the slicing  to be done on Android, when we know about Bitmaps and Storage.

Now that you have 16 or more small .jpg files, you need to **get them to your drawable** folder.  
Once you've done that, create an **xml resource array** (just like the color array in [our last session](http://stackoverflow.com/questions/9114587/how-can-i-save-colors-in-array-xml-and-get-its-back-to-color-array)), but this time use a `TypedArray`, (obtain it using `getResources().obtainTypedArray(int arrayId)`).  

**Use the `getDrawable` method to obtain the drawables.**
Don't forget to recycle the typed array! (`ta.recycle()`)

###### Building the layout
This time, as you don't know how many puzzle pieces they will be in advance, you won't be able to just type all the layouts in an xml file.   
Create your views dynamically, in the `onCreate` method. [See the answers here](http://stackoverflow.com/questions/2395769/how-to-programmatically-add-views-to-views)  
Use whatever layout you like the most and is easiest for your. Don't worry about performance for the moment.   

You should use an [ImageView](http://developer.android.com/reference/android/widget/ImageView.html) to display all the pictures. Check out and read carefully the documentation around  `setAdjustViewBounds` and `setScaleType` methods. They might come useful.

###### Dragging and dropping
- See the [Drag and Drop developer guide](http://developer.android.com/guide/topics/ui/drag-drop.html)  again.
- You need to manually tell the Android system when a drag has started!
See [startDrag](http://developer.android.com/reference/android/view/View.html#startDrag(android.content.ClipData, android.view.View.DragShadowBuilder, java.lang.Object, int)), [onDragEvent](http://developer.android.com/reference/android/view/View.html#onDragEvent(android.view.DragEvent)) and [DragEvent](http://developer.android.com/reference/android/view/DragEvent.html)


###### Finish the game. 
- Implement a  random shuffling of the pictures
- Implement an easy way to determine whether the puzzle is solved : )







 



