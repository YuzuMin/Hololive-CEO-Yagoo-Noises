package com.yuzumin.yagoonoises.alarm;

import android.database.Cursor;
import android.net.Uri;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Class;
import java.lang.Integer;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class AlarmDAO_Impl implements AlarmDAO {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<AlarmEntity> __insertionAdapterOfAlarmEntity;

  private final EntityInsertionAdapter<RepeatEntity> __insertionAdapterOfRepeatEntity;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAlarm;

  private final SharedSQLiteStatement __preparedStmtOfToggleAlarm;

  private final SharedSQLiteStatement __preparedStmtOfUpdateAlarmDate;

  private final SharedSQLiteStatement __preparedStmtOfToggleAlarm_1;

  private final SharedSQLiteStatement __preparedStmtOfToggleHasUserChosenDate;

  public AlarmDAO_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfAlarmEntity = new EntityInsertionAdapter<AlarmEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `alarm_entity` (`alarmID`,`alarmHour`,`alarmMinutes`,`isAlarmOn`,`alarmDay`,`alarmMonth`,`alarmYear`,`isSnoozeOn`,`snoozeTimeInMinutes`,`snoozeFrequency`,`alarmVolume`,`isRepeatOn`,`alarmType`,`alarmTone`,`hasUserChosenDate`,`alarmMessage`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, AlarmEntity value) {
        stmt.bindLong(1, value.alarmID);
        stmt.bindLong(2, value.alarmHour);
        stmt.bindLong(3, value.alarmMinutes);
        final int _tmp;
        _tmp = value.isAlarmOn ? 1 : 0;
        stmt.bindLong(4, _tmp);
        stmt.bindLong(5, value.alarmDay);
        stmt.bindLong(6, value.alarmMonth);
        stmt.bindLong(7, value.alarmYear);
        final int _tmp_1;
        _tmp_1 = value.isSnoozeOn ? 1 : 0;
        stmt.bindLong(8, _tmp_1);
        stmt.bindLong(9, value.snoozeTimeInMinutes);
        stmt.bindLong(10, value.snoozeFrequency);
        stmt.bindLong(11, value.alarmVolume);
        final int _tmp_2;
        _tmp_2 = value.isRepeatOn ? 1 : 0;
        stmt.bindLong(12, _tmp_2);
        stmt.bindLong(13, value.alarmType);
        final String _tmp_3;
        _tmp_3 = Convertors.uriToString(value.alarmTone);
        if (_tmp_3 == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindString(14, _tmp_3);
        }
        final int _tmp_4;
        _tmp_4 = value.hasUserChosenDate ? 1 : 0;
        stmt.bindLong(15, _tmp_4);
        if (value.alarmMessage == null) {
          stmt.bindNull(16);
        } else {
          stmt.bindString(16, value.alarmMessage);
        }
      }
    };
    this.__insertionAdapterOfRepeatEntity = new EntityInsertionAdapter<RepeatEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `alarm_repeat_entity` (`alarmID`,`repeatDay`) VALUES (?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, RepeatEntity value) {
        stmt.bindLong(1, value.alarmID);
        stmt.bindLong(2, value.repeatDay);
      }
    };
    this.__preparedStmtOfDeleteAlarm = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM alarm_entity WHERE alarmHour = ? AND alarmMinutes = ?";
        return _query;
      }
    };
    this.__preparedStmtOfToggleAlarm = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE alarm_entity SET isAlarmOn = ? WHERE alarmHour = ? AND alarmMinutes = ?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateAlarmDate = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE alarm_entity SET alarmDay = ?, alarmMonth = ?, alarmYear = ? WHERE alarmHour = ? AND alarmMinutes = ?";
        return _query;
      }
    };
    this.__preparedStmtOfToggleAlarm_1 = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE alarm_entity SET isAlarmOn = ? WHERE alarmID = ?";
        return _query;
      }
    };
    this.__preparedStmtOfToggleHasUserChosenDate = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE alarm_entity SET hasUserChosenDate = ? WHERE alarmID = ?";
        return _query;
      }
    };
  }

  @Override
  public void addAlarm(final AlarmEntity alarmEntity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfAlarmEntity.insert(alarmEntity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertRepeatData(final RepeatEntity repeatEntity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfRepeatEntity.insert(repeatEntity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteAlarm(final int hour, final int mins) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteAlarm.acquire();
    int _argIndex = 1;
    _stmt.bindLong(_argIndex, hour);
    _argIndex = 2;
    _stmt.bindLong(_argIndex, mins);
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteAlarm.release(_stmt);
    }
  }

  @Override
  public void toggleAlarm(final int hour, final int mins, final int newAlarmState) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfToggleAlarm.acquire();
    int _argIndex = 1;
    _stmt.bindLong(_argIndex, newAlarmState);
    _argIndex = 2;
    _stmt.bindLong(_argIndex, hour);
    _argIndex = 3;
    _stmt.bindLong(_argIndex, mins);
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfToggleAlarm.release(_stmt);
    }
  }

  @Override
  public void updateAlarmDate(final int hour, final int mins, final int newDayOfMonth,
      final int newMonth, final int newYear) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateAlarmDate.acquire();
    int _argIndex = 1;
    _stmt.bindLong(_argIndex, newDayOfMonth);
    _argIndex = 2;
    _stmt.bindLong(_argIndex, newMonth);
    _argIndex = 3;
    _stmt.bindLong(_argIndex, newYear);
    _argIndex = 4;
    _stmt.bindLong(_argIndex, hour);
    _argIndex = 5;
    _stmt.bindLong(_argIndex, mins);
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdateAlarmDate.release(_stmt);
    }
  }

  @Override
  public void toggleAlarm(final int alarmId, final int newAlarmState) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfToggleAlarm_1.acquire();
    int _argIndex = 1;
    _stmt.bindLong(_argIndex, newAlarmState);
    _argIndex = 2;
    _stmt.bindLong(_argIndex, alarmId);
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfToggleAlarm_1.release(_stmt);
    }
  }

  @Override
  public void toggleHasUserChosenDate(final int alarmId, final int newState) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfToggleHasUserChosenDate.acquire();
    int _argIndex = 1;
    _stmt.bindLong(_argIndex, newState);
    _argIndex = 2;
    _stmt.bindLong(_argIndex, alarmId);
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfToggleHasUserChosenDate.release(_stmt);
    }
  }

  @Override
  public List<AlarmEntity> getAlarms() {
    final String _sql = "SELECT * FROM alarm_entity ORDER BY alarmHour, alarmMinutes";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfAlarmID = CursorUtil.getColumnIndexOrThrow(_cursor, "alarmID");
      final int _cursorIndexOfAlarmHour = CursorUtil.getColumnIndexOrThrow(_cursor, "alarmHour");
      final int _cursorIndexOfAlarmMinutes = CursorUtil.getColumnIndexOrThrow(_cursor, "alarmMinutes");
      final int _cursorIndexOfIsAlarmOn = CursorUtil.getColumnIndexOrThrow(_cursor, "isAlarmOn");
      final int _cursorIndexOfAlarmDay = CursorUtil.getColumnIndexOrThrow(_cursor, "alarmDay");
      final int _cursorIndexOfAlarmMonth = CursorUtil.getColumnIndexOrThrow(_cursor, "alarmMonth");
      final int _cursorIndexOfAlarmYear = CursorUtil.getColumnIndexOrThrow(_cursor, "alarmYear");
      final int _cursorIndexOfIsSnoozeOn = CursorUtil.getColumnIndexOrThrow(_cursor, "isSnoozeOn");
      final int _cursorIndexOfSnoozeTimeInMinutes = CursorUtil.getColumnIndexOrThrow(_cursor, "snoozeTimeInMinutes");
      final int _cursorIndexOfSnoozeFrequency = CursorUtil.getColumnIndexOrThrow(_cursor, "snoozeFrequency");
      final int _cursorIndexOfAlarmVolume = CursorUtil.getColumnIndexOrThrow(_cursor, "alarmVolume");
      final int _cursorIndexOfIsRepeatOn = CursorUtil.getColumnIndexOrThrow(_cursor, "isRepeatOn");
      final int _cursorIndexOfAlarmType = CursorUtil.getColumnIndexOrThrow(_cursor, "alarmType");
      final int _cursorIndexOfAlarmTone = CursorUtil.getColumnIndexOrThrow(_cursor, "alarmTone");
      final int _cursorIndexOfHasUserChosenDate = CursorUtil.getColumnIndexOrThrow(_cursor, "hasUserChosenDate");
      final int _cursorIndexOfAlarmMessage = CursorUtil.getColumnIndexOrThrow(_cursor, "alarmMessage");
      final List<AlarmEntity> _result = new ArrayList<AlarmEntity>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final AlarmEntity _item;
        final int _tmpAlarmHour;
        _tmpAlarmHour = _cursor.getInt(_cursorIndexOfAlarmHour);
        final int _tmpAlarmMinutes;
        _tmpAlarmMinutes = _cursor.getInt(_cursorIndexOfAlarmMinutes);
        final boolean _tmpIsAlarmOn;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfIsAlarmOn);
        _tmpIsAlarmOn = _tmp != 0;
        final int _tmpAlarmDay;
        _tmpAlarmDay = _cursor.getInt(_cursorIndexOfAlarmDay);
        final int _tmpAlarmMonth;
        _tmpAlarmMonth = _cursor.getInt(_cursorIndexOfAlarmMonth);
        final int _tmpAlarmYear;
        _tmpAlarmYear = _cursor.getInt(_cursorIndexOfAlarmYear);
        final boolean _tmpIsSnoozeOn;
        final int _tmp_1;
        _tmp_1 = _cursor.getInt(_cursorIndexOfIsSnoozeOn);
        _tmpIsSnoozeOn = _tmp_1 != 0;
        final int _tmpSnoozeTimeInMinutes;
        _tmpSnoozeTimeInMinutes = _cursor.getInt(_cursorIndexOfSnoozeTimeInMinutes);
        final int _tmpSnoozeFrequency;
        _tmpSnoozeFrequency = _cursor.getInt(_cursorIndexOfSnoozeFrequency);
        final int _tmpAlarmVolume;
        _tmpAlarmVolume = _cursor.getInt(_cursorIndexOfAlarmVolume);
        final boolean _tmpIsRepeatOn;
        final int _tmp_2;
        _tmp_2 = _cursor.getInt(_cursorIndexOfIsRepeatOn);
        _tmpIsRepeatOn = _tmp_2 != 0;
        final int _tmpAlarmType;
        _tmpAlarmType = _cursor.getInt(_cursorIndexOfAlarmType);
        final Uri _tmpAlarmTone;
        final String _tmp_3;
        if (_cursor.isNull(_cursorIndexOfAlarmTone)) {
          _tmp_3 = null;
        } else {
          _tmp_3 = _cursor.getString(_cursorIndexOfAlarmTone);
        }
        _tmpAlarmTone = Convertors.stringToUri(_tmp_3);
        final boolean _tmpHasUserChosenDate;
        final int _tmp_4;
        _tmp_4 = _cursor.getInt(_cursorIndexOfHasUserChosenDate);
        _tmpHasUserChosenDate = _tmp_4 != 0;
        final String _tmpAlarmMessage;
        if (_cursor.isNull(_cursorIndexOfAlarmMessage)) {
          _tmpAlarmMessage = null;
        } else {
          _tmpAlarmMessage = _cursor.getString(_cursorIndexOfAlarmMessage);
        }
        _item = new AlarmEntity(_tmpAlarmHour,_tmpAlarmMinutes,_tmpIsAlarmOn,_tmpIsSnoozeOn,_tmpSnoozeTimeInMinutes,_tmpSnoozeFrequency,_tmpAlarmVolume,_tmpIsRepeatOn,_tmpAlarmType,_tmpAlarmDay,_tmpAlarmMonth,_tmpAlarmYear,_tmpAlarmTone,_tmpAlarmMessage,_tmpHasUserChosenDate);
        _item.alarmID = _cursor.getInt(_cursorIndexOfAlarmID);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<AlarmEntity> getAlarmDetails(final int hour, final int mins) {
    final String _sql = "SELECT * FROM alarm_entity WHERE alarmHour = ? AND alarmMinutes = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, hour);
    _argIndex = 2;
    _statement.bindLong(_argIndex, mins);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfAlarmID = CursorUtil.getColumnIndexOrThrow(_cursor, "alarmID");
      final int _cursorIndexOfAlarmHour = CursorUtil.getColumnIndexOrThrow(_cursor, "alarmHour");
      final int _cursorIndexOfAlarmMinutes = CursorUtil.getColumnIndexOrThrow(_cursor, "alarmMinutes");
      final int _cursorIndexOfIsAlarmOn = CursorUtil.getColumnIndexOrThrow(_cursor, "isAlarmOn");
      final int _cursorIndexOfAlarmDay = CursorUtil.getColumnIndexOrThrow(_cursor, "alarmDay");
      final int _cursorIndexOfAlarmMonth = CursorUtil.getColumnIndexOrThrow(_cursor, "alarmMonth");
      final int _cursorIndexOfAlarmYear = CursorUtil.getColumnIndexOrThrow(_cursor, "alarmYear");
      final int _cursorIndexOfIsSnoozeOn = CursorUtil.getColumnIndexOrThrow(_cursor, "isSnoozeOn");
      final int _cursorIndexOfSnoozeTimeInMinutes = CursorUtil.getColumnIndexOrThrow(_cursor, "snoozeTimeInMinutes");
      final int _cursorIndexOfSnoozeFrequency = CursorUtil.getColumnIndexOrThrow(_cursor, "snoozeFrequency");
      final int _cursorIndexOfAlarmVolume = CursorUtil.getColumnIndexOrThrow(_cursor, "alarmVolume");
      final int _cursorIndexOfIsRepeatOn = CursorUtil.getColumnIndexOrThrow(_cursor, "isRepeatOn");
      final int _cursorIndexOfAlarmType = CursorUtil.getColumnIndexOrThrow(_cursor, "alarmType");
      final int _cursorIndexOfAlarmTone = CursorUtil.getColumnIndexOrThrow(_cursor, "alarmTone");
      final int _cursorIndexOfHasUserChosenDate = CursorUtil.getColumnIndexOrThrow(_cursor, "hasUserChosenDate");
      final int _cursorIndexOfAlarmMessage = CursorUtil.getColumnIndexOrThrow(_cursor, "alarmMessage");
      final List<AlarmEntity> _result = new ArrayList<AlarmEntity>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final AlarmEntity _item;
        final int _tmpAlarmHour;
        _tmpAlarmHour = _cursor.getInt(_cursorIndexOfAlarmHour);
        final int _tmpAlarmMinutes;
        _tmpAlarmMinutes = _cursor.getInt(_cursorIndexOfAlarmMinutes);
        final boolean _tmpIsAlarmOn;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfIsAlarmOn);
        _tmpIsAlarmOn = _tmp != 0;
        final int _tmpAlarmDay;
        _tmpAlarmDay = _cursor.getInt(_cursorIndexOfAlarmDay);
        final int _tmpAlarmMonth;
        _tmpAlarmMonth = _cursor.getInt(_cursorIndexOfAlarmMonth);
        final int _tmpAlarmYear;
        _tmpAlarmYear = _cursor.getInt(_cursorIndexOfAlarmYear);
        final boolean _tmpIsSnoozeOn;
        final int _tmp_1;
        _tmp_1 = _cursor.getInt(_cursorIndexOfIsSnoozeOn);
        _tmpIsSnoozeOn = _tmp_1 != 0;
        final int _tmpSnoozeTimeInMinutes;
        _tmpSnoozeTimeInMinutes = _cursor.getInt(_cursorIndexOfSnoozeTimeInMinutes);
        final int _tmpSnoozeFrequency;
        _tmpSnoozeFrequency = _cursor.getInt(_cursorIndexOfSnoozeFrequency);
        final int _tmpAlarmVolume;
        _tmpAlarmVolume = _cursor.getInt(_cursorIndexOfAlarmVolume);
        final boolean _tmpIsRepeatOn;
        final int _tmp_2;
        _tmp_2 = _cursor.getInt(_cursorIndexOfIsRepeatOn);
        _tmpIsRepeatOn = _tmp_2 != 0;
        final int _tmpAlarmType;
        _tmpAlarmType = _cursor.getInt(_cursorIndexOfAlarmType);
        final Uri _tmpAlarmTone;
        final String _tmp_3;
        if (_cursor.isNull(_cursorIndexOfAlarmTone)) {
          _tmp_3 = null;
        } else {
          _tmp_3 = _cursor.getString(_cursorIndexOfAlarmTone);
        }
        _tmpAlarmTone = Convertors.stringToUri(_tmp_3);
        final boolean _tmpHasUserChosenDate;
        final int _tmp_4;
        _tmp_4 = _cursor.getInt(_cursorIndexOfHasUserChosenDate);
        _tmpHasUserChosenDate = _tmp_4 != 0;
        final String _tmpAlarmMessage;
        if (_cursor.isNull(_cursorIndexOfAlarmMessage)) {
          _tmpAlarmMessage = null;
        } else {
          _tmpAlarmMessage = _cursor.getString(_cursorIndexOfAlarmMessage);
        }
        _item = new AlarmEntity(_tmpAlarmHour,_tmpAlarmMinutes,_tmpIsAlarmOn,_tmpIsSnoozeOn,_tmpSnoozeTimeInMinutes,_tmpSnoozeFrequency,_tmpAlarmVolume,_tmpIsRepeatOn,_tmpAlarmType,_tmpAlarmDay,_tmpAlarmMonth,_tmpAlarmYear,_tmpAlarmTone,_tmpAlarmMessage,_tmpHasUserChosenDate);
        _item.alarmID = _cursor.getInt(_cursorIndexOfAlarmID);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<Integer> getAlarmRepeatDays(final int alarmId) {
    final String _sql = "SELECT repeatDay from alarm_repeat_entity WHERE alarmID = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, alarmId);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final List<Integer> _result = new ArrayList<Integer>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Integer _item;
        if (_cursor.isNull(0)) {
          _item = null;
        } else {
          _item = _cursor.getInt(0);
        }
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<AlarmEntity> getActiveAlarms() {
    final String _sql = "SELECT * FROM alarm_entity WHERE isAlarmOn = 1 ORDER BY alarmHour, alarmMinutes";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfAlarmID = CursorUtil.getColumnIndexOrThrow(_cursor, "alarmID");
      final int _cursorIndexOfAlarmHour = CursorUtil.getColumnIndexOrThrow(_cursor, "alarmHour");
      final int _cursorIndexOfAlarmMinutes = CursorUtil.getColumnIndexOrThrow(_cursor, "alarmMinutes");
      final int _cursorIndexOfIsAlarmOn = CursorUtil.getColumnIndexOrThrow(_cursor, "isAlarmOn");
      final int _cursorIndexOfAlarmDay = CursorUtil.getColumnIndexOrThrow(_cursor, "alarmDay");
      final int _cursorIndexOfAlarmMonth = CursorUtil.getColumnIndexOrThrow(_cursor, "alarmMonth");
      final int _cursorIndexOfAlarmYear = CursorUtil.getColumnIndexOrThrow(_cursor, "alarmYear");
      final int _cursorIndexOfIsSnoozeOn = CursorUtil.getColumnIndexOrThrow(_cursor, "isSnoozeOn");
      final int _cursorIndexOfSnoozeTimeInMinutes = CursorUtil.getColumnIndexOrThrow(_cursor, "snoozeTimeInMinutes");
      final int _cursorIndexOfSnoozeFrequency = CursorUtil.getColumnIndexOrThrow(_cursor, "snoozeFrequency");
      final int _cursorIndexOfAlarmVolume = CursorUtil.getColumnIndexOrThrow(_cursor, "alarmVolume");
      final int _cursorIndexOfIsRepeatOn = CursorUtil.getColumnIndexOrThrow(_cursor, "isRepeatOn");
      final int _cursorIndexOfAlarmType = CursorUtil.getColumnIndexOrThrow(_cursor, "alarmType");
      final int _cursorIndexOfAlarmTone = CursorUtil.getColumnIndexOrThrow(_cursor, "alarmTone");
      final int _cursorIndexOfHasUserChosenDate = CursorUtil.getColumnIndexOrThrow(_cursor, "hasUserChosenDate");
      final int _cursorIndexOfAlarmMessage = CursorUtil.getColumnIndexOrThrow(_cursor, "alarmMessage");
      final List<AlarmEntity> _result = new ArrayList<AlarmEntity>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final AlarmEntity _item;
        final int _tmpAlarmHour;
        _tmpAlarmHour = _cursor.getInt(_cursorIndexOfAlarmHour);
        final int _tmpAlarmMinutes;
        _tmpAlarmMinutes = _cursor.getInt(_cursorIndexOfAlarmMinutes);
        final boolean _tmpIsAlarmOn;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfIsAlarmOn);
        _tmpIsAlarmOn = _tmp != 0;
        final int _tmpAlarmDay;
        _tmpAlarmDay = _cursor.getInt(_cursorIndexOfAlarmDay);
        final int _tmpAlarmMonth;
        _tmpAlarmMonth = _cursor.getInt(_cursorIndexOfAlarmMonth);
        final int _tmpAlarmYear;
        _tmpAlarmYear = _cursor.getInt(_cursorIndexOfAlarmYear);
        final boolean _tmpIsSnoozeOn;
        final int _tmp_1;
        _tmp_1 = _cursor.getInt(_cursorIndexOfIsSnoozeOn);
        _tmpIsSnoozeOn = _tmp_1 != 0;
        final int _tmpSnoozeTimeInMinutes;
        _tmpSnoozeTimeInMinutes = _cursor.getInt(_cursorIndexOfSnoozeTimeInMinutes);
        final int _tmpSnoozeFrequency;
        _tmpSnoozeFrequency = _cursor.getInt(_cursorIndexOfSnoozeFrequency);
        final int _tmpAlarmVolume;
        _tmpAlarmVolume = _cursor.getInt(_cursorIndexOfAlarmVolume);
        final boolean _tmpIsRepeatOn;
        final int _tmp_2;
        _tmp_2 = _cursor.getInt(_cursorIndexOfIsRepeatOn);
        _tmpIsRepeatOn = _tmp_2 != 0;
        final int _tmpAlarmType;
        _tmpAlarmType = _cursor.getInt(_cursorIndexOfAlarmType);
        final Uri _tmpAlarmTone;
        final String _tmp_3;
        if (_cursor.isNull(_cursorIndexOfAlarmTone)) {
          _tmp_3 = null;
        } else {
          _tmp_3 = _cursor.getString(_cursorIndexOfAlarmTone);
        }
        _tmpAlarmTone = Convertors.stringToUri(_tmp_3);
        final boolean _tmpHasUserChosenDate;
        final int _tmp_4;
        _tmp_4 = _cursor.getInt(_cursorIndexOfHasUserChosenDate);
        _tmpHasUserChosenDate = _tmp_4 != 0;
        final String _tmpAlarmMessage;
        if (_cursor.isNull(_cursorIndexOfAlarmMessage)) {
          _tmpAlarmMessage = null;
        } else {
          _tmpAlarmMessage = _cursor.getString(_cursorIndexOfAlarmMessage);
        }
        _item = new AlarmEntity(_tmpAlarmHour,_tmpAlarmMinutes,_tmpIsAlarmOn,_tmpIsSnoozeOn,_tmpSnoozeTimeInMinutes,_tmpSnoozeFrequency,_tmpAlarmVolume,_tmpIsRepeatOn,_tmpAlarmType,_tmpAlarmDay,_tmpAlarmMonth,_tmpAlarmYear,_tmpAlarmTone,_tmpAlarmMessage,_tmpHasUserChosenDate);
        _item.alarmID = _cursor.getInt(_cursorIndexOfAlarmID);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public int getAlarmId(final int hour, final int mins) {
    final String _sql = "SELECT alarmID FROM alarm_entity WHERE alarmHour = ? AND alarmMinutes = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, hour);
    _argIndex = 2;
    _statement.bindLong(_argIndex, mins);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _result;
      if(_cursor.moveToFirst()) {
        _result = _cursor.getInt(0);
      } else {
        _result = 0;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public int getNumberOfAlarms() {
    final String _sql = "SELECT COUNT(*) FROM alarm_entity";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _result;
      if(_cursor.moveToFirst()) {
        _result = _cursor.getInt(0);
      } else {
        _result = 0;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<AlarmEntity> getInactiveAlarms() {
    final String _sql = "SELECT * FROM alarm_entity WHERE isAlarmOn = 0";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfAlarmID = CursorUtil.getColumnIndexOrThrow(_cursor, "alarmID");
      final int _cursorIndexOfAlarmHour = CursorUtil.getColumnIndexOrThrow(_cursor, "alarmHour");
      final int _cursorIndexOfAlarmMinutes = CursorUtil.getColumnIndexOrThrow(_cursor, "alarmMinutes");
      final int _cursorIndexOfIsAlarmOn = CursorUtil.getColumnIndexOrThrow(_cursor, "isAlarmOn");
      final int _cursorIndexOfAlarmDay = CursorUtil.getColumnIndexOrThrow(_cursor, "alarmDay");
      final int _cursorIndexOfAlarmMonth = CursorUtil.getColumnIndexOrThrow(_cursor, "alarmMonth");
      final int _cursorIndexOfAlarmYear = CursorUtil.getColumnIndexOrThrow(_cursor, "alarmYear");
      final int _cursorIndexOfIsSnoozeOn = CursorUtil.getColumnIndexOrThrow(_cursor, "isSnoozeOn");
      final int _cursorIndexOfSnoozeTimeInMinutes = CursorUtil.getColumnIndexOrThrow(_cursor, "snoozeTimeInMinutes");
      final int _cursorIndexOfSnoozeFrequency = CursorUtil.getColumnIndexOrThrow(_cursor, "snoozeFrequency");
      final int _cursorIndexOfAlarmVolume = CursorUtil.getColumnIndexOrThrow(_cursor, "alarmVolume");
      final int _cursorIndexOfIsRepeatOn = CursorUtil.getColumnIndexOrThrow(_cursor, "isRepeatOn");
      final int _cursorIndexOfAlarmType = CursorUtil.getColumnIndexOrThrow(_cursor, "alarmType");
      final int _cursorIndexOfAlarmTone = CursorUtil.getColumnIndexOrThrow(_cursor, "alarmTone");
      final int _cursorIndexOfHasUserChosenDate = CursorUtil.getColumnIndexOrThrow(_cursor, "hasUserChosenDate");
      final int _cursorIndexOfAlarmMessage = CursorUtil.getColumnIndexOrThrow(_cursor, "alarmMessage");
      final List<AlarmEntity> _result = new ArrayList<AlarmEntity>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final AlarmEntity _item;
        final int _tmpAlarmHour;
        _tmpAlarmHour = _cursor.getInt(_cursorIndexOfAlarmHour);
        final int _tmpAlarmMinutes;
        _tmpAlarmMinutes = _cursor.getInt(_cursorIndexOfAlarmMinutes);
        final boolean _tmpIsAlarmOn;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfIsAlarmOn);
        _tmpIsAlarmOn = _tmp != 0;
        final int _tmpAlarmDay;
        _tmpAlarmDay = _cursor.getInt(_cursorIndexOfAlarmDay);
        final int _tmpAlarmMonth;
        _tmpAlarmMonth = _cursor.getInt(_cursorIndexOfAlarmMonth);
        final int _tmpAlarmYear;
        _tmpAlarmYear = _cursor.getInt(_cursorIndexOfAlarmYear);
        final boolean _tmpIsSnoozeOn;
        final int _tmp_1;
        _tmp_1 = _cursor.getInt(_cursorIndexOfIsSnoozeOn);
        _tmpIsSnoozeOn = _tmp_1 != 0;
        final int _tmpSnoozeTimeInMinutes;
        _tmpSnoozeTimeInMinutes = _cursor.getInt(_cursorIndexOfSnoozeTimeInMinutes);
        final int _tmpSnoozeFrequency;
        _tmpSnoozeFrequency = _cursor.getInt(_cursorIndexOfSnoozeFrequency);
        final int _tmpAlarmVolume;
        _tmpAlarmVolume = _cursor.getInt(_cursorIndexOfAlarmVolume);
        final boolean _tmpIsRepeatOn;
        final int _tmp_2;
        _tmp_2 = _cursor.getInt(_cursorIndexOfIsRepeatOn);
        _tmpIsRepeatOn = _tmp_2 != 0;
        final int _tmpAlarmType;
        _tmpAlarmType = _cursor.getInt(_cursorIndexOfAlarmType);
        final Uri _tmpAlarmTone;
        final String _tmp_3;
        if (_cursor.isNull(_cursorIndexOfAlarmTone)) {
          _tmp_3 = null;
        } else {
          _tmp_3 = _cursor.getString(_cursorIndexOfAlarmTone);
        }
        _tmpAlarmTone = Convertors.stringToUri(_tmp_3);
        final boolean _tmpHasUserChosenDate;
        final int _tmp_4;
        _tmp_4 = _cursor.getInt(_cursorIndexOfHasUserChosenDate);
        _tmpHasUserChosenDate = _tmp_4 != 0;
        final String _tmpAlarmMessage;
        if (_cursor.isNull(_cursorIndexOfAlarmMessage)) {
          _tmpAlarmMessage = null;
        } else {
          _tmpAlarmMessage = _cursor.getString(_cursorIndexOfAlarmMessage);
        }
        _item = new AlarmEntity(_tmpAlarmHour,_tmpAlarmMinutes,_tmpIsAlarmOn,_tmpIsSnoozeOn,_tmpSnoozeTimeInMinutes,_tmpSnoozeFrequency,_tmpAlarmVolume,_tmpIsRepeatOn,_tmpAlarmType,_tmpAlarmDay,_tmpAlarmMonth,_tmpAlarmYear,_tmpAlarmTone,_tmpAlarmMessage,_tmpHasUserChosenDate);
        _item.alarmID = _cursor.getInt(_cursorIndexOfAlarmID);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
