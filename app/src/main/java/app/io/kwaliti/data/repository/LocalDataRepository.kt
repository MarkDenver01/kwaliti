package app.io.kwaliti.data.repository

import app.io.kwaliti.data.local.dao.DeviceInformationDao
import app.io.kwaliti.data.models.DeviceInformation
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LocalDataRepository @Inject constructor(
    private val deviceInformationDao: DeviceInformationDao
) {
    val getAllDeviceInformation: Flow<List<DeviceInformation>> =
        deviceInformationDao.getAllDeviceInformation()

    val sortByLock: Flow<List<DeviceInformation>> =
        deviceInformationDao.sortByLock()

    val sortByHub: Flow<List<DeviceInformation>> =
        deviceInformationDao.sortByHub()

    fun getSelectedDevice(deviceId: Int): Flow<DeviceInformation> =
        deviceInformationDao.getSelectedDevice(deviceId = deviceId)

    suspend fun addDeviceInformation(deviceInformation: DeviceInformation) =
        deviceInformationDao.addDeviceInformation(deviceInformation = deviceInformation)

    suspend fun updateDeviceInformation(deviceInformation: DeviceInformation) =
        deviceInformationDao.updateDeviceInformation(deviceInformation = deviceInformation)

    suspend fun deleteDeviceInformation(deviceInformation: DeviceInformation) =
        deviceInformationDao.deleteDeviceInformation(deviceInformation = deviceInformation)

    suspend fun deleteAllDeviceInformation() = deviceInformationDao.deleteAllDeviceInformation()

    fun searchDeviceInformation(searchQuery: String): Flow<List<DeviceInformation>> =
        deviceInformationDao.searchDeviceInformation(searchQuery = searchQuery)
}