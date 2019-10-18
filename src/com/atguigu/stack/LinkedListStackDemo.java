package com.atguigu.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LinkedListStackDemo {

	public static void main(String[] args) {
		// 测试一下ArrayStack 是否正确
		// 先创建一个ArrayStack对象->表示栈
		LinkedListStack stack = new LinkedListStack(4);
		String key = "";
		boolean loop = true; // 控制是否退出菜单
		Scanner scanner = new Scanner(System.in);

		while (loop) {
			System.out.println("show: 表示显示栈");
			System.out.println("exit: 退出程序");
			System.out.println("push: 表示添加数据到栈(入栈)");
			System.out.println("pop: 表示从栈取出数据(出栈)");
			System.out.println("请输入你的选择");
			key = scanner.next();
			switch (key) {
			case "show":
				stack.list();
				break;
			case "push":
				System.out.println("请输入一个数");
				int value = scanner.nextInt();
				stack.push(value);
				break;
			case "pop":
				try {
					int res = stack.pop();
					System.out.printf("出栈的数据是 %d\n", res);
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

		System.out.println("程序退出~~~");
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

	// 栈满
	public boolean isFull() {
		return top == maxSize;
	}

	// 栈空
	public boolean isEmpty() {
		return top == -1;
	}

	// 入栈 push
	public void push(int value) {
		if (isFull()) {
			System.out.println("栈满~~");
			return;
		}
		top++;
		stack.add(value);
	}

	// 出栈
	public int pop() {
		if (isEmpty()) {
			throw new RuntimeException("栈空，没有数据~");
		}
		int value = stack.get(top);
		top--;
		return value;
	}

	public void list() {
		if (isEmpty()) {
			System.out.println("栈空，没有数据~~");
			return;
		}
		for (int i = top; i >= 0; i--) {
			System.out.printf("stack[%d]= %d\n", i, stack.get(i));
		}
	}
}
