package model.IA;

import model.element.Monster;
import model.map.Map;

public class Arbarr implements IMonster{
	
	/**
	 * Get monster behavior
	 * @param monster The monster AI
	 * @param map	Map to react with the AI
	 */
	@Override
	public void monsterBehavior(Monster monster, Map map) {
		int x = monster.getPosition().x + (monster.random.nextInt() % 2);
		int y = monster.getPosition().y + (monster.random.nextInt() % 2);
		
		if(map.getElement(y, x).getSprite() == ' ') {
			monster.getPosition().x = x;
			monster.getPosition().y = y;
		}
		
        if (monster.getPosition().x < 0) {
        	monster.getPosition().x = 0;
        }
        if (monster.getPosition().x > map.getRows()) {
        	monster.getPosition().x = map.getRows() - 1;
        }
        if (monster.getPosition().y < 0) {
        	monster.getPosition().y = 0;
        }
        if (monster.getPosition().y > map.getColumns()) {
        	monster.getPosition().y = map.getColumns() - 1;
        }
	}

}
