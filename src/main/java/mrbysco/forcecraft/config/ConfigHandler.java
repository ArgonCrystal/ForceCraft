package mrbysco.forcecraft.config;


import mrbysco.forcecraft.ForceCraft;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.BooleanValue;
import net.minecraftforge.common.ForgeConfigSpec.ConfigValue;
import net.minecraftforge.common.ForgeConfigSpec.DoubleValue;
import net.minecraftforge.common.ForgeConfigSpec.IntValue;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.config.ModConfig;
import org.apache.commons.lang3.tuple.Pair;

import java.util.Collections;
import java.util.List;

public class ConfigHandler {
    public static class Common {
        public final BooleanValue generateForceOre;
        public final BooleanValue generateForceTree;
        public final BooleanValue timeTorchEnabled;
        public final BooleanValue timeTorchLogging;
        public final IntValue baconatorMaxStacks;
        public final DoubleValue sturdyDamageReduction;
        public final IntValue forceInfusingTime;
        public final ConfigValue<List<? extends String>> furnaceOutputBlacklist;

        public final IntValue bleedCap;
        public final IntValue healingCap;
        public final IntValue sturdyCap;
        public final IntValue luckCap;
        public final IntValue damageCap;
        public final IntValue forceCap;
        public final IntValue speedCap;
        public final IntValue rodSpeedCap;

        public final BooleanValue ChuChuSpawning;
        public final IntValue ChuChuWeight;
        public final IntValue ChuChuMinGroup;
        public final IntValue ChuChuMaxGroup;

        public final BooleanValue CreeperTotSpawning;
        public final IntValue CreeperTotWeight;
        public final IntValue CreeperTotMinGroup;
        public final IntValue CreeperTotMaxGroup;

        public final BooleanValue EnderTotSpawning;
        public final IntValue EnderTotWeight;
        public final IntValue EnderTotMinGroup;
        public final IntValue EnderTotMaxGroup;

        public final BooleanValue FairySpawning;
        public final IntValue FairyWeight;
        public final IntValue FairyMinGroup;
        public final IntValue FairyMaxGroup;


        Common(ForgeConfigSpec.Builder builder) {
            //General settings
            builder.comment("General settings")
                    .push("general");

            generateForceOre = builder
                    .comment("Enable Force Ore generation. [Default: true]")
                    .define("generateForceOre", true);

            generateForceTree = builder
                    .comment("Enable Force Tree generation. [Default: true]")
                    .define("generateForceTree", true);

            timeTorchEnabled = builder
                    .comment("Enable Time Torch. [Default: true]")
                    .define("timeTorchEnabled", true);

            timeTorchLogging = builder
                    .comment("Print in Log when Time Torch is placed and by who. [Default: true]")
                    .define("timeTorchLogging", true);

            baconatorMaxStacks = builder
                    .comment("The max amount of food stacks stored in the baconator [Default: 4]")
                    .defineInRange("baconatorMaxStacks", 4, 1, Integer.MAX_VALUE);

            sturdyDamageReduction = builder
                    .comment("The max amount of damage blocked when all armor pieces have the Sturdy infusion [Default: 0.75]")
                    .defineInRange("sturdyDamageReduction", 0.75, 0.0, 1.0);

            forceInfusingTime = builder
                    .comment("The max amount of ticks it takes to charge a tool with Force [Default: 120 (6 seconds)]")
                    .defineInRange("forceInfusingTime",120, 20, Integer.MAX_VALUE);

            furnaceOutputBlacklist = builder
                    .comment("An additional list of tile entities the Force Furnace can NOT insert into [Syntax: modid:tile_name]\n" +
                            "Examples: \"minecraft:shulker_box\" would stop it inserting into shulkers")
                    .defineListAllowEmpty(Collections.singletonList("furnaceOutputBlacklist"), () -> Collections.singletonList(""), o -> (o instanceof String));

            builder.pop();
            builder.comment("Infusion settings")
                    .push("infusion");

            bleedCap = builder
                    .comment("The max level of Bleeding that can be applied [Default: 3]")
                    .defineInRange("bleedCap", 3, 1, 5);

            healingCap = builder
                    .comment("The max level of Healing that can be applied [Default: 3]")
                    .defineInRange("healingCap", 3, 1, 5);

            sturdyCap = builder
                    .comment("The max level of Sturdy that can be applied on force tools [Default: 3]")
                    .defineInRange("sturdyToolCap", 3, 1, 10);

            luckCap = builder
                    .comment("The max level of Luck that can be applied [Default: 4]")
                    .defineInRange("luckCap", 4, 1, 10);

            damageCap = builder
                    .comment("The max level of Damage that can be applied [Default: 5]")
                    .defineInRange("luckCap", 5, 1, 10);

            forceCap = builder
                    .comment("The max level of Force that can be applied [Default: 2]")
                    .defineInRange("forceCap", 2, 1, 10);

            speedCap = builder
                    .comment("The max level of Speed that can be applied [Default: 5]")
                    .defineInRange("speedCap", 5, 1, 10);

            rodSpeedCap = builder
                    .comment("The max level of Speed that can be applied to a Force Rod [Default: 3]")
                    .defineInRange("speedCap", 3, 1, 5);

            builder.pop();
            builder.comment("Mob settings")
                    .push("mob");

            ChuChuSpawning = builder
                    .comment("Enable Chu Chu's to spawn [Default: true]")
                    .define("ChuChuSpawning", true);

            ChuChuWeight = builder
                    .comment("Chu Chu spawn weight [Default: 100]")
                    .defineInRange("ChuChuWeight", 100, 1, Integer.MAX_VALUE);

            ChuChuMinGroup = builder
                    .comment("Chu Chu Min Group size [Default: 1]")
                    .defineInRange("ChuChuMinGroup", 1, 1, Integer.MAX_VALUE);

            ChuChuMaxGroup = builder
                    .comment("Chu Chu Max Group size [Default: 1]")
                    .defineInRange("ChuChuMaxGroup", 1, 1, Integer.MAX_VALUE);

            CreeperTotSpawning = builder
                    .comment("Enable Creeper Tot's to spawn [Default: true]")
                    .define("CreeperTotSpawning", true);

            CreeperTotWeight = builder
                    .comment("Creeper Tot spawn weight [Default: 25]")
                    .defineInRange("CreeperTotWeight", 25, 1, Integer.MAX_VALUE);

            CreeperTotMinGroup = builder
                    .comment("Creeper Tot Min Group size [Default: 1]")
                    .defineInRange("CreeperTotMinGroup", 1, 1, Integer.MAX_VALUE);

            CreeperTotMaxGroup = builder
                    .comment("Creeper Tot Max Group size [Default: 1]")
                    .defineInRange("CreeperTotMaxGroup", 2, 1, Integer.MAX_VALUE);

            EnderTotSpawning = builder
                    .comment("Enable Ender Tot's to spawn [Default: true]")
                    .define("CreeperTotSpawning", true);

            EnderTotWeight = builder
                    .comment("Ender Tot spawn weight [Default: 5]")
                    .defineInRange("CreeperTotWeight", 5, 1, Integer.MAX_VALUE);

            EnderTotMinGroup = builder
                    .comment("Ender Tot Min Group size [Default: 1]")
                    .defineInRange("CreeperTotMinGroup", 1, 1, Integer.MAX_VALUE);

            EnderTotMaxGroup = builder
                    .comment("Ender Tot Max Group size [Default: 1]")
                    .defineInRange("CreeperTotMaxGroup", 1, 1, Integer.MAX_VALUE);

            FairySpawning = builder
                    .comment("Enable Fairy's to spawn [Default: true]")
                    .define("FairySpawning", true);

            FairyWeight = builder
                    .comment("Fairy spawn weight [Default: 4]")
                    .defineInRange("FairyWeight", 4, 1, Integer.MAX_VALUE);

            FairyMinGroup = builder
                    .comment("Fairy Min Group size [Default: 1]")
                    .defineInRange("FairyMinGroup", 1, 1, Integer.MAX_VALUE);

            FairyMaxGroup = builder
                    .comment("Fairy Max Group size [Default: 1]")
                    .defineInRange("FairyMaxGroup", 2, 1, Integer.MAX_VALUE);

            builder.pop();
        }
    }

    public static final ForgeConfigSpec commonSpec;
    public static final Common COMMON;

    static {
        final Pair<Common, ForgeConfigSpec> specPair = new ForgeConfigSpec.Builder().configure(Common::new);
        commonSpec = specPair.getRight();
        COMMON = specPair.getLeft();
    }


    @SubscribeEvent
    public static void onLoad(final ModConfig.Loading configEvent) {
        ForceCraft.LOGGER.debug("Loaded ForceCraft's config file {}", configEvent.getConfig().getFileName());
    }

    @SubscribeEvent
    public static void onFileChange(final ModConfig.Reloading configEvent) {
        ForceCraft.LOGGER.fatal("ForceCraft's config just got changed on the file system!");
    }
}


