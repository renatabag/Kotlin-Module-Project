data class Note(val title: String, val content: String)

class Archive(val name: String) {
    val notes = mutableListOf<Note>()
}

class NoteManager {
    val archives = mutableListOf<Archive>()

    fun addArchive(archive: Archive) {
        archives.add(archive)
    }
}

fun main() {
    val noteManager = NoteManager()
    val mainMenu = MainMenu(noteManager)
    mainMenu.show()
}


