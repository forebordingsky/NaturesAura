package de.ellpeck.naturesaura.recipes;

import de.ellpeck.naturesaura.Helper;
import de.ellpeck.naturesaura.NaturesAura;
import de.ellpeck.naturesaura.api.NaturesAuraAPI;
import de.ellpeck.naturesaura.api.recipes.AltarRecipe;
import de.ellpeck.naturesaura.api.recipes.AnimalSpawnerRecipe;
import de.ellpeck.naturesaura.api.recipes.OfferingRecipe;
import de.ellpeck.naturesaura.api.recipes.TreeRitualRecipe;
import de.ellpeck.naturesaura.api.recipes.ing.AmountIngredient;
import de.ellpeck.naturesaura.api.recipes.ing.NBTIngredient;
import de.ellpeck.naturesaura.blocks.ModBlocks;
import de.ellpeck.naturesaura.chunk.effect.AnimalEffect;
import de.ellpeck.naturesaura.chunk.effect.CacheRechargeEffect;
import de.ellpeck.naturesaura.chunk.effect.PlantBoostEffect;
import de.ellpeck.naturesaura.items.ItemAuraBottle;
import de.ellpeck.naturesaura.items.ItemEffectPowder;
import de.ellpeck.naturesaura.items.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFlower;
import net.minecraft.block.BlockStoneBrick;
import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.passive.*;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.oredict.OreDictionary;

import java.util.function.Function;

public final class ModRecipes {

    public static void init() {
        new TreeRitualRecipe(new ResourceLocation(NaturesAura.MOD_ID, "eye"),
                Ingredient.fromStacks(new ItemStack(Blocks.SAPLING)), new ItemStack(ModItems.EYE), 250,
                Ingredient.fromItem(Items.SPIDER_EYE),
                Ingredient.fromItem(Items.GOLD_INGOT),
                Ingredient.fromItem(ModItems.GOLD_LEAF),
                Ingredient.fromItem(ModItems.GOLD_LEAF)).register();
        new TreeRitualRecipe(new ResourceLocation(NaturesAura.MOD_ID, "eye_improved"),
                Ingredient.fromStacks(new ItemStack(Blocks.SAPLING)), new ItemStack(ModItems.EYE_IMPROVED), 500,
                Ingredient.fromItem(ModItems.EYE),
                Ingredient.fromItem(ModItems.SKY_INGOT),
                Ingredient.fromItem(ModItems.SKY_INGOT),
                Helper.blockIng(ModBlocks.END_FLOWER),
                Ingredient.fromItem(ModItems.GOLD_LEAF),
                Ingredient.fromItem(ModItems.GOLD_LEAF)).register();
        new TreeRitualRecipe(new ResourceLocation(NaturesAura.MOD_ID, "nature_altar"),
                Helper.blockIng(Blocks.SAPLING), new ItemStack(ModBlocks.NATURE_ALTAR), 500,
                Helper.blockIng(Blocks.STONE),
                Helper.blockIng(Blocks.STONE),
                Helper.blockIng(Blocks.STONE),
                Ingredient.fromItem(ModItems.GOLD_LEAF),
                Ingredient.fromItem(Items.GOLD_INGOT),
                new NBTIngredient(ItemAuraBottle.setType(new ItemStack(ModItems.AURA_BOTTLE), NaturesAuraAPI.TYPE_OVERWORLD))).register();
        new TreeRitualRecipe(new ResourceLocation(NaturesAura.MOD_ID, "ancient_sapling"),
                Helper.blockIng(Blocks.SAPLING), new ItemStack(ModBlocks.ANCIENT_SAPLING), 200,
                Helper.blockIng(Blocks.SAPLING),
                Helper.blockIng(Blocks.YELLOW_FLOWER),
                Helper.blockIng(Blocks.RED_FLOWER),
                Ingredient.fromItem(Items.WHEAT_SEEDS),
                Ingredient.fromItem(Items.REEDS),
                Ingredient.fromItem(ModItems.GOLD_LEAF)).register();
        new TreeRitualRecipe(new ResourceLocation(NaturesAura.MOD_ID, "furnace_heater"),
                Helper.blockIng(Blocks.SAPLING), new ItemStack(ModBlocks.FURNACE_HEATER), 600,
                Helper.blockIng(ModBlocks.INFUSED_STONE),
                Helper.blockIng(ModBlocks.INFUSED_STONE),
                Ingredient.fromItem(ModItems.INFUSED_IRON),
                Ingredient.fromItem(ModItems.INFUSED_IRON),
                Ingredient.fromItem(Items.FIRE_CHARGE),
                Ingredient.fromItem(Items.FLINT),
                Helper.blockIng(Blocks.MAGMA),
                new NBTIngredient(ItemAuraBottle.setType(new ItemStack(ModItems.AURA_BOTTLE), NaturesAuraAPI.TYPE_NETHER))).register();
        new TreeRitualRecipe(new ResourceLocation(NaturesAura.MOD_ID, "conversion_catalyst"),
                Ingredient.fromStacks(new ItemStack(Blocks.SAPLING, 1, 3)), new ItemStack(ModBlocks.CONVERSION_CATALYST), 600,
                Ingredient.fromStacks(new ItemStack(Blocks.STONEBRICK, 1, 1)),
                Helper.blockIng(ModBlocks.INFUSED_STONE),
                Ingredient.fromItem(Items.BREWING_STAND),
                Ingredient.fromItem(ModItems.SKY_INGOT),
                Ingredient.fromItem(ModItems.GOLD_LEAF),
                Helper.blockIng(Blocks.GLOWSTONE)).register();
        new TreeRitualRecipe(new ResourceLocation(NaturesAura.MOD_ID, "plant_powder"),
                Ingredient.fromStacks(new ItemStack(Blocks.SAPLING)),
                ItemEffectPowder.setEffect(new ItemStack(ModItems.EFFECT_POWDER), PlantBoostEffect.NAME), 400,
                Helper.blockIng(ModBlocks.GOLD_POWDER),
                Helper.blockIng(ModBlocks.GOLD_POWDER),
                Ingredient.fromItem(ModItems.SKY_INGOT),
                Ingredient.fromItem(Items.WHEAT)).register();
        new TreeRitualRecipe(new ResourceLocation(NaturesAura.MOD_ID, "cache_powder"),
                Ingredient.fromStacks(new ItemStack(Blocks.SAPLING)),
                ItemEffectPowder.setEffect(new ItemStack(ModItems.EFFECT_POWDER), CacheRechargeEffect.NAME), 400,
                Helper.blockIng(ModBlocks.GOLD_POWDER),
                Helper.blockIng(ModBlocks.GOLD_POWDER),
                Ingredient.fromItem(ModItems.SKY_INGOT),
                Ingredient.fromItem(ModItems.AURA_CACHE)).register();
        new TreeRitualRecipe(new ResourceLocation(NaturesAura.MOD_ID, "animal_powder"),
                Ingredient.fromStacks(new ItemStack(Blocks.SAPLING, 1, 3)),
                ItemEffectPowder.setEffect(new ItemStack(ModItems.EFFECT_POWDER), AnimalEffect.NAME), 400,
                Helper.blockIng(ModBlocks.GOLD_POWDER),
                Helper.blockIng(ModBlocks.GOLD_POWDER),
                Ingredient.fromItem(ModItems.SKY_INGOT),
                Ingredient.fromItem(Items.EGG)).register();

        new AltarRecipe(new ResourceLocation(NaturesAura.MOD_ID, "infused_iron"),
                Ingredient.fromItem(Items.IRON_INGOT), new ItemStack(ModItems.INFUSED_IRON),
                Ingredient.EMPTY, 300, 80).register();
        new AltarRecipe(new ResourceLocation(NaturesAura.MOD_ID, "infused_iron_block"),
                Helper.blockIng(Blocks.IRON_BLOCK), new ItemStack(ModBlocks.INFUSED_IRON),
                Ingredient.EMPTY, 2700, 700).register();
        new AltarRecipe(new ResourceLocation(NaturesAura.MOD_ID, "infused_stone"),
                Helper.blockIng(Blocks.STONE), new ItemStack(ModBlocks.INFUSED_STONE),
                Ingredient.EMPTY, 150, 40).register();

        Ingredient conversion = Helper.blockIng(ModBlocks.CONVERSION_CATALYST);
        new AltarRecipe(new ResourceLocation(NaturesAura.MOD_ID, "breath"),
                new NBTIngredient(ItemAuraBottle.setType(new ItemStack(ModItems.AURA_BOTTLE), NaturesAuraAPI.TYPE_END)),
                new ItemStack(Items.DRAGON_BREATH),
                conversion, 500, 80).register();
        new AltarRecipe(new ResourceLocation(NaturesAura.MOD_ID, "leather"),
                Ingredient.fromItem(Items.ROTTEN_FLESH), new ItemStack(Items.LEATHER),
                conversion, 400, 50).register();
        new AltarRecipe(new ResourceLocation(NaturesAura.MOD_ID, "soul_sand"),
                Helper.blockIng(Blocks.SAND), new ItemStack(Blocks.SOUL_SAND),
                conversion, 200, 100).register();
        new AltarRecipe(new ResourceLocation(NaturesAura.MOD_ID, "nether_wart"),
                Helper.blockIng(Blocks.RED_MUSHROOM), new ItemStack(Items.NETHER_WART),
                conversion, 600, 250).register();
        new AltarRecipe(new ResourceLocation(NaturesAura.MOD_ID, "prismarine"),
                Ingredient.fromItem(Items.QUARTZ), new ItemStack(Items.PRISMARINE_SHARD),
                conversion, 850, 200).register();

        new OfferingRecipe(new ResourceLocation(NaturesAura.MOD_ID, "sky_ingot"),
                new AmountIngredient(new ItemStack(ModItems.INFUSED_IRON, 3)),
                Ingredient.fromItem(ModItems.CALLING_SPIRIT),
                new ItemStack(ModItems.SKY_INGOT)).register();

        NaturesAuraAPI.BOTANIST_PICKAXE_CONVERSIONS.put(
                Blocks.COBBLESTONE.getDefaultState(),
                Blocks.MOSSY_COBBLESTONE.getDefaultState());
        NaturesAuraAPI.BOTANIST_PICKAXE_CONVERSIONS.put(
                Blocks.STONEBRICK.getDefaultState().withProperty(BlockStoneBrick.VARIANT, BlockStoneBrick.EnumType.DEFAULT),
                Blocks.STONEBRICK.getDefaultState().withProperty(BlockStoneBrick.VARIANT, BlockStoneBrick.EnumType.MOSSY));

        for (Block block : ForgeRegistries.BLOCKS)
            if (block instanceof BlockFlower)
                NaturesAuraAPI.FLOWERS.addAll(block.getBlockState().getValidStates());

        spawner("cow", EntityCow::new, 500, 60, Ingredient.fromItem(Items.BEEF), Ingredient.fromItem(Items.LEATHER));
        for (EnumDyeColor color : EnumDyeColor.values())
            spawner("sheep_" + color.getName(), world -> {
                EntitySheep sheep = new EntitySheep(world);
                sheep.setFleeceColor(color);
                return sheep;
            }, 500, 60, Ingredient.fromItem(Items.MUTTON), Ingredient.fromStacks(new ItemStack(Blocks.WOOL, 1, color.getMetadata())));
        spawner("chicken", EntityChicken::new, 300, 40, Ingredient.fromItem(Items.FEATHER), Ingredient.fromItem(Items.EGG));
        spawner("pig", EntityPig::new, 500, 60, Ingredient.fromItem(Items.PORKCHOP));
        spawner("blaze", EntityBlaze::new, 1500, 120, Ingredient.fromItem(Items.BLAZE_ROD), Ingredient.fromItem(Items.BLAZE_POWDER));
        spawner("ghast", EntityGhast::new, 1200, 150, Ingredient.fromItem(Items.GUNPOWDER), Ingredient.fromItem(Items.GHAST_TEAR));
        spawner("ocelot", EntityOcelot::new, 800, 60, Ingredient.fromItem(Items.FISH), Helper.blockIng(Blocks.WOOL));
        spawner("mule", EntityMule::new, 1000, 100, Ingredient.fromItem(Items.LEATHER), Helper.blockIng(Blocks.CHEST), Ingredient.fromItem(Items.APPLE));
        spawner("bat", EntityBat::new, 300, 40, Ingredient.fromItem(Items.FEATHER));
        spawner("endermite", EntityEndermite::new, 300, 40, Ingredient.fromItem(Items.ENDER_PEARL), Helper.blockIng(Blocks.STONE));
        spawner("parrot", EntityParrot::new, 500, 60, Ingredient.fromItem(Items.FEATHER), Ingredient.fromItem(Items.COOKIE));
        spawner("slime", EntitySlime::new, 300, 40, Ingredient.fromItem(Items.SLIME_BALL));
        spawner("spider", EntitySpider::new, 1000, 120, Ingredient.fromItem(Items.STRING), Ingredient.fromItem(Items.SPIDER_EYE));
        spawner("skeleton", EntitySkeleton::new, 1000, 120, Ingredient.fromItem(Items.BONE), Ingredient.fromItem(Items.ARROW));
        spawner("enderman", EntityEnderman::new, 1200, 120, Ingredient.fromItem(Items.ENDER_PEARL));
        spawner("silverfish", EntitySilverfish::new, 300, 40, Helper.blockIng(Blocks.STONE));
        spawner("squid", EntitySquid::new, 500, 40, Ingredient.fromStacks(new ItemStack(Items.DYE, 1, EnumDyeColor.BLACK.getDyeDamage())));
        spawner("stray", EntityStray::new, 1000, 120, Ingredient.fromItem(Items.BONE), Helper.blockIng(Blocks.ICE));
        spawner("shulker", EntityShulker::new, 1500, 100, Ingredient.fromItem(Items.SHULKER_SHELL));
        spawner("husk", EntityHusk::new, 1000, 120, Ingredient.fromItem(Items.ROTTEN_FLESH), Helper.blockIng(Blocks.SAND));
        spawner("llama", EntityLlama::new, 600, 80, Ingredient.fromStacks(new ItemStack(Blocks.WOOL, 1, OreDictionary.WILDCARD_VALUE)));
        spawner("rabbit", EntityRabbit::new, 300, 40, Ingredient.fromItem(Items.RABBIT_HIDE));
        spawner("magma_cube", EntityMagmaCube::new, 1000, 100, Ingredient.fromItem(Items.MAGMA_CREAM));
        spawner("zombie_pigman", EntityPigZombie::new, 1200, 150, Ingredient.fromItem(Items.ROTTEN_FLESH), Ingredient.fromItem(Items.GOLD_NUGGET));
        spawner("polar_bear", EntityPolarBear::new, 500, 60, Ingredient.fromItem(Items.FISH), Helper.blockIng(Blocks.ICE));
        spawner("mooshroom", EntityMooshroom::new, 400, 60, Ingredient.fromItem(Items.LEATHER), Helper.blockIng(Blocks.RED_MUSHROOM));
        spawner("guardian", EntityGuardian::new, 1500, 150, Ingredient.fromItem(Items.PRISMARINE_SHARD), Ingredient.fromItem(Items.PRISMARINE_CRYSTALS));
        spawner("horse", EntityHorse::new, 1000, 100, Ingredient.fromItem(Items.LEATHER));
        spawner("donkey", EntityDonkey::new, 1000, 100, Ingredient.fromItem(Items.LEATHER), Helper.blockIng(Blocks.CHEST));
        spawner("cave_spider", EntityCaveSpider::new, 1000, 120, Ingredient.fromItem(Items.STRING), Ingredient.fromItem(Items.FERMENTED_SPIDER_EYE));
        spawner("creeper", EntityCreeper::new, 1000, 120, Ingredient.fromItem(Items.GUNPOWDER));
        spawner("witch", EntityWitch::new, 1500, 150, Ingredient.fromItem(Items.GLASS_BOTTLE), Ingredient.fromItem(Items.GLOWSTONE_DUST));
        spawner("wither_skeleton", EntityWitherSkeleton::new, 1500, 150, Ingredient.fromItem(Items.BONE), Helper.blockIng(Blocks.OBSIDIAN));
        spawner("wolf", EntityWolf::new, 500, 60, Ingredient.fromItem(Items.LEATHER), Ingredient.fromItem(Items.BONE));
        spawner("zombie", EntityZombie::new, 1000, 100, Ingredient.fromItem(Items.ROTTEN_FLESH));
    }

    private static void spawner(String name, Function<World, Entity> entity, int aura, int time, Ingredient... ings) {
        Ingredient[] actualIngs = new Ingredient[ings.length + 1];
        actualIngs[0] = Ingredient.fromItem(ModItems.BIRTH_SPIRIT);
        System.arraycopy(ings, 0, actualIngs, 1, ings.length);
        new AnimalSpawnerRecipe(new ResourceLocation(NaturesAura.MOD_ID, name), entity, aura, time, actualIngs).register();
    }
}
