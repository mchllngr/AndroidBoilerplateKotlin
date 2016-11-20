package de.mchllngr.androidboilerplatekotlin.util.timber

import android.util.Log

import timber.log.Timber

/**
 * [timber.log.Timber.Tree] for choosing what should be printed to the [Log].
 */
class ReleaseTree : Timber.Tree() {

    companion object {
        /**
         * Max length of a [Log]-line.
         */
        private val MAX_LOG_LENGTH = 4000
    }

    override fun isLoggable(priority: Int): Boolean {
        // only log ERROR, WTF
        return !(priority == Log.WARN ||
                priority == Log.VERBOSE ||
                priority == Log.DEBUG ||
                priority == Log.INFO)
    }

    override fun log(priority: Int, tag: String, message: String, t: Throwable) {
        if (isLoggable(priority)) {

            // Message is short enough, does not need to be broken into chunks
            if (message.length < MAX_LOG_LENGTH) {
                if (priority == Log.ASSERT)
                    Log.wtf(tag, message)
                else
                    Log.println(priority, tag, message)

                return
            }

            // Split by line, then ensure each line can fit into Logs maximum length
            val length = message.length
            var i = 0
            while (i < length) {
                var newline = message.indexOf('\n', i)
                newline = if (newline != -1) newline else length
                do {
                    val end = Math.min(newline, i + MAX_LOG_LENGTH)
                    val part = message.substring(i, end)

                    if (priority == Log.ASSERT)
                        Log.wtf(tag, part)
                    else
                        Log.println(priority, tag, part)

                    i = end
                } while (i < newline)
                i++
            }
        }
    }
}
