#### Fun with flags
Let's kick off the layout tasks with a simple 'flag' game.

Create an application that draws a flag on the screen.   
Each of the flags should be in **a separate layout xml file** - this means you will end up having flags_easy.xml, flags_medium.xml, flags_hard.xml
##### Easy 
![Easy](http://i.imgur.com/AgJTRCRl.jpg)
- Start off with a simple flag - like Bulgaria's. 
- Use a [LinearLayout](http://developer.android.com/guide/topics/ui/layout/linear.html) for it.
- Use a simple [View](http://developer.android.com/reference/android/view/View.html) and its [background](http://developer.android.com/reference/android/view/View.html#attr_android:background) xml property.

###### Bonus 1 
Make a horizontal-stripes flag, like Italy's:
![Italy]http://upload.wikimedia.org/wikipedia/en/0/03/Flag_of_Italy.svg

###### Bonus 2*
Switch colors on touch. 
Prepare an array of colors in a resource file. Check this [hackoverflow thread](http://stackoverflow.com/questions/9114587/how-can-i-save-colors-in-array-xml-and-get-its-back-to-color-array for how you can do that) in order to see how it's done.  

Obtain the color array using `getResources().getIntArray(R.array.my_color_array);`, and when the user touches one of the flag colors, change that flag color to another from the array (Hint: keep a 'currentColor' pointer). This way you can achieve a number of flags, for instance [Russia's flag](http://upload.wikimedia.org/wikipedia/en/archive/f/f3/20120812153730!Flag_of_Russia.svg)


##### Medium
![Medium](http://i.imgur.com/Zzr2QwWl.jpg)
- Use [FrameLayout] (http://developer.android.com/reference/android/widget/FrameLayout.html) 
- Use and combine `layout_marginTop` and `layout_marginBottom` properties.
- Use exact dp values for width and height, e.g. `150dp` 

##### Hard*
![Hard](http://i.imgur.com/mgtulWR.png)
- RelativeLayout, FrameLayout and/or LinearLayout/GridLayout
- Think and draw how you would compose the layers.
- You will need to use exact dp values.
- Better finish this one at home. 
