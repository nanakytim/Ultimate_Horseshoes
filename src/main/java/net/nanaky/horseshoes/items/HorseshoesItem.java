package net.nanaky.horseshoes.items;

import net.minecraft.resources.Identifier;
import net.minecraft.tags.TagKey;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class HorseshoesItem extends Item {

    private final float speedBonus;
    private final float jumpBonus;
    private final float armorBonus;
    private final Identifier entityTexture;

    public HorseshoesItem(float speedBonus, float jumpBonus, float armorBonus,
                        Properties settings, Identifier entityTexture) {
        super(settings);
        this.speedBonus = speedBonus;
        this.jumpBonus = jumpBonus;
        this.armorBonus = armorBonus;
        this.entityTexture = entityTexture;
    }

    @Override
    public InteractionResult use(Level world, Player user, InteractionHand hand) {
        return InteractionResult.PASS;
    }

    public float getSpeedBonus() { return speedBonus; }
    public float getJumpBonus() { return jumpBonus; }
    public float getArmorBonus() { return armorBonus; }
    public Identifier getEntityTexture() { return entityTexture; }
}