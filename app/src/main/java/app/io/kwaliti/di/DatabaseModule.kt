package app.io.kwaliti.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import app.io.kwaliti.data.local.DeviceInfoDatabase
import app.io.kwaliti.utils.Constants
import app.io.kwaliti.utils.Constants.DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(context: Context) = Room.databaseBuilder(
        context,
        DeviceInfoDatabase::class.java,
        DATABASE_NAME
    ).build()


    @Singleton
    @Provides
    fun provideDeviceInformationDao(database: DeviceInfoDatabase) = database.deviceInfoDao()
}