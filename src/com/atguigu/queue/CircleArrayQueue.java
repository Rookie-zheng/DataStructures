package com.atguigu.queue;

import java.util.Scanner;

public class CircleArrayQueue {

	public static void main(String[] args) {
		
		//����
		System.out.println("��������ģ�⻷�ζ��еİ���");
		//����һ������
		CircleArray queue = new CircleArray(4); //˵������4������Ч���е���Ч����Ϊ3
		char key = ' '; //�����û�����
		Scanner scanner = new Scanner(System.in);
		boolean loop = true;
		//���һ���˵�
		while(loop) {
			System.out.println("s(show): ��ʾ����");
			System.out.println("e(exit): �˳�����");
			System.out.println("a(add): ������ݵ�����");
			System.out.println("g(get): �Ӷ���ȡ������");
			System.out.println("h(head): �鿴����ͷ������");
			key = scanner.next().charAt(0);//����һ���ַ�
			switch (key) {
			case 's':
				queue.showQueue();
				break;
			case 'a':
				System.out.println("������һ����");
				int value = scanner.nextInt();
				queue.addQueue(value);
				break;
			case 'g':
				try {
					int res = queue.getQueue();
					System.out.printf("ȡ����������%d\n", res);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case 'h':
				try {
					int res = queue.headQueue();
					System.out.printf("����ͷ��������%d\n", res);
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println(e.getMessage());
				}
				break;
			case 'e':
				scanner.close();
				loop = false;
				break;
			default:
				break;
			}
		}
		System.out.println("�����˳�");		
	}
}

class CircleArray{
	private int maxSize; // ��ʾ������������
	//front �����ĺ�����һ��������front ��ָ����еĵ�һ��Ԫ�أ�Ҳ����˵arr[front]
	//front �ĳ�ʼֵ = 0
	private int front; //����ͷ
	//rear �����ĺ�����һ��������rear ָ����е����һ��Ԫ�صĺ�һ��λ�ã���Ϊϣ���ճ�
	//rear �ĳ�ʼֵ = 0
	private int rear; //����β
	private int[] arr; //���������ڴ�����ݣ�ģ�����
	
	public CircleArray(int arrMaxSize) {
		maxSize = arrMaxSize;
		arr = new int[maxSize];
	}
	
	//�ж϶����Ƿ���
	public boolean isFull() {
		return (rear + 1) % maxSize == front;
	}
	
	//�ж϶����Ƿ�Ϊ��
	public boolean isEmpty() {
		return rear == front;
	}
	
	//������ݵ�����
	public void addQueue(int n) {
		//�ж϶����Ƿ���
		if(isFull()) {
			System.out.println("�����������ܼ�������~");
			return;
		}
		//ֱ�ӽ����ݼ���
		arr[rear] = n;
		//�� rear ���ƣ�������뿼��ȡģ
		rear = (rear + 1) % maxSize;
	}
	
	//��ȡ���е����ݣ�������
	public int getQueue() {
		//�ж϶����Ƿ�Ϊ��
		if(isEmpty()) {
			//ͨ���׳��쳣
			throw new RuntimeException("���пգ�����ȥ����");
		}
		// ������Ҫ������ front ��ָ����еĵ�һ��Ԫ��
		// 1. �Ƚ� front ��Ӧ��ֵ������һ����ʱ����
		// 2. �� front ����,����ȡģ
		// 3. ����ʱ����ı�������
		int value = arr[front];
		front = (front + 1) % maxSize;
		return value;
	}
	
	//��ʾ���е���������
	public void showQueue() {
		if(isEmpty()) {
			System.out.println("���пյģ�û������~");
			return;
		}
		// ˼·����front��ʼ�������������ٸ�Ԫ��
		for(int i = front; i < front + size(); i++) {
			System.out.printf("arr[%d]=%d\n", i % maxSize, arr[i % maxSize]);
		}
	}
	
	//�����ǰ������Ч���ݵĸ���
	public int size() {
		return (rear + maxSize - front) % maxSize;
	}
	
	//��ʾ���е�ͷԪ�أ�ע�ⲻ��ȡ������
	public int headQueue() {
		//�ж�
		if(isEmpty()) {
			throw new RuntimeException("���пյģ�û������~~");
		}
		return arr[front];
	}
}
