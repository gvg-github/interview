package ru.interview.lesson_third.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by GVG on 18.10.2018.
 */
class Counter {
    private long counter = 0L;
    private Lock lock = new ReentrantLock();

    public synchronized void increaseCounter() {
        try {
            if (lock.tryLock(10, TimeUnit.SECONDS)) {
                counter++;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public long getCounter() {
        return counter;
    }
}

