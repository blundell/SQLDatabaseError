package com.blundell.sqldatabasecursorerror;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.io.Closeable;

public class DatabaseHelper extends SQLiteOpenHelper {

	public DatabaseHelper(Context context) {
		super(context, "test", null, 1);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

	}

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

}
