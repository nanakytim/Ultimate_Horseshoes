package net.nanaky.horseshoes;

import net.minecraft.world.SimpleContainer;

/**
 * Duck-typing interface applied to AbstractHorse via mixin.
 * Lets other mixins access the horseshoe container without shadowing.
 */
public interface IHorseshoesContainer {
    SimpleContainer horseshoes$getContainer();
}