package com.container;

public class MyStack<E> {
	private Object[] data = null;
	private int capacity; // capacity�� ջ������
	private int top; // top�� ջ��ָ��

	MyStack() {
		this(10);
	}

	/**
	 * ��ʼ��ջ�������������ݵ������С��
	 * 
	 * @param initialSize
	 *            ջ�ĳ�ʼ����С
	 */
	MyStack(int initialSize) {
		if (initialSize >= 0) {
			this.capacity = initialSize;
			data = new Object[initialSize];
			top = 0;
		} else {
			throw new RuntimeException("��ʼ����С����С��0��" + initialSize);
		}
	}

	/**
	 * �ж�ջ�Ƿ�Ϊ��
	 * 
	 * @return
	 */
	boolean empty() {
		return top == 0 ? true : false;
	}

	/**
	 * ��ȡջ��Ԫ�ص����ݣ����ǲ�����
	 * 
	 * @return
	 */
	E peek() {
		return (E) data[top - 1];
	}

	/**
	 * ����ջ��Ԫ��
	 * 
	 * @return
	 */
	E pop() {
		E e = (E) data[top - 1];
		--top;
		return e;
	}

	/**
	 * ��ջ������Ԫ��
	 * 
	 * @param e
	 *            �������Ԫ��
	 * @return
	 */
	boolean push(E e) {
		ensureCapacity();
		data[top] = e;
		++top;
		return true;
	}

	/**
	 * ���洢���ݵ�������������������Ѿ��������������������򲻲�����
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
