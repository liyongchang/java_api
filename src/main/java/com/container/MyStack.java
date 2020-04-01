package com.container;

public class MyStack<E> {
	private Object[] data = null;
	private int capacity; // capacity： 栈的容量
	private int top; // top： 栈顶指针

	MyStack() {
		this(10);
	}

	/**
	 * 初始化栈，声明保存数据的数组大小。
	 * 
	 * @param initialSize
	 *            栈的初始化大小
	 */
	MyStack(int initialSize) {
		if (initialSize >= 0) {
			this.capacity = initialSize;
			data = new Object[initialSize];
			top = 0;
		} else {
			throw new RuntimeException("初始化大小不能小于0：" + initialSize);
		}
	}

	/**
	 * 判断栈是否为空
	 * 
	 * @return
	 */
	boolean empty() {
		return top == 0 ? true : false;
	}

	/**
	 * 获取栈顶元素的内容，但是不弹出
	 * 
	 * @return
	 */
	E peek() {
		return (E) data[top - 1];
	}

	/**
	 * 弹出栈顶元素
	 * 
	 * @return
	 */
	E pop() {
		E e = (E) data[top - 1];
		--top;
		return e;
	}

	/**
	 * 在栈顶插入元素
	 * 
	 * @param e
	 *            待插入的元素
	 * @return
	 */
	boolean push(E e) {
		ensureCapacity();
		data[top] = e;
		++top;
		return true;
	}

	/**
	 * 检查存储数据的数组容量，如果数组已经满，则扩充容量；否则不操作。
	 */
	private void ensureCapacity() {
		int index;
		if (top == capacity) {
			capacity *= 2;
			Object[] newData = new Object[capacity];
			for (index = 0; index < top; ++index) {
				newData[index] = data[index];
			}
			data = newData;
		}
	}

	@Override
	public String toString() {
		String str = "";
		for (int index = 0; index <= top - 1; ++index) {
			str += (data[index] + " ");
		}
		return str;
	}
}
