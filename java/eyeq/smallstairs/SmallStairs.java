package eyeq.smallstairs;

import eyeq.util.client.model.UModelLoader;
import eyeq.util.client.renderer.ResourceLocationFactory;
import eyeq.util.client.resource.ULanguageCreator;
import eyeq.util.client.resource.lang.LanguageResourceManager;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import eyeq.smallstairs.block.BlockStairsSmall;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.io.File;

import static eyeq.smallstairs.SmallStairs.MOD_ID;

@Mod(modid = MOD_ID, version = "1.0", dependencies = "after:eyeq_util")
@Mod.EventBusSubscriber
public class SmallStairs {
    public static final String MOD_ID = "eyeq_smallstairs";

    @Mod.Instance(MOD_ID)
    public static SmallStairs instance;

    private static final ResourceLocationFactory resource = new ResourceLocationFactory(MOD_ID);

    public static Block stairsSmallOak;
    public static Block stairsSmallSpruce;
    public static Block stairsSmallBirch;
    public static Block stairsSmallJungle;
    public static Block stairsSmallAcacia;
    public static Block stairsSmallDarkOak;

    public static Block stairsSmallStone;
    public static Block stairsSmallSandstone;
    public static Block stairsSmallRedSandstone;
    public static Block stairsSmallBrick;
    public static Block stairsSmallStoneBrick;
    public static Block stairsSmallNetherBrick;
    public static Block stairsSmallQuartz;
    public static Block stairsSmallPurpur;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        addRecipes();
        if(event.getSide().isServer()) {
            return;
        }
        renderItemModels();
        createFiles();
    }

    @SubscribeEvent
    protected static void registerBlocks(RegistryEvent.Register<Block> event) {
        stairsSmallOak = new BlockStairsSmall(Blocks.OAK_STAIRS.getDefaultState()).setUnlocalizedName("stairsSmallOak");
        stairsSmallSpruce = new BlockStairsSmall(Blocks.SPRUCE_STAIRS.getDefaultState()).setUnlocalizedName("stairsSmallSpruce");
        stairsSmallBirch = new BlockStairsSmall(Blocks.BIRCH_STAIRS.getDefaultState()).setUnlocalizedName("stairsSmallBirch");
        stairsSmallJungle = new BlockStairsSmall(Blocks.JUNGLE_STAIRS.getDefaultState()).setUnlocalizedName("stairsSmallJungle");
        stairsSmallAcacia = new BlockStairsSmall(Blocks.ACACIA_STAIRS.getDefaultState()).setUnlocalizedName("stairsSmallAcacia");
        stairsSmallDarkOak = new BlockStairsSmall(Blocks.DARK_OAK_STAIRS.getDefaultState()).setUnlocalizedName("stairsSmallDarkOak");

        stairsSmallStone = new BlockStairsSmall(Blocks.STONE_STAIRS.getDefaultState()).setUnlocalizedName("stairsSmallStone");
        stairsSmallSandstone = new BlockStairsSmall(Blocks.SANDSTONE_STAIRS.getDefaultState()).setUnlocalizedName("stairsSmallSandstone");
        stairsSmallRedSandstone = new BlockStairsSmall(Blocks.RED_SANDSTONE_STAIRS.getDefaultState()).setUnlocalizedName("stairsSmallRedSandstone");
        stairsSmallBrick = new BlockStairsSmall(Blocks.BRICK_STAIRS.getDefaultState()).setUnlocalizedName("stairsSmallBrick");
        stairsSmallStoneBrick = new BlockStairsSmall(Blocks.STONE_BRICK_STAIRS.getDefaultState()).setUnlocalizedName("stairsSmallStoneBrick");
        stairsSmallNetherBrick = new BlockStairsSmall(Blocks.NETHER_BRICK_STAIRS.getDefaultState()).setUnlocalizedName("stairsSmallNetherBrick");
        stairsSmallQuartz = new BlockStairsSmall(Blocks.QUARTZ_STAIRS.getDefaultState()).setUnlocalizedName("stairsSmallQuartz");
        stairsSmallPurpur = new BlockStairsSmall(Blocks.PURPUR_STAIRS.getDefaultState()).setUnlocalizedName("stairsSmallPurpur");

        GameRegistry.register(stairsSmallOak, resource.createResourceLocation("small_oak_stairs"));
        GameRegistry.register(stairsSmallSpruce, resource.createResourceLocation("small_spruce_stairs"));
        GameRegistry.register(stairsSmallBirch, resource.createResourceLocation("small_birch_stairs"));
        GameRegistry.register(stairsSmallJungle, resource.createResourceLocation("small_jungle_stairs"));
        GameRegistry.register(stairsSmallAcacia, resource.createResourceLocation("small_acacia_stairs"));
        GameRegistry.register(stairsSmallDarkOak, resource.createResourceLocation("small_dark_oak_stairs"));

        GameRegistry.register(stairsSmallStone, resource.createResourceLocation("small_stone_stairs"));
        GameRegistry.register(stairsSmallSandstone, resource.createResourceLocation("small_sandstone_stairs"));
        GameRegistry.register(stairsSmallRedSandstone, resource.createResourceLocation("small_red_sandstone_stairs"));
        GameRegistry.register(stairsSmallBrick, resource.createResourceLocation("small_brick_stairs"));
        GameRegistry.register(stairsSmallStoneBrick, resource.createResourceLocation("small_stone_brick_stairs"));
        GameRegistry.register(stairsSmallNetherBrick, resource.createResourceLocation("small_nether_brick_stairs"));
        GameRegistry.register(stairsSmallQuartz, resource.createResourceLocation("small_quartz_stairs"));
        GameRegistry.register(stairsSmallPurpur, resource.createResourceLocation("small_purpur_stairs"));
    }

    @SubscribeEvent
    protected static void registerItems(RegistryEvent.Register<Item> event) {
        GameRegistry.register(new ItemBlock(stairsSmallOak), stairsSmallOak.getRegistryName());
        GameRegistry.register(new ItemBlock(stairsSmallSpruce), stairsSmallSpruce.getRegistryName());
        GameRegistry.register(new ItemBlock(stairsSmallBirch), stairsSmallBirch.getRegistryName());
        GameRegistry.register(new ItemBlock(stairsSmallJungle), stairsSmallJungle.getRegistryName());
        GameRegistry.register(new ItemBlock(stairsSmallAcacia), stairsSmallAcacia.getRegistryName());
        GameRegistry.register(new ItemBlock(stairsSmallDarkOak), stairsSmallDarkOak.getRegistryName());

        GameRegistry.register(new ItemBlock(stairsSmallStone), stairsSmallStone.getRegistryName());
        GameRegistry.register(new ItemBlock(stairsSmallSandstone), stairsSmallSandstone.getRegistryName());
        GameRegistry.register(new ItemBlock(stairsSmallRedSandstone), stairsSmallRedSandstone.getRegistryName());
        GameRegistry.register(new ItemBlock(stairsSmallBrick), stairsSmallBrick.getRegistryName());
        GameRegistry.register(new ItemBlock(stairsSmallStoneBrick), stairsSmallStoneBrick.getRegistryName());
        GameRegistry.register(new ItemBlock(stairsSmallNetherBrick), stairsSmallNetherBrick.getRegistryName());
        GameRegistry.register(new ItemBlock(stairsSmallQuartz), stairsSmallQuartz.getRegistryName());
        GameRegistry.register(new ItemBlock(stairsSmallPurpur), stairsSmallPurpur.getRegistryName());
    }

    public static void addRecipeSmallStairs(Block smallStairs, Block stairs) {
        GameRegistry.addShapelessRecipe(new ItemStack(smallStairs, 2), stairs);
        GameRegistry.addShapelessRecipe(new ItemStack(stairs), smallStairs, smallStairs);
    }

    public static void addRecipes() {
        addRecipeSmallStairs(stairsSmallOak, Blocks.OAK_STAIRS);
        addRecipeSmallStairs(stairsSmallSpruce, Blocks.SPRUCE_STAIRS);
        addRecipeSmallStairs(stairsSmallBirch, Blocks.BIRCH_STAIRS);
        addRecipeSmallStairs(stairsSmallJungle, Blocks.JUNGLE_STAIRS);
        addRecipeSmallStairs(stairsSmallAcacia, Blocks.ACACIA_STAIRS);
        addRecipeSmallStairs(stairsSmallDarkOak, Blocks.DARK_OAK_STAIRS);

        addRecipeSmallStairs(stairsSmallStone, Blocks.STONE_STAIRS);
        addRecipeSmallStairs(stairsSmallSandstone, Blocks.SANDSTONE_STAIRS);
        addRecipeSmallStairs(stairsSmallRedSandstone, Blocks.RED_SANDSTONE_STAIRS);
        addRecipeSmallStairs(stairsSmallBrick, Blocks.BRICK_STAIRS);
        addRecipeSmallStairs(stairsSmallStoneBrick, Blocks.STONE_BRICK_STAIRS);
        addRecipeSmallStairs(stairsSmallNetherBrick, Blocks.NETHER_BRICK_STAIRS);
        addRecipeSmallStairs(stairsSmallQuartz, Blocks.QUARTZ_STAIRS);
        addRecipeSmallStairs(stairsSmallPurpur, Blocks.PURPUR_STAIRS);
    }

    @SideOnly(Side.CLIENT)
    public static void renderItemModels() {
        UModelLoader.setCustomModelResourceLocation(stairsSmallOak);
        UModelLoader.setCustomModelResourceLocation(stairsSmallSpruce);
        UModelLoader.setCustomModelResourceLocation(stairsSmallBirch);
        UModelLoader.setCustomModelResourceLocation(stairsSmallJungle);
        UModelLoader.setCustomModelResourceLocation(stairsSmallAcacia);
        UModelLoader.setCustomModelResourceLocation(stairsSmallDarkOak);

        UModelLoader.setCustomModelResourceLocation(stairsSmallStone);
        UModelLoader.setCustomModelResourceLocation(stairsSmallSandstone);
        UModelLoader.setCustomModelResourceLocation(stairsSmallRedSandstone);
        UModelLoader.setCustomModelResourceLocation(stairsSmallBrick);
        UModelLoader.setCustomModelResourceLocation(stairsSmallStoneBrick);
        UModelLoader.setCustomModelResourceLocation(stairsSmallNetherBrick);
        UModelLoader.setCustomModelResourceLocation(stairsSmallQuartz);
        UModelLoader.setCustomModelResourceLocation(stairsSmallPurpur);
    }

    public static void createFiles() {
        File project = new File("../1.11.2-SmallStairs");

        LanguageResourceManager language = new LanguageResourceManager();

        language.register(LanguageResourceManager.EN_US, stairsSmallOak, "Small Oak Wood Stairs");
        language.register(LanguageResourceManager.JA_JP, stairsSmallOak, "小さな樫の木の階段");
        language.register(LanguageResourceManager.EN_US, stairsSmallSpruce, "Small Spruce Wood Stairs");
        language.register(LanguageResourceManager.JA_JP, stairsSmallSpruce, "小さな松の木の階段");
        language.register(LanguageResourceManager.EN_US, stairsSmallBirch, "Small Birch Wood Stairs");
        language.register(LanguageResourceManager.JA_JP, stairsSmallBirch, "小さな白樺の木の階段");
        language.register(LanguageResourceManager.EN_US, stairsSmallJungle, "Small Jungle Wood Stairs");
        language.register(LanguageResourceManager.JA_JP, stairsSmallJungle, "小さなジャングルの木の階段");
        language.register(LanguageResourceManager.EN_US, stairsSmallAcacia, "Small Acacia Wood Stairs");
        language.register(LanguageResourceManager.JA_JP, stairsSmallAcacia, "小さなアカシアの木の階段");
        language.register(LanguageResourceManager.EN_US, stairsSmallDarkOak, "Small Dark Oak Wood Stairs");
        language.register(LanguageResourceManager.JA_JP, stairsSmallDarkOak, "小さなダークオークの木の階段");

        language.register(LanguageResourceManager.EN_US, stairsSmallStone, "Small Cobblestone Stairs");
        language.register(LanguageResourceManager.JA_JP, stairsSmallStone, "小さな石の階段");
        language.register(LanguageResourceManager.EN_US, stairsSmallSandstone, "Small Sandstone Stairs");
        language.register(LanguageResourceManager.JA_JP, stairsSmallSandstone, "小さな砂岩の階段");
        language.register(LanguageResourceManager.EN_US, stairsSmallRedSandstone, "Small Red Sandstone Stairs");
        language.register(LanguageResourceManager.JA_JP, stairsSmallRedSandstone, "小さな赤色砂岩の階段");
        language.register(LanguageResourceManager.EN_US, stairsSmallBrick, "Small Brick Stairs");
        language.register(LanguageResourceManager.JA_JP, stairsSmallBrick, "小さなレンガの階段");
        language.register(LanguageResourceManager.EN_US, stairsSmallStoneBrick, "Small Stone Brick Stairs");
        language.register(LanguageResourceManager.JA_JP, stairsSmallStoneBrick, "小さな石レンガの階段");
        language.register(LanguageResourceManager.EN_US, stairsSmallNetherBrick, "Small Nether Brick Stairs");
        language.register(LanguageResourceManager.JA_JP, stairsSmallNetherBrick, "小さなネザーレンガの階段");
        language.register(LanguageResourceManager.EN_US, stairsSmallQuartz, "Small Quartz Stairs");
        language.register(LanguageResourceManager.JA_JP, stairsSmallQuartz, "小さなネザー水晶の階段");
        language.register(LanguageResourceManager.EN_US, stairsSmallPurpur, "Small Purpur Stairs");
        language.register(LanguageResourceManager.JA_JP, stairsSmallPurpur, "小さなプルプァの階段");

        ULanguageCreator.createLanguage(project, MOD_ID, language);
    }
}
