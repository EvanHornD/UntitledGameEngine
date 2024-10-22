package Engine;

import Engine.userInput.KeyBinds;

public class LevelEditorScene extends Scene {

    private boolean changingScene = false;
    private float timeToChangeScene = .5f;
    private float timer = 0f;

    public LevelEditorScene(){
        System.out.println("Level Editor");
    }

    @Override
    public void update(float dt) {

        System.out.println(""+1.0f/dt+"FPS");
        
        int test = KeyBinds.getActionFrame("test");
        if(test!=0&&!changingScene){
            changingScene = true;
            timer = timeToChangeScene;
            System.out.println(test);
        }
        if(changingScene && timer>0){
            timer-=dt;
            Window.get().r += dt/timeToChangeScene;
            Window.get().g += dt/timeToChangeScene;
            Window.get().b += dt/timeToChangeScene;
        } else  if(changingScene){
            Window.changeScene(1);
        }
    }
}
