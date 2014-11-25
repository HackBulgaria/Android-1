#### Bluetooth Hello World (BroadcastReceiver)

![Imgur](http://i.imgur.com/A3ZmSMh.png)

This task is not an idiomatic service/broadcast one, but we thought you might want to check out the Bluetooth API. Also, you need to use a `BroadcastReceiver`. Bottom line => do the other task first!  

We want you to list all available (and **visible**) Bluetooth devices in HackBulgaria's rooms : ) and display them in a `ListView`. Once more, we don't care about styling, glossiness and stuff - use the most common styles `TextView`'s if you have to.  


Here is how to do it:
- Obtain a `BluetoothAdapter` via `BluetoothAdapter.getDefaultAdapter()`
- Register a `BroadcastReceiver` for the action `BluetoothDevice.ACTION_FOUND`
- Whenever your `BroadcastReceiver` gets called, just add the device and it's name to the `ListView`'s `Adapter` (You can get the device from the intent like this `  BluetoothDevice device = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);`)
- Make sure you have your Bluetooth turned **on**, and **your device is visible**. 

