package com.yuzumin.yagoonoises.alarm;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.room.RoomOpenHelper.Delegate;
import androidx.room.RoomOpenHelper.ValidationResult;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.room.util.TableInfo.Column;
import androidx.room.util.TableInfo.ForeignKey;
import androidx.room.util.TableInfo.Index;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Callback;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@SuppressWarnings({"unchecked", "deprecation"})
public final class AlarmDatabase_Impl extends AlarmDatabase {
  private volatile AlarmDAO _alarmDAO;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(2) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `alarm_entity` (`alarmID` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `alarmHour` INTEGER NOT NULL, `alarmMinutes` INTEGER NOT NULL, `isAlarmOn` INTEGER NOT NULL, `alarmDay` INTEGER NOT NULL, `alarmMonth` INTEGER NOT NULL, `alarmYear` INTEGER NOT NULL, `isSnoozeOn` INTEGER NOT NULL, `snoozeTimeInMinutes` INTEGER NOT NULL, `snoozeFrequency` INTEGER NOT NULL, `alarmVolume` INTEGER NOT NULL, `isRepeatOn` INTEGER NOT NULL, `alarmType` INTEGER NOT NULL, `alarmTone` TEXT, `hasUserChosenDate` INTEGER NOT NULL, `alarmMessage` TEXT)");
        _db.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS `index_alarm_entity_alarmHour_alarmMinutes` ON `alarm_entity` (`alarmHour`, `alarmMinutes`)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `alarm_repeat_entity` (`alarmID` INTEGER NOT NULL, `repeatDay` INTEGER NOT NULL, PRIMARY KEY(`alarmID`, `repeatDay`), FOREIGN KEY(`alarmID`) REFERENCES `alarm_entity`(`alarmID`) ON UPDATE CASCADE ON DELETE CASCADE )");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '573f62079e2f484790af40ba96973c66')");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `alarm_entity`");
        _db.execSQL("DROP TABLE IF EXISTS `alarm_repeat_entity`");
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onDestructiveMigration(_db);
          }
        }
      }

      @Override
      protected void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        _db.execSQL("PRAGMA foreign_keys = ON");
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      public void onPreMigrate(SupportSQLiteDatabase _db) {
        DBUtil.dropFtsSyncTriggers(_db);
      }

      @Override
      public void onPostMigrate(SupportSQLiteDatabase _db) {
      }

      @Override
      protected RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsAlarmEntity = new HashMap<String, TableInfo.Column>(16);
        _columnsAlarmEntity.put("alarmID", new TableInfo.Column("alarmID", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAlarmEntity.put("alarmHour", new TableInfo.Column("alarmHour", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAlarmEntity.put("alarmMinutes", new TableInfo.Column("alarmMinutes", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAlarmEntity.put("isAlarmOn", new TableInfo.Column("isAlarmOn", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAlarmEntity.put("alarmDay", new TableInfo.Column("alarmDay", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAlarmEntity.put("alarmMonth", new TableInfo.Column("alarmMonth", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAlarmEntity.put("alarmYear", new TableInfo.Column("alarmYear", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAlarmEntity.put("isSnoozeOn", new TableInfo.Column("isSnoozeOn", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAlarmEntity.put("snoozeTimeInMinutes", new TableInfo.Column("snoozeTimeInMinutes", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAlarmEntity.put("snoozeFrequency", new TableInfo.Column("snoozeFrequency", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAlarmEntity.put("alarmVolume", new TableInfo.Column("alarmVolume", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAlarmEntity.put("isRepeatOn", new TableInfo.Column("isRepeatOn", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAlarmEntity.put("alarmType", new TableInfo.Column("alarmType", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAlarmEntity.put("alarmTone", new TableInfo.Column("alarmTone", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAlarmEntity.put("hasUserChosenDate", new TableInfo.Column("hasUserChosenDate", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAlarmEntity.put("alarmMessage", new TableInfo.Column("alarmMessage", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysAlarmEntity = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesAlarmEntity = new HashSet<TableInfo.Index>(1);
        _indicesAlarmEntity.add(new TableInfo.Index("index_alarm_entity_alarmHour_alarmMinutes", true, Arrays.asList("alarmHour","alarmMinutes")));
        final TableInfo _infoAlarmEntity = new TableInfo("alarm_entity", _columnsAlarmEntity, _foreignKeysAlarmEntity, _indicesAlarmEntity);
        final TableInfo _existingAlarmEntity = TableInfo.read(_db, "alarm_entity");
        if (! _infoAlarmEntity.equals(_existingAlarmEntity)) {
          return new RoomOpenHelper.ValidationResult(false, "alarm_entity(com.yuzumin.yagoonoises.alarm.AlarmEntity).\n"
                  + " Expected:\n" + _infoAlarmEntity + "\n"
                  + " Found:\n" + _existingAlarmEntity);
        }
        final HashMap<String, TableInfo.Column> _columnsAlarmRepeatEntity = new HashMap<String, TableInfo.Column>(2);
        _columnsAlarmRepeatEntity.put("alarmID", new TableInfo.Column("alarmID", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAlarmRepeatEntity.put("repeatDay", new TableInfo.Column("repeatDay", "INTEGER", true, 2, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysAlarmRepeatEntity = new HashSet<TableInfo.ForeignKey>(1);
        _foreignKeysAlarmRepeatEntity.add(new TableInfo.ForeignKey("alarm_entity", "CASCADE", "CASCADE",Arrays.asList("alarmID"), Arrays.asList("alarmID")));
        final HashSet<TableInfo.Index> _indicesAlarmRepeatEntity = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoAlarmRepeatEntity = new TableInfo("alarm_repeat_entity", _columnsAlarmRepeatEntity, _foreignKeysAlarmRepeatEntity, _indicesAlarmRepeatEntity);
        final TableInfo _existingAlarmRepeatEntity = TableInfo.read(_db, "alarm_repeat_entity");
        if (! _infoAlarmRepeatEntity.equals(_existingAlarmRepeatEntity)) {
          return new RoomOpenHelper.ValidationResult(false, "alarm_repeat_entity(com.yuzumin.yagoonoises.alarm.RepeatEntity).\n"
                  + " Expected:\n" + _infoAlarmRepeatEntity + "\n"
                  + " Found:\n" + _existingAlarmRepeatEntity);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "573f62079e2f484790af40ba96973c66", "5c1beb332f7496cdec06f05749279f0b");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "alarm_entity","alarm_repeat_entity");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    boolean _supportsDeferForeignKeys = android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP;
    try {
      if (!_supportsDeferForeignKeys) {
        _db.execSQL("PRAGMA foreign_keys = FALSE");
      }
      super.beginTransaction();
      if (_supportsDeferForeignKeys) {
        _db.execSQL("PRAGMA defer_foreign_keys = TRUE");
      }
      _db.execSQL("DELETE FROM `alarm_entity`");
      _db.execSQL("DELETE FROM `alarm_repeat_entity`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      if (!_supportsDeferForeignKeys) {
        _db.execSQL("PRAGMA foreign_keys = TRUE");
      }
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final HashMap<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(AlarmDAO.class, AlarmDAO_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  public AlarmDAO alarmDAO() {
    if (_alarmDAO != null) {
      return _alarmDAO;
    } else {
      synchronized(this) {
        if(_alarmDAO == null) {
          _alarmDAO = new AlarmDAO_Impl(this);
        }
        return _alarmDAO;
      }
    }
  }
}
