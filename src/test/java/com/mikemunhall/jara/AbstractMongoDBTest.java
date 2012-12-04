package com.mikemunhall.jara;

import com.mongodb.Mongo;
import de.flapdoodle.embed.mongo.MongodExecutable;
import de.flapdoodle.embed.mongo.MongodProcess;
import de.flapdoodle.embed.mongo.MongodStarter;
import de.flapdoodle.embed.mongo.config.MongodConfig;
import de.flapdoodle.embed.mongo.distribution.Version;
import de.flapdoodle.embed.process.runtime.Network;
import org.testng.annotations.*;

public abstract class AbstractMongoDBTest {

    private MongodExecutable _mongodExe;
    private MongodProcess _mongod;
    private Mongo _mongo;

    @BeforeTest
    protected void setUpMongo() throws Exception {
        MongodStarter runtime = MongodStarter.getDefaultInstance();
        _mongodExe = runtime.prepare(new MongodConfig(Version.Main.V2_0, 12345, Network.localhostIsIPv6()));
        _mongod = _mongodExe.start();

        _mongo = new Mongo("localhost", 12345);
    }

    @AfterTest()
    protected void tearDownMongo() throws Exception {

        _mongod.stop();
        _mongodExe.cleanup();
    }

    public Mongo getMongo() {
        return _mongo;
    }
}