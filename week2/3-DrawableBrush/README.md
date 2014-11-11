#### Drawable Brush

###### Description
Let the user choose from an array of brushes and use them to draw on the canvas. 
The trick here is that the brushes are images.
![original](http://i.imgur.com/7WAokRk.png)

###### Hints
- Use `Paint.setAlpha` to set the alpha of every drawn image, obviously they should be semi-transparent for aesthetical reasons 
- To force the canvas to redraw itself you must call `View.invalidate`
- Every call to `View.invalidate` clears the canvas
- Create a bitmap, use that bitmap to create a private canvas. At every touch event draw on that canvas. What you draw there will be drawn on the bitmap, for there draw the bitmap on the canvas in the `onDraw` method

###### Bonus 
- Highlight the selected brush in green and the other ones in red, using a gradient







 



