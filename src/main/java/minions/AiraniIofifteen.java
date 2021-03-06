package minions;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.helpers.FontHelper;
import com.megacrit.cardcrawl.localization.OrbStrings;
import com.megacrit.cardcrawl.vfx.combat.DarkOrbActivateEffect;

public class AiraniIofifteen extends AbstractMinion {
    private static final String ID = "Hololive_AiraniIofifteen";
    private static final OrbStrings cardStrings = CardCrawlGame.languagePack.getOrbString(ID);
    private static final String NAME = cardStrings.NAME;
    private static final String[] DESCRIPTION = cardStrings.DESCRIPTION;
    private static final String IMG_PATH = "img/Orbs/AiraniIofifteen.png";
    private static final int basePassiveAmount = 3;
    private static final int baseEvokeAmount = 3;
    private static final int originalHP = 8;
    private static final int originalATK = 2;
    public AiraniIofifteen(boolean upgraded){
        super(ID,NAME,basePassiveAmount,baseEvokeAmount,originalHP,IMG_PATH,DESCRIPTION[0],DESCRIPTION[1]);
        this.upgraded = upgraded;
        this.ATK = originalATK;
    }

    public AbstractMinion makeCopy(){
        return new AiraniIofifteen(this.upgraded);
    }

    @Override
    public void onEvoke(){
        super.onEvoke();
    }

    @Override
    public void triggerEvokeAnimation(){
        CardCrawlGame.sound.play("ORB_DARK_EVOKE", 0.1F);
        AbstractDungeon.effectsQueue.add(new DarkOrbActivateEffect(this.cX, this.cY));
    }


    @Override
    public void onEndOfTurn(){
        this.AttackEffect();
    }

    @Override
    public void AttackEffect(){
        Attack(AbstractGameAction.AttackEffect.SHIELD);
        Trigger();
        super.AttackEffect();
    }


    @Override
    public void renderText(SpriteBatch sb){
        FontHelper.renderFontCentered(sb, FontHelper.cardEnergyFont_L, "|" , this.cX - NUM_X_OFFSET * 2 - 20, this.cY + this.bobEffect.y / 2.0F + NUM_Y_OFFSET * 2, new Color(0.6F,0.8F,1.0F,1.0F), this.fontScale);
        FontHelper.renderFontCentered(sb, FontHelper.cardEnergyFont_L, "|" , this.cX - NUM_X_OFFSET * 2 - 20, this.cY + this.bobEffect.y / 2.0F, new Color(0.6F,0.8F,1.0F,1.0F), this.fontScale);
        FontHelper.renderFontCentered(sb, FontHelper.cardEnergyFont_L, "|" , this.cX - NUM_X_OFFSET * 2 - 20, this.cY + this.bobEffect.y / 2.0F - NUM_Y_OFFSET * 2, new Color(0.6F,0.8F,1.0F,1.0F), this.fontScale);
        super.renderText(sb);
    }

    public void playChannelSFX(){
        CardCrawlGame.sound.play("ORB_LIGHTNING_CHANNEL", 0.1F);
    }
}
