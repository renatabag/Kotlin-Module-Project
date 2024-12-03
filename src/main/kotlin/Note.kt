class NoteMenu(private val archive: Archive) {
    fun show() {
        while (true) {
            println("Заметки в архиве '${archive.name}':")
            if (archive.notes.isEmpty()) {
                println("Нет доступных заметок.")
            } else {
                archive.notes.forEachIndexed { index, note ->
                    println("${index + 1}. ${note.title}")
                }
            }
            println("2. Создать заметку")
            println("0. Назад")


            when (readLine()) {
                "2" -> {
                    val createNoteMenu = CreateNoteMenu(archive)
                    createNoteMenu.show()
                }
                "0" -> return

                else -> {
                    val index = readLine()?.toIntOrNull()
                    if (index != null && index in 1..archive.notes.size) {
                        val noteDisplayMenu = NoteDisplayMenu(archive.notes[index - 1])
                        noteDisplayMenu.show()
                    } else {
                        println("Неверный выбор. Попробуйте снова.")
                    }
                }
            }
        }
    }
}

class CreateNoteMenu(private val archive: Archive) {
    fun show() {
        println("Создание заметки:")
        print("Введите заголовок: ")
        val title = readLine() ?: ""
        print("Введите текст заметки: ")
        val content = readLine() ?: ""

        archive.notes.add(Note(title, content))

        println("Заметка создана! Нажмите любую клавишу для продолжения...")
        readLine()
    }
}

class NoteDisplayMenu(private val note: Note) {
    fun show() {
        println("Заметка: ${note.title}")
        println(note.content)
        println("Нажмите любую клавишу для возвращения...")
        readLine()
    }
}