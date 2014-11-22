### ListViews, Adapters and ViewPager ###

##### ListView and adapter- guide and example  
http://developer.android.com/guide/topics/ui/layout/listview.html 
(The example here accesses and shows all the contacts - neat, huh?)  

(More basic example here - http://androidexample.com/Create_A_Simple_Listview_-_Android_Example/index.php?view=article_discription&aid=65&aaid=90 )   

(Even more basic example here - http://www.java-samples.com/showtutorial.php?tutorialid=1516 )



##### Adapters, ConvertView, recycling
https://www.youtube.com/watch?v=N6YdwzAvwOA - The first 11 minutes



##### ViewPager reference
http://developer.android.com/reference/android/support/v4/view/ViewPager.html
[What visually ViewPager looks like](http://developer.android.com/training/animation/screen-slide.html)



##### Try to answer the following questions:
- You make a `getRegisteredUsers()` API call to your website. It will return a `List<User>` - all the users regsitered. You don't know in advance how many are they. How would you visualize them?
- How do `ListView`'s work on Android? Why can we scroll down and down and down through thousands of records (e.g. check your call logs) without any hiccup or gargabe collection? How does this happen?
- What is the purpose of the `getView(...)` method in Android? Why does it return a `View`. Do we need this method? Can't we just return `null`? 
- Why makes Android's adapters like a "Man in the middle"? 
- What is is a `convertView`? Why should we care about `convertView`?
- What is `ViewPager` usually used for?  


### Rotation, Intents, Multiple Activities, ApplicationContext

[All you need to know about configuration changes in Android (rotation)](http://developer.android.com/guide/topics/resources/runtime-changes.html)
- What would you use `onSaveInstanceState` for? 
- When should you override `onConfigurationChanged`?

[What is a "configuration change"?](http://developer.android.com/guide/topics/manifest/activity-element.html#config) 
- Why is it called `onConfigurationChanged` instead of just `onDeviceRotated`? 

[What is an intent?](http://developer.android.com/reference/android/content/Intent.html)
- What is the differnce between `action` and `data` (as Intent members)?
- What is an **Intent Resolution**? 
- Write down some example `ACTION`'s provided by the Android system

[On Activities](http://developer.android.com/guide/components/activities.html)
- How can you start another activity?
- When would `onActivityResult` be called? What does the `startActivityForResult` method mean? 

[On ApplicationContext](http://developer.android.com/reference/android/app/Application.html) (not the Spring one :D )
- What is this used for? 
- Try to figure out a use case where you will need an ApplicationContext
