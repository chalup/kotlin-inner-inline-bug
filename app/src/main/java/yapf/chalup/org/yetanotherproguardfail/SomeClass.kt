package yapf.chalup.org.yetanotherproguardfail

interface Printer {
    fun print(message: String)
}

interface MessageBuilder {
    fun message(): String
    fun logLevel(): LogLevel
}

enum class LogLevel {
    DEBUG, ERROR
}

object OddMessageBuilder : MessageBuilder {
    override fun message(): String = "Huh, this is odd"
    override fun logLevel(): LogLevel = LogLevel.ERROR
}

class SomeClass(
    private val printer: Printer,
    private val defaultLogLevel: LogLevel
) {
    fun builder(value: Int?) = SomeBuilder(value)

    inner class SomeBuilder
    internal constructor(value: Int? = null) {
        private val messageBuilder =
            value
                ?.let {
                    object : MessageBuilder {
                        override fun message(): String = "Message $it"
                        override fun logLevel(): LogLevel = defaultLogLevel
                    }
                }
                ?: OddMessageBuilder

        fun print() = printer.print(messageBuilder.message())
    }
}