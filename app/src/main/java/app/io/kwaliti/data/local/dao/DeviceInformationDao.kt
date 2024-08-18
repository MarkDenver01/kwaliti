package app.io.kwaliti.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import app.io.kwaliti.data.models.DeviceInformation
import kotlinx.coroutines.flow.Flow

@Dao
interface DeviceInformationDao {
    @Query("SELECT * FROM device_table ORDER BY id ASC")
    fun getAllDeviceInformation(): Flow<List<DeviceInformation>>

    @Query("SELECT * FROM device_table WHERE id=:deviceId")
    fun getSelectedDevice(deviceId: Int): Flow<DeviceInformation>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addDeviceInformation(deviceInformation: DeviceInformation)

    @Update
    suspend fun updateDeviceInformation(deviceInformation: DeviceInformation)

    @Delete
    suspend fun deleteDeviceInformation(deviceInformation: DeviceInformation)

    @Query("DELETE FROM device_table")
    suspend fun deleteAllDeviceInformation()

    @Query("SELECT * FROM device_table WHERE serialNumber LIKE :searchQuery OR deviceAddress LIKE :searchQuery")
    fun searchDeviceInformation(searchQuery: String) : Flow<List<DeviceInformation>>

    @Query("SELECT * FROM device_table ORDER BY CASE WHEN deviceTypeByColor LIKE 'L%' THEN 1 WHEN deviceTypeByColor LIKE 'H%' THEN 2 WHEN deviceTypeByColor LIKE 'R%' THEN 3 END")
    fun sortByLock() : Flow<List<DeviceInformation>>

    @Query("SELECT * FROM device_table ORDER BY CASE WHEN deviceTypeByColor LIKE 'H%' THEN 1 WHEN deviceTypeByColor LIKE 'R%' THEN 2 WHEN deviceTypeByColor LIKE 'L%' THEN 3 END")
    fun sortByHub() : Flow<List<DeviceInformation>>
}