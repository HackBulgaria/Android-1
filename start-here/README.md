#### 0. Install (Oracle's) Java 8 

We will be using a Java 8 Oracle VM.  
While we will not code Android on Java 8 (unfortutanely we need to do a lot of work to do that and won't even gain the performance benefits), we will use the Java 8 VM (the one from Oracle), as it has some serious performance benefits.  

Please make sure you install the Oracle version of java 8. (JDK, not JRE)  


#### 1. Choose your ~~destiniy~~ IDE 
We will be using the [Android Studio](https://developer.android.com/sdk/installing/studio.html) That is the one we recommend.  

If you have some experience with the Eclipse/ADT and prefering using Eclipse over the Android Studio, that's okay with us.  
[Download Eclipse/ADT bundle](https://developer.android.com/sdk/index.html)  

Download one of the IDE bundles and install it to a location of your choosing.

#### 2. Make sure your IDE is powered by Oracle's Java 8
Whichever IDE you install, make sure it is powered by Java 8. 
The easiest way to do that is to **first install java 8** and make it the default java (for Linux distributions). (Remove/uninstall older java versions for Mac OS X or Windows).

If you need more than one JDK installed, [point the location to your java VM in Eclipse.ini](http://wiki.eclipse.org/Eclipse.ini)
See [File->Other Settings->Default Project Structure->SDKs.  for Android Studio](http://stackoverflow.com/questions/16823790/android-studio-dont-know-where-is-java)  

#### 3. Fixing your $PATH

When you install one of the IDE bundles, you also install **The Android SDK**, which contains some tools we will need.   
It will be a lot easier for us if we can summon them any time from the console without having to go to their folders...  

This is where $PATH (%PATH% if you are on Windows) comes in.  
You should add the following folders to your $PATH variable:  
- Eclipse: /path-to-adt-bundle-installation/sdk/platform-tools/
- Android Studio: /path-to-Android-Studio/sdk/platform-tools/ 
 
[Changing PATH in Linux](http://www.wikihow.com/Change-the-Path-Variable-in-Linux)  
[Changing PATH in Windows](http://www.computerhope.com/issues/ch000549.htm)  
[Changing PATH in MAC OS X](http://www.cyberciti.biz/faq/appleosx-bash-unix-change-set-path-environment-variable/)  

 
