             package cvmakerr.advance.cvmakepro.Room_Database.DataBase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import cvmakerr.advance.cvmakepro.Room_Database.Dio.*
import cvmakerr.advance.cvmakepro.Room_Database.Entities.*

@Database(entities = [Experience::class,Qualification::class  ,Achievements::class,Hobbies::class,Languages::class,Skills::class,Projects::class ], version = 2, exportSchema = false)
abstract class RoomDataBasecv : RoomDatabase() {


    abstract fun experienceDao(): ExperienceDao
    abstract fun qualificationDao(): QualificationDao
    abstract fun achievementsDao(): AchievementsDao
    abstract fun hobbiesDao(): HobbiesDao
    abstract fun languagesDao(): LanguagesDao
    abstract fun skillsDao(): SkillsDao
    abstract fun projectsDao():ProjectsDao

    companion object {

        @Volatile
        private var INSTANCE: RoomDataBasecv? = null

        fun getDatabase(context: Context): RoomDataBasecv? {
            if (INSTANCE == null) {
                synchronized(RoomDataBasecv::class.java) {
                    if (INSTANCE == null) {
                        INSTANCE = Room.databaseBuilder(
                            context.applicationContext,
                            RoomDataBasecv::class.java, "testcvdb2"
                        )
                            .build()
                    }
                }
            }
            return INSTANCE
        }
    }
}