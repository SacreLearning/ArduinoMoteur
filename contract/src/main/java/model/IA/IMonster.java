package model.IA;

import model.element.Monster;
import model.map.Map;

public interface IMonster {
	
	/**
	 * Design Pattern strategy for the monster behavior
	 * @param monster	Monster AI
	 * @param map		Map for AI
	 */
	public void monsterBehavior(Monster monster, Map map);
}
