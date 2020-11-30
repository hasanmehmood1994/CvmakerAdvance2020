package cvmakerr.advance.cvmakepro.Room_Database.Repositry

import android.app.Application
import cvmakerr.advance.cvmakepro.Room_Database.DataBase.RoomDataBasecv
import cvmakerr.advance.cvmakepro.Room_Database.Dio.*
import cvmakerr.advance.cvmakepro.Room_Database.Entities.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.coroutines.CoroutineContext

class Repository (application: Application):CoroutineScope{
    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main

    private var experienceDao :ExperienceDao? = null
    private var qualificationDao :QualificationDao? = null
    private var skillsDao :SkillsDao? = null
    private var achievementsDao:AchievementsDao? = null
    private var languagesDao:LanguagesDao? = null
    private var projectsDao :ProjectsDao? = null
    private var hobbiesDao :HobbiesDao? = null

    init {
        val db= RoomDataBasecv.getDatabase(application)
        experienceDao=db?.experienceDao()
        qualificationDao=db?.qualificationDao()
        skillsDao=db?.skillsDao()
        achievementsDao=db?.achievementsDao()
       languagesDao=db?.languagesDao()
        projectsDao=db?.projectsDao()
        hobbiesDao=db?.hobbiesDao()
    }
    //projects
    fun getProjects()=projectsDao?.getProjects()
    fun setProjects(projects: Projects) {
        launch  { setProjectsBG(projects) }
    }
    private suspend fun setProjectsBG(projects:Projects) {
        withContext(Dispatchers.IO){
           projectsDao?.setProjects(projects)
        }
    }
    fun delProjects() {
        launch  { delProjectsBG() }
    }
    private suspend fun delProjectsBG() {
        withContext(Dispatchers.IO){
           projectsDao?.deleteAll()
        }
    }
    fun delSingleProjects(id: Int) {
        launch  { delSingleProjectsBG(id) }
    }
    private suspend fun delSingleProjectsBG(id: Int) {
        withContext(Dispatchers.IO){
           projectsDao?.deletesingle(id)
        }
    }

    //languages
    fun getLanguages()=languagesDao?.getLanguages()
    fun setLanguages(languages: Languages) {
        launch  { setLanguagesBG(languages) }
    }
    private suspend fun setLanguagesBG(languages:Languages) {
        withContext(Dispatchers.IO){
           languagesDao?.setLanguages(languages)
        }
    }
    fun delLanguages() {
        launch  { delLanguagesBG() }
    }
    private suspend fun delLanguagesBG() {
        withContext(Dispatchers.IO){
           languagesDao?.deleteAll()
        }
    }
    fun delSingleLanguages(id: Int) {
        launch  { delSingleLanguagesBG(id) }
    }
    private suspend fun delSingleLanguagesBG(id: Int) {
        withContext(Dispatchers.IO){
           languagesDao?.deletesingle(id)
        }
    }



    //hobbies
    fun getHobbies()=hobbiesDao?.getHobbies()
    fun setHobbies(hobbies: Hobbies) {
        launch  { setHobbiesBG(hobbies) }
    }
    private suspend fun setHobbiesBG(hobbies:Hobbies) {
        withContext(Dispatchers.IO){
           hobbiesDao?.setHobbies(hobbies)
        }
    }
    fun delHobbies() {
        launch  { delHobbiesBG() }
    }
    private suspend fun delHobbiesBG() {
        withContext(Dispatchers.IO){
           hobbiesDao?.deleteAll()
        }
    }
    fun delSingleHobbies(id: Int) {
        launch  { delSingleHobbiesBG(id) }
    }
    private suspend fun delSingleHobbiesBG(id: Int) {
        withContext(Dispatchers.IO){
            hobbiesDao?.deletesingle(id)
        }
    }



    //skills
    fun getAchivements()=achievementsDao?.getAchivements()
    fun setAchivements(achievements: Achievements) {
        launch  { setAchivementsBG(achievements) }
    }
    private suspend fun setAchivementsBG(achievements:Achievements) {
        withContext(Dispatchers.IO){
            achievementsDao?.setAchivements(achievements)
        }
    }
    fun delAchivements() {
        launch  { delAchivementsBG() }
    }
    private suspend fun delAchivementsBG() {
        withContext(Dispatchers.IO){
            achievementsDao?.deleteAll()
        }
    }
    fun delSingleAchivements(id: Int) {
        launch  { delSingleAchivementsBG(id) }
    }
    private suspend fun delSingleAchivementsBG(id: Int) {
        withContext(Dispatchers.IO){
         achievementsDao?.deletesingle(id)
        }
    }



//experience
    fun getExperience()=experienceDao?.getExperience()
    fun setExperience(experience: Experience) {
        launch  { setExperienceBG(experience) }
    }
    private suspend fun setExperienceBG(experience: Experience) {
        withContext(Dispatchers.IO){
           experienceDao?.setExperience(experience)
        }
    }
    fun delExperience() {
        launch  { delExperienceBG() }
    }
    private suspend fun delExperienceBG() {
        withContext(Dispatchers.IO){
            experienceDao?.deleteAll()
        }
    }
    fun delSingleExperience(id: Int) {
        launch  { delSingleExperienceBG(id) }
    }
    private suspend fun delSingleExperienceBG(id: Int) {
        withContext(Dispatchers.IO){
            experienceDao?.deletesingle(id)
        }
    }

    //qualification
    fun getQualification()=qualificationDao?.getQualification()
    fun setQualification(qualification: Qualification) {
        launch  { setQualificationBG(qualification) }
    }
    private suspend fun setQualificationBG(qualification: Qualification) {
        withContext(Dispatchers.IO){
            qualificationDao?.setQualification(qualification)
        }
    }
    fun delQualification() {
        launch  { delQualificationBG() }
    }
    private suspend fun delQualificationBG() {
        withContext(Dispatchers.IO){
            qualificationDao?.deleteAll()
        }
    }
    fun delSingleQualification(id: Int) {
        launch  { delSingleQualificationBG(id) }
    }
    private suspend fun delSingleQualificationBG(id: Int) {
        withContext(Dispatchers.IO){
            qualificationDao?.deletesingle(id)
        }
    }



    //skills
    fun getSkills()=skillsDao?.getSkills()
    fun setSkills(skills: Skills) {
        launch  { setSkillsBG(skills) }
    }
    private suspend fun setSkillsBG(skills:Skills) {
        withContext(Dispatchers.IO){
            skillsDao?.setSkills(skills)
        }
    }
    fun delSkills() {
        launch  { delSkillsBG() }
    }
    private suspend fun delSkillsBG() {
        withContext(Dispatchers.IO){
            skillsDao?.deleteAll()
        }
    }
    fun delSingleSkills(id: Int) {
        launch  { delSingleSkillsBG(id) }
    }
    private suspend fun delSingleSkillsBG(id: Int) {
        withContext(Dispatchers.IO){
            skillsDao?.deletesingle(id)
        }
    }
}

