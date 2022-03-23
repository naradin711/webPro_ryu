package com.lec.ex04_actor;

public class Actor implements IFireFighter, IPoliceman, IChef {
	 private String name;
	 public Actor(String name) {
		   this.name = name;
	 }
	@Override
	public void makePizza() {
		System.out.println(name+"�� ���ڸ� ���� �� �ֽ��ϴ�.");
	}

	@Override
	public void makeSpagetti() {
		System.out.println(name+"�� ���İ�Ƽ�� ���� �� �ֽ��ϴ�.");
	}

	@Override
	public void catchPrisoner() {
		System.out.println(name+"�� ������ ���� �� �ֽ��ϴ�.");
	}

	@Override
	public void canSearch() {
		System.out.println(name+"�� ������ ã�� �� �ֽ��ϴ�.");
	}

	@Override
	public void outFire() {
		System.out.println(name+"�� ���� �� �� �ֽ��ϴ�.");
	}

	@Override
	public void saveMan() {
		System.out.println(name+"�� ����� ���� �� �ֽ��ϴ�.");
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	
}
