package hero;

abstract class Character {
	public int level;
	public final int MAX_LEVEL = 99;
	public int hp;
	public int max_hp;
	public int mp;
	public int max_mp;
	public int strength;
	public int attack_speed;
	public int defense;
	public int dodge;
	public boolean using_weapon;
	
	abstract void ultimate();
	
	abstract void primary();
	
	public int level_Up(int current_level) {
		System.out.println("������ �Ͽ����ϴ�.");
		return this.level + 1;
	}
	
	public void death() {
		System.out.println("����Ͽ����ϴ�.");
	}
	
	public boolean use_skill(int cost_mp) {
		if(this.mp < cost_mp) {
			System.out.println("mp�� �����մϴ�.");
			return false;
		}
		this.mp -= cost_mp;
		System.out.println(cost_mp + "�� mp�� ����մϴ�.");
		return true;
	}
	
	public boolean avoid(int dodge) {
		if(Math.random() > dodge) {
			return false;
		}
		System.out.println("������ ������ ȸ���߽��ϴ�.");
		return true;
	}
	
	public void skill_heal() {
		int heal = 30;
		int cost_mp = 20;
		boolean check_mp = use_skill(cost_mp);
		if(check_mp == true) {
			System.out.println("��ų:���� ����մϴ�.");
			if(this.max_hp <= (this.hp+heal)) {
				this.hp = this.max_hp;
				System.out.println((this.max_hp - this.hp) + "��ƴ ȸ���߽��ϴ�.");
			}
			if(this.max_hp > (this.hp+heal)) {
				this.hp += heal;
				System.out.println(heal + "��ŭ ȸ���߽��ϴ�.");
			}
		}
	}
	// ���� ����� ���� �ɷ�ġ�� ���ƿ;� ��.
	public void skill_steam() {
		int cost_mp = 30;
		double steam = 0.2;
		boolean check_mp = use_skill(cost_mp);
		if (check_mp == true) {
			System.out.println("��ų:������ ����մϴ�.");
			this.strength += (strength * steam);
			System.out.println("���ݷ���" + (steam * 100) + "% �����߽��ϴ�.");
		}
	}
}
