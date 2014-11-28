### File Browser

Write a quick, but complete File Browser application in Android.

![shot](https://raw.githubusercontent.com/HackBulgaria/Android-1/master/week6/4-FileBrowser/shot.png)

Feature set:
- Starts at `Environment.getExternalStorageDirectory()`
- Folders are listed in yellow color
- Files are listed in white color.
- If a folder is clicked, you "enter" in the folder and immediately display all of it's children in the list, forgetting about the previous ones.
- If a file is clicked, the file gets opened - if it is an image, a Gallery is launched, if it is mp3/mp4, a player gets launched and etc.
- - It is absolutely forbidden to write `switch(fileType)` of any case in order to guess what program to launch. Use:
``` java
			    Intent intent = new Intent();
                            intent.setAction(Intent.ACTION_VIEW);
                            MimeTypeMap map = MimeTypeMap.getSingleton();
                            String ext = MimeTypeMap.getFileExtensionFromUrl(files[position].getName());
                            String type = map.getMimeTypeFromExtension(ext);

                            if (type == null) {
                                type = "*/*";
                            }

                            Uri data = Uri.fromFile(fileThatUserClickedOn);

                            intent.setDataAndType(data, type);
``` 
^^ start an activity with the above intent and the Android System will do all the magic of guessing what to launch.
- When user presses **the back button**, you should go "back" to the parent of the currently viewed folder
- When the user presses **the back button and the file browser is in the root directory** - `Environment.getExternalStorageDirectory()` - exit the application
- Be careful with the adapter for folders with a lot of files : ) 


