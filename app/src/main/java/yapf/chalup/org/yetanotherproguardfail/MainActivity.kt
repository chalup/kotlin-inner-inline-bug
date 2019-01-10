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

        SomeClass(printer, LogLevel.DEBUG).builder(Random().nextInt().takeIf { it % 2 == 0 }).print()
    }
}
