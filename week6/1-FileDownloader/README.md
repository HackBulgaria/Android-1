#### Download manager

###### Description
Create a file download manager.

###### Details:
There is a file listing here: http://95.111.103.224:8080/static/ .Create a button for every file you want to be able to download. When the user clicks the button, start a service that downloads the file at a specified path in the external storage directory. I know some of you are rolling their eyes right now thinking "pff...casuals", so if you really feel like creating a dynamic list filled with the contents of this directory, then by all means do. 

###### Hints
- Don't bother extending a `Service`, use `IntentService` instead
- Register a `BroadcastReceiver` in `onResume` and unregister it in `onPause`

###### Bonus
- Create a progress report bar
- Send a notification for every file download