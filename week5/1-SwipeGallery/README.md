#### Swipe Gallery

###### Description
Create a horizontal swipe gallery out of the pictures in your external memory.

###### Details:
Use a `ViewPager`. It implements the swipe gestures and the transition animations for you. You have to pass it an adapter which implements `FragmentStatePagerAdapter`.

###### Hints
- To get your pictures folder use Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES)
- Use `FileFilter` to filter the files that are not directories, or maybe images with a specific extension
- Don't forget to add an ID for your `ViewPager` otherwise you will crash and burn
- `ViewPager` is in the support libraries, for details how to get them refer to the Android Developer website or your nearby lecturer
