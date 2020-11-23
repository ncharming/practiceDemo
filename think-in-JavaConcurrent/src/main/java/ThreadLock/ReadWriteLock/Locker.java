package ThreadLock.ReadWriteLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public enum Locker {
    INSTANCE;

    private static final ReadWriteLock r = new ReentrantReadWriteLock();

    public Lock writeLock() {
        return r.writeLock();
    }

}
