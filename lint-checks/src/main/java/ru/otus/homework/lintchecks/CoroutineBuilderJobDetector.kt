package ru.otus.homework.lintchecks

import com.android.tools.lint.detector.api.*

private const val ID = "CoroutineBuilderJobUsage"
private const val BRIEF_DESCRIPTION = "Не используйте Job/SuperJob внутри корутин-билдеров"
private const val EXPLANATION = """Использование Job/SuperJob внутри корутин-билдеров не имеет никакого эффекта.
     это может сломать ожидаемые обработку ошибок и механизм отмены корутин."""

class CoroutineBuilderJobDetector() : Detector(), Detector.UastScanner {

    companion object {
        val ISSUE = Issue.create(
            id = ID,
            briefDescription = BRIEF_DESCRIPTION,
            explanation = EXPLANATION,
            category = Category.CORRECTNESS,
            priority = 6,
            severity = Severity.WARNING,
            implementation = Implementation(
                GlobalScopeDetector::class.java,
                Scope.JAVA_FILE_SCOPE
            )
        )
    }
}