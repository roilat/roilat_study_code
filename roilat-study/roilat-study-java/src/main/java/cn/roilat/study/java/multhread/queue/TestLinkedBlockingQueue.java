/**
 * 
 */
package cn.roilat.study.java.multhread.queue;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author roilat-D TestLinkedBlockingQueue.java
 */
public class TestLinkedBlockingQueue {

	public static void main(String[] args) {

		/**
		 * add和remove对应，当无法队列已满/没有数据时，分别抛出异常 put和take对应，当无法队列已满/没有数据时，都会进行阻塞
		 * offer和poll对应，当无法队列已满/没有数据时，分别返回false和null,两者都可以增加一个入参，在有限时间内阻塞等待，超时仍未取得数据则返回false和null.
		 */
		InvokeHandler handler = getInvokeHandler();
		testAdd(handler);
		testPut(handler);
		testOffer(handler);
		testRemove(handler);
		testTake(handler);
		testPoll(handler);
	}

	public static InvokeHandler getInvokeHandler() {
		return new TestLinkedBlockingQueue().generateInvokeHandler();
	}

	public InvokeHandler generateInvokeHandler() {
		return new InvokeHandler() {
			@Override
			public void invoke(InvokeTask task) {
				task.run();
				while (Thread.activeCount() > 1)
					;
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
	}

	/**
	 * Inserts the specified element into this queue if it is possible to do so
	 * immediately without violating capacity restrictions, returning true upon
	 * success and throwing an IllegalStateException if no space is currently
	 * available.
	 * 
	 * This implementation returns true if offer succeeds, else throws an
	 * IllegalStateException. dd方法在添加元素的时候，若超出了度列的长度会直接抛出异常：
	 */
	public static void testAdd(InvokeHandler handler) {
		handler.invoke(new InvokeTask() {
			@Override
			public void run() {
				System.out.println("test LinkedBlockingQueue.add");
				try {
					LinkedBlockingQueue<String> queue = new LinkedBlockingQueue<String>(2);
					/**
					 * public boolean add(E e) { if (offer(e)) return true; else throw new
					 * IllegalStateException("Queue full"); }
					 */
					queue.add("hello");
					queue.add("world");
					queue.add("yes");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	/**
	 * Inserts the specified element at the tail of this queue, waiting if necessary
	 * for space to become available. 对于put方法，若向队尾添加元素的时候发现队列已经满了会发生阻塞一直等待空间，以加入元素。
	 */

	public static void testPut(InvokeHandler handler) {
		handler.invoke(new InvokeTask() {
			@Override
			public void run() {
				System.out.println("test LinkedBlockingQueue.put");
				try {
					LinkedBlockingQueue<String> queue = new LinkedBlockingQueue<String>(2);
					new Thread() {

						@Override
						public void run() {
							try {
								Thread.sleep(5000);
								System.out.println("sub Thread remove:" + queue.take());
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}

					}.start();
					queue.put("hello");
					queue.put("world");
					queue.put("yes");

					System.out.println("main end and the queue content is=" + queue.toString());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	/**
	 * Inserts the specified element at the tail of this queue if it is possible to
	 * do so immediately without exceeding the queue's capacity, returning true upon
	 * success and false if this queue is full. When using a capacity-restricted
	 * queue, this method is generally preferable to method add, which can fail to
	 * insert an element only by throwing an exception.
	 * offer方法在添加元素时，如果发现队列已满无法添加的话，会直接返回false。
	 */
	public static void testOffer(InvokeHandler handler) {
		handler.invoke(new InvokeTask() {
			@Override
			public void run() {
				System.out.println("test LinkedBlockingQueue.offer");
				try {
					LinkedBlockingQueue<String> queue = new LinkedBlockingQueue<String>(2);

					boolean bol1 = queue.offer("hello");
					boolean bol2 = queue.offer("world");
					boolean bol3 = queue.offer("yes");

					System.out.println("the queue content:" + queue.toString());
					System.out.println(bol1);
					System.out.println(bol2);
					System.out.println(bol3);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	/**
	 * 若队列为空，抛出NoSuchElementException异常。
	 */
	public static void testRemove(InvokeHandler handler) {
		handler.invoke(new InvokeTask() {
			@Override
			public void run() {
				System.out.println("test LinkedBlockingQueue.remove");
				try {
					LinkedBlockingQueue<String> queue = new LinkedBlockingQueue<String>(2);

					queue.add("hello");
					queue.add("world");

					System.out.println("the queue content:" + queue.toString());
					System.out.println("remove 1:" + queue.remove());
					System.out.println("remove 2:" + queue.remove());
					System.out.println("remove 3:" + queue.remove());// 抛出异常
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	/**
	 * 若队列为空，发生阻塞，等待有元素。
	 */
	public static void testTake(InvokeHandler handler) {
		handler.invoke(new InvokeTask() {
			@Override
			public void run() {
				System.out.println("test LinkedBlockingQueue.take");
				try {
					LinkedBlockingQueue<String> queue = new LinkedBlockingQueue<String>(2);

					queue.put("hello");
					queue.put("world");
					new Thread() {// 另一线程等待5秒放入数据

						@Override
						public void run() {
							try {
								Thread.sleep(5000);
								queue.put("yes");
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}

					}.start();
					System.out.println("the queue content:" + queue.toString());
					System.out.println("take 1:" + queue.take());
					System.out.println("take 2:" + queue.take());
					System.out.println("after 5 second, queue.take=" + queue.take());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * 若队列为空，返回null。
	 */
	public static void testPoll(InvokeHandler handler) {
		handler.invoke(new InvokeTask() {
			@Override
			public void run() {
				System.out.println("test LinkedBlockingQueue.poll");
				try {
					LinkedBlockingQueue<String> queue = new LinkedBlockingQueue<String>(2);

					boolean bol1 = queue.offer("hello");
					boolean bol2 = queue.offer("world");
					boolean bol3 = queue.offer("yes");

					System.out.println("the queue content:" + queue.toString());

					System.out.println("offer 1:" + bol1);
					System.out.println("offer 2:" + bol2);
					System.out.println("offer 3:" + bol3);// false
					System.out.println("poll 1:" + queue.poll());
					System.out.println("poll 2:" + queue.poll());
					System.out.println("poll 3:" + queue.poll());// null
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public interface InvokeTask {
		void run();
	}

	public interface InvokeHandler {
		void invoke(InvokeTask task);
	}

}
