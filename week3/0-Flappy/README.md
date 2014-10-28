#### Flappy
![Flappy](http://i.imgur.com/0rN7qdX.png)
Has everyone played/seen the **Flappy Bird** game? It was removed from both the PlayStore and the App store, but it was fun. (Check out its clone - [FloppyBird](https://play.google.com/store/apps/details?id=floppy.bird))

 
That's the task today - create a quick and hacky game for Android, using the primitives from last lecture and the resource folders.  
We will help you with a quick, quirky and ugly game architecture that you should probably avoid when you try to do the real thing : )  We will hack and hardcode a little bit, and we do no expect a production/sale ready game. But it will be fun for you and important to master some Android primitives.

The game is divided in several subtasks. You should do them sequentially. Also, **the game's due date is not until 08 of Novermber**.


###### Task 0 - Create your GameActivity
Create a standard (blank screen activity).

###### Task 1 - Enable immersive mode.
Immersive mode is just a mode that hides the status bar and software buttons (if present) on your Android device while you play.  
See [how to enable immersive mode](https://developer.android.com/training/system-ui/immersive.html)

###### Task 2 - Create your custom view
Create your own custom view, name it something like `DrawingView`. You can safely extend ImageView. (Note: It is usually better to extend either `SurfaceView` or `GLSurfaceView`, but we are keeping things as simple as possible for now)

###### Task 3 - Start your background music!
There should be an .mp3 file here. Copy it in your `/res/raw` resource folder. If you don't have a `raw` folder, create one.   
Refer to [this android document](http://developer.android.com/guide/topics/media/mediaplayer.html) when you implement the background music for your game : )  

**Note:** As any anoying clumsy game ever made, your music must of course repeat itself when it finishes. See [OnCompletionListener](http://developer.android.com/reference/android/media/MediaPlayer.OnCompletionListener.html) and `MediaPlayer.setOnCompletionListener...` methods.

**Gotcha:** Do not attempt to start music playback before `onCreate` has finished. Use in `onResume` or later. See [Activity.runOnUiThread](http://developer.android.com/reference/android/app/Activity.html#runOnUiThread(java.lang.Runnable)) 

###### Task 4 - Initiallize a Game Clock
The **Game Clock** is essentially just something that calls your methods every **16ms**.   
Why exactly 16? Because we want 60 frames per **second**. (1 second = 1000ms, 1000ms/60fps = one frame every 16 milliseconds).

```java
public class GameClock {

    private List<GameClockListener> clockListeners = new ArrayList<GameClockListener>();

    public static interface GameClockListener {
        public void onGameEvent(GameEvent gameEvent);
    }

    private Handler handler = new Handler();

    public GameClock() {
        handler.post(new ClockRunnable());
    }

    public void subscribe(GameClockListener listener) {
        clockListeners.add(listener);
    }


    private class ClockRunnable implements Runnable {
        @Override
        public void run() {
            onTimerTick();
            handler.postDelayed(this, Settings.FRAMERATE_CONSTANT);
        }

        private void onTimerTick() {
            for (GameClockListener listener : clockListeners) {
                listener.onGameEvent(new GameEvent());
            }
        }
    }
```

Take a look at this class. It does exactly that - the `onTimerClick` method gets called every 16 milliseconds (`Settings.FRAMERATE_CONSTANT = 16`). 
`onTimerClick` just calls every `GameClockListener` to tell him that a `GameEvent` has occured.

`GameGlockListener` is an interface we've just made up. It's implementators will be for instance the `Bird` class, the `Background` class, that want to redraw/update on every frame (We want to update the bird's position, don't we now :) )  

So the idea is simple - whenevr a `GameClockEvent` is fired, we want our methods in `Bird` and `Background` to be called, so we can redraw them. 

And that is basically the whole (proposed by us) architecture of the game - create classes for every thing that will move or will draw or will update. Make them all extend a base class of your choosing. Every "GameObject" (Bird, Background, Obstacles, etc.)  should have the:
- a `draw(Canvas canvas)` method - every "GameObject" should know how to draw himself
- a `PointF getPosition()` method - every "GameObject" should know it's position
- a `int getWidth()` method
- a `int  getHeight()` method
- an `onClick`/`onTouch` method - every "GameObject" object should receive the event and react accordingly. (For instance, when the user touches the screen, you will want the `Bird` to raise up! : ) 
- and of course, an `onGameEvent(GameEvent event)` method as they will be listeners to great `Game Clock` and react when the great clocks tells them they should recalculate their positions and redraw.

Last, about your custom view class. **It should also be subscribed to the GameClock**. When it's `onGameEvent`  event is called, the view should:
- `invalidate()` itself (this triggers redraw).


###### Task 5 - implement a repetitive background
You know when you play games and the background moves to the left? (see [FloppyBird](https://play.google.com/store/apps/details?id=floppy.bird)'s video for an example). You know it is not an endless background, right? We can implement it here with a simple bitmap and translation - when our `GameClock` ticks, we just do a `translation-=10` for instance. 
- Careful, your `Math.abs(translation)` should not be bigger than your `backgroundBitmap.getWidth()`.
- When your background slides out of view, you need to start drawing it again : )

- If you still do not understand this subtask, ask me and I will draw you an example on our board : )


##### To be continued : )
