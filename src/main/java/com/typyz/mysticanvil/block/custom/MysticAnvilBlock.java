package com.typyz.mysticanvil.block.custom;

import com.typyz.mysticanvil.block.custom.VoxelShapeHelper;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.Nonnull;
import java.util.EnumMap;
import java.util.stream.Stream;


public class MysticAnvilBlock extends Block {
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;

    public MysticAnvilBlock(Properties properties) {
        super(properties);
    }

    public static shape Stream.of(Block.box(1, 0, 1, 15, 9, 15),
            Shapes.join(Block.box(14, 9, 1, 15, 10, 15), Shapes.join(Block.box(1, 9, 1, 2, 10, 15), Shapes.join(Block.box(1, 9, 1, 15, 10, 2), Block.box(1, 9, 14, 15, 10, 15), BooleanOp.OR), BooleanOp.OR), BooleanOp.OR),
            Shapes.join(Block.box(6.3, 11, 5, 9.7, 14, 11), Shapes.join(Block.box(6, 10, 4, 10, 11, 12), Block.box(5, 9, 3, 11, 10, 13), BooleanOp.OR), BooleanOp.OR),
            Shapes.join(Block.box(5.25, 14, 4, 10.75, 15, 12), Shapes.join(Block.box(4.65, 15, 3.25, 11.35, 16, 12.25), Shapes.join(Block.box(5.75, 15, 12.25, 10.25, 16, 13.25), Shapes.join(Block.box(6, 14, 12, 10, 15, 13), Shapes.join(Block.box(6.75, 14.125, 13, 9.25, 15.125, 14), Shapes.join(Block.box(6.5, 15, 13.25, 9.5, 16, 14.25), Shapes.join(Block.box(7, 15, 14.25, 9, 16, 15.25), Block.box(7.25, 14.25, 14, 8.75, 15.25, 15), BooleanOp.OR), BooleanOp.OR), BooleanOp.OR), BooleanOp.OR), BooleanOp.OR), BooleanOp.OR), BooleanOp.OR),
            Shapes.join(Block.box(3, 9, 10.5, 5, 10, 12.5), Shapes.join(Block.box(3, 9, 3.5, 5, 10, 5.5), Shapes.join(Block.box(11, 9, 3.5, 13, 10, 5.5), Block.box(11, 9, 10.5, 13, 10, 12.5), BooleanOp.OR), BooleanOp.OR), BooleanOp.OR),
            Shapes.join(Block.box(11.5, 9.25, 11, 12.5, 10.25, 12), Shapes.join(Block.box(11.5, 9.25, 4, 12.5, 10.25, 5), Shapes.join(Block.box(3.5, 9.25, 4, 4.5, 10.25, 5), Block.box(3.5, 9.25, 11, 4.5, 10.25, 12), BooleanOp.OR), BooleanOp.OR), BooleanOp.OR)
            ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get()

     VoxelShapeHelper.rotateShape( , Direction.EAST) ;

//    private static final VoxelShape SHAPE = Stream.of(Block.box(1, 0, 1, 15, 9, 15),
//            Shapes.join(Block.box(14, 9, 1, 15, 10, 15), Shapes.join(Block.box(1, 9, 1, 2, 10, 15), Shapes.join(Block.box(1, 9, 1, 15, 10, 2), Block.box(1, 9, 14, 15, 10, 15), BooleanOp.OR), BooleanOp.OR), BooleanOp.OR),
//            Shapes.join(Block.box(6.3, 11, 5, 9.7, 14, 11), Shapes.join(Block.box(6, 10, 4, 10, 11, 12), Block.box(5, 9, 3, 11, 10, 13), BooleanOp.OR), BooleanOp.OR),
//            Shapes.join(Block.box(5.25, 14, 4, 10.75, 15, 12), Shapes.join(Block.box(4.65, 15, 3.25, 11.35, 16, 12.25), Shapes.join(Block.box(5.75, 15, 12.25, 10.25, 16, 13.25), Shapes.join(Block.box(6, 14, 12, 10, 15, 13), Shapes.join(Block.box(6.75, 14.125, 13, 9.25, 15.125, 14), Shapes.join(Block.box(6.5, 15, 13.25, 9.5, 16, 14.25), Shapes.join(Block.box(7, 15, 14.25, 9, 16, 15.25), Block.box(7.25, 14.25, 14, 8.75, 15.25, 15), BooleanOp.OR), BooleanOp.OR), BooleanOp.OR), BooleanOp.OR), BooleanOp.OR), BooleanOp.OR), BooleanOp.OR),
//            Shapes.join(Block.box(3, 9, 10.5, 5, 10, 12.5), Shapes.join(Block.box(3, 9, 3.5, 5, 10, 5.5), Shapes.join(Block.box(11, 9, 3.5, 13, 10, 5.5), Block.box(11, 9, 10.5, 13, 10, 12.5), BooleanOp.OR), BooleanOp.OR), BooleanOp.OR),
//            Shapes.join(Block.box(11.5, 9.25, 11, 12.5, 10.25, 12), Shapes.join(Block.box(11.5, 9.25, 4, 12.5, 10.25, 5), Shapes.join(Block.box(3.5, 9.25, 4, 4.5, 10.25, 5), Block.box(3.5, 9.25, 11, 4.5, 10.25, 12), BooleanOp.OR), BooleanOp.OR), BooleanOp.OR)
//            ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

//    @Override
//    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
//        return SHAPE;
//    }

    /* FACING */

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        return this.defaultBlockState().setValue(FACING, pContext.getHorizontalDirection().getOpposite());
    }

    @Override
    public BlockState rotate(BlockState pState, Rotation pRotation) {
        return pState.setValue(FACING, pRotation.rotate(pState.getValue(FACING)));
    }

    @Override
    public BlockState mirror(BlockState pState, Mirror pMirror) {
        return pState.rotate(pMirror.getRotation(pState.getValue(FACING)));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(FACING);
   }
}