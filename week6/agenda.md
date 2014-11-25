- Broadcast Receivers
- - "subscribers" 
- - link between `IntentFilter` and `BroadcastReceiver`
- - usually registered in `onResume` and unregistered in `onPause` => lead to a memory leak otherwise

- Services 
- - `onStartCommand()` vs `onBind()` 
- - Service (when not bound) should stop itself!!!
- - Bound services - automatically stopped
- - `Service` vs `IntentService` 
- - `Services`s launch on the UI thread!
- - `IntentService` has its own thread 
- - `BroadcastReceiver` for communication

