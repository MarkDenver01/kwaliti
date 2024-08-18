package app.io.kwaliti.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import app.io.kwaliti.data.local.dao.DeviceInformationDao

@Database(entities = [DeviceInfoDatabase::class], version = 1, exportSchema = false)
abstract class DeviceInfoDatabase: RoomDatabase() {

    abstract fun deviceInfoDao() : DeviceInformationDao

}