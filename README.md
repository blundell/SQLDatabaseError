SQLDatabaseError
================

Strange error saying SQLiteDatabase doesn't implement java.io.Closeable

See here: https://github.com/blundell/SQLDatabaseError/blob/master/SqlDatabaseCursorError/src/com/blundell/sqldatabasecursorerror/DatabaseHelper.java

Doesn't work:

Xperia Play Android 2.3.4

Does work:

Samsung Galaxy Nexus Android 4.2

http://developer.android.com/reference/android/database/sqlite/SQLiteDatabase.html
http://developer.android.com/reference/android/database/sqlite/SQLiteClosable.html
http://developer.android.com/reference/java/io/Closeable.html

<pre>
12-14 12:23:43.719: E/AndroidRuntime(5179): FATAL EXCEPTION: main
12-14 12:23:43.719: E/AndroidRuntime(5179): java.lang.IncompatibleClassChangeError: interface not implemented
12-14 12:23:43.719: E/AndroidRuntime(5179):   at com.blundell.sqldatabasecursorerror.DatabaseHelper.close(DatabaseHelper.java:35)
12-14 12:23:43.719: E/AndroidRuntime(5179): 	at com.blundell.sqldatabasecursorerror.DatabaseHelper.openAndCloseDatabase(DatabaseHelper.java:29)
12-14 12:23:43.719: E/AndroidRuntime(5179): 	at com.blundell.sqldatabasecursorerror.MainActivity.onCreate(MainActivity.java:13)
12-14 12:23:43.719: E/AndroidRuntime(5179): 	at android.app.Instrumentation.callActivityOnCreate(Instrumentation.java:1047)
12-14 12:23:43.719: E/AndroidRuntime(5179): 	at android.app.ActivityThread.performLaunchActivity(ActivityThread.java:1623)
12-14 12:23:43.719: E/AndroidRuntime(5179): 	at android.app.ActivityThread.handleLaunchActivity(ActivityThread.java:1675)
12-14 12:23:43.719: E/AndroidRuntime(5179): 	at android.app.ActivityThread.access$1500(ActivityThread.java:121)
12-14 12:23:43.719: E/AndroidRuntime(5179): 	at android.app.ActivityThread$H.handleMessage(ActivityThread.java:943)
12-14 12:23:43.719: E/AndroidRuntime(5179): 	at android.os.Handler.dispatchMessage(Handler.java:99)
12-14 12:23:43.719: E/AndroidRuntime(5179): 	at android.os.Looper.loop(Looper.java:130)
12-14 12:23:43.719: E/AndroidRuntime(5179): 	at android.app.ActivityThread.main(ActivityThread.java:3701)
12-14 12:23:43.719: E/AndroidRuntime(5179): 	at java.lang.reflect.Method.invokeNative(Native Method)
12-14 12:23:43.719: E/AndroidRuntime(5179): 	at java.lang.reflect.Method.invoke(Method.java:507)
12-14 12:23:43.719: E/AndroidRuntime(5179): 	at com.android.internal.os.ZygoteInit$MethodAndArgsCaller.run(ZygoteInit.java:866)
12-14 12:23:43.719: E/AndroidRuntime(5179): 	at com.android.internal.os.ZygoteInit.main(ZygoteInit.java:624)
12-14 12:23:43.719: E/AndroidRuntime(5179): 	at dalvik.system.NativeStart.main(Native Method)
</pre>

    public void openAndCloseDatabase() {
  	    SQLiteDatabase database = getWritableDatabase();

		close(database);
	}

	private void close(Closeable database) {
		try {
			if (database != null) {
				database.close();
			}
		} catch (Exception e) {
			Log.e("Error", "Oh no!", e);
		}
	}
