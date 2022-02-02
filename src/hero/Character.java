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
		System.out.println("레벨업 하였습니다.");
		return this.level + 1;
	}
	
	public void death() {
		System.out.println("사망하였습니다.");
	}
	
	public boolean use_skill(int cost_mp) {
		if(this.mp < cost_mp) {
			System.out.println("mp가 부족합니다.");
			return false;
		}
		this.mp -= cost_mp;
		System.out.println(cost_mp + "의 mp를 사용합니다.");
		return true;
	}
	
	public boolean avoid(int dodge) {
		if(Math.random() > dodge) {
			return false;
		}
		System.out.println("몬스터의 공격을 회피했습니다.");
		return true;
	}
	
	public void skill_heal() {
		int heal = 30;
		int cost_mp = 20;
		boolean check_mp = use_skill(cost_mp);
		if(check_mp == true) {
			System.out.println("스킬:힐을 사용합니다.");
			if(this.max_hp <= (this.hp+heal)) {
				this.hp = this.max_hp;
				System.out.println((this.max_hp - this.hp) + "만틈 회복했습니다.");
			}
			if(this.max_hp > (this.hp+heal)) {
				this.hp += heal;
				System.out.println(heal + "만큼 회복했습니다.");
			}
		}
	}
	// 전투 종료시 원래 능력치로 돌아와야 함.
	public void skill_steam() {
		int cost_mp = 30;
		double steam = 0.2;
		boolean check_mp = use_skill(cost_mp);
		if (check_mp == true) {
			System.out.println("스킬:스팀을 사용합니다.");
			this.strength += (strength * steam);
			System.out.println("공격력이" + (steam * 100) + "% 증가했습니다.");
		}
	}
}
