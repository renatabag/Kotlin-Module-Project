class MainMenu(private val noteManager: NoteManager) {
    fun show() {
        while (true) {
            println("Главное меню:")
            println("1. Выбор архива")
            println("2. Создание архива")
            println("0. Выход")

            when (readLine()) {
                "1" -> {
                    val archiveMenu = ArchiveMenu(noteManager)
                    archiveMenu.show()
                }
                "2" -> {
                    val createArchiveMenu = CreateArchiveMenu(noteManager)
                    createArchiveMenu.show()
                }
                "0" -> return
                else -> println("Неверный выбор. Попробуйте снова.")
            }
        }
    }
}

class ArchiveMenu(private val noteManager: NoteManager) {
    fun show() {
        while (true) {
            println("Выбор архива:")
            noteManager.archives.forEachIndexed { index, archive ->
                println("${index + 1}. ${archive.name}")
            }
            println("0. Назад")

            when (readLine()) {
                "0" -> return
                else -> {
                    val index = readLine()?.toIntOrNull()
                    if (index != null && index in 1..noteManager.archives.size) {
                        val noteMenu = NoteMenu(noteManager.archives[index - 1])
                        noteMenu.show()
                    } else {
                        println("Неверный выбор. Попробуйте снова.")
                    }
                }
            }
        }
    }
}

class CreateArchiveMenu(private val noteManager: NoteManager) {
    fun show() {
        println("Создание архива:")
        print("Введите название архива: ")
        val name = readLine() ?: ""
        noteManager.addArchive(Archive(name))
        println("Архив создан! Нажмите любую клавишу для продолжения...")
        readLine()
    }
}

