package com.atguigu.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LinkedListStackDemo {

	public static void main(String[] args) {
		// ����һ��ArrayStack �Ƿ���ȷ
		// �ȴ���һ��ArrayStack����->��ʾջ
		LinkedListStack stack = new LinkedListStack(4);
		String key = "";
		boolean loop = true; // �����Ƿ��˳��˵�
		Scanner scanner = new Scanner(System.in);

		while (loop) {
			System.out.println("show: ��ʾ��ʾջ");
			System.out.println("exit: �˳�����");
			System.out.println("push: ��ʾ������ݵ�ջ(��ջ)");
			System.out.println("pop: ��ʾ��ջȡ������(��ջ)");
			System.out.println("���������ѡ��");
			key = scanner.next();
			switch (key) {
			case "show":
				stack.list();
				break;
			case "push":
				System.out.println("������һ����");
				int value = scanner.nextInt();
				stack.push(value);
				break;
			case "pop":
				try {
					int res = stack.pop();
					System.out.printf("��ջ�������� %d\n", res);
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println(e.getMessage());
				}
				break;
			case "exit":
				scanner.close();
				loop = false;
				break;
			default:
				break;
			}
		}

		System.out.println("�����˳�~~~");
	}

}

class LinkedListStack {
	private int maxSize;
	private List<Integer> stack;
	private int top = -1;

	public LinkedListStack(int maxSize) {
		this.maxSize = maxSize;
		stack = new ArrayList<Integer>(this.maxSize);
	}

	// ջ��
	public boolean isFull() {
		return top == maxSize;
	}

	// ջ��
	public boolean isEmpty() {
		return top == -1;
	}

	// ��ջ push
	public void push(int value) {
		if (isFull()) {
			System.out.println("ջ��~~");
			return;
		}
		top++;
		stack.add(value);
	}

	// ��ջ
	public int pop() {
		if (isEmpty()) {
			throw new RuntimeException("ջ�գ�û������~");
		}
		int value = stack.get(top);
		top--;
		return value;
	}

	public void list() {
		if (isEmpty()) {
			System.out.println("ջ�գ�û������~~");
			return;
		}
		for (int i = top; i >= 0; i--) {
			System.out.printf("stack[%d]= %d\n", i, stack.get(i));
		}
	}
}
