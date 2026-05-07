package net.nanaky.ultimate_horseshoes.compat;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class LegacyMigration {

    private static final Logger LOGGER =
            LoggerFactory.getLogger("ultimate_horseshoes/LegacyMigration");

    private static final String OLD_NS = "horseshoes";
    private static final String NEW_NS = "ultimate_horseshoes";

    private LegacyMigration() {}

    public static void register() {
        String[] items = {
            "copper_horseshoes",
            "iron_horseshoes",
            "golden_horseshoes",
            "diamond_horseshoes",
            "netherite_horseshoes"
        };

        for (String path : items) {
            Identifier oldId = Identifier.fromNamespaceAndPath(OLD_NS, path);
            Identifier newId = Identifier.fromNamespaceAndPath(NEW_NS, path);
            BuiltInRegistries.ITEM.addAlias(oldId, newId);
        }

        LOGGER.info("[UltimateHorseshoes] Registered legacy '{}' item aliases.", OLD_NS);
    }
}