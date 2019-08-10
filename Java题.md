sleep() wait() yield() join()用法与区别
sleep()方法
       在指定时间内让当前正在执行的线程暂停执行，但不会释放“锁标志”。不推荐使用。sleep()使当前线程进入阻塞状态，在指定时间内不会执行。
wait()方法
       在其他线程调用对象的notify或notifyAll方法前，导致当前线程等待。线程会释放掉它所占有的“锁标志”，从而使别的线程有机会抢占该锁。
　　当前线程必须拥有当前对象锁。如果当前线程不是此锁的拥有者，会抛出　IllegalMonitorStateException异常。
　　唤醒当前对象锁的等待线程使用notify或notifyAll方法，也必须拥有相同的对象锁，否则也会抛出IllegalMonitorStateException异常。
　　waite()和notify()必须在synchronized函数或synchronized block中进行调用。如果在non-synchronized函数或non-synchronized block中进行调用，虽然能编译通过，但在运行时会发生IllegalMonitorStateException的异常。
yield()方法
       暂停当前正在执行的线程对象。yield()只是使当前线程重新回到可执行状态，所以执行yield()的线程有可能在进入到可执行状态后马上又被执行。
　　yield()只能使同优先级或更高优先级的线程有执行的机会。
join()方法
       等待该线程终止。等待调用join方法的线程结束，再继续执行之后的代码。
Java中sleep方法的几个注意点：

Thread.sleep()方法用来暂停线程的执行，将CPU放给线程调度器。
Thread.sleep()方法是一个静态方法，它暂停的是当前执行的线程。
Java有两种sleep方法，一个只有一个毫秒参数，另一个有毫秒和纳秒两个参数。
与wait方法不同，sleep方法不会释放锁
如果其他的线程中断了一个休眠的线程，sleep方法会抛出Interrupted Exception。
休眠的线程在唤醒之后不保证能获取到CPU，它会先进入就绪态，与其他线程竞争CPU。
有一个易错的地方，当调用t.sleep()的时候，会暂停线程t。这是不对的，因为Thread.sleep是一个静态方法，它会使当前线程而不是线程t进入休眠状态。

yield和sleep的区别
       yield和sleep的主要是，yield方法会临时暂停当前正在执行的线程，来让有同样优先级的正在等待的线程有机会执行。如果没有正在等待的线程，或者所有正在等待的线程的优先级都比较低，那么该线程会继续运行。执行了yield方法的线程什么时候会继续运行由线程调度器来决定，不同的厂商可能有不同的行为。
　　yield方法不保证当前的线程会暂停或者停止，但是可以保证当前线程在调用yield方法时会放弃CPU。