package yapf.chalup.org.yetanotherproguardfail

import android.app.Activity
import android.os.Bundle
import android.util.Log
import java.util.*

class MainActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val printer = object : Printer {
            override fun print(message: String) {
                Log.d("JCH", message)
            }
        }

        val value = Random().nextInt()
        with (SomeClass(printer, LogLevel.DEBUG)) {
            builder(value).print()
            builder(value + 1).print()
        }
    }
}
