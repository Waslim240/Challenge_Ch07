package waslim.binar.andlima.challengech06v10.roomdatabase

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import junit.framework.TestCase
import org.junit.Assert.*

import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class FilmDatabaseTest : TestCase(){
    private lateinit var db : FilmDatabase
    private lateinit var dao : FilmDao

    @Before
    public override fun setUp() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(context, FilmDatabase::class.java).build()
        dao = db.filmDao()
    }

    @After
    public override fun tearDown() {
        db.close()
    }

    @Test
    fun filmDao() {
        val result = dao.getAllFilm()
    }
}