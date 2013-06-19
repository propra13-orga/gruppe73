package dungeoncrawler;


public class Gegner {

	public static void trap_collision() {
		String Current_LevelMap = LoadLevel.Current_LevelMap;
		if (Current_LevelMap.charAt(CollisionControl.PlyPosUmrechnen()) == 'S' | Current_LevelMap.charAt(CollisionControl.PlyPosUmrechnen()) == 'N'){
			BuildLevel.GameOver(null);
		}
	}
	

}
