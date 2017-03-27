package eyeq.smallstairs.block;

import net.minecraft.block.BlockStairs;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.ReflectionHelper;

import javax.annotation.Nullable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

public class BlockStairsSmall extends BlockStairs {
    public BlockStairsSmall(IBlockState modelState) {
        super(modelState);
        this.setLightOpacity(0);
        this.setHardness(this.blockHardness * 0.75F);
    }

    private double getNewMin(double value) {
        if(value == 0) {
            return 0.33;
        }
        if(value == 0.5) {
            return 0.66;
        }
        return value;
    }

    private double getNewMax(double value) {
        if(value == 1.0) {
            return 0.66;
        }
        if(value == 0.5) {
            return 0.33;
        }
        return value;
    }

    protected AxisAlignedBB getNewBox(AxisAlignedBB box, boolean isTop, EnumFacing facing) {
        double maxX = box.maxX;
        double maxY = box.maxY;
        double maxZ = box.maxZ;
        double minX = box.minX;
        double minY = box.minY;
        double minZ = box.minZ;
        if(isTop) {
            minY = getNewMin(minY);
        } else {
            maxY = getNewMax(maxY);
        }
        switch(facing) {
        case NORTH:
            maxZ = getNewMax(maxZ);
            break;
        case SOUTH:
            minZ = getNewMin(minZ);
            break;
        case WEST:
            maxX = getNewMax(maxX);
            break;
        case EAST:
            minX = getNewMin(minX);
            break;
        }
        return new AxisAlignedBB(minX, minY, minZ, maxX, maxY, maxZ);
    }

    @Override
    public void addCollisionBoxToList(IBlockState state, World world, BlockPos pos, AxisAlignedBB entityBox, List<AxisAlignedBB> collidingBoxes, @Nullable Entity entity, boolean p_185477_7_) {
        if(!p_185477_7_) {
            state = this.getActualState(state, world, pos);
        }
        List<AxisAlignedBB> collisionBoxList = null;
        try {
            collisionBoxList = getCollisionBoxList(state);
        } catch(InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
        if(collisionBoxList == null) {
            System.out.println("error: Small Stairs");
            return;
        }
        boolean isTop = state.getValue(HALF) == BlockStairs.EnumHalf.TOP;
        EnumFacing facing = state.getValue(FACING);
        for(AxisAlignedBB collidingBox : collisionBoxList) {
            addCollisionBoxToList(pos, entityBox, collidingBoxes, getNewBox(collidingBox, isTop, facing));
        }
    }

    @Override
    public AxisAlignedBB getSelectedBoundingBox(IBlockState state, World world, BlockPos pos) {
        AxisAlignedBB box = super.getSelectedBoundingBox(state, world, pos);
        boolean isTop = state.getValue(HALF) == BlockStairs.EnumHalf.TOP;
        EnumFacing facing = state.getValue(FACING);
        return getNewBox(box, isTop, facing);
    }

    @Override
    public boolean doesSideBlockRendering(IBlockState state, IBlockAccess world, BlockPos pos, EnumFacing facing) {
        return state.isOpaqueCube();
    }

    public static List<AxisAlignedBB> getCollisionBoxList(IBlockState state) throws InvocationTargetException, IllegalAccessException {
        Method method = ReflectionHelper.findMethod(BlockStairs.class, null, new String[]{"getCollisionBoxList", "func_185708_x"}, IBlockState.class);
        return (List<AxisAlignedBB>) method.invoke(null, state);
    }
}
