package cvmakerr.advance.cvmakepro.Room_Database.ViewModel

import android.app.Application

import androidx.lifecycle.AndroidViewModel
import cvmakerr.advance.cvmakepro.Room_Database.Entities.*
import cvmakerr.advance.cvmakepro.Room_Database.Repositry.Repository

class ViewModel_Class (application: Application) : AndroidViewModel(application) {

    private var repository: Repository = Repository(application)

    //Achievements
    fun getAchievements() = repository.getAchivements()
    fun setAchievements(achievements: Achievements) { repository.setAchivements(achievements)}
    fun deleteAchievements() { repository.delAchivements()}
    fun deleteSingleAchievements(id: Int) { repository.delSingleAchivements(id)}


//experience
    fun getExperience() = repository.getExperience()
    fun setExperience(experience: Experience) { repository.setExperience(experience)}
    fun deleteExperience() { repository.delExperience()}
    fun deleteSingleExperience(id: Int) { repository.delSingleExperience(id)}

    //Hobbies
    fun getHobbies() = repository.getHobbies()
    fun setHobbies(hobbies: Hobbies) { repository.setHobbies(hobbies)}
    fun deleteHobbies() { repository.delHobbies()}
    fun deleteSingleHobbies(id: Int) { repository.delSingleHobbies(id)}

    //Languages
    fun getLanguages() = repository.getLanguages()
    fun setLanguages(languages: Languages) { repository.setLanguages(languages)}
    fun deleteLanguages() { repository.delLanguages()}
    fun deleteSingleLanguages(id: Int) { repository.delSingleLanguages(id)}

    //Projects
    fun getProjects() = repository.getProjects()
    fun setProjects(projects:Projects) { repository.setProjects(projects)}
    fun deleteProjects() { repository.delProjects()}
    fun deleteSingleProjects(id: Int) { repository.delSingleProjects(id)}

    //qualification
    fun getQualification() = repository.getQualification()
    fun setQualification(qualification: Qualification) { repository.setQualification(qualification)}
    fun deleteQualification() { repository.delQualification()}
    fun deleteSingleQualification(id: Int) { repository.delSingleQualification(id)}

    //Skills
    fun getSkills() = repository.getSkills()
    fun setSkills(skills:Skills) { repository.setSkills(skills)}
    fun deleteSkills() { repository.delSkills()}
    fun deleteSingleSkills(id: Int) { repository.delSingleSkills(id)}

    //Skills
    fun getHistory() = repository.getHistory()
    fun setHistory(history:History) { repository.setHistory(history)}
    fun deleteHistory() { repository.delHistory()}
    fun deleteSingleHistory(id: Int) { repository.delSingleHistory(id)}
}