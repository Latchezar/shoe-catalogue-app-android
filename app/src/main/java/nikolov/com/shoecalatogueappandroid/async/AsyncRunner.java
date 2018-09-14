package nikolov.com.shoecalatogueappandroid.async;

import android.os.AsyncTask;

public interface AsyncRunner {
    void runInBackground(Runnable action);
}
