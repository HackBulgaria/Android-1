ListView and adapter- guide and example  
http://developer.android.com/guide/topics/ui/layout/listview.html  
(The example here accesses and shows all the contacts - neat, huh?)

(More basic example here - http://androidexample.com/Create_A_Simple_Listview_-_Android_Example/index.php?view=article_discription&aid=65&aaid=90 )
(Even more basic example here - http://www.java-samples.com/showtutorial.php?tutorialid=1516 )

Adapters, ConvertView, recycling
https://www.youtube.com/watch?v=N6YdwzAvwOA - The first 11 minutes

ViewPager reference
http://developer.android.com/reference/android/support/v4/view/ViewPager.html
[What visually ViewPager looks like](http://developer.android.com/training/animation/screen-slide.html)

Try to answer the following questions:
- How do you display dynamic stuff in Android? 
- How do `ListView`'s work on Android? Why can we scroll down and down and down through thousands of records (e.g. check your call logs) without any hiccup or gargabe collection? How does this happen?
- For instance you make a `getRegisteredUsers()` API call to your website, how do you show them on the screen when you don't know exactly how many are they?
- What is the purpose of the `getView(...)` method in Android? Why does it return a `View`. Do we need this method? Can't we just return `null`? 
- Why makes Android's adapters like a "Man in the middle"? 
- What is is a `convertView`? Why should we care about `convertView`?
- What is ViewPager usually used for?  
