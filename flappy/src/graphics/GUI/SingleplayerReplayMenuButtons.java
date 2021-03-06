package graphics.GUI;

import graphics.Screen;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.gui.AbstractComponent;
import org.newdawn.slick.gui.MouseOverArea;
import resources.PathHandler;
import resources.Resource;
import resources.ResourcePack;
import states.menu.SingleplayerReplayMenu;

/**
 * GUI che si occupa dei bottoni dello stato SinglePlayerReplayMenu
 */

public class SingleplayerReplayMenuButtons extends AbstractMenuGUI {

    private MouseOverArea replayButton;
    private MouseOverArea backButton;
    private SingleplayerReplayMenu state;

    public SingleplayerReplayMenuButtons(GameContainer container, Screen screen, SingleplayerReplayMenu state) throws SlickException {
        super(container, screen);
        this.state=state;

        int buttonHeight = container.getHeight()/10;
        int buttonWidth = container.getWidth()/3;

        Image replayImage = new Image(PathHandler.getInstance().getPath(ResourcePack.BUTTON, Resource.PLAYAGAINBUTTON)).getScaledCopy(buttonWidth, buttonHeight);
        replayButton = new MouseOverArea(container, replayImage, container.getWidth()-3*buttonWidth, container.getHeight()-2*buttonHeight, buttonWidth, buttonHeight, this);

        Image backImage = new Image(PathHandler.getInstance().getPath(ResourcePack.BUTTON, Resource.BACKTOMENUBUTTON)).getScaledCopy(buttonWidth, buttonHeight);
        backButton = new MouseOverArea(container, backImage, container.getWidth()-buttonWidth, container.getHeight()-2*buttonHeight, buttonWidth, buttonHeight, this);

        addButton(replayButton);
        addButton(backButton);
    }

    public void render(){
        renderButtons();
    }

    @Override
    public void componentActivated(AbstractComponent source) {
        if (source == backButton)
            state.noRematch();

        else if (source == replayButton)
            state.rematch();
    }
}
