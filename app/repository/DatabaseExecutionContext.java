package repository;

import akka.actor.ActorSystem;
import play.libs.concurrent.CustomExecutionContext;
import scala.concurrent.ExecutionContext;

import javax.inject.Inject;

/**
 * Custom execution context wired to "database.dispatcher" thread pool
 */
public class DatabaseExecutionContext extends CustomExecutionContext {

    private static final String name = "database.dispatcher";
    
    public DatabaseExecutionContext(ActorSystem actorSystem, String name) {
	super(actorSystem, name);
    }
    
    @Inject
    public DatabaseExecutionContext(ActorSystem actorSystem) {
	super(actorSystem, "database.dispatcher");
    }

    @Override
    public ExecutionContext prepare() {
	return super.prepare();
    }

    @Override
    public void execute(Runnable command) {
	super.execute(command);
    }

    @Override
    public void reportFailure(Throwable cause) {
	super.reportFailure(cause);
    }
}